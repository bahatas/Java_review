package com.cybertek.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Algo_5TwoNumberOfSum {


    public static void main(String[] args) {

//        int[] givenArray = {3, 5, -4, 8, 11, 1, -1, 6,4};
        int[] givenArray = {5,5,5};
        int[] givenArray2 = {0,10};
        int targetSum = 10;

        System.out.println("Arrays.toString(getArray(givenArray,10)) = " + Arrays.toString(getArray(givenArray, targetSum)));
        System.out.println("Arrays.toString(getArray2(givenArray,10)) = " + Arrays.toString(getArray2(givenArray, targetSum)));
        System.out.println("Arrays.toString(getArray3(givenArray,10)) = " + Arrays.toString(getArray3(givenArray, targetSum)));
        System.out.println("Arrays.toString(getArray3(givenArray2,10)) = " + Arrays.toString(getArray3(givenArray2, targetSum)));
        //Sample Output
        //[-1, 11] // the numbers could be in reverse order


    }

    public static int[] getArray(int[] givenArray, int target) {

        return IntStream.range(0,givenArray.length)
                .flatMap(e-> Arrays.stream(givenArray)
                        .filter(x->(x+givenArray[e])==target)
                ).limit(2).toArray();

    }
    public static int[] getArray2(int[] givenArray, int target) {

     int[] result = new int[2];
     outer:
     for(int i = givenArray.length-1; i>=0; i--){
         for(int j = i-1; j>=0; j --){
             if(givenArray[i]+givenArray[j]==10) {
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
                         .flatMap(e->Arrays.stream(givenArray)
                        .filter(x->(e+x)==target && e!=x)
                ).limit(2).toArray();

    }


}
