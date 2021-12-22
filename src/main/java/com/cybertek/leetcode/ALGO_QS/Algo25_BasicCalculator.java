package com.cybertek.leetcode.ALGO_QS;

import java.util.Stack;

public class Algo25_BasicCalculator {

    public static void main(String[] args) {
        calculate("3+2*2");
        System.out.println(" calculate2(3+2*2*3+4) = " +  calculate2("3+2*2*3+4"));
    }


    /**
     * Cozum
     * Fatih Hoca
     */
    public static int calculateII(String s) {

        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            // calculate the number if more than one digit
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static int calculateIII(String str) {
        if (str == null || str.isEmpty()) return 0;
        int length = str.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = str.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
    static int calculate2(String s) {

        Stack<Integer> stack = new Stack<>();
        String numS ="";
        int num=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                numS+=c;
            }
            if(i+1==s.length() || (c == '+' || c == '-' || c == '*' || c == '/')){
                num=Integer.parseInt(numS);
                numS="";
                if (c == '+'){
                    stack.push(num);
                }else if(c == '-'){
                    stack.push(-num);
                }else  if(c == '*'){
                    while(Character.isDigit(s.charAt(i+1))){
                        numS+=s.charAt(i+1);
                        i++;
                        if(i==s.length()-1) break;
                    }
                   num=num*Integer.parseInt(numS);
                   stack.push(num);
                   numS="";
                }else  if(c == '/'){
                    while(Character.isDigit(s.charAt(i+1))){
                        numS+=s.charAt(i+1);
                        i++;
                        if(i==s.length()-1) break;
                    }
                    num=num/Integer.parseInt(numS);
                    stack.push(num);
                    numS="";
                }
            }
        }
        return stack.stream().reduce(0, (a, b) -> a + b);
    }

    static int calculate1(String s) {
        s = s.replaceAll(" ", "");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='*' || c == '/'){

                int leftPointer,rightPointer;
                rightPointer=leftPointer=i;
                String leftNum="";
                String rightNum="";
                while (!Character.isDigit(s.charAt(leftPointer-1))){
                    leftNum+=s.charAt(leftPointer-1);
                    leftPointer--;
                }
                while (!Character.isDigit(s.charAt(rightPointer+1))){
                    leftNum+=s.charAt(rightPointer+1);
                   rightPointer++;
                }


            }
        }


        for (int i = 0; i > s.length(); i++) {
            char c = s.charAt(i);
            if(c=='+' || c == '-'){



            }
        }

        return 0;
    }
    static int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<String> numStack = new Stack<>();
        Stack<String> calStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                calStack.push(c + "");
            } else {
                numStack.push(c + "");
            }
            int i1 = Math.addExact(3, Math.multiplyExact(2, 2));
            System.out.println(i1);
        }
        return 0;
    }
}

/**
 *
 */


/**
 * Basic Calculator
 * Difficulty :Medium     Category :Stacks
 * <p>
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 * Input: s = " 3+5 / 2 "
 * Output: 5
 * <p>
 * Constraints:
 * •	1 <= s.length <= 3 * 105
 * •	s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * •	s represents a valid expression.
 * •	All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * •	The answer is guaranteed to fit in a 32-bit integer.
 * Good luck!
 * <p>
 * Fatih
 */
