package com.cybertek.leetcode.ALGO_QS;

import java.util.List;
import java.util.Stack;

public class Algo23_StackBalancedBrackets {

    public static void main(String[] args) {

        String given = "([])(){}(())()()"; //true
        String given2 = "[[()]{(]}]"; //false
        System.out.println("isBalanced(given) = " + isBalanced(given));
        System.out.println("isBalanced2(given) = " + isBalanced2(given));
        System.out.println("isBalanced3(given) = " + isBalanced3(given));

    }

    //open --> ([{
    //close--> )}]

    static boolean isBalanced_(String given) {

        boolean isBalanced;
        String regex = "{}()[]";

        String str = "";
        for (int i = 0; i < given.length(); i++) {

            char ch = given.charAt(i);
            if (regex.contains(ch + "")) {
                str += ch + "";
            }
        }
        while (!regex.contains(str)) {
            str.replace("{}", "");
            str.replace("()", "");
            str.replace("[]", "");
        }
        isBalanced = (str.length() == 0) ? true : false;

        return isBalanced;
    }

    static boolean isBalanced1(String given) {

        boolean isBalanced = true;
        String openBrackets = "({[";
        Stack<Character> openStack = new Stack<>();


        for (int i = 0; i < given.length(); i++) {
            if (openBrackets.contains(given.charAt(i) + "")) {
                openStack.push(given.charAt(i));
            } else if (given.charAt(i) == '}') {
                if (openStack.peek() == '{') {
                    openStack.pop();
                } else {
                    isBalanced = false;
                }

            } else if (given.charAt(i) == ']') {
                if (openStack.peek() == '[') {
                    openStack.pop();
                } else {
                    isBalanced = false;
                }

            } else if (given.charAt(i) == ')') {
                if (openStack.peek() == '(') {
                    openStack.pop();
                } else {
                    isBalanced = false;
                }
            }

        }

        if (!openStack.isEmpty()) {
            isBalanced = false;
        }

        return isBalanced;
    }

    static boolean isBalanced(String given) {

        boolean isBalanced = false;
        List<String> couples = List.of("()", "[]", "{}");
        String openBrackets = "({[";
        String closeBrackets = ")}]";

        Stack<Character> openStack = new Stack<>();
        Stack<Character> closeStack = new Stack<>();


        for (String c : given.split("")) {
            if (openBrackets.contains(c)) {
                openStack.push(c.charAt(0));
            } else if (closeBrackets.contains(c)) {
                closeStack.push(c.charAt(0));
            }
        }
        while (!openStack.isEmpty() || !closeStack.isEmpty()) {
              isBalanced =couples.contains(openStack.pop() + "" + closeStack.pop());
        }

        return isBalanced;

    }

    static String isBalanced2(String given) {

        boolean isBalanced = true;
        String openBrackets = "({[";
        Stack<Character> openStack = new Stack<>();


        for (int i = 0; i < given.length(); i++) {
            if (openBrackets.contains(given.charAt(i) + "")) {
                openStack.push(given.charAt(i));
            }
           else if (given.charAt(i) == '}') {
                if (openStack.peek() == '{') {
                    openStack.pop();
                } else {
                    isBalanced = false;
                }

            } else if (given.charAt(i) == ']') {
                if (openStack.peek() == '[') {
                    openStack.pop();
                } else {
                    isBalanced = false;
                }

            } else if (given.charAt(i) == ')') {
                if (openStack.peek() == '(') {
                    openStack.pop();
                } else {
                    isBalanced = false;
                }
            }

        }

        if(!openStack.isEmpty()){
            isBalanced=false;
        }

        return isBalanced == true ? "YES" : "NO";
    }
    static String isBalanced3(String given) {

        Stack<Character> stack = new Stack<>();
        String y = "YES";
        String n = "NO";
        for(int i = 0; i<given.length(); i++){
            char ch = given.charAt(i);
            if(ch=='{'||ch=='('||ch=='['){
                stack.push(ch);
            }else if(stack.isEmpty()){
                return n;
            }
            else if(ch=='}'){
                if(stack.peek()=='{'){
                    stack.pop();
                }
                else{return n;}

            }else if(ch==']'){
                if(stack.peek()=='['){
                    stack.pop();
                }
                else{return n;}

            }else if(ch==')'){
                if(stack.peek()=='('){
                    stack.pop();
                }
                else{return n;}

            }
        }
        if(!stack.isEmpty()){
            return n;
        }
        return y;


    }

}


/**
 * Question # 23
 * Description: Balanced Brackets
 * Difficulty: Medium Category: Stacks
 * <p>
 * Write a function that takes in a string made up of brackets ( ( , [ , { , ) , ] , and } ) and other
 * optional
 * characters. The function should return a boolean representing whether the string is
 * balanced with regards to brackets.
 * A string is said to be balanced if it has as many opening brackets of a certain type as it has
 * closing brackets of that type and if no bracket is unmatched. Note that an opening bracket
 * can't match a corresponding closing bracket that comes before it, and similarly, a closing
 * bracket can't match a corresponding opening bracket that comes after it. Also,brackets can't
 * overlap each other as in [(]) .
 * <p>
 * Sample Input
 * <p>
 * string = "([])(){}(())()()"
 * <p>
 * Sample Output
 * true // it's balanced
 */

