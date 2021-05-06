package com.cybertek.stream.excercises;

import com.cybertek.enums.Status;

public class TestExercise {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(StreamDemo.getListOfProject().stream().findFirst().get().getProjectName());

        System.out.println(2);
        System.out.println(StreamDemo.getListOfProject(Status.IN_PROGRESS).get(0).getProjectName());

        System.out.println(3);

        System.out.println(StreamDemo.getListOfProject(DataGenerator.manager4).get(0).getProjectName());
        System.out.println(4);


        System.out.println(5);


        System.out.println(6);


        System.out.println(7);


        System.out.println(8);


        System.out.println(9);


        System.out.println(10);
        System.out.println(StreamDemo.findProjectByManager(DataGenerator.manager4));

        System.out.println(11);

        System.out.println(12);
        System.out.println(StreamDemo.findTotalMaleInCompany());





















    }
}
