package com.bittech;

public class Test {
    public static void main(String[] args) {
        int[] m = new int[]{1, 8, 2, 7, 6, 4, 5, 3};
        bubberSort(m);
        Day.print(m);
    }
    /**
     * 冒泡排序：时间复杂度O(n^2)
     * 空间复杂度O(1)
     * 原地排序
     * 稳定
     *
     * @param data
     */
    private static void bubberSort(int[] data) {
        int n = data.length;
        //外层循环表示多少个数
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            //内层循环表示每个数比较多少次
            for (int j = 0; j < n - i - 1; j++) {
                if (n <= 1) {
                    return;
                } else {
                    if (data[j] > data[j + 1]) {
                        flag = true;
                        if (data[j] > data[j + 1]) {
                            int m = data[j];
                            data[j] = data[j + 1];
                            data[j + 1] = m;
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
