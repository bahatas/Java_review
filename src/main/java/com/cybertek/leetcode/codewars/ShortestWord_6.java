package com.cybertek.leetcode.codewars;

import java.util.stream.Stream;

public class ShortestWord_6 {

    public static void main(String[] args) {

        String str = "bitcoin take over the world maybe who knows perhaps";
        String str2 = "turns out random test cases are easier than writing ou basic ones";

        System.out.println(findShort(str));
        System.out.println(findShort2(str));
        System.out.println(findShort2(str2));
    }

    public static int findShort2(String s) {

        return Stream.of(s.split(" "))
                .map(each -> each = String.valueOf(each.length()))
                .map(Integer::valueOf)
                .sorted().findFirst().get();
    }
    public static int findShort(String s) {

        int counter=0,minlength = Integer.MAX_VALUE;


       for(int i = 0; i<s.length();i++){
           if(s.charAt(i)!=' '){
               counter++;

           }else {
               minlength= Math.min(minlength, counter);
               counter=0;
           }



       }

        return minlength;
    }

}
