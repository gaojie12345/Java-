package com.qing;

import java.util.HashSet;
import java.util.Set;

public class Test2 {

      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
         }
      }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> node = new HashSet<>();
            while(head != null) {
                if(node.contains(head)){
                    return true;
                }else{
                    node.add(head);
                    head = head.next;
                }
            }
            return false;
        }
    }
}
