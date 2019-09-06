package com.qing;

public class Test1 {
     String s;

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.go();
    }

    void Test1() {
        s = "ss";
    }

    void go() {
        System.out.println(s);
    }
}
