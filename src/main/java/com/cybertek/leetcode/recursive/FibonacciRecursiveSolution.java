package com.cybertek.leetcode.recursive;

public class FibonacciRecursiveSolution {


    // 0 1 1 2 3 5 8 13 21 ...
    public static void main(String[] args) {

        System.out.println(recursiveFib(250));
    }


    public static int recursiveFib(int number) {

        if (number == 0) return 0;
        if (number == 1) return 1;
        return recursiveFib(number - 1) + recursiveFib(number - 2);
    }

}
