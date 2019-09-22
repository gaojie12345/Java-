package com.qing;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a);
        System.out.println(b);
        System.out.println(method(a,b));
    }

    public static int method(int n, int m) {
        if (n == 0 && m == 0) {
            return 0;
        }
        if (n == 0 || m == 0) {
            return 1;
        }
        return method(n - 1,m) + method(n, m-1);
    }
}
