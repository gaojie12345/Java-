package com.qing;

/**
 * 锁的粗化
 */
public class Test3{
   // private static StringBuffer sb = new StringBuffer();
    private final static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        synchronized (sb){
            sb.append("a");
            sb.append("b");
            sb.append("c");
        }
        System.out.println(sb.toString());
    }
}
