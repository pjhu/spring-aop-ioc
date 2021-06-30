package com.pjhu.springsourcecode.test;

// 将两个排序（升序）链表合并
public class A165MergeList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.addNode(3).addNode(8).addNode(11).addNode(15);
        ListNode b = new ListNode(2);
        ListNode merge = merge(a, b);
        ListNode tmp = merge;
        while (tmp != null) {
            System.out.println(tmp.getVal());
            tmp = tmp.getNext();
        }
    }

    private static ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);

        dummy.setNext(a);
        ListNode cur1 = dummy;
        ListNode cur2 = b;

        while (cur1.getNext() != null && cur2 != null) {
            if (cur1.getNext().getVal() > cur2.getVal()) {
                ListNode tmp = cur2.getNext();
                cur2.setNext(cur1.getNext());
                cur1.setNext(cur2);
                cur2 = tmp;
            }
            cur1 = cur1.getNext();
        }
        if (cur2 != null) {
            cur1.setNext(cur2);
        }
        return dummy.getNext();
    }
}

class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode addNode(int val) {
        this.next = new ListNode(val);
        return next;
    }
}