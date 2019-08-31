package com.qing.server.multi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable {

    private static final Map<String, Socket> SOCKET_MAP = new ConcurrentHashMap<>();
    //当前客户端注册的名称
    private String currentName;

    //Socket -> in out
    private final Socket client;


    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        //业务实现
        try {
            InputStream in = this.client.getInputStream();
            Scanner scanner = new Scanner(in);
            while (true) {
                String line = scanner.nextLine();
                if (line.startsWith("register")) {
                    //注册流程
                    String[] segments = line.split(":");
                    if (segments.length == 2 && segments[0].equals("register")) {
                        String name = segments[1];
                        register(name);
                    }
                    continue;
                }
                if (line.startsWith("group")) {
                    //群聊流程
                    String[] segments = line.split(":");
                    if (segments.length == 2 && segments[0].equals("group")) {
                        String message = segments[1];
                        groupChat(message);
                    }
                    continue;
                }
                if (line.startsWith("private")) {
                    //私聊流程
                    String[] segments = line.split(":");
                    if (segments.length == 3 && segments[0].equals("private")) {
                        String name = segments[1];
                        String message = segments[2];
                        privateChat(name, message);
                    }
                    continue;
                }
                if (line.equals("quit")) {
                    //退出流程
                    quit();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void quit() {
        //退出
        Iterator<Map.Entry<String, Socket>> iterator = SOCKET_MAP.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Socket> entry = iterator.next();
            if (entry.getValue() == this.client) {
                System.out.println(entry.getKey() + "退出");
                iterator.remove();
                break;
            }
            printOnlineClient();
        }
    }

    private void privateChat(String name, String message) {
        //私聊

        Socket socket = SOCKET_MAP.get(name);
        if (socket != null) {
            this.sendMessage(socket, this.currentName + "说:" + message);
        }
    }

    private void groupChat(String message) {
        //群聊
        //发送消息给当前在线的客户端，不包含自己
        //谁  发    消息
        for (Map.Entry<String, Socket> entry : SOCKET_MAP.entrySet()) {
            Socket socket = entry.getValue();
            if (socket != this.client) {
                this.sendMessage(socket, this.currentName + "说:" + message);
            }
        }
    }

    private void register(String name) {
        //注册
        //name -> socket
        //key  -> value
        SOCKET_MAP.put(name, this.client);
        this.currentName = name;
        this.sendMessage(this.client, "恭喜<" + name + ">注册成功");
        printOnlineClient();
    }

    private void printOnlineClient() {
        System.out.println("当前在线的客户端有 " + SOCKET_MAP.size() + " 名称列表如下:");
        for (String key : SOCKET_MAP.keySet()) {
            System.out.println(key);
        }
    }

    private void sendMessage(Socket socket, String message) {
        try {
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println(message);
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
//字节流转化成字符流 -->装饰器设计模式