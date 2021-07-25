package com.cybertek.leetcode.array;

public class MaxSubArray {

    /**
     * Given an integer array nums,
     * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     * <p>
     * A subarray is a contiguous part of an array.
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     */
    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("maxSubArray(nums) = " + maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int currentSum = maxSum;
        for (int i = 0; i < nums.length ; i++) {
            currentSum=Math.max(nums[i]+currentSum,nums[i]);
            maxSum=Math.max(currentSum, maxSum);
        }


        return maxSum;
    }
}
