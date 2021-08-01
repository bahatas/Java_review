package com.cybertek.leetcode.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
 *
 * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
 */
public class Regex {

    public static void main(String[] args) {
        System.out.println(Pattern.matches("[a-zA-z]", "The quick brown fox jumps over the lazy dog"));
        System.out.println(Pattern.compile("abcdefghijklmnopqrstuvwxyz"));

        //Pattern pattern = Pattern.compile("[^a-z^]");

        String regex="abcdefghijklmnopqrstuvwxyz";



        String sentence = "The quick brown fox jumps over the lazy dog".replace(" ", "").trim();
        String s = Arrays.stream(sentence.toLowerCase().split(""))
                .sorted().distinct().collect(Collectors.toList()).toString()
                .replace("[","").replace("]","").replace(", " , "");
        System.out.println("******************");
        System.out.println(s);


        System.out.println(Arrays.stream(sentence.toLowerCase().split("")).sorted().distinct().count());
        System.out.println();
        List<String> collect = Arrays.stream(sentence.split("")).distinct().collect(Collectors.toList());

        System.out.println("collect.toString() = " + collect.toString());

        String regex1 = "[a-z]";
        System.out.println("regex = " + regex);


        Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Visit W3Schools!");
        boolean matchFound = matcher.find();
        if(matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }

        String s1 = "You shall not pass!";

        System.out.println(check(sentence));
        System.out.println(check(s1));

    }



    public static boolean check(String sentence) {
        String regex="abcdefghijklmnopqrstuvwxyz";
        String s = Arrays.stream(sentence.toLowerCase().split(""))
                .sorted().distinct().collect(Collectors.toList()).toString()
                .replace("[","").replace("]","").replace(", " , "");
        return regex.equals(s);
    }

}
