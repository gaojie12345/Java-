package com.qing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] s = str.split(" ");
        int[] data = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            data[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < s.length; i++) {
            int count = 0;
            for (int j = 0; j < s.length; j++) {
                if(data[i] == data[j]) {
                    count++;
                }
            }
            if(count >= (s.length / 2)) {
                System.out.print(data[i]);
                break;
            } else {
                break;
            }
        }

    }

}
