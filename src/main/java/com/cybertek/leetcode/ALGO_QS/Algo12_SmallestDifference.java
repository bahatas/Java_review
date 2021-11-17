package com.cybertek.leetcode.ALGO_QS;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Algo12_SmallestDifference {
    public static void main(String[] args) {

        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};
        System.out.println("(getSmallestDiffPair(arrayOne,arrayTwo)) = " + Arrays.toString(getSmallestDiffPair(arrayOne, arrayTwo)));
    }
    static int[] getSmallestDiffPair(int[] firstArr, int[] secondArr) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i < firstArr.length; i++) {
            for (int j = 0; j < secondArr.length; j++) {
                int diff=Math.subtractExact(firstArr[i], secondArr[j]);
                hm.put(Math.abs(diff) ,Arrays.asList(firstArr[i], secondArr[j]));
            }
        }
        return
                hm.entrySet()
                        .stream().min(Map.Entry.comparingByKey())
                        .map(Map.Entry::getValue).get().stream()
                        .mapToInt(e -> e).toArray();
    }

    static int[] getSmallestDiffPair2(int[] firstArr, int[] secondArr) {

        Map<Integer,Integer> hm = new HashMap<>();
        IntStream.of(firstArr).map(e->hm.put(e,1));
        System.out.println(hm);


      int[] mergedArray = new int [firstArr.length+secondArr.length];
      Arrays.stream(firstArr).flatMap(each->Arrays.stream(secondArr));
      //  Stream.of(firstArr,secondArr).flatMap(each->Arrays.stream())



        int[] result = new int[0];
        return result;
    }
}


/**
 * Question # 12
 * Description:
 * Smallest Difference
 * Difficulty: Medium Category: Arrays
 * Write a function that takes in two non-empty arrays of integers, finds the pair of numbers
 * (one from each array) whose absolute difference is closest to zero, and returns an array
 * containing these two numbers, with the number from the first array in the first position.
 * Note that the absolute difference of two integers is the distance between them on the real
 * number line. For example, the absolute difference of -5 and 5 is 10, and the absolute
 * difference of -5 and -4 is 1. You can assume that there will only be one pair of numbers with
 * the smallest difference.
 * Sample Input
 * arrayOne = [-1, 5, 10, 20, 28, 3]
 * arrayTwo = [26, 134, 135, 15, 17]
 * Sample Output
 * [28, 26]
 */