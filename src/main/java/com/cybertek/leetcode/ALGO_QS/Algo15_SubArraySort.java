package com.cybertek.leetcode.ALGO_QS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Algo15_SubArraySort {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        getLongestArray(array);
    }

    static int[] getLongestArray(int[] given){

        HashMap<Integer,Integer> hm = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();

        int[] result = new int[2];
        int[] sortedGiven= Arrays.copyOf(given,given.length);

        Arrays.sort(sortedGiven);
        if(Arrays.equals(given,sortedGiven)) result= new int[]{-1, -1};

        for (int i = 0; i < given.length; i++) {
            hm.put(i+1, given[i]);
        }

        System.out.println("hm = " + hm);

        for (int idx = 1; idx < given.length; idx++) { // * array = [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]
            int previousPointer = given[idx - 1];
            int pointer = given[idx];
            int breakPoint;

            if(pointer>previousPointer){
                continue;
            }else{
                    breakPoint=pointer;
                    hm2.put(idx,pointer);


            }
        }

        return  result;
    }
    // Function to find the smallest window in the array, sorting
    // which will make the entire array sorted
    public static void findSubarray(int[] A)
    {
        int leftIndex = -1, rightIndex = -1;

        // traverse from left to right and keep track of maximum so far
        int max_so_far = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++)
        {
            if (max_so_far < A[i]) {
                max_so_far = A[i];
            }

            // find the last position that is less than the maximum so far
            if (A[i] < max_so_far) {
                rightIndex = i;
            }
        }

        // traverse from right to left and keep track of the minimum so far
        int min_so_far = Integer.MAX_VALUE;
        for (int i = A.length - 1; i >= 0; i--)
        {
            if (min_so_far > A[i]) {
                min_so_far = A[i];
            }

            // find the last position that is more than the minimum so far
            if (A[i] > min_so_far) {
                leftIndex = i;
            }
        }

        if (leftIndex == -1) {
            System.out.print("Array is already sorted");
            return;
        }

        System.out.print("Sort array from index " + leftIndex + " to " + rightIndex);
    }




//matt abi
static int[] findTheUnsortedPart(int[] arr){
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    int[] result = {-1,-1};

    for(int i = 0;i< arr.length;i++){
        int j = arr.length-1-i;

        if(i != arr.length-1 && arr[i+1]<arr[i]) max = Math.max(arr[i],max );
        if(j != 0 && arr[j-1]>arr[j]) min = Math.min(arr[j],min);

        if( arr[i]<=max) result[1] = i;
        if( arr[j]>=min) result[0] = j;
    }
    return result;
}

    static int[] findTheUnsortedPart2(int[] arr){
        int i = 0,j = arr.length-1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] result = {-1,-1};

        while(i< arr.length){

            if(i != arr.length-1 && arr[i+1]<arr[i]) max = Math.max(arr[i],max );
            if(j != 0 && arr[j-1]>arr[j]) min = Math.min(arr[j],min);

            if( arr[i++]<=max) result[1] = i-1;
            if( arr[j--]>=min) result[0] = j+1;
        }
        return result;
    }

    static int[] findTheUnsortedPartWithSort(int[] arr){
        int[] sorted = Arrays.copyOf(arr,arr.length);
        int[] result = {-1,-1};
        int left=-1, right= arr.length;
        Arrays.sort(sorted);

        for(int i=0;i< arr.length;i++){

            int j= arr.length-1-i;
            if(left == -1 && sorted[i]!=arr[i]) result[0]=left=i;
            if(right == arr.length && sorted[j]!=arr[j]) result[1]=right=j;
        }

        return result;
    }

    //Cundullah
    public static int[] bruteForce(int[] nums) {

        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int[] compare = Arrays.copyOf(nums, nums.length);
        int startPoint = -1;
        int endPoint = -1;

        Arrays.sort(nums);

        if (compare[0] != nums[0]) {
            startPoint = 0;
        }

        if (compare[compare.length - 1] != nums[nums.length - 1]) {
            endPoint = compare.length - 1;
        }

        for (int i = 1, j = nums.length - 1; i <= j; i++, j--) {

            if (compare[i] != nums[i] && startPoint == -1) {
                startPoint = i;
                i--;
            }

            if (compare[j] != nums[j] && endPoint == -1) {
                endPoint = j;
                j++;
            }

        }

        return new int[] {startPoint, endPoint};

    }

    public static int[] subArraySort(int[] nums) {

        int start = -1;
        int end = -1;
        int max = 0;
        int min = 0;

        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        for (int i =  0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                start = i;
                break;
            }
        }

        if (start == - 1) {
            return new int[] {-1, -1};
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                end = i;
                break;
            }
        }

        max = nums[start];
        min = nums[start];

        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        for (int i = 0; i < start; i++) {
            if (nums[i] > min) {
                start = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= end; i--) {
            if (nums[i] < max) {
                end = i;
                break;
            }
        }

        return new int[] {start, end};

    }

    private static String getLongestNonDupSubstringMySol1(String source){
        ArrayList<SubString> subStrings = new ArrayList<>();

        subStrings.add(new SubString(source.charAt(0), 0));

        for (int i = 1; i < source.length(); i++) {
            char currentChar = source.charAt(i);
            int finalI = i;
            subStrings.forEach(s -> s.addWithControl(currentChar, finalI));
            subStrings.add(new SubString(currentChar, finalI));
        }

        subStrings.sort((o1, o2) -> o2.getLength() > o1.getLength() ? 1 : -1);

        return subStrings.get(0).substring;
    }
}

//kichi
 class SubString{
    public String substring;
    public int startIndex, endIndex;
    public char startingChar;
    public boolean isClosed = false;

    public SubString(char startingChar, int startIndex){
        this.startingChar = startingChar;
        this.startIndex = startIndex;
        substring = String.valueOf(startingChar);
    }

    public void addWithControl(char charToAdd, int index){
        if (!isClosed){
            isClosed = substring.contains(String.valueOf(charToAdd));

            if (!isClosed)
            {
                endIndex = index;
                substring += charToAdd;
            }
        }
    }

    public int getLength(){return endIndex - startIndex + 1;}
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