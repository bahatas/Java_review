package com.cybertek.leetcode.ALGO_QS;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Algo14_LongestSubstring {
    public static void main(String[] args) {

        String string = "clementisacap"; //mentisac

        //System.out.println("getLongestSub(string) = " + getLongestSub(string));
        System.out.println("getLongestSubstring(string) = " + getLongestSubstring(string));
        System.out.println("bbbbbbb = " + getLongestSubstring("babbbbb"));
        System.out.println("bbbb = " + getLongestSubstring("bbbb"));
        System.out.println("abc= " + getLongestSubstring("abc"));
    }

    static String getLongestSub(String given ){

        List<String> collect = Stream.of(given.split("")).distinct().collect(Collectors.toList());

        System.out.println("collect = " + collect);

        // Step 1
        IntStream intStream = given.chars();

        // Step 2
        Stream<Character> charsStream = intStream.mapToObj(ch -> (char) ch);

        // Step 3
        Map<Character, Long> output = charsStream.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        System.out.println("output :" +output);//output :{p=1, a=2, s=1, c=2, t=1, e=2, i=1, l=1, m=1, n=1}

        Map<Character, Long> hm = given.
                chars().mapToObj(ch -> (char) ch).
                collect(Collectors.groupingBy(each -> each, Collectors.counting()));


        Stream.of(given.toCharArray());

        System.out.println("hm :" +output);

        return  "";
    }
    static String getLongestSubstring (String given){

        String subStr =""+given.charAt(0);
        String result ="";
        for(int i=1; i<given.length();i++){
            char pointer = given.charAt(i);
            boolean notContains = !subStr.contains(given.charAt(i)+"");
            boolean lastChardublicated = subStr.substring(subStr.length()).equals(given.charAt(i)+"");

            if(notContains){
                subStr+=pointer;
                continue;
            }
            else if(lastChardublicated){
                subStr="";
                continue;
            }
            result=(result.length()<subStr.length())?subStr:result;
            subStr="";
        }

        return result;
    }
}


/**
 * Question #14
 * Longest Substring Without Duplication
 * Difficulty : - Category : Strings
 * Write a function that takes in a string and returns its longest substring without duplicate
 * characters.
 * You can assume that there will only be one longest substring without duplication.
 * Sample Input
 * string = "clementisacap"
 * Sample Output
 * "mentisac"
 */







/**
 *
 # O(n) time  |  O(min(n, a))  space
 def longestSubstringWithoutDuplication(string):
 lastSeen = {}
 longest = [0, 1] # Here 0 and 1 is the values in the 0 and 1 index. This variable stores the start and end index of of the longest string.
 startIndex = 0
 for i, char in enumerate(string):
 if char in lastSeen:
 startIndex = max(startIndex, lastSeen[char] + 1)
 if longest[1] - longest[0] < i + 1 - startIndex: # Here 0 and 1 is the index of the value of longest array
 longest = [startIndex, i + 1]
 lastSeen[char] = i
 return string[longest[0]:longest[1]]

 */