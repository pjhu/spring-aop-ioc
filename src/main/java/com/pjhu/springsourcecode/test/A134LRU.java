package com.pjhu.springsourcecode.test;

import java.util.HashMap;

public class A134LRU {

    public static void main(String[] args) {

    }
}

class LRU {
    public static class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);

    public int get(int key) {
        if (!hs.containsKey(key)) {
            return -1;
        }

        Node current = hs.get(key);
        current.pre.next = current.next;
        current.next.pre = current.pre;

        moveToTail(current);
        return hs.get(key).val;
    }

    public void set(int key, int val) {
        if (get(key) != -1) {
            hs.get(key).val = val;
        }

        if (hs.size() == capacity) {
            hs.remove(head.next.val);
            head.next = head.next.next;
            head.next.pre = head;
        }

        Node insert = new Node(key, val);
        hs.put(key, insert);
        moveToTail(insert);
    }

    private void moveToTail(Node current) {
        current.pre = tail.pre;
        tail.pre = current;
        current.pre.next = current;
        current.next = tail;
    }
}
