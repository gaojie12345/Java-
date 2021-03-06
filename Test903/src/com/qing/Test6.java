package com.qing;

/**
 * 归并排序
 * 将待排序的数组平均分成2部分，将每部分排序好之后，存储到一个新的数组中，
 * 最后将新的数组中的元素拷贝到旧数组中
 */

public class Test6 {
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
            mergeIntern(data, 0, n - 1);
        }
    }

    public static void mergeIntern(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeIntern(data, low, mid);
        mergeIntern(data, mid + 1, high);
        merge(data, low, mid, high);
    }

    public static void merge(int[] data, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }
        int start = i;
        int end = mid;
        if (j <= high) {
            start = j;
            end = high;
        }
        while (start <= end) {
            temp[k++] = data[start++];
        }
        for (i = 0; i <= high - low; i++) {
            data[low + i] = temp[i];
        }
    }

}
