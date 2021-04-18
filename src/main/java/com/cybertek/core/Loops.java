package com.cybertek.core;



public class Loops {
    public static void demoForIterator(){
        for (int i = 0; i<5 ; i++){
            System.out.println(i);
        }
    }
    public static void demoForEach(){
        //we need Collection to use this classes

        String[] cars = {"Honda","Nissan", "Ford"};
        for (String car : cars){ //for (String car : Collection name)
            System.out.println(car);
        }
    }
}
