package com.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author forip on 2017/5/31.
 */
//设置当前类为aspect
@Aspect
@Component
@Slf4j
public class LoginAspect {

    @Before("execution(public * com.demo.controller..*.*(..))")
    public void beforeLogin() {
            //连接点只能为方法，即任意iservice中的方法都会触发签到
            log.error("****** before login *****");
    }
}
