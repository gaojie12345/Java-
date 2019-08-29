package com.qing;

import java.util.HashMap;
import java.util.Map;

public class Test4 {

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node,Node> map = new HashMap<>();
            Node cur = head;
            while(cur != null) {
                Node copy = new Node(cur.val,null,null);
                map.put(cur,copy);
                cur = cur.next;
            }
            cur = head;
            while(cur != null) {
                Node copy = map.get(cur);
                copy.next = map.get(cur.next);
                copy.random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }
    }
}
