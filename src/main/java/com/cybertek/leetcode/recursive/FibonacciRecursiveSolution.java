package com.cybertek.leetcode.recursive;

import javafx.application.Application;
import javafx.stage.Stage;

public class FibonacciRecursiveSolution {

    public static void main(String[] args) {

    }

    static int fib(int number){

        if(number == 0) return 0;

        else if (number == 1) return 1;

        else {
            return fib(number-1)+fib(number-2);
        }

        return null;
    }
}
