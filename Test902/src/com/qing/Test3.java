package com.qing;

/**
 * 直接插入
 * 将待排序数组分为两个区间：已排序、未排序
 * 默认第一个数为已排序--->j    i从1开始遍历
 * 如果j大于i的话就将j后移，然后寻找插入位置将i插入到j的后一个位置
 */
public class Test3 {
    public static void main(String[] args) {
        int[] res = new int[]{4, 5, 6, 1, 3, 2};
        test(res);
        for (int i : res) {
            System.out.print(i + "、");
        }
    }

    private static void test(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = data[i];
            int j = i- 1;
            for (;j >=0; j--) {
                if(data[j] > value) {
                    data[j + 1] = data[j];
                }else {
                    break;
                }
            }
            data[j + 1] = value;
        }
    }
}
