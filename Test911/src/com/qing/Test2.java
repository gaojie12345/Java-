package com.qing;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(5,"111");
        map.put(6,"222");
        map.put(7,"333");
        map.put(8,"444");
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer,String> s = iterator.next();
            System.out.println(s.getKey() + " : " + s.getValue());
        }

    }
}
