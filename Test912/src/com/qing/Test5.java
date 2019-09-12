package com.qing;

import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] s = str.split(",");
            int[] data = new int[s.length];
            for (int i = 0; i < data.length; i++) {
                data[i] = Integer.parseInt(s[i]);
            }

            List<Integer> list = new ArrayList<>();
            list.add(data[0]);
            for (int i = 1; i < data.length;i++) {
                if(!list.contains(data[i])) {
                    list.add(data[i]);
                }
            }
            for (int i : list) {
                System.out.print(i);
            }

        }
    }
}
