package com.leetcode.algorithms.medium;

/*
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Tags: Linked List
 * */

public class Problem19 {

  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null) {
      return null;
    }
    ListNode curr = head;
    ListNode prev = head;
    int iterator = -1;
    while(curr != null) {
      iterator++;
      if(iterator > n) {
        iterator = n;
        prev = prev.next;
      }
      curr = curr.next;
    }
    if(prev.next == null) {
      return null;
    }
    if(iterator < n) {
      head = head.next;
      return head;
    }
    prev.next = prev.next.next;
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    Problem19 problem19 = new Problem19();
    problem19.removeNthFromEnd(head, 2);
    ListNode curr = head;
    while(curr != null){
      System.out.print(curr.val + " ");
      curr = curr.next;
    }
  }

}
