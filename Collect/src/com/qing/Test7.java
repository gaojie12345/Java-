package com.qing;

import java.util.LinkedList;
import java.util.Queue;

public class Test7 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(3);
        queue.add(5);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
