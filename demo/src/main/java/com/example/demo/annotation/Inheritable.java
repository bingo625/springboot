package com.example.demo.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Inherited;

/**
 * 自定义的Annotation。https://www.runoob.com/w3cnote/java-annotation.html
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Inheritable {
    String name() default "mao";
}



