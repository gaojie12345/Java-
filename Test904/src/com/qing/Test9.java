package com.qing;

/**
 * 一个整数中二进制1的个数
 */
public class Test9 {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n&(n - 1);
        }
        return count;
    }
}
