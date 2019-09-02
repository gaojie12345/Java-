package com.qing;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = a * a;
            System.out.print(test(a));
            System.out.print(" " + test(b));
        }
    }

    public static int test(int x) {
        int sum = 0;
        for (; x != 0; ) {
            sum = sum + x % 10;
            x = x / 10;
        }
        return sum;
    }
}