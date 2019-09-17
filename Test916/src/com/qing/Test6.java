package com.qing;

import java.io.BufferedReader;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            str1.toUpperCase();
            str2.toUpperCase();
            char[] c1 = str1.toCharArray();
            char[] c2 = str2.toCharArray();
            Set<Character> set1 = new LinkedHashSet<>();
            Set<Character> set2 = new LinkedHashSet<>();
            for (int i = 0; i < c1.length;i++) {
                set1.add(c1[i]);
            }
            for (int i = 0; i < c2.length;i++) {
                set2.add(c2[i]);
            }
            for (Character v : set2) {
                set1.remove(v);
            }
            for (Character c : set1) {
                System.out.println(c);
            }
        }
    }


}
