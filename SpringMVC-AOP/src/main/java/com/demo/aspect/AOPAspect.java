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
     */
    @Pointcut("execution(public * com.demo.controller.HelloController.*(..))")
    public void visitHello() {
            //连接点只能为方法
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
     * this 匹配当前AOP代理对象类型的执行方法；注意是AOP代理对象的类型匹配，
     * 这样就可能包括引入接口方法也可以匹配类型；
     * 注意this中使用的表达式必须是类型全限定名，不支持通配符；
     */
    @Before("this(com.demo.service.IThisService)")
    public void showThis() {
        log.error("**** before showThis ****");
    }








    //this this 的作用是匹配一个 bean, 这个 bean(Spring AOP proxy) 是一个给定类型的实例(instance of).

    //target target 匹配的是一个目标对象(target object, 即需要织入 advice 的原始的类), 此对象是一个给定类型的实例(instance of).

    //args 限制匹配连接点（使用Spring AOP时执行方法），其中参数是给定类型的实例
        //with args 参数位置

    //bean 匹配 bean 名字为指定值的 bean 下的所有方法.

    //@target 匹配的对象具有一个指定的 annotation. 执行对象的类具有给定类型的注释

    //@args 方法运行时传入的参数的实际类型拥有@args描述中给出的annotation

    //@within   类型拥有@target描述中给出的annotation,其中@target和@within的区别在于@within要求的annotation的级别为CLASS，而@target为RUNTIME

    //@annotation   匹配由指定注解所标注的方法
    //get annotation


    //before
    //after
    //afterreturn
    //afterthrowing
    //around
    //returning



    //get class
}
