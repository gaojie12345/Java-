package com.ming.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {
    public static void main(String[] args) {
        /*UserInfo userInfo = new UserInfo();
        userInfo.setUsername("avin");
        String result = userInfo.sayHello();
        System.out.println("result = " +result);*/

        //spring
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInfo userInfo = (UserInfo) context.getBean("userInfo");
        String result = userInfo.sayHello();
        System.out.println("result = " + result);

    }
}
