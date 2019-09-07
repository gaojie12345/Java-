package com.qing;

public class Test3 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (true) {
                if (fast == null || fast.next == null) {
                    return slow;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
        }
    }
}
