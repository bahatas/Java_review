package com.cybertek.leetcode.ALGO_QS;

public class Algo_15 {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        getLongestArray(array);
    }

    static int[] getLongestArray(int[] given){

        int[] result = new int[2];
        return  result;
    }
}
/**
 * Question # 15
 * Description:
 * Subarray Sort
 * Difficulty: Hard Category: Array
 * Write a function that takes in an array of at least two integers and that returns an array of
 * the starting and ending indices of the smallest subarray in the input array that needs
 * to be sorted in place in order for the entire input array to be sorted (in ascending order).
 * If the input array is already sorted, the function should return [-1, -1].
 *
 * Sample Input
 * array = [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]
 * Sample Output
 * [3, 9]
 *
 * Find the smallest and largest numbers that are out of order in the input array.
 * You should be able to do this in a single pass through the array.
 */