package com.qing;

/**
 * 基于链表的动态扩容
 */
public class Test2<E> {
    private class Node{
        E data;
        Node next;
        Node prev;

        public Node(E data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    private int size;
    private Node head;
    private Node tail;

    public void add(E data) {
        Node node = new Node(data,null,tail);
        if (tail == null) {
            //此时链表为空
            head = tail = node;
        }
        tail.next = node;
        tail = node;
    }

}
