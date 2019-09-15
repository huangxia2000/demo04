package com.hxs.web.aoplog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface Log {

    public String LogType() default "";

    public String LogName() default "";

}
