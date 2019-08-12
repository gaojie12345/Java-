package com.qing;

import java.util.ArrayList;
import java.util.List;

class Goods {
    private String goodsName;
    private int count;
    private int maxCount;

    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    public synchronized void set(String goodsName) {
        while (count == maxCount) {
            System.out.println("此时还有商品，需要等待消费者消费了再生产");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goodsName = goodsName;
        count++;
        System.out.println(Thread.currentThread().getName() + "生产" + this);
        //唤醒消费者
        this.notifyAll();
    }

    public synchronized void get() {
        while (count == 0) {
            System.out.println("此时商品卖完了，需要等待卖家上架");
            //需要让消费者阻塞
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "消费" + this);
        //唤醒生产者
        this.notifyAll();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}

class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            this.goods.set("生产一个小黑瓶");
        }
    }
}

class Consumer implements Runnable {
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            this.goods.get();
        }
    }
}

public class CPTest {
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods(10);
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);
        List<Thread> list = new ArrayList<>();
        //产生20个生产者
        for (int i = 0; i < 20; i++) {
            list.add(new Thread(producer,"生产者" + (i + 1)));
        }
        //产生30个消费者
        for(int i = 0;i < 30;i++) {
            list.add(new Thread(consumer,"消费者" + (i+1)));
        }
        //启动所有的生产、消费者
        for (Thread thread : list) {
            thread.start();
        }
    }
}
