package com.qing.client.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleClient {
    public static void main(String[] args) {

        //客户端
        String host = "127.0.0.1";
        int port = 8080;
        try {
            //1.创建客户端Socket和服务器建立连接
            final Socket socket = new Socket(host, port);
            //2.客户端进行接收和发送数据
            //2.1发送数据(write)
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println("服务器我来了...");
            printStream.flush();


            //2.2接收数据(read)
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            String message = scanner.next();
            System.out.println("从服务器端接受的数据是：" + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
