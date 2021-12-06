package com.cybertek.leetcode.ALGO_QS;



public class Algo16_MedianOfTwoSortedArray {

    public static void main(String[] args) {

        int[] given1 = {1, 2, 4, 9, 11, 19}; //9  123 456789 /5
        int[] given2 = {3, 4, 9, 11, 17};

        System.out.println("findMedianfromArrays(given1,given2) = " + findMedianFromArrays(given1, given2));
    }

    static double findMedianFromArrays(int[] array1, int[] array2) {

        int[] longArray = (array1.length >= array2.length) ? array1 : array2;
        int[] shortArray = (array1.length < array2.length) ? array1 : array2;
        int totalLength = array1.length + array2.length;
        boolean isEven = totalLength % 2 == 0;
        int medianIdx = (totalLength - 1) / 2;
        int pointer;
        int ls = 0, lr = longArray.length - 1;
        int ss = 0, sr = shortArray.length - 1;


        if (shortArray[shortArray.length - 1] <= longArray[0]) //123 456789
            return longArray[medianIdx - shortArray.length];
        if (longArray[longArray.length - 1] < shortArray[0]) // 12345 678
            return longArray[medianIdx - shortArray.length];

//        int[] given1 = {1, 2, 4, 9, 11, 19};
//        int[] given2 = {3, 4, 9, 11, 17};

        return 0;
    }

    int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            //x değeri ortanca değer mi kontrol et
            if (arr[m] == x)
                return m;

            // x ortanca değerden büyükse, sol yarıyı görmezden gelir
            if (arr[m] < x)
                l = m + 1;

                // x ortanca değerden küçükse, sağ yarıyı görmezden gelir
            else
                r = m - 1;
        }

        // x değeri dizide bulunamadıysa -1 değerini döner
        return -1;
    }
}


/**
 * Question # 16
 * Description:
 * Median of Two Sorted Arrays
 * Difficulty: Hard Category: Array
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median
 * of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * <p>
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
 * <p>
 * <p>
 * <p>
 * public static void main(String args[]) {
 * BinarySearch search = new BinarySearch();
 * int arr[] = { 1, 3, 5, 7, 9 };
 * int n = arr.length;
 * int x = 7;
 * int result = search.binarySearch(arr, x);
 * if (result == -1)
 * System.out.println("Element not present");
 * else
 * System.out.println("Element found at "
 * + "index " + result);
 * }
 * }
 */