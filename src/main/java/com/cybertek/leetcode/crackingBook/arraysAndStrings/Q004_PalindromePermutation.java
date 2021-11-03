package com.cybertek.leetcode.crackingBook.arraysAndStrings;


import java.util.Locale;

public class Q004_PalindromePermutation {

    /**
     * Given a string, write a function to check if it is a permutation of
     * a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
     * permutation is a rearrangement of letters. The palindrome does not need to be limited to just
     * dictionary words.
     * EXAMPLE
     * Input: Tact Coa
     * Output: True (permutations: "taco cat'; "atc o eta·; etc.)
     */
    public static void main(String[] args) {

        String given = "Tact Cao".toLowerCase(Locale.ROOT);
        System.out.println("canPermutePalindrome(\"aab\") = " + canPermutePalindrome("aab"));
        System.out.println("canPermutePalindrome(\"code\") = " + canPermutePalindrome("code"));
        System.out.println("canPermutePalindrome(given) = " + canPermutePalindrome(given));
    }


    /**
     * \
     * Implementing this algorithm is fairly straightforward. We use a hash table to count how many times each
     * character appears. Then, we iterate through the hash table and ensure that no more than one character has
     * an odd count.
     */

    static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    static boolean checkMaxOneOdd(int[] table) {

        boolean foundOdd = false;

        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /**
     * Map each charcater to a number. a -> 0, b -> 1, c -> 2, etc.
     * 21 * This is case insensitive. Non-letter characters map to -1.
     */

    static int getCharNumber(Character c) {

        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue('c');
        if (a <= val && val <= z) {
            return val - a;

        }
        return -1;
    }

    /* Count how many times each character appears. */
    static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z')
                - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;

            }
        }
        return table;
    }


    //This algorithm takes O ( N) time, where N is the length of the string.

    public static boolean canPermutePalindrome(String s ){

        int [] char_counts = new int[128];
        for (int i = 0; i <s.length() ; i++) {
            char_counts[s.charAt(i)]++;
        }

        int count = 0;
        for(int i=0; i<128;i++){
            count+= char_counts[i] %2;
        }
        return count <=1;



    }

}

