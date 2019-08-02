package com.bite;

import java.io.*;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\高杰\\Desktop\\TestIo.TXT");
        /*PrintStream printStream = new PrintStream(new FileOutputStream(file));
        printStream.println("姓名：蛋哥");
        printStream.println(34);
        printStream.println("工资为5000");*/
        Scanner scanner = new Scanner(new FileInputStream(file));
        while (scanner.hasNext()){
            String str= scanner.next();
            System.out.println(str);
        }
    }
}
