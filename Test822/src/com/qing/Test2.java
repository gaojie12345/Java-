package com.qing;

import java.util.*;
public class Test2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            char[] data = s1.toCharArray();
            for(int i = 0;i < data.length;i++) {
                if(!s2.contains(String.valueOf(data[i]))){
                    System.out.print(data[i]);
                }
            }
        }
    }
}
