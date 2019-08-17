package com.qing;

import java.util.concurrent.*;


class CallableTest implements Callable<String> {
    private int ticket = 20;
    @Override
    public String call() throws Exception {
        for (int i= 0;i < 20;i ++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"还剩下："+ticket--+"票");
            }
        }
        return Thread.currentThread().getName() + "票完了";
    }
}
public class ExecutorTest {
    public static void main(String[] args) {
        //创建线程池对象
        ExecutorService executorService =
                new ThreadPoolExecutor(
                        2,
                        3,
                        60,
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>());
        CallableTest callableTest = new CallableTest();
        for (int i = 0;i < 5;i++) {
            executorService.submit(callableTest);
        }
        executorService.shutdown();
    }
}
