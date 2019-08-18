package com.qing;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("Bit");
        set.add("Hello");
        set.add("java");
        set.add(null);
        set.add(null);
        System.out.println(set);
    }
}
