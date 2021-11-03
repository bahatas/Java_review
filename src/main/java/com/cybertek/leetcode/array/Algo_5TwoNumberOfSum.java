package com.cybertek.leetcode.array;

import jdk.jfr.StackTrace;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Algo_5TwoNumberOfSum {


    public static void main(String[] args) {

        int[] givenArray3 = {3, 5, -4, 8, 11, 1, -1, 6, 4};
//        Sample Output
//        [-1, 11] // the numbers could be in reverse order
        int[] givenArray = {5, 5, 5};
        int[] givenArray2 = {0, 10};
        int targetSum = 10;

        System.out.println("Arrays.toString(getArray(givenArray,10)) = " + Arrays.toString(getArray(givenArray, targetSum)));
        System.out.println("Arrays.toString(getArray(givenArray,10)) = " + Arrays.toString(getArray(givenArray3, targetSum)));
        System.out.println("Arrays.toString(getArray2(givenArray,10)) = " + Arrays.toString(getArray2(givenArray, targetSum)));
        System.out.println("Arrays.toString(getArray3(givenArray,10)) = " + Arrays.toString(getArray3(givenArray, targetSum)));
        System.out.println("Arrays.toString(getArray3(givenArray2,10)) = " + Arrays.toString(getArray3(givenArray3, targetSum)));
        System.out.println("Arrays.toString(getArray3(givenArray2,10)) = " + Arrays.toString(twoSum(givenArray3, targetSum)));
        System.out.println("" +
                "sahin abi = " + Arrays.toString(twoNumberSum(givenArray3, targetSum)));
        System.out.println("" +
                "cihat abi = " + Arrays.toString(twoSum(givenArray3, targetSum)));


    }

    public static int[] getArray(int[] givenArray, int target) {
        Set< Integer>  set = new HashSet<>();
//        Stream.of(givenArray).forEach(e->set.add(Integer.valueOf(e)));
//        for (int a:nums) {
//            System.out.println(a);
//        }
//        return Arrays.stream(givenArray)
//                .filter(e->nums.contains(target-e))
//                .


//        return IntStream.range(0, givenArray.length)
//                .flatMap(e -> Arrays.stream(givenArray)
//                        .sorted()
//                        .filter(x -> (x + givenArray[e]) == target)
//                ).limit(2).toArray();
                        return null;
    }
    public static int[] getArray2(int[] givenArray, int target) {

     int[] result = new int[2];
     outer:
     for(int i = givenArray.length-1; i>=0; i--){
         for(int j = i-1; j>=0; j --){
             if(givenArray[i]+givenArray[j]==target) {
                 result[0] = givenArray[i];
                 result[1] = givenArray[j];
                 break outer;
             }
         }
     }

     return result;
    }

    public static int[] getArray3(int[] givenArray, int target) {

        return
                Arrays.stream(givenArray)
                        .flatMap(e -> Arrays.stream(givenArray)
                                //                  .filter(x->(e+x)==target && givenArray[e]!=x)
                        ).limit(2).toArray();

    }

    //sahin abi
    public static int[] twoNumberSum(int[] array, int totalSum) {

        int[] result = new int[2];
        Arrays.sort(array);

        int head = 0;
        int tail = array.length - 1;

        while (head < tail) {

            if (array[head] + array[tail] == totalSum) {
                result[0] = array[head];
                result[1] = array[tail];
                return result;
            }

            if (array[head] + array[tail] < totalSum) head++;
            if (array[head] + array[tail] > totalSum) tail--;
        }

        return new int[0];

    }

    //cihat abi
    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
            }
        }
        return result;
    }

    //matt abi
    public static int[] findThePair(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        Arrays.sort(arr);  // nlog(n)

        while (i < j) {  //n
            if (arr[i] + arr[j] == target) return new int[]{arr[i], arr[j]};
            else if (arr[i] + arr[j] < target) i++;
            else j--;
        }
        return new int[0];
    }

    public static int[] findThePair2(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {   //o(n)
            if (map.containsKey(j)) return new int[]{j, map.get(j)};
            else map.put(target - j, j);
        }
        return new int[0];
    }

}
