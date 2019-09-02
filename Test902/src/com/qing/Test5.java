package com.qing;

/**
 * 希尔排序
 */

public class Test5 {
    public static void main(String[] args) {
        int[] res = new int[]{4, 5, 6, 1, 2, 3};
        test(res);
        for (int i : res) {
            System.out.print(i + "、");
        }
    }

    public static void test(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        }
        int step = n / 2;
        for (int i = step; i < n; i++) {
            int value = data[i];
            int j = i - step;
            for (; j >= 0; j--) {
                if (data[j] > value) {
                    data[j + step] = data[j];
                }
            }
            data[j + 1] = value;
        }
        step = step / 2;
    }
}
