package com.bittech.gao;

public class Bubber {
    public static void main(String[] args) {
        int[] res = new int[]{4, 5, 6, 1, 2, 3};
        Sort1(res);
        for (int i : res) {
            System.out.print(i + "、");
        }
    }

    private static void Sort1(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 0; i < n; i++) {
                int value = data[i];
                for (int j = 0; j < n - i - 1; j++) {
                    if (data[j] > data[j + 1]) {
                        int temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;
                    }
                }
            }
        }
    }
}
