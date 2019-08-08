package com.spring.dynamicproxy;

public class MyAspectForConfig {
    //横切关注点
    public void checkSecurity() {
        System.out.println("==========MyAspect.checkSecurity()==============");
    }
}
