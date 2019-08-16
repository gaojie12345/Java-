package com.qing;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TaskInterrupt implements Runnable {
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            while (true) {
                lock.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            System.err.println("线程响应中断");
            return;
        } finally {
            lock.unlock();
        }

    }
}

public class LockInterrupt {
    public static void main(String[] args) {
        TaskInterrupt taskInterrupt = new TaskInterrupt();
        Thread thread = new Thread(taskInterrupt);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
