package com.bittech;

import java.lang.annotation.*;

//该注解用来注解方法
@Target(ElementType.METHOD)
//注解信息保留到运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface Measurement {
    //一共进行几组测试
    int iterations();
    //每组进行多少次方法
    int countPerGroup();
}
