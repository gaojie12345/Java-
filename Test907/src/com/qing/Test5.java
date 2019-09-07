package com.qing;

public class Test5 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class Partition {
        public ListNode partition(ListNode pHead, int x) {
            // write code here
            ListNode s = new ListNode(0);
            ListNode b = new ListNode(0);
            ListNode small = s;
            ListNode big = b;

            ListNode cur = pHead;
            while(cur != null) {
                if(cur.val < x) {
                    small.next = cur;
                    small = small.next;
                }else {
                    big.next = cur;
                    big = big.next;
                }
                cur = cur.next;
            }
            small.next = b.next;
            big.next = null;
            return s.next;
        }
    }
}
