package com.spring.convert;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.定义自定义类型的转化器，该转化器要继承PropertyEditorSupport类
 * 2.注册该类到Spring容器去
 */
public class MyConvertUtils extends PropertyEditorSupport {
    private String format = "yyyy-MM-dd";

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("MyConvertUtils----text = " + text);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date date = sdf.parse(text);
            this.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
