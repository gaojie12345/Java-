package com.qing;

import java.util.Arrays;

/**
 * 基于数组的动态扩容
 * @param <E>
 */
public class Test<E> {
    //实际存放元素的数组
    private E[] elementData;
    //初始化长度
    private final static int DEFAULT_CAPACITY =10;
    private int size;

    //在构造方法中对数据做初始化
    public Test() {
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public Test(int initCap) {
        elementData = (E[]) new Object[initCap];
    }

    public void add(E e) {
        //此时数组已经放不下元素，需要扩容
        if (size == elementData.length) {
            int oldCap = elementData.length;
            int newCap = oldCap + ((size < 64)?oldCap+1:oldCap>>1);
            if (newCap > Integer.MAX_VALUE-8) {
                throw new IndexOutOfBoundsException("数组元素过多！");
            }else {
                elementData = Arrays.copyOf(elementData,newCap);
            }
        }
        elementData[size] = e;
    }
}
