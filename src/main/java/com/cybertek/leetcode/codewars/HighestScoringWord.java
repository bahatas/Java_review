package com.cybertek.leetcode.codewars;

import java.util.Arrays;
import java.util.stream.Stream;

public class HighestScoringWord {

    public static void main(String[] args) {


        System.out.println(high("man i need a taxi up to ubud"));


    }
//todo
    public static String high(String s) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        String[] word = s.split(" ");

        for (String eachWord:word) {
            Stream<Integer> integerStream = Arrays.stream(eachWord.split(""))
                    .map(each -> {
                                int sum = 0;
                                sum += alphabet.indexOf(each);
                                return sum;
                            }

                    );


        }

        Integer integer = Arrays.stream(s.split(" "))
                .map(eachWord -> Arrays.stream(eachWord.split(""))
                        .map(eachChar ->
                                alphabet.indexOf(eachChar))
                        .reduce(1, (a, b) -> a + b)


                ).sorted().findFirst().get();

        return integer+"";

    }


}
