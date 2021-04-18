package com.cybertek.stream.excercises;

import com.cybertek.enums.Status;

import java.util.stream.Stream;

public class TestExercise {
    public static void main(String[] args) {
        System.out.println(StreamDemo.getListOfProject().stream().findFirst().get().getProjectName());


        System.out.println(StreamDemo.getListOfProject(Status.IN_PROGRESS).stream().);













    }
}
