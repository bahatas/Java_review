package com.cybertek.leetcode.codewars;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.logging.Logger;

public class Automorphic {
    static Logger log = Logger.getGlobal();



    public static void main(String[] arrays) {
        System.out.println("arrays[0] = " + arrays.length);




        System.out.println(log);
        log.info("This is message comes from logger");
        System.out.println("autoMorphic(25) = " + autoMorphic(25));
        log.info("{} method name" );
        System.out.println("autoMorphic(13) = " + autoMorphic(13));
        System.out.println("autoMorphic(76) = " + autoMorphic(76));
        System.out.println("autoMorphic(95) = " + autoMorphic(95));
        System.out.println("autoMorphic(625) = " + autoMorphic(625));
        System.out.println("autoMorphic(225) = " + autoMorphic2(225));
        System.out.println("autoMorphic(425) = " + autoMorphi3(425));
        System.out.println("autoMorphic(399) = " + autoMorphic(399));

        System.out.println("arrays[0] = " + arrays[0]);
    }

    public static String autoMorphic2(int number) {
        log.info("second method has been called");
        log.entering("Automorphic","auto-1");
        return number  == Math.pow(number, 2) % 10 ? "Automorphic" : "Not!!";

    }

    public static String autoMorphic(int number) {

        log.info("first method has been called");

        String numString= String.valueOf(number);
        String numStringSq= String.valueOf(number*number);


        return   numStringSq.substring(numStringSq.length()-numString.length()).equals(numString)?"Automorphic" : "Not!!";


    }

    public static String autoMorphi3(int number) {
        log.info("thirth method has been called");
        return BigInteger.valueOf(number).pow(2).toString().endsWith(String.valueOf(number)) ? "Automorphic" : "Not!!";
    }
}