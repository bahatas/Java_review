package com.cybertek.leetcode.codewars;

import java.math.BigInteger;

public class Automorphic {

    public static void main(String[] args) {

        System.out.println("autoMorphic(13) = " + autoMorphic(25));
        System.out.println("autoMorphic(13) = " + autoMorphic(13));
        System.out.println("autoMorphic(13) = " + autoMorphic(76));
        System.out.println("autoMorphic(13) = " + autoMorphic(95));
        System.out.println("autoMorphic(13) = " + autoMorphic(625));
        System.out.println("autoMorphic(13) = " + autoMorphic(225));
        System.out.println("autoMorphic(13) = " + autoMorphic(425));
        System.out.println("autoMorphic(13) = " + autoMorphic(399));
    }

    public static String autoMorphic2(int number) {
        return number  == Math.pow(number, 2) % 10 ? "Automorphic" : "Not!!";
    }

    public static String autoMorphic(int number) {


        String numString= String.valueOf(number);
        String numStringSq= String.valueOf(number*number);


        return   numStringSq.substring(numStringSq.length()-numString.length()).equals(numString)?"Automorphic" : "Not!!";


    }

    public static String autoMorphi3(int number) {
        return BigInteger.valueOf(number).pow(2).toString().endsWith(String.valueOf(number)) ? "Automorphic" : "Not!!";
    }
}