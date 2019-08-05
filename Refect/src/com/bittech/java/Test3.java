package com.bittech.java;

import java.util.Date;

public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException {
        Date date = new Date();
        System.out.println(date.getClass());

        Class cls = Class.forName("java.util.Date");
        System.out.println(cls);

        Class ss = Date.class;
        System.out.println(ss);
    }
}
