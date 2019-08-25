package com.qing;



  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(true) {
            if(fast == null || fast.next == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}
public class Test1 {
}
