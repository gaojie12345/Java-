package com.qing;

import java.util.*;
public class Test1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(res(n));
    }
    public static int res(int n) {
        if(n % 2 != 0 || n == 10 || n < 6) {
            return -1;
        }
        if(n % 8 ==0){
            return n/8;
        }
        return 1 + (n/8);

    }
}