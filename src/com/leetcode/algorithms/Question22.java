package com.leetcode.algorithms;

/*
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * Tags: String, Backtracking
 * */

import java.util.ArrayList;
import java.util.List;

public class Question22 {

  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    backtrack(list, 0, 0, "", n);
    return list;
  }

  private void backtrack(List<String> list, int leftParenthesisCount, int rightParenthesisCount,
      String s, int n) {
    if (s.length() == n * 2) {
      list.add(s);
      return;
    }

    if (leftParenthesisCount < n) {
      backtrack(list, leftParenthesisCount + 1, rightParenthesisCount, s + "(", n);
    }
    if (rightParenthesisCount < leftParenthesisCount) {
      backtrack(list, leftParenthesisCount, rightParenthesisCount + 1, s + ")", n);
    }
  }

  public static void main(String[] args) {
    Question22 question22 = new Question22();
    System.out.println(question22.generateParenthesis(3));
  }
}
