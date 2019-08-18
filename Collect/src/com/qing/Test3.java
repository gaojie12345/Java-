package com.qing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("bit");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
