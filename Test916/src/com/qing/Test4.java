package com.qing;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] s = str.toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (s[i] >= 'a' && s[i] <= 'y' || s[i] >= 'A' && s[i] <= 'Y') {
                s[i] += 1;
            } else if(s[i] == 'z') {
                s[i] = 'a';
            } else if(s[i] == 'Z') {
                s[i] = 'A';
            }
        }
        System.out.println(s);
    }
}
