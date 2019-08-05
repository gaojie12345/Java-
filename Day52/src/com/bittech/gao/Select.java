package com.bittech.gao;

public class Select {
    public static void main(String[] args) {
        int[] res = new int[]{4, 5, 6, 1, 2, 3};
        Sort2(res);
        for (int i : res) {
            System.out.print(i + "、");
        }
    }

    //选择排序
    private static void Sort2(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; ++j) {
                    if (data[j] < data[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = data[minIndex];
                data[minIndex] = data[i];
                data[i] = temp;
            }
        }
    }
}
