package com.bittech.gao;

public class quickSort {
    public static void main(String[] args) {
        int[] res = new int[]{4, 5, 6, 1, 2, 3};
        quickSort1(res);
        for (int i : res) {
            System.out.print(i + "、");
        }
    }

    private static void quickSort1(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            quickSortInternal(data, 0, n - 1);
        }
    }

    //递归函数
    private static void quickSortInternal(int[] data, int l, int r) {
        if (l >= r) {
            return;
        }
        int q = paratiton2(data, l, r);
        quickSortInternal(data, l, q - 1);
        quickSortInternal(data, q + 1, r);
    }

    //获取分区点paratiton1
    private static int paratiton1(int[] data, int l, int r) {
        int v = data[l];
        int i = l + 1;
        int j = l;
        for (; i <= r; i++) {
            if (data[i] < v) {
                swap(data, i, j + 1);
                j++;
            }
        }
        swap(data, l, j);
        return j;
    }

    //获取分区点paratiton2
    private static int paratiton2(int[] data, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(data, l, randomIndex);
        int v = data[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && data[i] < v) {
                i++;
            }
            while (j >= l + 1 && data[j] > v) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(data, i, j);
            i++;
            j--;
        }
        swap(data, l, j);
        return j;
    }

    //交换函数
    private static void swap(int[] data, int A, int B) {
        int temp = data[A];
        data[A] = data[B];
        data[B] = temp;
    }
}

