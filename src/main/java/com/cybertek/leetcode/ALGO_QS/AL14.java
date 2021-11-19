package com.cybertek.leetcode.ALGO_QS;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AL14 {
    public static void main(String[] args) {

        String string = "clementisacap"; //mentisac
        getLongestSub(string);
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

        String subStr ="";
        String result ="";
        int maxL=0;
        for(int i=0; i<given.length();i++){
            int previousPointer = given.charAt(i-1);
            char pointer = given.charAt(i);
            int nextPointer = given.charAt(i+1);
            boolean isUniqe = subStr.contains(given.charAt(i)+"");

            if(isUniqe){
                subStr+=pointer;
            }
            result=(result.length()>subStr.length())?subStr:result;
            maxL=Math.max(maxL,subStr.length());
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