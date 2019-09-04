package com.qing;

/**
 * 青蛙跳台阶
 */
public class Test1 {
    public int JumpFloor(int target) {
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }
        int[] data = new int[target + 1];
        data[1] = 1;
        data[2] = 2;
        for(int i = 3; i <= target; i++) {
            data[i] = data[i - 1] + data[i - 2];
        }
        return data[target];
    }
}
