package com.qing;

import java.math.BigDecimal;

/**
 * 保留2位小数
 */
public class Test4 {
    public static void main(String[] args) {
        double f = 1111.5676;
        System.out.println(String.format("%.2f",f));
    }
}
