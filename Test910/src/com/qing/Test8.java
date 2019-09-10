package com.qing;

public class Test8 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s != null) {
                if (s.val == t.val) {
                    if (isSameTree(s, t)) {
                        return true;
                    }
                }
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }
            return false;
        }

        public boolean isSameTree(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.val != t.val) {
                return false;
            }
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }
}
