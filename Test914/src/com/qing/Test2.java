package com.qing;

class MyThread2 implements Runnable {
    private int ticket = 1000;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (this) {
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ",还有" + this.ticket-- + " 张票");
                }
            }
        }
    }
}

public class Test2 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt, "黄牛A");
        Thread t2 = new Thread(mt, "黄牛B");
        Thread t3 = new Thread(mt, "黄牛C");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}

