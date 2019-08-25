package com.qing;



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solutionw {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode fir = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = fir;
            fir = cur;
            cur = next;
        }
        return fir;
    }
}
public class Test3 {
}
