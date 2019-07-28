package com.bite.J;

public class InsertSort {
    public static void main(String[] args) {
        int[] res = new int[]{4, 5, 6, 1, 2, 3};
        binaryInsertSort(res);
        Test.print(res);
    }

    /**
     * 直接插入排序：时间复杂度O(n^2)
     * 空间复杂度
     * 原地排序
     * 稳定
     *
     * @param data
     */
    private static void insertSort(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        }
        //外层循环表示未排序的数，i表示未排序的第一个数
        for (int i = 1; i < n; i++) {
            int value = data[i];
            //外层循环表示已排序的数，j表示已排序的最后一个数
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (data[j] > value) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            //找到要插入的位置，将数插入
            data[j + 1] = value;
        }
    }

    /**
     * 折半插入(二分查找)
     *
     * @param data
     */
    private static void binaryInsertSort(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        }else {
            //遍历未排序的元素，i表示没有排序的第一个元素
            for (int i = 1; i < n; i++) {
                //已排序的第一个元素
                int low = 0;
                //已排序的最后一个元素
                int high = i - 1;
                int j = i - 1;
                //寻找要插入的元素的位置
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (data[i] <= data[mid]) {
                        high = mid - 1;
                    }
                    if (data[i] > data[mid]) {
                        low = mid + 1;
                    }
                }
                //找到位置之后开始将元素搬移
                for (; j > high; j--) {
                    data[j + 1] = data[j];
                }
                data[j + 1] = data[i];
            }
        }
    }
}
