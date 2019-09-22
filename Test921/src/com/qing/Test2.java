package com.qing;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String s1 = str.substring(0, str.length() - 16);
        String s2 = str.substring(str.length() - 15, str.length());
        char[] data = s1.toCharArray();
        String s = "MASK";
        char[] data2 = s.toCharArray();
        char[] res = new char[data.length + data2.length];
        int count = data.length / 4;
        int l = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 4; j++) {
                res[l] = (char) (data[j] + data2[j]);
                l++;
            }
        }
        int co = data.length % 4;
        for (int i = count * 4 + 1; i < res.length; i++) {
            if (co == 1) {
                res[i] = (char) (data[i] + data2[0]);
            }
            if (co == 2) {
                for (int k = 0;k < 2;k++) {
                    res[i] = data2[k];
                }
            }
            if (co == 3) {
                for (int k = 0;k < 3;k++) {
                    res[i] = data2[k];
                }
            }

        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
        System.out.print(s2);
    }
}
