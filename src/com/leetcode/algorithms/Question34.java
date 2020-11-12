package com.leetcode.algorithms;

/*
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Tags: Binary Search, Array
 * */

import java.util.Arrays;

public class Question34 {

    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, 0, nums.length - 1, target);
        int finalLeftIndex = index;
        while(index != -1){
            index = binarySearch(nums, 0, index-1, target);
            if(index != -1){
                finalLeftIndex = index;
            }
        }

        index = binarySearch(nums, 0, nums.length - 1, target);
        int finalRightIndex = index;
        while(index != -1){
            index = binarySearch(nums, index+1, nums.length - 1, target);
            if(index != -1){
                finalRightIndex = index;
            }
        }

        int result[] = {finalLeftIndex, finalRightIndex};
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10};
        Question34 question34 = new Question34();
        int result[] = question34.searchRange(nums, 8);
        Arrays.stream(result).forEach(record -> System.out.print(record + " "));
    }
}
