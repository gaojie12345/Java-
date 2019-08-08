package com.spring.dynamicproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ISuerManager iSuerManager = (ISuerManager) context.getBean("userMgr");
        iSuerManager.addUserInfo("xiaoming","4444");
    }
}
