package com.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//表示的是这个Annotation可以应用在哪里 方法 类 变量 属性等
//当前注解仅作用在方法上
@Target({ElementType.TYPE})
//指示编译器如何对待你的自定义 Annotation
//在运行期间有效
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AopClassAnno {

    String testString() default "";
}

