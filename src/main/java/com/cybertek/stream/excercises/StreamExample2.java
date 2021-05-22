package com.cybertek.stream.excercises;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExample2 {
    //Stream of sorted and findfirst
    public static void main(String[] args) throws IOException {
        Stream.of("Baha", "Anna", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println); // Alberto

        Stream.of("Baha", "Anna", "Alberto")
                .sorted()
                .findAny()
                .ifPresent(System.out::println); //Albereto


        //Stream from Array Srot filter and print

        String [] names = {"Al","Baha", "Alberto","Sarika","Amanda"};
        Arrays.stream(names)
                .filter(name->name.startsWith("S"))
                .sorted()
                .forEach(System.out::println); // Sarika
        //

        Stream.of(2,4,6,8,10)
                .map(number->number*number)
                .forEach(System.out::print);
//
//        4
//        16
//        36
//        64
//        100

        System.out.println();
        Arrays.stream(new int[]{2,4,6,8,10})
                .map(number->number*number)
                .average()
                .ifPresent(System.out::println);


        Stream<String> textLine = Files.lines(Paths.get("C:\\Users\\User\\IdeaProjects\\Java_review\\src\\main\\resources\\textFile.txt"));
       // .NoSuchFileException: textFile.txt

        textLine
                .sorted()
                .filter(name->name.contains("a"))
                .forEach(System.out::println);

        textLine.close();
//        1	Liam	Olivia
//        10	Alexander	Harper
//        2	Noah	Emma
//        3	Oliver	Ava
//        4	Elijah	Charlotte
//        5	William	Sophia
//        6	James	Amelia
//        7	Benjamin	Isabella
//        8	Lucas	Mia

        Stream<String> textLine2 = Files.lines(Paths.get("C:\\Users\\User\\IdeaProjects\\Java_review\\src\\main\\resources\\textFile.txt"));

        long count = textLine2
                .map(x -> x.split(" "))
                .filter(a -> a.length == 1)
                .count();

        textLine.close();

        System.out.println("count is : ");


    }






}