package com.cybertek.leetcode.ALGO_QS;

import java.util.*;

public class Algo13_ {
    public static void main(String[] args) throws Exception {

        int [] giveArray = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        int [] giveArray3 = {-8,-7,-6,-3,-2,0,-5,-10,6,4,6,7,8,9,5,4,3,2,1,0,-1,6};
        int[] giveArray2 = {0, 10, 6, 5, -1, -3, 2, 3};
        int[] giveArray4 = {5,4,3,2,1,2,3,4,5};
        int[] giveArray5 = {5,5,5,5,5,5,99,5,5,5,};
        int[] giveArray6 = {5,5,5,5,5};
        //getLongestPeakSize(giveArray);
        System.out.println("getLongestPeakSize(giveArray2) = " + getLongestPeakSize(giveArray2));
        System.out.println("getLongestPeakSize(giveArray) = " + getLongestPeakSize(giveArray));
        System.out.println("getLongestPeakSize(giveArray3) = " + getLongestPeakSize(giveArray3));
        System.out.println("getLongestPeakSize(giveArray4) = " + getLongestPeakSize(giveArray4));
        System.out.println("getLongestPeakSize(giveArray5) = " + getLongestPeakSize(giveArray5));
        System.out.println("getLongestPeakSize(giveArray6) = " + getLongestPeakSize(giveArray6));
    }



    static int getLongestPeakSize(int[] given) {
        int left = given[0];
        int peak = given[0];
        int right = given[0];

        List<Integer> peakSizeList =new ArrayList<>();
        int sizeCounter=0;

        for(int idx =1; idx<given.length-1;idx++){
            int pointer = given[idx];
            int previousPointer = given[idx-1];
            int nextPointer = given[idx +1];

            if(pointer>previousPointer){

                if(pointer<nextPointer){
                    sizeCounter++;
                }else if(pointer>nextPointer){
                    peak=pointer;
                    right=nextPointer;
                    sizeCounter++;
                }
            }else if(pointer<previousPointer){
                if(pointer>nextPointer && peak!=left){
                    right=nextPointer;
                    sizeCounter++;
                }else{
                    peakSizeList.add(sizeCounter+2);
                    left=right=peak=pointer; sizeCounter=0;
                }
            }else{
                peakSizeList.add(sizeCounter+2);
                left=right=peak=pointer; sizeCounter=0;
            }


        }
        System.out.println("peakSizeList = " + peakSizeList);
        return peakSizeList.stream().filter(e->e>2).max(Integer::compareTo).orElse(0);
    }
    static int getLongestPeakSize2(int[] given) throws Exception {

        int left = given[0];
        int peak = given[0];
        int right = given[0];

        List<Integer> initialNums = List.of(left, peak, right);
        List<Map<Integer,Integer>> updates = new ArrayList<>();
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(left,0);hm.put(peak,0);hm.put(right,0);

        if (given.length < 3) throw new Exception("Given array argument is not available");

        int idx = 1;
        while (idx < given.length - 1) {
            int pointer = given[idx];
            int previousPointer = given[idx-1];

            if (pointer > peak) {
                peak = pointer;
                hm.replace(peak,pointer);
                right=pointer;

                idx++;
                continue;

            } else if (pointer < peak) {
                if(pointer<right){
                    right=pointer;
                    hm.replace(right,pointer);
                    idx++;
                    continue;
                }else {
                    right=previousPointer;
                    hm.replace(right,previousPointer);
                    idx++;

                    continue;
                }

            } else if (pointer == peak) {
                left = pointer;
                peak = pointer;
                right = pointer;
                idx++;
                continue;
            }

        }
        System.out.println("hm = " + hm);
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        int l = Arrays.binarySearch(given,left);
        System.out.println("l = " + l);
        int r = Arrays.binarySearch(given,right);
        System.out.println("r = " + r);


        return r-l+1;
    }
}


/**
 * Difficulty : Medium. Category : Arrays
 * Write a function that takes in an array of integers and returns the length of the longest peak
 * in the array. A peak is defined as adjacent integers in the array that are strictly increasing
 * until they reach a tip (the highest value in the peak), at which point they become strictly
 * decreasing. At least three integers are required to form a peak. For example, the integers 1,
 * 4, 10, 2 form a peak, but the integers 4, 0, 10 don't and neither do the integers 1, 2, 2, 0 .
 * Similarly, the integers 1, 2, 3 don't form a peak because there aren't any strictly decreasing
 * integers after the 3.
 * <p>
 * Sample Input
 * array = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
 * <p>
 * Sample Output
 * 6 // 0, 10, 6, 5, -1, -3
 */