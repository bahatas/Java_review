package com.cybertek.lambda.functionalinterface;

import java.sql.SQLOutput;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
    public static void main(String[] args) {

        //aceptes a s,nle parameter and returns a single vaalue
        Function<Integer, Double> half = a -> a / 2.0; ///apply
        System.out.println(half.apply(10));

        //Does NOT accepts any arguments and returns an object

        Supplier<Double> randomValue = () -> Math.random(); // get
        System.out.println(randomValue.get());


        //accept a single argıumant and does not retun any result

        Consumer <Integer> display = a-> System.out.println(a); //accept
        display.accept(10);

        //accept a signle argumetn and returns true or false
        Predicate<Integer> lesserThan = i -> (i<10); //test
        System.out.println(lesserThan.test(3));


    }
}
