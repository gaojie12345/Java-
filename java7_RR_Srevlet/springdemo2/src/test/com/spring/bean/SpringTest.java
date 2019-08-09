package com.spring.bean;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {
    private ApplicationContext context = null;
    @Before
    public void testInit() {
        context = new ClassPathXmlApplicationContext(new String[]{"applicationContext-public.xml", "applicationContext-beans.xml","applicationContext-convert.xml"});
    }

    @Test
    public void testFunction() {
        Bean1 bean1 = (Bean1) context.getBean("bean1");
        /*System.out.println("strvValue = " + bean1.getStrValue());
        System.out.println("intVlaue = " + bean1.getIntValue());
        System.out.println("arrayValue = " + bean1.getArrayValue());
        System.out.println("listVlaue = " + bean1.getListValue());
        System.out.println("mapVlaue = " + bean1.getMapValue());
        System.out.println("setValue = " + bean1.getSetValue());*/
        //System.out.println("dateValue = " + bean1.getDateValue());
    }
    //@Test
    /*public void testFunction2() {
        Bean2 bean2 = (Bean2) context.getBean("bean2");
        System.out.println(bean2.getBean3().getId());
        System.out.println(bean2.getBean3().getUsername());
        System.out.println(bean2.getBean3().getPassword());

        System.out.println(bean2.getBean4().getId());
        System.out.println(bean2.getBean4().getUsername());

        System.out.println(bean2.getBean5().getAge());
    }*/

    @Test
    public void testFunction3() {
        Bean1 bean1 = (Bean1) context.getBean("bean1");
        System.out.println("dateValue = " + bean1.getDateValue());
    }

}
