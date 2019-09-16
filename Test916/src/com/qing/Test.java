package com.qing;

import javafx.scene.transform.Scale;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = scanner.nextInt();
            }

            int max = 0;
            for (int i = 1; i < n; i++) {
                int a = data[i] - data[i - 1];
                Math.abs(a);
                if (a > max) {
                    max = data[i] - data[i - 1];
                }
            }
            System.out.println(max);
        }
    }
}
