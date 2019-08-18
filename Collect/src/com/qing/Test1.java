package com.qing;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Test1 {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person(21,"B"));
        set.add(new Person(20,"A"));
        set.add(new Person(22,"b"));
        set.add(new Person(22,"b"));
        System.out.println(set);
    }
}
