package com.qing;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        Arrays.sort(data);
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int s = j;
                int a = 2;
                int g = data[j] - data[i];
                for (int k = j + 1; k < n; k++) {
                    if (data[k] - data[n] == g) {
                        a = a + 1;
                        n = k;
                    }
                    if (data[k] - g > data[n]) {
                        break;
                    }
                }
                if (count < a) {
                    count = a;
                }
            }
        }
        System.out.println(count);
    }
}
