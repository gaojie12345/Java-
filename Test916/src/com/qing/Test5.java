package com.qing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            char[] c1 = str1.toCharArray();
            char[] c2 = str2.toCharArray();
            List<Character> list1 = new ArrayList<>();
            List<Character> list2 = new ArrayList<>();
            for (int i = 0; i < c1.length; i++) {
                list1.add(c1[i]);
            }
            for (int i = 0; i < c2.length; i++) {
                list1.add(c2[i]);
            }

            boolean flag = true;
            for (int i : list2) {
                int count1 = 0;
                int count2 = 0;
                if (!list1.contains(i)) {
                    flag = false;
                    System.out.println("No");
                    break;
                } else {

                    for (int j :list1) {
                        if(j == i) {
                            count1++;
                        }
                    }
                    for (int m : list2) {
                        if (m == i) {
                            count2++;
                        }
                    }
                    count2 -= 1;
                    if(count1 <= count2){
                        System.out.println("No");
                    }
                }
            }
            if (flag) {
                System.out.println("Yes");
            }
        }
    }
}
