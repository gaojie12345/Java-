package com.qing;

public class Test {
    public static void main(String[] args) {
        System.out.println(test1());
    }
    public static int test() {
        try {
            return 1;
        }catch (Exception e) {
            return 2;
        }finally {
            return 3;
        }
    }
    public static int test1() {
        int x = 0;
        try {
            return x;
        }finally {
            x= 1;
        }
    }
}
