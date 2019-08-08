/*
package com.spring.dynamicproxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//切面类----->注解方式实现
@Aspect
public class MyAspect {
    */
/**
     * 这是一个标识，该方法不具体的被调用,仅仅是指定一个范围
     *//*

    @Pointcut("execution(* add*(..)) || execution(* del(..))")
    private void allMethod(){

    }
    //横切关注点
    @Before("allMethod()")
    public void checkSecurity() {
        System.out.println("==========MyAspect.checkSecurity()==============");
    }
}
*/
