package com.qing;

/**
 * 二叉树的镜像
 */
public class Test3 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null) {
                return null;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
