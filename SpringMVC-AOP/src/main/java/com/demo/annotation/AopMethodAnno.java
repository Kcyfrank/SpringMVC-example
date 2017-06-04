package com.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//当前注解仅作用在类，接口，或枚举上
@Target({ElementType.METHOD})
//指示编译器如何对待你的自定义 Annotation
//在运行期间有效
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AopMethodAnno {

    String testString() default "";
}

