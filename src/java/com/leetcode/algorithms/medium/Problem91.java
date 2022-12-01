package com.leetcode.algorithms.medium;

/*
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 * Tags: Dynamic Programming
 * Helpful Resources:
 *  https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 * */

import java.util.Arrays;

public class Problem91 {

    public int numDecodings(String s) {
        int cache[] = new int[s.length()];
        Arrays.fill(cache, -1);
        return dfs(s, 0, cache);
    }

    private int dfs(String s, int i, int[] cache) {
        if(i >= s.length()) {
            return 1;
        }

        if(cache[i] != -1) {
            return cache[i];
        }

        char ch = s.charAt(i);
        int result = 0;
        if(ch != '0') {
            result += dfs(s, i+1, cache);
        }
        if((ch == '1' || ch == '2') && i+1 < s.length()) {
            char nextChar = s.charAt(i+1);
            if(ch == '2' && nextChar >= '0' && nextChar <= '6') {
                result += dfs(s, i+2, cache);
            }else if(ch == '1' && nextChar >= '0' && nextChar <= '9') {
                result += dfs(s, i+2, cache);
            }
        }
        cache[i] = result;
        return result;
    }

    public int numDecodingsIterative(String s) {
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
