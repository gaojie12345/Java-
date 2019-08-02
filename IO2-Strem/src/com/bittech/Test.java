package com.bittech;

import java.io.*;


public class Test {
    public static void main(String[] args) throws IOException {
        //1.取得终端
        File file = new File("C:\\Users\\高杰\\Desktop\\ass.java");
        //2.取得相应终端的输出流
        OutputStream out = new FileOutputStream(file);
        //3.将数据通过输出流输出
        out.write("hello".getBytes());
        //4.关闭流
        out.close();


    }
}
