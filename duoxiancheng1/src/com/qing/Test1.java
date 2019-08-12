package com.qing;

/**
 * 同步代码块
 */

class TicketTask implements Runnable{
    private int ticket = 20;
    @Override
    public void run() {
        for (int i = 0;i < 20;i++) {
            synchronized (this){
                if (ticket > 0) {
                    try {
                        Thread .sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "还剩下" + ticket-- + "票");                }
            }
        }
    }
}

public class Test1 {
    public static void main(String[] args) {
        TicketTask ticketTask = new TicketTask();
        Thread thread1 = new Thread(ticketTask,"黄牛A");
        Thread thread2 = new Thread(ticketTask,"黄牛B");
        Thread thread3 = new Thread(ticketTask,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
