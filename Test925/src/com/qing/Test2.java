package com.qing;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(te());
    }
    public static int te(){
        try{
            int i = 1 /0;
            return 0;
        }catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }
}
