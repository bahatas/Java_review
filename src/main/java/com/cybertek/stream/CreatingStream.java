package com.cybertek.stream;

import com.cybertek.collections.ArrayLists;
import com.cybertek.oop.encapculation.Role;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreatingStream {
    public static void main(String[] args) {
        // creating strem from an array
        String[] courses = {"Java","Js","TS","API","Seleium"};

        Stream<String> courseStream = Arrays.stream(courses);

       //Creating a stream from a collection
        Stream<Role> roleStream = ArrayLists.createRoleList().stream();

        //creating a streamfrom q spesified stream
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,88);

        System.out.println(stream);
    }

}
