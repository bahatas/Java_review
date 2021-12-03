package com.cybertek.leetcode.ALGO_QS;

public class Algo16_MedianOfTwoSortedArray {

    public static void main(String[] args) {

       int[] nums1 = {1,3};



    }

    static double findMedianfromArrays(int [] array1, int[] array2){


        return 0;
    }
    static double medianOfTwoArrays1(int[] arr1, int[] arr2) {
        //if arr1 length is greater than arr2, switch them so that arr1 is smaller than arr2
        if (arr1.length > arr2.length) {
            return medianOfTwoArrays1(arr2, arr1);
        }

        int x = arr1.length;
        int y = arr2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : arr2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : arr2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }

        }
        throw new IllegalArgumentException();
    }
}


/**
 * Question # 16
 * Description:
 * Median of Two Sorted Arrays
 * Difficulty: Hard Category: Array
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median
 * of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */