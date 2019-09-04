package com.qing;

public class Test5 {
    public static void main(String[] args) {
        int[] data = new int[]{4,5,6,1,2,3};
        t(data);
        for (int i : data) {
            System.out.print( i + "、");
        }
    }

    public static void t(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = data[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (data[mid] > data[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            int j = i - 1;
            for (;j >high;j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = value;
        }
    }
}
