package com.demo.aspect;

import com.demo.annotation.AopClassAnno;
import com.demo.annotation.AopMethodAnno;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author forip on 2017/5/31.
 */
//设置当前类为aspect
@Aspect
@Component
@Slf4j
public class AOPAspect {

    public AOPAspect() {
        log.error("**** init AOPAspect ****");
    }

    /**
     * execution 匹配所有目标类符合表示式的**方法**. aop 中最主要的 pointcut 标志符.
     * 例：execution(* hello*(..)) 匹配任意方法名以 hello 开头的方法
     * 当前 expression 匹配 HelloController 中的 public hello方法
     * 注： （）代表匹配的方法的参数 * 代表一个任意类型参数 .. 代表任意数量参数
     */
    @Pointcut("execution(public * com.demo.controller.HelloController.hello(..))")
    public void visitHello() {
            //存在 @Pointcut 注解的方法不执行方法体，只表示切入点的入口
            log.error("****** visitHello  *****");
    }

    /**
     * advice 增强，触发当前 joinpoint 时执行
     */
    @Before("visitHello()")
    public void beforVisitHello(){
        log.error("***** before visitHelloController *****");
    }

    /**
     * within 匹配特定路径范围下的所有 join point
     * 例 @Pointcut("within(com.demo)")  匹配 整个 demo 包下的所有方法
     * 当前 within 匹配 controller 包下已 yController 结尾的类/包下的所有方法
     */
    @Pointcut("within(com.demo.controller.*yController)")
    public void showWithin() {

    }

    /**
     * 当前 joinpoint 执行后 执行
     */
    @After("showWithin()")
    public void aftershowWithin() {
        log.error("**** After showWithin ****");
    }

    /**
     * 当前 joinPoint 成功返回后 执行
     */
    @AfterReturning(pointcut = "showWithin()", returning="retVal")
    public void afterReturnShowWithin(Object retVal) {
        log.error("**** afterReturning showWithin **** " + (String) retVal);
    }

    /**
     * 当前 joinPoint 抛出异常后执行
     */
    @AfterThrowing(pointcut = "showWithin()", throwing="ex")
    public void afterThrowinghowWithin(RuntimeException ex) {
        log.error("**** AfterThrowing showWithin ****  " + ex);
    }

    /**
     * this 匹配 bean (Spring AOP proxy)；
     * 注意this中使用的表达式必须是类型全限定名，不支持通配符；
     */
    @Pointcut("this(com.demo.service.IThisService)")
    public void showThis() {
    }

    @Before("showThis()")
    public void beforShowThis() {
        log.error("**** before showThis ****");
    }

    /**
     * target 匹配当前目标对象(target object, 即需要织入 advice 的原始的类)
     * TODO this与target的差别？
     *      bean
     *      target object
     */
//    @Before("target(com.demo.service.IThisService)")
//    public void showTarget() {
//        log.error("**** before showTarget ****");
//    }

    @Pointcut("execution(* com.demo.controller.*.*(..))")
    public void thisController() {
    }

    /**
     * args 匹配参数满足要求的的方法
     * 当前 匹配 thisController 下 仅包含一个参数 x 的方法
     * args 不匹配参数名称，仅匹配类型与参数顺序
     */
    @Before(value = "thisController()  &&  args(cat)")
    public void beforeArgsOne(String cat) {
        log.error("*** beforeArgsOne ***  arg = " + cat);
    }

    // 匹配第一个参数为 String 类型的所有方法
    // @Before(value = "thisController()  &&  args(cat, ..)")
    /**
     * 当前 匹配 thisController 下 第二个参数为 String 类型的执行方法
     */
    @Before(value = "thisController() && args(*, cat, ..)")
    public void beforeArgsTwo(String cat) {
        log.error("*** beforeArgsTwo ***" + cat);
    }

    /**
     * bean 匹配 bean 名字为指定值的 bean 下的所有方法
     */
    @Before(value="bean(beanController)")
    public void beforeBean() {
        log.error("*** beforeBean ***");
    }

    //@target 匹配的对象具有一个指定的 annotation. 执行对象的类具有给定类型的注释
//    @Pointcut("@target(org.springframework.transaction.annotation.Transactional))")
//    public void whileTransactional() {
//    }


    /**
     * @within   类型拥有@target描述中给出的annotation,
     * 其中@target和@within的区别在于@within要求的annotation的级别为CLASS，
     *                                          而@target为RUNTIME
     *
     * 当前匹配类上存在 aopClassAnno 注解且执行 world 方法时
     */
//    @Before("@within(com.demo.annotation.AopClassAnno) && execution(* world(..))")
//    public void withinTransactional(JoinPoint jp) {
//        //获取类上的注解
//        AopClassAnno anno = jp.getTarget().getClass().getAnnotation(AopClassAnno.class);
//        log.error("*** anno param *** " + anno.testString());
//        //获取当前切入点的参数 获取的都是object 需要已知类型才能获取
//        log.error("*** first param *** " + (String)jp.getArgs()[0]);
//        log.error("*** sec param *** " + (int)jp.getArgs()[1]);
//        log.error("*** third param *** " + (String)jp.getArgs()[2]);
//        log.error("*****Before advise, signature: " + jp.getSignature().toLongString() + " *****");
//        log.error("*****Before advise, signature: " + jp.getSignature().toShortString() + " *****");
//    }

    //@args 方法运行时传入的参数的实际类型拥有@args描述中给出的annotation

    //@Pointcut("@args(org.springframework.web.bind.annotation.RequestParam)")
//    public void markByRequestParam() {
//    }


    /**
     * @annotation   匹配由指定注解所标注的 *方法*  并获取当前注解的内容
     * 当前匹配 AopMethodAnno 注解并把当前注解作为参数传入
     */
//    @After("@annotation(anno)")
//    public void annoByTransactional(AopMethodAnno anno) {
//        log.error("***  " + anno.testString() + "  ***");
//    }


}
