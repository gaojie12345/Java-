package com.qing.server.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadServer {
    //支持100个客户端
    //一个Thread可以处理10个client
    private static ExecutorService executor;

    public static void main(String[] args) {
        //将数据通过外部的方式传入程序
        //1:键盘输入
        //2:参数String[] args
        //3:文件Properties
        //4:数据库
        int defaultPort = 8080;
        int defaultThread = 10;
        int port = defaultPort;
        int thread = defaultThread;
        for (String arg : args) {
            if (arg.startsWith("--port=")) {
                String portStr = arg.substring("--port=".length());
                try {
                    port = Integer.parseInt(portStr);
                } catch (NumberFormatException e) {
                    port = defaultPort;
                }
            }
            if (arg.startsWith("--thread=")) {
                String threadStr = arg.substring("--thread=".length());
                try {
                    thread = Integer.parseInt(threadStr);
                } catch (NumberFormatException e) {
                    thread = defaultThread;
                }
            }
        }


        try {
            executor = Executors.newFixedThreadPool(thread, new ThreadFactory() {
                private final AtomicInteger id = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setName("Thread-Client-Handler-" + id.getAndIncrement());
                    return t;
                }
            });
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动：" + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
            while (true) {
                final Socket client = serverSocket.accept();
                //使用线程池
                executor.execute(new ClientHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
