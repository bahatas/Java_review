package com.cybertek.leetcode.ALGO_QS;

import java.util.ArrayDeque;
import java.util.Deque;

public class Algo10_ReverseString {

    public static void main(String[] args) {
        String str1 = "   hello    welcome  with me       to java  ";
        System.out.println(str1.length());
        System.out.println("reverseWords(str1) = " + reverseString(str1));
        System.out.println("reverseWords(str1) = " + reverseString(str1).length());

    }

    static String reverseString(String given){

        String eachword ="";
        Deque<String> deque = new ArrayDeque<>();
        for (int i= 0; i<given.length();i++){
            eachword+=given.charAt(i);
            if(given.charAt(i)==' ' || i==given.length()-1){
                deque.push(eachword);
                eachword="";
            }
        }
        return deque.stream().reduce("",(a,b)->a+b);
    }

}
