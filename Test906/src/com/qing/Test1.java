package com.qing;

public class Test1 {
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
            quick(data, 0, n - 1);
        }
    }

    public static void quick(int[] data, int low, int high) {
        if (low > high) {
            return;
        }
        int q = paratition(data, low, high);
        quick(data, low, q - 1);
        quick(data, q + 1, high);
    }

    public static int paratition(int[] data, int low, int high) {
        int v = data[low];
        int i = low + 1;
        int j = low;
        for (; i <= high; i++) {
            if (data[i] < v) {
                swap(data, j + 1, i);
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
