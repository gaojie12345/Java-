package com.jie;

import com.jie.Day;

public class Sort {
    public static void main(String[] args) {
        int[] res = new int[]{4, 5, 6, 1, 2, 3};
        shellSort(res);
        Day.print(res);
    }

    /**
     * 直接插入排序： 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * 稳定
     *
     * @param data
     */
    private static void insertSort(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 0; i < n; i++) {
                int temp = data[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (data[j] > temp) {
                        data[j + 1] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + 1] = temp;
            }
        }
    }

    /**
     * 折半插入排序： 时间复杂度O(n^2)
     * 空间复杂度O(1)原地排序
     * 稳定
     *
     * @param data
     */
    private static void binaryInsertSort(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            //i表示未排序的第一个数
            for (int i = 1; i < n; i++) {
                //i表示未排序的第一个数
                int temp = data[i];
                //已排序第一个数
                int low = 0;
                //已排序最后一个数
                int high = i - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (data[mid] > temp) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                //找到要插入的位置high+1，开始搬移元素
                int j = i - 1;
                for (; j > high; j--) {
                    data[j + 1] = data[j];
                }
                data[j + 1] = temp;
            }
        }
    }

    /**
     * 希尔排序： 时间复杂度O(2^1.3~2)
     *          空间复杂度O(1)
     *          不稳定
     *
     * @param data
     */
    private static void shellSort(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            int step = n / 2;
            while (step >= 1) {
                for (int i = step; i < n; i++) {
                    int value = data[i];
                    int j = i - step;
                    for (; j >= 0; j -= step) {
                        if (data[j] > value) {
                            data[j + step] = data[j];
                        } else {
                            break;
                        }
                    }
                    data[j + step] = value;
                }
                step = step / 2;
            }
        }
    }
}
