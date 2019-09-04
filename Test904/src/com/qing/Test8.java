package com.qing;

public class Test8 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode slow = head;
        ListNode fast = head;
        int a = k;
        int count = 0;
        while(fast != null) {
            fast = fast.next;
            count++;
            if(k < 1) {
                slow = slow.next;
            }
            k--;
        }
        if(a > count) {
            return null;
        }
        return slow;
    }
}
