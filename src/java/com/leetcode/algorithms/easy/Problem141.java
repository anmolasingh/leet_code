package com.leetcode.algorithms.easy;

/*
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 * Tags: Linked List
 * */

public class Problem141 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while(p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if(p2 != null) {
                p2 = p2.next;
                if(p1 == p2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(new Problem141().hasCycle(head));//true
    }
}
