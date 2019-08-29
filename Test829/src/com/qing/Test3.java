package com.qing;

import java.util.HashSet;
import java.util.Set;

public class Test3 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> node = new HashSet<>();
            while (head != null) {
                if (node.contains(head)) {
                    return head;
                } else {
                    node.add(head);
                    head = head.next;
                }
            }
            return null;
        }
    }
}
