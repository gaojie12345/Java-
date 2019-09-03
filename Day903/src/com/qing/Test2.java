package com.qing;

/**
 * 快速排序
 *
 * 将数组第一个元素作为基准值v,开始遍历数组，遇到比v小的数，就交换j+1和i
 * 遍历完成之后交换v和j位置
 */

public class Test2 {
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
        } else {
            quick(data,0,n - 1);
        }
    }

    public static void quick(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int q = partition(data, low, high);
        quick(data, low, q - 1);
        quick(data, q + 1, high);
    }

    public static int partition(int[] data, int low, int high) {
        int v = data[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (data[i] < v) {
                swap(data, i, j + 1);
                j++;
            }
        }
        swap(data, low, j);
        return j;
    }

    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
