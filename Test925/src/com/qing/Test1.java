package com.qing;


import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            for (int j = b;j < a;j++) {
                int c = j % 10;
                while (j > 0) {
                    if (c == b) {
                        data[i]++;
                    }
                    j = j / 10;
                    c = j % 10;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(data[i]);
        }
    }
}
