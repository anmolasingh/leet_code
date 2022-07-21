package com.leetcode.algorithms.easy;

import java.util.Stack;

/*
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 * Tags: String, Stack
 * */

public class Problem20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }else{
                if(stack.isEmpty()) {
                    return false;
                }
                if(ch == ')') {
                    Character popChar = stack.pop();
                    if(popChar != '(') {
                        return false;
                    }
                }else if(ch == '}') {
                    Character popChar = stack.pop();
                    if(popChar != '{') {
                        return false;
                    }
                }else if(ch == ']') {
                    Character popChar = stack.pop();
                    if(popChar != '[') {
                        return false;
                    }
                }
            }
        }
        if(stack.size() != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem20().isValid("()"));//true
        System.out.println(new Problem20().isValid("()[]{}"));//true
        System.out.println(new Problem20().isValid("(]"));//false
        System.out.println(new Problem20().isValid("[{()}]"));//true
        System.out.println(new Problem20().isValid("[{(})]"));//false
        System.out.println(new Problem20().isValid("]"));//false
        System.out.println(new Problem20().isValid("["));//false
    }
}
