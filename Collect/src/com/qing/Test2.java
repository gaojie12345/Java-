package com.qing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("bit");
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String str1 = iterator.next();
            System.out.println(str1);
        }
        System.out.println("--------------");
        while (iterator.hasPrevious()) {
            String str2 = iterator.previous();
            System.out.println(str2);
        }
    }
}
