package com.qing;

/**
 * 快速排序
 * 将待排序的数组分成3部分，小于分区点，等于分区点，大于分区点
 * 区间为：[low,j-1]   j   [j+1,high-1]
 * 选取数组第一个元素为分区点--->v，遍历数组
 * 遇到比分区点小的元素，交换j + 1 和该元素的位置
 * 遍历完成之后交换分区点和j的位置
 */

public class Test7 {
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
            quickIntern(data,0,n - 1);
        }
    }

    public static void quickIntern(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int q = partition(data, low, high);
        quickIntern(data, low, q - 1);
        quickIntern(data, q + 1, high);
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
        swap(data, j, low);
        return j;
    }

    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
