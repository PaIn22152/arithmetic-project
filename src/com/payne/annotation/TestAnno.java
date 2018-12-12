package com.payne.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.annotation
 * Date       2018/11/13 - 09:54
 * Author     Payne.
 * About      类描述：
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface TestAnno {

    int id();

    String msg() default "ff";

}
