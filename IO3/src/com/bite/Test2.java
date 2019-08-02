package com.bite;

import java.io.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        System.out.println("请输入内容：");
        String str = bufferedReader.readLine();
        System.out.println("输入内容为:"+str);
    }
}
