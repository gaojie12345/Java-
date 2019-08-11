package com.qing;

import com.qing.annotations.Benchmark;
import com.qing.annotations.Measurement;
import com.qing.cases.Case;


import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

class CaseRunner {
    private final int DEFAULT_ITERATIONS = 10;
    private final int DEFAULT_GROUP = 5;
    private final List<Case> caseList;

    public CaseRunner(List<Case> caseList) {
        this.caseList = caseList;
    }

    public void run() throws InvocationTargetException, IllegalAccessException {
        for (Case bCase : caseList) {
            int iterations = DEFAULT_ITERATIONS;
            int group = DEFAULT_GROUP;

            //先获取类级别的配置
            Measurement classMeasurement = bCase.getClass().getAnnotation(Measurement.class);
            if (classMeasurement != null) {
                iterations = classMeasurement.iterations();
                group = classMeasurement.group();
            }

            //找到对象中哪些方法是需要测试的方法
            Method[] methods = bCase.getClass().getMethods();
            for (Method method : methods) {
                Benchmark benchmark = method.getAnnotation(Benchmark.class);
                if (benchmark == null) {
                    continue;
                }
                Measurement methodMeasurement = method.getAnnotation(Measurement.class);
                if (methodMeasurement != null) {
                    iterations = methodMeasurement.iterations();
                    group = methodMeasurement.group();
                }
                runCase(bCase, method, iterations, group);
            }
        }
    }

    private void runCase(Case bCase, Method method, int iterations, int group) throws InvocationTargetException, IllegalAccessException {
        System.out.println(method.getName());

        for (int i = 0; i < group; i++) {
            long t1 = System.nanoTime();
            for (int j = 0; j < iterations; j++) {
                method.invoke(bCase);
            }
            long t2 = System.nanoTime();
            System.out.println("第" + i + "次实验耗时："+ (t2 - t1));
        }

    }
}

public class CaseLoader {
    public CaseRunner load() throws Exception {
        String pkdDot = "com.qing.cases";
        String pkg = "com/qing/cases";

        List<String> classNameList = new ArrayList<>();

        //1.根据一个固定类找到类加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        //2.根据类加载器找到类文件所在目录
        Enumeration<URL> urls = classLoader.getResources(pkg);

        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            /*if (!url.getProtocol().equals("file")) {
                //如果不是*.class文件，暂时不支持
                continue;
            }*/


            File dir = new File(url.getPath());
            if (!dir.isDirectory()) {
                //不是目录
                continue;
            }
            //扫描该目录下的所有*.class文件，作为所有的类文件
            File[] files = dir.listFiles();
            if (files == null) {
                continue;
            }

            for (File file : files) {
                String filename = file.getName();
                String className = filename.substring(0, filename.length() - 6);
                classNameList.add(className);
            }
        }
        List<Case> caseList = new ArrayList<Case>();
        for (String className : classNameList) {
            Class<?> cls = Class.forName(pkdDot + "." + className);
            if (hasInterface(cls, Case.class)) {
                caseList.add((Case) cls.newInstance());
            }
        }

        return new CaseRunner(caseList);
    }

    private boolean hasInterface(Class<?> cls, Class<?> intf) {
        Class<?>[] intfs = cls.getInterfaces();
        for (Class<?> i : intfs) {
            if (i == intf) {
                return true;
            }
        }
        return false;
    }
}
