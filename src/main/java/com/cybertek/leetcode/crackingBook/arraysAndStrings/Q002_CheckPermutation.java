package com.cybertek.leetcode.crackingBook.arraysAndStrings;

import java.util.Arrays;

public class Q002_CheckPermutation {
    /**
     * Given two strings, write a method to decide if one is permutation of the
     * other
     *
     * @param args
     */
    public static void main(String[] args) {

        String str1 = "abhf,";
        String str2 = ".abhf,";

        System.out.println("permutation(str1,str2) = " + permutation(str1, str2));
    }


    /**
     *
     * Like in many questions, we should confirm some details with our interviewer. We should understand if the
     * permutation comparison is case sensitive. That is: is God a permutation of dog? Additionally, we should
     * ask if whitespace is significant. We will assume for this problem that the comparison is case sensitive and
     * whitespace is significant. So, "god " is different from "dog".
     * Observe first that strings of different lengths cannot be permutations of each other. There are two easy
     * ways to solve this problem, both of which use this optimization.
     */

    /**
     * If two strings are permutations, then we know they have the same characters, but in different orders. Therefore,
     * sorting the strings will put the characters from two permutations in the same order. We just need to
     * compare the sorted versions of the strings.
     */
    /**
     * Though this algorithm is not as optimal in some senses, it may be preferable in one sense: It's clean, simple
     * and easy to understand. In a practical sense, this may very well be a superior way to implement the problem.
     * However, if efficiency is very important, we can implement it a different way.
     */
    //Quite easy implementation
    static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return sort(s).equals(sort(t));
    }

    /**
     * We can also use the definition of a permutation-two words with the same character counts-to implement
     * this algorithm. We simply iterate through this code, counting how many times each character appears.
     * Then, afterwards, we compare the two arrays.
     * @param s
     * @param t
     * @return
     */

    //second alghoritm ? ASCII table is still valid or not ?

    boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128]; //Assumption
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            // count number of each char in s.
            letters[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}


/**
 * Note the assumption on line 6. In your interview, you should always check with your interviewer about the
 * size of the character set. We assumed that the character set was ASCII.
 */