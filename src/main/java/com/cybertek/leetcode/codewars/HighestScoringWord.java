package com.cybertek.leetcode.codewars;

import java.util.Arrays;

public class HighestScoringWord {

    public static void main(String[] args) {


        System.out.println(high("man i need a taxi up to ubud"));


    }
//todo
    public static String high(String s) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        Integer integer = Arrays.stream(s.split(" "))
                .map(eachWord -> Arrays.stream(eachWord.split(""))
                        .map(eachChar ->
                                alphabet.indexOf(eachChar))
                        .reduce(1, (a, b) -> a + b)


                ).sorted().findFirst().get();

        return integer+"";

    }


}
