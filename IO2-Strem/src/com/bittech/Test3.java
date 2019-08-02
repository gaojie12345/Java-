package com.bittech;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("参数非法");
        }
        //源文件
        File sourceFile = new File(args[0]);
        //目标文件
        File destFile = new File(args[1]);
        InputStream in = new FileInputStream(sourceFile);
        OutputStream out = new FileOutputStream(destFile);
        //文件拷贝
    }

    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        System.out.println("文件拷贝开始");
        long start = System.currentTimeMillis();
        int len = 0;
        //边读边取，每次只读一个字节，写一个字节
        byte[] data = new byte[1024];
        while ((len = in.read(data)) != -1) {
            out.write(data,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println("文件拷贝结束，共耗时:"+(end-start) + "毫秒");
    }

}
