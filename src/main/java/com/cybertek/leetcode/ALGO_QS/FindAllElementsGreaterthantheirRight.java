package com.cybertek.leetcode.ALGO_QS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given an unsorted integer array, print all greater elements than all elements present to their right using Stack.
 * For example, consider the array [10, 4, 6, 3, 5]. The elements that are greater than all elements to their right are 10, 6, and 5.
 * 10 > 4  &  10 > 6  &  10 > 3  &  10 > 5
 */
public class FindAllElementsGreaterthantheirRight {
    public static void main(String[] args) {

        System.out.println(find(new int[]{10, 4, 6, 3, 5}));
    }

    static List<Integer> find(int [] arr){
        Stack<Integer> stack = new Stack<>();
        for (int each : arr) {
            while(!stack.isEmpty() && stack.peek()< each ){
                stack.pop();
            }
            stack.push(each);
        }


        var array = new ArrayList<>(stack);
        Collections.sort(array);
        return array;
        //push all to stack

    }

}
