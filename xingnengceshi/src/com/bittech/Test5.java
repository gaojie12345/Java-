package com.bittech;

import java.lang.reflect.Method;

public class Test5 {
    @Measurement(iterations = 10, countPerGroup = 1)
    public static String addString() {
        String a = "";
        for (int i = 0; i < 10; i++) {
            a += i;
        }
        return a;
    }
    @Measurement(iterations = 10,countPerGroup = 1)
    public static String addStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 10;i++) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void runCase(Method method, int iterations, int countPerGroup){

    }
    public static void main(String[] args) {

    }
}
