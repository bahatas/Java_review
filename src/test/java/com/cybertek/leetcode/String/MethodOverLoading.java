package com.cybertek.leetcode.String;

public class MethodOverLoading {

    public static void main(String[] args) {
        System.out.println(multiply(5.0,6.0, "Hey"));

        loop();
    }

    public static double multiply(double a, int b){
        return a*b;
    };

    public static double multiply(int a, double b){
        return a*b;
    };

    public static double multiply(int a, int b){
        return a*b;
    };

    public static double multiply(double a, double b){  //30
        return a*b;
    };

    public static String multiply(double a, double b, String c){
        return c+ "--> " + multiply(a,b);
    };


    public static void loop(){
        for (int i = 10; i <=25 ; i--) {
            System.out.println("i = " + i);
        }
    }
}
