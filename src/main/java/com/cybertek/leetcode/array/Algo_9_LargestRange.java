package com.cybertek.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Algo_9_LargestRange {
    public static void main(String[] args) {

        int[] array = {1, 11, 3, 0, 13, 5, 2, 4, 10, 7, 12, 6,15,20};
        //largestInterval(array);

        largestInterval2(array);


    }


    static int[] largestInterval(int[] given) {

        int[] result = new int[2];
        List<Set<Integer>> list = new LinkedList<>();
        Set<Integer> innerSet = new HashSet<>();

        int[] sortedArray = Arrays.stream(given).sorted().toArray(); //sort nlogn
        System.out.println("sorted array = " + Arrays.toString(sortedArray));


        for (int i = 0; i < sortedArray.length - 1; i++) {

            innerSet.add(sortedArray[i]);

            if (sortedArray[i + 1] != sortedArray[i] + 1) {
                list.add(innerSet);
                innerSet = new HashSet<>();

            } else {
                innerSet.add(sortedArray[i + 1]);
            }
        }

        list.add(innerSet); //for last innerlist

        Set<Integer> largestInnerSet = list.stream().max(Comparator.comparingInt(Set::size)).get();

        System.out.println("largestInnerSet = " + largestInnerSet);

        result[0] = Collections.min(largestInnerSet);
        result[1] = Collections.max(largestInnerSet);

        System.out.println("result = " + Arrays.toString(result));

        return result;

    }

    static int[] largestInterval2(int[] given) {

        int[] result = new int[2];

        List<Stack<Integer>> list = new ArrayList<>();
        Stack<Integer> innerStack = new Stack<>();
        Arrays.sort(given);

        innerStack.push(given[0]);

        for(int num :given){
            if(num==innerStack.peek()) continue;

            if(num==innerStack.peek()+1){
                innerStack.push(num);
            }else{
                list.add(innerStack);
                innerStack=new Stack<>();
                innerStack.push(num);
            }
        }
        list.add(innerStack);
        System.out.println("list: "+ list);



//        Stream.of(list).max(Comparator.comparingInt(value -> Stack.size(value))).get()


//        return
//        Arrays.stream(Arrays.stream(list.stream()
//                .max(Comparator.comparingInt(Stack::size))
//                .map(each ->
//                        Stream.of(each)
//                                .filter(e -> e.peek().equals(e.firstElement()) && e.peek().equals(e.lastElement()))
//                                .collect(Collectors.toList())
//                ).get().toArray()
//        ).toArray();
        return result;
    }
}
/**
 * Write a function that takes in an array of integers and returns an array of length 2
 * representing the largest range of integers contained in that array. The first number in the
 * output array should be the first number in the range, while the second number should be
 * the last number in the range. A range of numbers is defined as a set of numbers that come
 * right after each other in the set of real integers. For instance, the output array [2, 6]
 * represents the range {2, 3, 4, 5, 6}, which is a range of length 5. Note that numbers don't
 * need to be sorted or adjacent in the input array in order to form a range. You can assume
 * that there will only be one largest range.
 * Sample Input
 * array = [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
 * Sample Output [0, 7]
 */

//