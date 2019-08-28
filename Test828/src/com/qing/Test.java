package com.qing;

import java.util.*;
public class Test {
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
            if(pHead == null) {

            }
            ListNode small = new ListNode(0);
            ListNode h1 = small;
            ListNode big = new ListNode(0);
            ListNode h2 = big;
            ListNode cur = pHead;
            while(cur != null) {
                if(cur.val < x) {
                    small.next = cur;
                    small = small.next;
                }else{
                    big.next = cur;
                    big = big.next;
                }
                cur = cur.next;
            }
            small.next = h2.next;
            big.next = null;
            return h1.next;
        }
    }
}
