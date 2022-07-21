package com.leetcode.algorithms.easy;

/*
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 * Tags: String, Two Pointer
 * */

public class Problem125 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l=0, r=s.length()-1;
        while(l < r) {
            if(!isValidChar(s.charAt(l))) {
                l++;
            } else if (!isValidChar(s.charAt(r))) {
                r--;
            } else {
                if(s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    private boolean isValidChar(char ch) {
        return (ch >= 97 && ch <= 122)
                || ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9';
    }

    public static void main(String[] args) {
        System.out.println(new Problem125().isPalindrome("A man, a plan, a canal: Panama"));//true
        System.out.println(new Problem125().isPalindrome("race a car"));//false
    }
}
