package com.qing;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (data[i] < 0) {
                flag = false;
            }
        }
        int count = 0;
        if(flag) {
            for (int i = 0; i < n; i++) {
                count = data[i] + count;
            }
        }
        System.out.println(count);
    }
}
