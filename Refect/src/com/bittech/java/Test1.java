package com.bittech.java;

interface Fruit{}
interface Message{}
class CLS implements Fruit,Message{
}

public class Test1 {
    public static void main(String[] args) {
        Class<?> cls = CLS.class;//取得class对象
        //取得包名称com.bittech.java
        System.out.println(cls.getPackage().getName());
        //取得父类名称java.lang.Object
        System.out.println(cls.getSuperclass().getName());
        Class<?>[] classes = cls.getInterfaces();
        //取得实现的父接口对象
        //com.bittech.java.Fruit
        //com.bittech.java.Message
        for (Class<?> class1:classes){
            System.out.println(class1.getName());
        }
    }
}
