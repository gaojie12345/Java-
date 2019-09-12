package com.qing;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(scanner.next());
            }
            int[] res = new int[n];

            for (int i = 0; i < n-1; i++) {
                if (data[i] < data[i + 1]) {
                    res[i] = 1;
                    res[i + 1] = 1;
                } else if (data[i] == data[i + 1]) {
                    res[i] = 1;
                    res[i + 1] = 1;
                } else {
                    res[i] =1;
                    res[i + 1] = 1;
                }


            }
            int a = 0;
            for (int i = 0; i < n;i++) {
                a += res[i];
            }
            System.out.println(a);
        }
    }
}
