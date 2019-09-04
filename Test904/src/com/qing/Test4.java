package com.qing;


public class Test4 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode p = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = p;
            p = cur;
            cur = next;
        }
        return p;
    }
}
