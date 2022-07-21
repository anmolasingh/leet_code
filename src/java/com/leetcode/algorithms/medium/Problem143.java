package com.leetcode.algorithms.medium;

/*
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 * Tags: Linked List
 * */

public class Problem143 {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }

          @Override
          public String toString() {
              return "ListNode{" +
                      "val=" + val +
                      ", next=" + next +
                      '}';
          }
      }

    public void reorderList(ListNode head) {
        //Find middle
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse second half
        ListNode second = slow.next;
        ListNode prev = null;
        slow.next = null;//Might not be needed
        while(second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        //Merge two halves
        ListNode first = head;
        second = prev;
        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    public static void main(String[] args) {
          ListNode head = new ListNode(1);
          head.next = new ListNode(2);
          head.next.next = new ListNode(3);
          head.next.next.next = new ListNode(4);
          new Problem143().reorderList(head);
          System.out.println(head);
    }
}
