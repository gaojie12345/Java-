package com.qing;

public class Test4 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSameTree1(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null && q != null) {
                return false;
            }
            if (p != null && q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
        }
    }

}
