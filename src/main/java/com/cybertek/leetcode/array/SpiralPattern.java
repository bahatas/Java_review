package com.cybertek.leetcode.array;

import java.util.Arrays;

public class SpiralPattern {


    /**
     * Sample Input
     * array = [ [1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7],]
     * Sample Output
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13,14,15,16]
     *
     */

    public static void main(String[] args) {

        int [][] given = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        System.out.println("getAllNumbers(given) = " + Arrays.toString(getAllNumbers(given)));

    }


     static int[] getAllNumbers(int[][] given) {

         int m,n;
         m=n=given.length;

        int [] result = new int[m*n];

        int index=0,outerPointer=0,innerPointer =0;
        for(int i=outerPointer; i<m;i++){

            for (int j = innerPointer; j <n; j++) {
                result[index]=given[i][j];
                index++;
                if((index)%m==4){
                    innerPointer=n-1;
                    continue;
                }
                if((index)%m==8){
                    outerPointer=n-1;
                    continue;
                }
            }
        }


        return result;

    }
}
