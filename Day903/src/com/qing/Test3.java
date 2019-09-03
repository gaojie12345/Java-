package com.qing;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] s = str.split(", ");
            int[] data = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                data[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(data);
            int n = data.length;
            int i = 0;
            int j = n - 1;
            int count = 0;
            while (i <= j) {
                if (data[i] + data[j] > 0) {
                    j--;
                } else if (data[i] + data[j] < 0) {
                    i++;
                } else {
                    i++;
                    j--;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
