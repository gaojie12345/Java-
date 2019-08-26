package com.qing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestEmp {
    public static void main(String[] args) {

        //需求：将一个字符串的内容赋值给Emp对象的属性
        //描述
        //比如："name:张三/job:softDeveloper"
        String value = "name:张三|job:SoftDeveloper";
        String[] attributeNameAndValues = value.split("|");
        Emp emp = new Emp();
        for (String nameAndValue : attributeNameAndValues) {
            String[] nv = nameAndValue.split(":");
            setXxx(emp, nv[0], nv[1]);
        }
        System.out.println(emp);
    }

    public static void setXxx(Object object, String name, String value) {
        Class classz = object.getClass();
        String setMethodName = "set" + name.substring(0,1).toUpperCase()
                + (name.length() > 1 ? name.substring(1) : "");
        try {
            Method setMethod = classz.getMethod(setMethodName, name.getClass());
                setMethod.invoke(object, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
