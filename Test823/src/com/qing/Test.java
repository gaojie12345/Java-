package com.qing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] a = str.split(" ");
                int[] data = new int[a.length];
            for (int i = 0; i < data.length;i++) {
                data[i] = Integer.parseInt(a[i]);
                System.out.print(data[i]);
            }

         }


    }
}
