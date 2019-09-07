package com.qing;

public class Test7 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class PalindromeList {
        public boolean chkPalindrome(ListNode A) {
            // write code here
            if(A == null && A.next == null) {
                return true;
            }
            ListNode cur = A;
            ListNode p = null;
            while(cur != null) {
                ListNode next = cur.next;
                cur.next = p;
                p = cur;
                cur = next;
            }
            while(p != null && A != null) {
                if(p.val != A.val) {
                    return false;
                }
                p = p.next;
                A = A.next;
            }
            return true;
        }
    }
}
