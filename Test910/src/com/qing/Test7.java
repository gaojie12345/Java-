package com.qing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的后序遍历
 */
public class Test7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root == null) {
                return Collections.emptyList();
            }
            inorderTraversal(root.left);
            inorderTraversal(root.right);
            list.add(root.val);
            return list;
        }
    }


}
