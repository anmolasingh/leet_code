package com.leetcode.algorithms.medium;

/*
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * Tags: Hash Table, Hash Map, HashMap, String
 * */

import java.util.*;
import java.util.stream.Collectors;

public class Problem49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<Character, Integer> alphabetPrimeWeightMap = new HashMap<>();
    alphabetPrimeWeightMap.put('a', 2);
    alphabetPrimeWeightMap.put('b', 3);
    alphabetPrimeWeightMap.put('c', 5);
    alphabetPrimeWeightMap.put('d', 7);
    alphabetPrimeWeightMap.put('e', 11);
    alphabetPrimeWeightMap.put('f', 13);
    alphabetPrimeWeightMap.put('g', 17);
    alphabetPrimeWeightMap.put('h', 19);
    alphabetPrimeWeightMap.put('i', 23);
    alphabetPrimeWeightMap.put('j', 29);
    alphabetPrimeWeightMap.put('k', 31);
    alphabetPrimeWeightMap.put('l', 37);
    alphabetPrimeWeightMap.put('m', 41);
    alphabetPrimeWeightMap.put('n', 43);
    alphabetPrimeWeightMap.put('o', 47);
    alphabetPrimeWeightMap.put('p', 53);
    alphabetPrimeWeightMap.put('q', 59);
    alphabetPrimeWeightMap.put('r', 61);
    alphabetPrimeWeightMap.put('s', 67);
    alphabetPrimeWeightMap.put('t', 71);
    alphabetPrimeWeightMap.put('u', 73);
    alphabetPrimeWeightMap.put('v', 79);
    alphabetPrimeWeightMap.put('w', 83);
    alphabetPrimeWeightMap.put('x', 89);
    alphabetPrimeWeightMap.put('y', 97);
    alphabetPrimeWeightMap.put('z', 101);

    Map<Long, List<String>> weightListMap = new HashMap<>();
    for (String s : strs) {
      long multipliedValue = 1;
      for (int i = 0; i < s.length(); i++) {
        multipliedValue *= alphabetPrimeWeightMap.get(s.charAt(i));
      }

      if (weightListMap.containsKey(multipliedValue)) {
        List<String> currentStringsList = weightListMap.get(multipliedValue);
        currentStringsList.add(s);
        weightListMap.put(multipliedValue, currentStringsList);
      } else {
        List<String> currentStringsList = new ArrayList<>();
        currentStringsList.add(s);
        weightListMap.put(multipliedValue, currentStringsList);
      }

    }

    List<List<String>> result = weightListMap.values().stream().collect(Collectors.toList());
    return result;
  }

  public static void main(String[] args) {
    Problem49 problem49 = new Problem49();
    String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(problem49.groupAnagrams(strs));
  }
}
