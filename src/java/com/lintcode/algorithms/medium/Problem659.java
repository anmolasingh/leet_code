package com.lintcode.algorithms.medium;

/*
 * 659 · Encode and Decode Strings
 * https://www.lintcode.com/problem/659/
 * Tags: Array
 * */

import java.util.*;

public class Problem659 {

    public String encode(List<String> strs) {
        String result = "";
        for(String s : strs) {
            result += s.length();
            result += "#";
            result += s;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0;
        String digitStr = "";
        int digit = -1;
        while(i < str.length()) {
            while(str.charAt(i) >= 48 && str.charAt(i) <= 97) {
                digitStr = digitStr + str.charAt(i);
                i++;
            }
            if(str.charAt(i) == '#') {
                digit = Integer.parseInt(digitStr);
                digitStr = "";
                i++;
            }
            if(digit != -1) {
                result.add(str.substring(i, i+digit));
                i += digit;
                digit = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList(new String[]{"lint","code","love","you"});
        String encodedString = new Problem659().encode(input);
        System.out.println(encodedString);
        System.out.println(new Problem659().decode(encodedString));//["lint","code","love","you"]

        input = Arrays.asList(new String[]{"lint","#code","lo##ve","y3#ou"});
        encodedString = new Problem659().encode(input);
        System.out.println(encodedString);
        System.out.println(new Problem659().decode(encodedString));//["lint","#code","lo##ve","y3#ou"]
    }
}
