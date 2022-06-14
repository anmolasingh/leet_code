package com.leetcode.algorithms.medium;

/*
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 * Tags: Dynamic Programming
 * Helpful Resources:
 *  https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 * */

public class Problem91 {

    public int numDecodings(String s) {
        int cache[] = new int[s.length()+1];
        cache[0] = 1;//empty string ""
        cache[1] = s.charAt(0) == '0'? 0 : 1;//string with 1 character
        for(int i=2;i<=s.length();i++){
            if(s.charAt(i-1) > '0'){
                cache[i] += cache[i-1];
            }
            int num = Integer.parseInt(s.charAt(i-2) + "" + s.charAt(i-1));
            if(num >=10 && num <=26){
                cache[i] += cache[i-2];
            }
        }
        return cache[s.length()];
    }

    public static void main(String[] args) {
        Problem91 problem91 = new Problem91();
        System.out.println(problem91.numDecodings("12"));//2
        System.out.println(problem91.numDecodings("226"));//3
        System.out.println(problem91.numDecodings("06"));//0
        System.out.println(problem91.numDecodings("2106"));//1
        System.out.println(problem91.numDecodings("2126"));//5
    }
}
