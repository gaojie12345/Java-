package com.bite;

import java.io.*;

public class DserTset {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("C:\\Users\\高杰\\Desktop\\TestIo.TXT");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object obj = in.readObject();
        System.out.println(obj);
    }
}
