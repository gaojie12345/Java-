package com.bittech.gao;

public class Test2 {
    public static void main(String[] args) {
        int[] res = new int[]{4, 5, 6, 1, 2, 3};
        Sort2(res);
        for (int i : res) {
            System.out.print(i + "、");
        }
    }

    //希尔
    private static void Sort2(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            int step = n / 2;
            while (step >= 1) {
                for (int i = step; i < n; i++) {
                    int value = data[i];
                    int j = i - step;
                    for (; j >= 0; j -= step) {
                        if (data[j] > value) {
                            data[j + step] = data[j];
                        } else {
                            break;
                        }
                    }
                    data[j + step] = value;
                }
                step = step / 2;
            }
        }
    }
}
