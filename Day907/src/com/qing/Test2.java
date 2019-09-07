package com.qing;

/**
 * 堆排序
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
        }
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftdown(data, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(data, 0, i);
            shiftdown(data, i, 0);
        }

    }

    public static void shiftdown(int[] data, int n, int k) {
        //有左子节点
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            //有右子节点
            if (j + 1 < n) {
                if (data[j] < data[j + 1]) {
                   j++;
                }
            }
            if(data[k] > data[j]) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
