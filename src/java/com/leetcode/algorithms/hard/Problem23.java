package com.leetcode.algorithms.hard;

/*
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Tags: Linked List
 * */

import java.util.*;

public class Problem23 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        while(lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for(int i=0; i<lists.length;i+=2) {
                ListNode list1 = lists[i];
                ListNode list2 = null;
                if(i+1 < lists.length) {
                    list2 = lists[i+1];
                }
                mergedLists.add(mergeTwoLists(list1, list2));
            }
            lists = new ListNode[mergedLists.size()];
            for(int i=0; i<mergedLists.size(); i++) {
                lists[i] = mergedLists.get(i);
            }
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                tail.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 != null) {
            tail.next = list1;
        }
        if(list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[2];
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        lists[0] = list1;
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        lists[1] = list2;
        ListNode curr = new Problem23().mergeKLists(lists);
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
