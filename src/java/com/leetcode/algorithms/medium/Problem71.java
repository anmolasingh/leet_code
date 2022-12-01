package com.leetcode.algorithms.medium;

import java.util.Stack;

public class Problem71 {

    public String simplifyPath(String path) {
        path = path + "/";
        String result = "";
        int i=0;
        Stack<String> stack = new Stack<>();
        String curr = "";
        while(i < path.length()) {
            char ch = path.charAt(i);
            if(ch == '/') {
                if(curr.length() > 0) {
                    if(curr.equals("..") && !stack.isEmpty()) {
                        stack.pop();
                    } else if(!curr.equals(".") && !curr.equals("..")){
                        stack.push(curr);
                    }
                    curr = "";
                }
            } else {
                curr += ch;
            }
            i++;
        }

        if(stack.size() == 0) {
            return "/";
        } else {
            for(String f : stack) {
                result += "/";
                result += f;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem71().simplifyPath("/home/"));// /home
        System.out.println(new Problem71().simplifyPath("/../"));// /
        System.out.println(new Problem71().simplifyPath("/home//foo/"));// /home/foo
        System.out.println(new Problem71().simplifyPath("/home/.."));// /
    }
}
