package com.qing;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("bit");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            list.remove("world");
            System.out.println(str);
        }
    }
}
