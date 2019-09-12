package com.qing;


import java.util.*;

public class Test3 {
    static class TreeNode {
        int data;
        TreeNode left = null;
        TreeNode right = null;
        int val ;

        public TreeNode(int data) {

            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        char[] data1 = s1.toCharArray();
        char[] data2 = s2.toCharArray();
        TreeNode a = crete(data1,0,data1.length-1,data2,0,data1.length -1);
        pre(a);
        String s = String.valueOf(a);
        System.out.println(s.toString());
    }

    public static TreeNode crete(char[] po, int poLeft, int poRight, char[] in, int inLeft, int inRight) {
        if(poLeft > poRight) {
            return null;
        }
        TreeNode root = new TreeNode(po[poRight]);
        int find = -1;
        for (int i = inLeft;i <= inRight;i++) {
            find = i;
            break;
        }
        int lsum = find - inLeft;
        root.left = crete(po,poLeft,poLeft + lsum -1,
                in,inLeft,find -1);

        root.right = crete(po,poLeft + lsum,poRight - 1,
                in,find + 1,inRight);

        return root;
    }

    public static void pre(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.val);
        pre(node.left);
        pre(node.right);
    }
}
