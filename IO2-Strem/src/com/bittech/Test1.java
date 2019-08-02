package com.bittech;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //取得终端对象
        File file = new File("C:\\Users\\高杰\\Desktop\\TestIO.txt");
        //取得输入流
        if (file.exists()) {
            InputStream in = new FileInputStream(file);
            byte[] data = new byte[1024];
            int len = 0;
            len = in.read(data);
            String str = new String(data,0,len);
            System.out.println(str);
        }
    }
}
