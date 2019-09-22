package com.qing;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int S = scanner.nextInt();
        int T = scanner.nextInt();
        int a = 0;
        int b = 0;
        boolean f = true;
        for (int i = 1; i < T; i++) {
            a += 13;
            if (M >= 10) {
                M -= 10;
                b += 50;
            } else {
                M += 4;
            }
            a = Math.max(a, b);
            if (a >= S) {
                f = false;
                System.out.println("Yes");
                System.out.println(i);
                break;
            }
        }
        if(f) {
            System.out.println("No");
            System.out.println(a);
        }

    }
}
