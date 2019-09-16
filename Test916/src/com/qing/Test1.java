package com.qing;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] c = str.toCharArray();
            int max = 0;
            int count = 0;
            int e = 0;
            int[] data = new int[255];
            for (int i = 0; i < c.length; i++) {
                if (c[i] >= '0' && c[i] <= '9') {
                    data[i] = c[i];
                    count++;
                    if (count > max) {
                        e = i;
                        max = count;
                    }
                } else {
                    count = 0;
                }
            }
            System.out.print(max + "/");
            for (int i = 0; i < data.length; i++) {
                System.out.print(i);
            }
        }
    }
}
