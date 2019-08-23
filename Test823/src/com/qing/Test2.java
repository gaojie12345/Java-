package com.qing;


import java.util.Arrays;
import java.util.Scanner;

public class Test2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        String[] a = str.split(" ");
        int[] data = new int[a.length];
        for(int i = 0;i < a.length;i++) {
            data[i] = Integer.parseInt(a[i]);
        }
        Arrays.sort(data);
        int count = 0;
        int left = 0;
        int right = data.length-1;
        while(left <= right) {
            if(data[left] + data[right] <= n) {
                count++;
                right--;
                left++;
            } else{
                count++;
                right--;
            }
        }
        System.out.println(count);
    }
}