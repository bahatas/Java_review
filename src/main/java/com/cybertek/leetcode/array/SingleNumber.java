package com.cybertek.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(" = " + getSingleNumber(new int[]{2, 2, 1,4,6,4,6}));
        System.out.println(" = " + getSingleNumber2(new int[]{2, 2, 1,4,6,4,6}));
    }

    public static int getSingleNumber(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (Integer i : nums) {
            if (!list.remove(i)) {
                list.add(i);
            }
        }

        return list.get(0);


    }
    public static int getSingleNumber3(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (Integer i : nums) {
            if (list.contains(i)) {
               var res =  list.remove(i);
            }else{
                list.add(i);
            }
        }
        return list.get(0);


    }
    public static int getSingleNumber2(int[] nums) {

        int result = 0;
        for(int i : nums){
            result ^= i;
        }
        return result;

    }
}
/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a **linear** runtime complexity and use only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,1]
 * Output: 1
 */