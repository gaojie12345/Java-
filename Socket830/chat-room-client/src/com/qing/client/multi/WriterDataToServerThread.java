package com.qing.client.multi;

import java.net.Socket;

public class WriterDataToServerThread extends Thread{
    private final Socket client;

    public WriterDataToServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        super.run();
    }
}
