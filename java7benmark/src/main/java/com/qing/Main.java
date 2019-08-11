package com.qing;

import com.cases.StringConcatCase;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        int iterations = 10;//默认配置
        int group = 5;//默认配置

        StringConcatCase object = new StringConcatCase();
        //通过反射来获取StringConcatCase类
        Class<?> cls = object.getClass();
        //获取类中的measurement的注解
        Annotation annotationMeasurement = cls.getAnnotation(Measurement.class);
        //如果注解不为空就是已经配置过了，不需要使用默认配置
        if (annotationMeasurement != null) {
            Measurement measurement = (Measurement) annotationMeasurement;
            iterations = measurement.iterations();
            group = measurement.group();
        }

        //获取到StringConcatCase类中的所有公开方法
        Method[] methods = cls.getMethods();
        //遍历所有获取到的方法
        for (Method method:methods) {
            //获取方法中的benchemark注解
            Annotation annotationBenchmark = method.getAnnotation(Benchmark.class);
            //如果注解为空，意味着方法中没有benchmark注解，不属于要测试的方法。跳过
            if (annotationBenchmark == null) {
                continue;
            }
            //打印被Benchmark注解修的方法
            System.out.println(method.getName());
            //继续进行默认配置
            int methodIterations = iterations;
            int methodGroup = group;
            //获取方法中的measurement注解
            Annotation methodAnnotation = method.getAnnotation(Measurement.class);
            //如果measurement注解不为空，则调用measurement的配置
            if (methodAnnotation != null) {
                Measurement methodMeasurement = (Measurement) methodAnnotation;
                methodIterations = methodMeasurement.iterations();
                methodGroup = methodMeasurement.group();
            }
            //开始进行测试，调用对象的实例方法
            for (int i = 0;i <methodGroup;i++) {
                long t1 = System.nanoTime();
                for (int j = 0;j <methodIterations;j++) {
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                long t2 = System.nanoTime();
                System.out.println("第" + i + "次测试耗时："+(t2-t1));
            }
        }
    }
}
