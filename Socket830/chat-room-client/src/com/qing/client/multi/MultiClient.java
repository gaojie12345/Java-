package com.qing.client.multi;

import java.io.IOException;
import java.net.Socket;

public class MultiClient {
    public static void main(String[] args) {
        int defaultPort = 8080;
        String defaultHost = "127.0.0.1";

        int port = defaultPort;
        String host = defaultHost;

        //--port-8081  --host=127.0.0.1
        for (String arg : args) {
            if (arg.startsWith("--port=")) {
                try {
                    String portStr = arg.substring("--port=".length());
                    port = Integer.parseInt(portStr);
                } catch (NumberFormatException e) {
                    port = defaultPort;
                }
            }
            if (arg.startsWith("--host=")) {
                host = arg.substring("--host=".length());
            }
        }
        try {
            Socket socket = new Socket(host, port);
            Thread read = new ReadDataFromServerThread(socket);
            read.setName("Thread-Client-Read");
            read.start();

            Thread write = new WriterDataToServerThread(socket);
            write.setName("Thread-Client-Write");
            write.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
