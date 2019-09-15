package com.hxs.web.aoplog;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SyetemLog {

    @Pointcut("execution(* com.hxs.web.mapper..*.*(..))")
    public void logPoint(){};
/*    @Pointcut("execution(* com.hxs.web.mapper.UserMapper.findUserByName(..))")
    public void logPoint(){};*/

    @After("logPoint()")
    public void after(JoinPoint jp){
        System.out.println("登入=====");
    };

}
