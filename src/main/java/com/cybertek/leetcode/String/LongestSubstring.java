package com.cybertek.leetcode.String;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    /**
     * Given a string s, find the length of the longest substring without repeating characters
     * <p>
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * <p>
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * <p>
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * <p>
     * <p>
     * Input: s = ""
     * Output: 0
     */

    public static void main(String[] args) {

        String input = "pwwkew";
        System.out.println(lengthOgString(input));

    }


    public static int lengthOgString(String str) {
        int freq = 1;
        int maxLength = 0;
        int windowStart = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character rightChar = str.charAt(windowEnd);

           if (map.containsKey(rightChar)){
               map.replace(rightChar,(map.get(rightChar))+1);
               windowStart=Math.max(windowStart,map.get(rightChar)+1);
           }
           else{
               maxLength+=1;
               map.put(rightChar,freq);
           }

        }
        return maxLength;
    }


}
