package com.bittech.gao;

public class Tset {
    public static void main(String[] args) {
        int[] res = new int[]{4, 5, 6, 1, 2, 3};
        Sort(res);
        for (int i : res) {
            System.out.print(i + "、");
        }
    }

    //直接插入
    private static void Sort(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 1; i < n; i++) {
                int value = data[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (data[j] > value) {
                        data[j + 1] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + 1] = value;
            }
        }
    }
}
