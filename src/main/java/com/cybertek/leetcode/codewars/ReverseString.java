package com.cybertek.leetcode.codewars;

import java.util.*;

public class ReverseString {

    public static void main(String[] args) {
        String name = "Mayki";

        System.out.println(reverse(name));

        reverse2(name);
    }

    public static String reverse(String name) {


        String reverse = "";
        for (int i = name.length()-1; i >= 0; i--) {
            reverse = reverse + name.charAt(i);
        }
        return reverse;


    }


    public static void reverse2(String name) {


        String[] split = name.split(""); //[i, k, y, a, M]



        List<String> splitArray = Arrays.asList(split);

        Collections.reverse(splitArray);

        //list --> Array ?

        String[] reversedArray = splitArray.toArray(split);

        System.out.println("splitArray.toString() = " + splitArray.toString());

        System.out.println("reversedArray = " + reversedArray);
        System.out.println("reversedArray.toString() = " + reversedArray.toString());


        System.out.println(splitArray.toString().replace("[", "").replace("]", "").replace(", ", ""));

    }

    public static void reverse3(String name) {



    }



}
