package com.qing;

/**
 * 折半查找
 * 将待排序的数组分为两部分：已排序、未排序
 * 已排序的最后一个元素为j，已排序的第一个元素为low，最后一个元素为high
 * 未排序的第一个元素为i
 * 取已排序的元素的中点mid与i相比，如果mid大于i的值，则high = mid-1
 * 反之则low = mid+1
 * 直到low不小于high，找到插入的位置为high +1
 * 开始将已排序的元素往后移
 * 搬移完成之后将i插入指定的位置
 */
public class Test4 {
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
        for (int i = 1; i < n; i++) {
            int value = data[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (data[mid] > value) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            int j = i - 1;
            for (; j > high; j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = value;
        }
    }
}
