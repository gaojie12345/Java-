package com.bite;

import java.io.*;

class MyPrint {
    private OutputStream out;

    public MyPrint(OutputStream out) {
        this.out = out;
    }

    public void print(String str) {
        try {
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void println(String str){
        this.print(str+"\n");
}
    public void print(double data) {
        this.print(String.valueOf(data));
    }
    public void println(double data) {
        this.print(data+"\n");
    }
    public void close(){
        try {
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Test1 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        System.out.println("请输入内容");
        byte[] data = new byte[1024];
        int len = in.read(data);
        System.out.println("输入内容为："+new String(data,0,len));
    }
}
