package com.qing.cases;

import com.qing.annotations.Benchmark;
import com.qing.annotations.Measurement;

import java.util.Arrays;
import java.util.Random;


/**
 * 1.快速排序和归并排序的差别
 * 2.自己实现的归并排序和Arrays.sort()对比
 * 3.自己实现并发排序和Arrays.parallelSort
 */

@Measurement(iterations = 10, group = 3)
public class SortCase implements Case {

    //快速排序
    public void quickSort(int[] a) {
        //确定基准值
        quickSortInternal(a, 0, a.length - 1);
    }

    //待排序区间是[low，high]
    private void quickSortInternal(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        //选取的基准值
        int[] index = partition(a, low, high);
        quickSortInternal(a, low, index[0]);
        quickSortInternal(a, index[1], high);
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private int[] partition(int[] a, int low, int high) {
        int pivot = a[high];
        int less = low;
        int i = low;
        int more = high;
        while (i < more) {
            if (a[i] == pivot) {
                i++;
            } else if (a[i] < pivot) {
                swap(a, less, i);
                i++;
                less++;
            } else {
                while (more > i && a[more] > pivot) {
                    more--;
                }
                swap(a, i, more);
            }
        }
        return new int[]{less - 1, more};
    }


    //归并排序
    public static void mergeSort(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            mergeSortInternal(data, 0, n - 1);
        }
    }

    private static void mergeSortInternal(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortInternal(data, low, mid);
        mergeSortInternal(data, mid + 1, high);
        merge(data, low, mid, high);
    }

    private static void merge(int[] data, int low, int mid, int high) {
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


    @Benchmark
    public void testQuickSort() {
        int[] a = new int[100000];
        Random random = new Random(20190713);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10000);
        }
        quickSort(a);
    }

    @Benchmark
    public void testMegerSort() {
        int[] a = new int[100000];
        Random random = new Random(20190713);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10000);
        }
        mergeSort(a);
    }

    @Benchmark
    public void testArraysSort() {
        int[] a = new int[100000];
        Random random = new Random(20190713);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10000);
        }
        Arrays.sort(a);
    }
}
