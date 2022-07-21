package com.leetcode.algorithms.easy;

/*
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 * Tags: Linked List
 * */

public class Problem206 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, temp = null;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode curr = new Problem206().reverseList(head);
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
