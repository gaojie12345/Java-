package com.qing;

import java.util.HashMap;
import java.util.Map;

public class Test5 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(2,"bit");
        map.put(3,"hello");
        map.put(4,"java");
        System.out.println(map.get(3));
    }
}
