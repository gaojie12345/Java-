package com.qing;

public class Test6 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode deleteDuplication(ListNode pHead){
            if(pHead == null || pHead.next == null) {
                return pHead;
            }
            ListNode header = new ListNode(0);
            header.next = pHead;
            ListNode prev = header;
            ListNode cur = pHead;
            while(cur != null) {
                if(cur.next != null && cur.val == cur.next.val) {
                    while(cur.next != null && cur.val == cur.next.val){
                        cur = cur.next;
                    }
                    prev.next = cur.next;
                    cur = cur.next;
                } else{
                    cur = cur.next;
                    prev = prev.next;
                }
            }
            return header.next;
        }
    }
}
