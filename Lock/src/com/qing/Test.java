package com.qing;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TickLock implements Runnable {
    private int ticket = 1000;
    private Lock ticketLock = new ReentrantLock();
    @Override
    public void run() {
       for (int i = 0;i < 1000;i++) {
           try {
               ticketLock.lock();
               if (ticket >0) {
                   System.out.println(Thread.currentThread().getName() +"还剩下："+ ticket--+ "票");
               }

           }finally {
               ticketLock.unlock();
           }
       }
    }
}

public class Test {
    public static void main(String[] args) {
        TickLock tickLock = new TickLock();
        Thread thread1 = new Thread(tickLock);
        Thread thread2 = new Thread(tickLock);
        Thread thread3 = new Thread(tickLock);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
