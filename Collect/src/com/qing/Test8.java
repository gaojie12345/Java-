package com.qing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Test8 {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        /*Properties properties = new Properties();
        InputStream in = Test8.class.getClassLoader().getResourceAsStream("test.properties");
        properties.load(in);
        System.out.println(properties.getProperty("xa"));
        System.out.println(properties.getProperty("sh"));*/
        Collections.addAll(list,"hello","java","hello","bit");
        }
}
