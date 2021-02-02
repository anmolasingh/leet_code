package com.leetcode.algorithms.medium;

/*
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/
 * Tags: Stacks
 * */

import java.util.Stack;

public class Problem394 {

  public String decodeString(String s) {
    if (s.length() == 0 || s == null) {
      return s;
    }
    Stack<String> strStack = new Stack<>();
    Stack<Integer> numStack = new Stack<>();
    StringBuilder res = new StringBuilder();
    int idx = 0;
    while (idx < s.length()) {
      if (Character.isDigit(s.charAt(idx))) {
        int num = 0;
        while (Character.isDigit(s.charAt(idx))) {
          num = num * 10 + (s.charAt(idx) - '0');
          idx++;
        }
        numStack.push(num);
      } else if (s.charAt(idx) == '[') {
        strStack.push(res.toString());
        res = new StringBuilder("");
        idx++;
      } else if (s.charAt(idx) == ']') {
        StringBuilder temp = new
            StringBuilder(strStack.pop());
        int repeatTimes = numStack.pop();
        for (int i = 0; i < repeatTimes; i++) {
          temp.append(res);
        }
        res = temp;
        idx++;
      } else {
        res.append(s.charAt(idx++));
      }
    }
    return res.toString();
  }

  public static void main(String[] args) {
    Problem394 problem394 = new Problem394();
    System.out.println(problem394.decodeString("3[a2[c]]"));
  }

}
