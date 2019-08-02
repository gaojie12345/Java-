package com.bite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\高杰\\Desktop\\TestIo.TXT");
        Writer writer = new FileWriter(file);
        writer.write("真好");
        writer.close();
    }
}
