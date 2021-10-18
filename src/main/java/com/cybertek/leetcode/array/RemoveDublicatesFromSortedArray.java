package com.cybertek.leetcode.array;




import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

/*
Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages,
 you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDublicatesFromSortedArray {


    public static void main(String[] args) {
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
        int [] nums =  {1,1,2};
       int [] nums2 =  {0,0,1,1,1,2,2,3,3,4};

        System.out.println("removeDuplicates(nums) = " + removeDuplicates(nums));
        System.out.println("removeDuplicates(nums2) = " + removeDuplicates(nums2));
        System.out.println("removeDuplicates2(nums) = " + removeDuplicates2(nums));
        System.out.println("removeDuplicates2(nums2) = " + removeDuplicates2(nums2));
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
    }


    public static  int removeDuplicates(int[] nums) {

        if(nums.length==0) return 0;
//        List<Integer> list = new ArrayList<>();

        Set<Integer> sortedSet = new TreeSet<>();
        Arrays.stream(nums).distinct().forEach(sortedSet::add);

        return sortedSet.size();

    }
    public static  int removeDuplicates2(int[] nums) {



        if( nums.length == 0)
            return 0;

        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]==nums[i])
                continue;
            nums[++i]=nums[j];
        }
        return i+1;


    }










}
