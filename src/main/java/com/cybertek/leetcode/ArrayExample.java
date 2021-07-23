package com.cybertek.leetcode;

public class ArrayExample {


    public int[] sumIndex(int[] array, int num){

        int [] result = new int[2];

        outer:
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length ; j++) {
                if(array[i]+array[j]==num){
                    result[0]=i;
                    result[1]=j;
                    break outer;
                }
            }
        }

        return result;
    }


}
