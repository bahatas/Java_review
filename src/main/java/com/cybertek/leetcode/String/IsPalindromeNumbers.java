package com.cybertek.leetcode.String;

import com.cybertek.leetcode.aop.LogicExecutionTime;

import java.util.stream.Stream;

public class IsPalindromeNumbers {

    public static void main(String[] args) {
        int number = 121;
        int number2 = -121;

        System.out.println("isPalindrome(number2) = " + isPalindrome(number2));
        System.out.println("isPalindrome(number) = " + isPalindrome(number));
        System.out.println("isPalindrome(number2) = " + isPalindrome2(number2));
        System.out.println("isPalindrome(number) = " + isPalindrome2(number));
    }


    @LogicExecutionTime
    public static boolean isPalindrome(int x) {


        String xStr= String .valueOf(x);

        String reversed = new StringBuilder(String.valueOf(x)).reverse().toString();
        System.out.println("string= " + xStr);
        System.out.println("reversed = " + reversed);

        return xStr.equals(reversed);


    }

   static boolean isPalindrome2(int x) {
        String s=String.valueOf(x);
        int n=s.length();
        int j=n-1;int i=0;boolean c=false;
        if(n==1)return true;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                c=true;
                i++;j--;
            }
            else {
                return false;
            }
        }return c;

    }
}
