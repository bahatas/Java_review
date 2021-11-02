package com.cybertek.leetcode.crackingBook.arraysAndStrings;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class Q004_PalindromePermutationTest {

    @Test
    public void canPermutePalindrome() {

        Assert.assertFalse(Q004_PalindromePermutation.canPermutePalindrome("code"));
        Assert.assertTrue("test", Q004_PalindromePermutation.canPermutePalindrome("aab"));
        Assert.assertTrue("test", Q004_PalindromePermutation.canPermutePalindrome("Tact Cao"));
    }

    @Test
    public void isPermutationOfPalindrome() {
        Assert.assertTrue("Tact Cao", Q004_PalindromePermutation.isPermutationOfPalindrome("Tact Cao"));
        Assert.assertTrue("code", Q004_PalindromePermutation.isPermutationOfPalindrome("code"));
        Assert.assertTrue("aab", Q004_PalindromePermutation.isPermutationOfPalindrome("aab"));
    }
}