package com.qing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "wo");
        map.put(2, "ta");
        map.put(3, "ni");
        map.put(4, "ai");
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,String> entr = iterator.next();
            System.out.println(entr.getKey() + " : " + entr.getValue());
        }
    }
}
