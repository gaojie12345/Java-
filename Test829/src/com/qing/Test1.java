package com.qing;

/**
 * 相交链表
 */
public class Test1 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            int alen = getLength(headA);
            int blen = getLength(headB);
            if (alen < blen) {
                for (int i = 0; i < blen - alen; i++) {
                    headB = headB.next;
                }
            } else {
                for (int j = 0; j < alen - blen; j++) {
                    headA = headA.next;
                }
            }
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }

        public static int getLength(ListNode tmp) {
            int count = 0;
            while (tmp != null) {
                tmp = tmp.next;
                count++;
            }
            return count;
        }
    }
}
