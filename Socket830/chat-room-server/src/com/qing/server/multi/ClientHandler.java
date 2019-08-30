package com.qing.server.multi;

import java.net.Socket;

public class ClientHandler implements Runnable{

    //Socket -> in out
    private final Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        //TODO 业务实现
    }
}
