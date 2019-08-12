package com.qing;

/**
 * 锁的消除
 */
public class Test4 {
   /* // private static StringBuffer sb = new StringBuffer();
    private final static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        synchronized (sb){
            sb.append("a");
            sb.append("b");
            sb.append("c");
        }
        System.out.println(sb.toString());
    }*/
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
    }
}
