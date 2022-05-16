package com.cybertek.leetcode.codewars;

import java.util.Arrays;

public class Mayki_1 {

    public static void main(String[] args) {

    }

    static int set(int[] number){

        Arrays.sort(number);

        int min=100000;
        int result=0;
        for (int i = 0; i < number.length-1; i++) {
           result= number[i+1]-number[i];
           if(result<min) min=result;

        }
        return  min;
    }
}
