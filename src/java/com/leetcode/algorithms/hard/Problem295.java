package com.leetcode.algorithms.hard;

import java.util.*;

/*
 * 295. Find Median from Data Stream
 * https://leetcode.com/problems/find-median-from-data-stream/
 * Tags: Priority Queue, Heaps
 * */

public class Problem295 {

    private PriorityQueue<Integer> small, large;

    public Problem295() {
        small = new PriorityQueue<>(Comparator.reverseOrder());//max heap
        large = new PriorityQueue<>();//min heap
    }

    public void addNum(int num) {
        small.add(num);
        if(!large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }
        if(!small.isEmpty() && small.size() - large.size() > 1) {
            large.add(small.poll());
        }
        if(!large.isEmpty() && large.size() - small.size() > 1) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        int sSize = small.size();
        int lSize = large.size();
        if((sSize + lSize) % 2 == 0) {
            return (small.peek() + large.peek())/2.0;
        } else {
            if(small.size() > large.size()) {
                return small.peek();
            } else {
                return large.peek();
            }
        }
    }

    public static void main(String[] args) {
        Problem295 p = new Problem295();
        p.addNum(2);
        p.addNum(1);
        System.out.println(p.findMedian());//1.5
        p.addNum(3);
        System.out.println(p.findMedian());//2.0
    }
}
