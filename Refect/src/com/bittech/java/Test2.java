package com.bittech.java;

import org.omg.CORBA.PERSIST_STORE;

import java.lang.reflect.Constructor;

class Person{
    /*public Person() {
    }
    public Person(String name) {
    }
    public Person(String name,int age) {
    }*/
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test2 {
    public static void main(String[] args) throws IllegalAccessException,
            InstantiationException, NoSuchMethodException {

    }
}
