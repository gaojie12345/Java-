package com.qing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] data = str.toCharArray();
        List<Character> list = new ArrayList<>();
        int i = 0;
        while(i < data.length) {
            int j = i;
            int count =0;
            for (;j < data.length;j++) {
                if (data[i] == data[j]) {
                    count++;
                }else {
                    break;
                }
            }
            count = count +48;
            char a = (char)count;
            list.add(a);
            list.add(data[i]);
            i = j;
        }

        for(char k : list) {
            System.out.print(k);
        }
    }
    
}
