package com.cybertek.stream;

import com.cybertek.collections.ArrayLists;
import com.cybertek.lambda.sorting.Employee;
import com.cybertek.oop.encapculation.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TerminalOperators {
    public static void main(String[] args) {

        System.out.println("*********** Integer Stream ********");

        IntStream
                .range(1,10)
                .forEach(each-> System.out.print(each + ","));
        System.out.println();
        System.out.println("********** COUNT *********");


        long count = Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9, 10).stream().count();

        System.out.println(count);

        long count1 = Arrays.asList("Apple", "Mango", "Kiwi", "Banana", "Apple", "Cherry", "Orange").stream().filter(str -> str.equals("Apple")).count();

        System.out.println(count1);


        int count3 = (int) Arrays.asList("one","two","three","four").stream().count();
        System.out.println("count3 = " + count3+" word");



        System.out.println("********** FIND FIRST - FIND ANY *********");
       Role r = ArrayLists.createRoleList().stream().filter(role -> role.getDescription().equals("Employee")).findFirst().get();

        System.out.println(r.getId());

        Role r2 = ArrayLists.createRoleList().stream().filter(role -> role.getDescription().equals("Employee")).findAny().get();
        System.out.println(r2.getId());


        System.out.println("********** COLLECT  *********");
        List<String> appleList = Arrays.asList("Apple","Orange","Kivi","Banana","Apple","Cheery","Mango")
                .stream().filter(a->a.equals("Apple")).collect(Collectors.toList());

        System.out.println("appleList.stream().count() = " + appleList.stream().count());


        System.out.println("********** REDUCE  *********");

        int total = Arrays.asList(3,4,5,6,12,20).stream().reduce(5,(a,b)->a+b);
        System.out.println("total = " + total);

        String word = Arrays.asList("C","y","b","e","r","t","e","k").stream().reduce("->",((s, s2) -> s+s2));
        System.out.println(word);


    }
}
