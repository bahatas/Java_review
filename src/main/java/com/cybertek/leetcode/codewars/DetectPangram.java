package com.cybertek.leetcode.codewars;

import java.util.Arrays;
import java.util.stream.Stream;

public class DetectPangram {

    public static void main(String[] args) {

    }


    public static int[] sortArray(int[] array) {

        int [] result = new int[array.length];
        int[] ints1 = Arrays.stream(array).filter(e -> e % 2 == 0).toArray();
        int[] ints = Arrays.stream(array).filter(e -> e % 2 == 1).toArray();
        Arrays.sort(ints);
        int counter =0;
        int counter1 =0;
        for (int i = 0; i < array.length ; i++) {

            if(array[0]%2==0) {
                result[0]=array[0];
            }else {
                
            }

        }



        return  null;
    }

}
/**
 *
 */