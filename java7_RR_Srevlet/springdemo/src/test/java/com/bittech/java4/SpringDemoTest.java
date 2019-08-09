package com.bittech.java4;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoTest {
    ApplicationContext context = null;
    
    @Before
    public void test_init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }

    @Test
    public void test_function() {
        MyCaluter myCaluter = (MyCaluter) context.getBean("MyCaluter-id");
        IShape rectangle = myCaluter.caculate_function("rectangle");
        System.out.println(rectangle.area());
        System.out.println(rectangle.cycle());
    }
}
