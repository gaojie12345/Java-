package com.bittech.gao;

public class Merge {
    public static void main(String[] args) {
        int[] res = new int[]{4, 5, 6, 1, 2, 3};
        Sort(res);
        for (int i : res) {
            System.out.print(i + "、");
        }
    }

    //归并排序
    private static void Sort(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            mergeSort(data, 0, n - 1);
        }
    }

    //分组
    private static void mergeSort(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(data, low, mid);
        mergeSort(data, mid + 1, high);
        merge(data, low, mid, high);
    }

    //开始合并
    private static void merge(int[] data, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int[] temp = new int[r - p + 1];
        int k = 0;
        //开始将数据排序
        while (i <= q && j <= r) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }
        //寻找剩余的那个数组
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        //将剩余的元素放入temp
        while (start <= end) {
            temp[k++] = data[start++];
        }
        //copy到原数组中
        for (i = 0; i < r - p + 1; i++) {
            data[p + i] = temp[i];
        }
    }
}
