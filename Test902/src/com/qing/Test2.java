package com.qing;

/**
 * 冒泡排序
 * 操作两个相邻的元素进行比较，如果第一个元素大于第二个元素，则交换位置，依次进行，
 * 一次的冒泡排序都会让至少一个元素移到最终的位置,重复n次，就完成排序
 */
public class Test2 {
    public static void main(String[] args) {
        int[] res = new int[]{4, 5, 6, 1, 3, 2};
        test(res);
        for (int i : res) {
            System.out.print(i + "、");
        }
    }

    public static void test(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < n - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

    }
}
