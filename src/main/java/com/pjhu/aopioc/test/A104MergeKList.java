package com.pjhu.aopioc.test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 将K个排序（升序）链表合并
public class A104MergeKList {

    public static void main(String[] args) {

    }

    public ListNode merge(List<ListNode> list) {
        if (list == null || list.size() == 0) {
            return null;
        }

        Queue<ListNode> pq = new PriorityQueue<>(list.size(), Comparator.comparingInt(l -> l.val));

        for (ListNode node: list) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);

        while (!pq.isEmpty()) {
            ListNode head = pq.poll();
            dummy.next = head;
            if (head.next != null) {
                pq.offer(head.next);
            }
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
