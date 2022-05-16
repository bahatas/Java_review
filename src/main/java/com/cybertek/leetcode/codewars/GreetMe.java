package com.cybertek.leetcode.codewars;

public class GreetMe {

    public static void main(String[] args) {
        System.out.println(greet("Jack"));
    }
    public static String greet(String name){

        name = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();

        return "Hello "+name+"!";
    }

}
