package com.cybertek.leetcode.array;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Algo_6ThreeNumberSum {
    public static void main(String[] args) {

        int [] givenArray = {12,3,1,2,-6,5,-8,6};
        int target = 0 ;

        //sample output =[[-8,2,6],[-8,3-5],[-6,1,5]]

        System.out.println(Arrays.toString(threeNumSum(givenArray, target)));
    }

    public static int[][] threeNumSum(int[] nums, int target){

        int [][] result = new int[3][];
        int[] innerArray= new int[3];

        int i = 0,inner=0;
        int center=1;
        int j = nums.length-1;
        Arrays.sort(nums); // -8,-6,1,2,3,5,6,12 [nlogn]


        while(i<center && j>center ){

            if(nums[i]+nums[center]+nums[j]==target){
               innerArray[0]=nums[i];
               innerArray[1]=nums[center];
               innerArray[2]=nums[j];

            }
//            j++;i++,center++;

        }


        return result;

    }


}
