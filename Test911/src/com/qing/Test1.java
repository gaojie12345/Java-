package com.qing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hahahh");
        list.add("xixxix");
        list.add("qqqqqq");
        list.add("qwwqwq");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String a = iterator.next();
            System.out.println(a);
        }
    }
}
