package com.qing;

public class dead_lock {
    private static Object work = new Object();
    private static Object money = new Object();
    public static void main(String[] args) {
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (work){
                    System.out.println("给钱在工作");
                    synchronized (money) {
                        System.out.println("给我钱");
                    }
                }
            }
        });
        Thread boss = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (money) {
                    System.out.println("先干活，再给亲啊");
                    synchronized (work) {
                        System.out.println("干");
                    }
                }
            }
        });
        worker.start();
        boss.start();
    }
}
