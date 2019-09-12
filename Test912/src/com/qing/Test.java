package com.qing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] data = str.toCharArray();

            int i = 0;
            List<Character> list = new ArrayList<>();

            while (i < data.length) {
                int count = 0;
                int j = i;
                for(; j < data.length; j++){
                    if(data[i] == data[j]){
                          count++;
                    }else{
                        break;
                    }
                }
                count += 48;
                char a = (char) count;
                list.add(a);
                list.add(data[i]);
                i = j;
            }
            for (char k : list) {
                System.out.print(k);
            }
        }
    }
}
