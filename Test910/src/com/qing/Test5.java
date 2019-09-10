package com.qing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class Test5 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<Integer> list = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return list;
        }
    }
}
