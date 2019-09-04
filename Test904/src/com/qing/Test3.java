package com.qing;

public class Test3 {
    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        int res = 1;
        for (int i = 2; i <= target; i++) {
            res = res * 2;
        }
        return res;
    }
}
