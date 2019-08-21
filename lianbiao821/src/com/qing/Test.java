package com.qing;

class Node{
    public Node next;
    public int value;
    public Node node;


}
public class Test {
    Node removeAll(Node h1,Node h2) {
        Node newHead = new Node();
        Node newLast = newHead;
        Node c1 = h2;
        Node c2 = h1;
        while (c1 != null && c2 != null) {
            if (c1.value <= c2.value) {
                newLast.next = c1;
                c1 = c1.next;
            }else {
                newLast.next = c2;
                c2 = c2.next;
            }
        }

        return newHead.next;
    }
    ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode n1 =dummyHead.next;
        ListNode n2 = n1.next;
        while(n2 != null) {
            n1.next = n2.next;
            n2.next = dummyHead.next;
            dummyHead.next = n2;
            n2 = n1.next;
        }
        return dummyHead.next;
    }
}
