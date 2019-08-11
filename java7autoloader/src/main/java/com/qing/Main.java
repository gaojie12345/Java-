package com.qing;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /**
         * 目标是找到com.qing.cases下的所有类
         * 转换：能找到存放com.qing.cases这个包的目录
         *      扫描整个目录下的所有*.class
         */

        /**
         * 如何找到这个目录
         */
        //先找到这个类的加载器
        ClassLoader classLoader = Main.class.getClassLoader();
        //获取到这个类的所在目录
        Enumeration<URL> urls = classLoader.getResources("com/qing/cases");
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url.getPath());
            //只能处理*.class的情况，无法处理达成jar包的情况
            File dir = new File(url.getPath());
            if (!dir.isDirectory()) {
                continue;
            }

            File[] files = dir.listFiles();
            if (files == null) {
                continue;
            }

            for (File file : files) {
                String fileName = file.getName();
                String className = fileName.substring(0, fileName.length() - 6);
                Class<?> cls = Class.forName("com.qing.cases."+ className);

               Class<?>[] interfaces = cls.getInterfaces();
               for (Class<?> interf : interfaces) {
                   if (interf == Case.class) {
                       System.out.println(className);
                   }
               }
            }
        }
    }
}
