package com.bittech;

/**
 * 针对单次实验的次数变多
 */
public class Test3 {
    private static String addString() {
        String a = "";
        for (int i = 0; i < 10; i++) {
            a += i;
        }
        return a;
    }

    private static String addStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0;i < 10;i++) {
            for (int j = 0;j < 1000;j++) {
                long t1 = System.nanoTime();
                addStringBuilder();
                long t2 = System.nanoTime();
                addString();
                long t3 = System.nanoTime();
                System.out.println("第"+i+"次测试：StringBuilder 耗时："+(t2-t1));
                System.out.println("第"+i+"次测试：String 耗时："+(t3-t2));
            }
        }
    }
}
