package com.qing;

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
        int i = low + 1;
        int j = high;
        while (true) {
            while (i <= high && data[i] < v) {
                i++;
            }
            while (j >= low && data[j] > v) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(data, i, j);
            i++;
            j--;
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
