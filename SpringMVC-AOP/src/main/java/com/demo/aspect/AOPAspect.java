package com.demo.aspect;

import lombok.extern.slf4j.Slf4j;
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
     * 当前 expression 匹配 HelloController 中所有的 public 方法
     * 注： （）代表匹配的方法的参数 * 代表一个任意类型参数 .. 代表任意数量参数
     */
    @Pointcut("execution(public * com.demo.controller.HelloController.*(..))")
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

    @Before("showWithin()")
    public void beforShowWithin() {
        log.error("**** before showWithin ****");
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
     * TODO this与target的差别
     *      target  - pointcut 所选取的Join point 的所有者，直白点说就是： 指明拦截的方法属于那个类。
     *      this    - pointcut 所选取的Join point 的调用的所有者，就是说：方法是在那个类中被调用的
     */
//    @Before("target(com.demo.service.IThisService)")
//    public void showTarget() {
//        log.error("**** before showTarget ****");
//    }

    @Pointcut("execution(* com.demo.controller.*.*(*))")
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

    //@args 方法运行时传入的参数的实际类型拥有@args描述中给出的annotation

    //@within   类型拥有@target描述中给出的annotation,其中@target和@within的区别在于@within要求的annotation的级别为CLASS，而@target为RUNTIME

    //@annotation   匹配由指定注解所标注的方法
    //get annotation

    //get class
}
