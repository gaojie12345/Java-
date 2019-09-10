package com.qing;

/**
 * 二叉搜索树的范围和
 */
public class Test2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null) {
                return 0;
            }
            if (root.val < L) {
                return rangeSumBST(root.right, L, R);
            }
            if (root.val > R) {
                return rangeSumBST(root.left, L, R);
            }
            int l = rangeSumBST(root.left, L, R);
            int r = rangeSumBST(root.right, L, R);
            return root.val + l + r;
        }
    }
}
