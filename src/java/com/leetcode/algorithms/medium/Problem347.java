package com.leetcode.algorithms.medium;

/*
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Tags: Priority Queue, Heaps
 * */

import java.util.*;

public class Problem347 {

  private static class Node {

    private final int number;
    private final int frequency;

    public Node(int number, int frequency) {
      this.number = number;
      this.frequency = frequency;
    }

    public int getNegativeFrequencyForDescendingSort() {
      return frequency * -1;
    }
  }

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();
    Arrays.stream(nums)
        .forEach(num -> countMap.put(num, countMap.containsKey(num) ? countMap.get(num) + 1 : 1));

    PriorityQueue<Node> priorityQueue =
        new PriorityQueue<>(Comparator.comparing(Node::getNegativeFrequencyForDescendingSort));
    countMap.entrySet()
        .forEach(entry -> priorityQueue.add(new Node(entry.getKey(), entry.getValue())));

    int result[] = new int[k];
    int index = 0;
    while (!priorityQueue.isEmpty() && index < k) {
      result[index] = priorityQueue.poll().number;
      index++;
    }
    return result;
  }

  public static void main(String[] args) {
    Problem347 problem347 = new Problem347();
    int nums[] = {1, 1, 1, 2, 2, 3};
    System.out.println(Arrays.toString(problem347.topKFrequent(nums, 2)));
  }
}
