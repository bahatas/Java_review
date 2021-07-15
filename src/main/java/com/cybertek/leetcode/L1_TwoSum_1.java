package com.cybertek.leetcode;

import java.util.Arrays;

public class L1_TwoSum_1 {

   /* Given an array of integers nums and an integer target,

   return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.*/

//    Constraints:
//
//            2 <= nums.length <= 104
//            -109 <= nums[i] <= 109
//            -109 <= target <= 109
//    Only one valid answer exists.

//    Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

//     <p> Example: Given nums = [2, 7, 11, 15], target = 9,
//            *
//            * <p>Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        outer:
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length-1) {
                inner:
                for (int j = i + 1; j < nums.length; j++) {

                    if ((nums[i] + nums[j]) == target) {
                        result[0] = i;
                        result[1] = j;
                        break;

                    }

                }

                if(result[0]!=0 && result[1]!=0);
                break;

            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};

        int [] result= twoSum(nums, 26);

        System.out.println("twoSum(nums,5).toString() = " + Arrays.toString(result));

    }
}
