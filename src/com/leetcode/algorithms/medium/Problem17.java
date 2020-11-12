package com.leetcode.algorithms.medium;

/*
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Tags: String, Backtracking
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem17 {

    private static Map<Character, List<Character>> digitLetterMap;

    static {
        digitLetterMap = new HashMap<>();
        digitLetterMap.put('2', Arrays.asList('a', 'b', 'c'));
        digitLetterMap.put('3', Arrays.asList('d', 'e', 'f'));
        digitLetterMap.put('4', Arrays.asList('g', 'h', 'i'));
        digitLetterMap.put('5', Arrays.asList('j', 'k', 'l'));
        digitLetterMap.put('6', Arrays.asList('m', 'n', 'o'));
        digitLetterMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitLetterMap.put('8', Arrays.asList('t', 'u', 'v'));
        digitLetterMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || digits.equals("")){
            return list;
        }
        backtrack(list, "", digits, 0);
        return list;
    }

    private void backtrack(List<String> list, String s, String digits, int index) {
        if (index == digits.length()) {
            list.add(s);
            return;
        }

        digitLetterMap.get(digits.charAt(index)).stream().forEach(letter -> {
            backtrack(list, s + letter, digits, index + 1);
        });

    }

    public static void main(String[] args) {
        Problem17 problem17 = new Problem17();
        System.out.println(problem17.letterCombinations("23"));
    }
}
