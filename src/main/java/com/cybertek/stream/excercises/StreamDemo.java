package com.cybertek.stream.excercises;

import com.cybertek.enums.Status;
import com.cybertek.oop.encapculation.User;
import com.cybertek.oop.inheritance.Project;

import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    //Task-1
    public static List<Project> getListOfProject() {

     return  DataGenerator.getProjects();

    }


    //Task-2
    public static List<Project> getListOfProject(Status status) {

        return DataGenerator.getProjects().stream().filter(project -> project.getProjectStatus().equals(status)).collect(Collectors.toList());

    }


    //Task-3
    public static List<Project> getListOfProject(User manager) {
        return null;
    }


    //Task-4
    public static List<Project> getProjectByProjectCode(String projectCode) {
        return null;
    }

    //Task-5
    public static List<User> getListUsers() {
        return null;
    }

    //Task-6
    public static User getUserByFirstName(String firstName) {

        return null;
    }

    //Task-7
//    public static String getUserByUserId(Long id){
//        List<User>userByUserId = DataGenerator.getUsers();
//        return userByUserId.stream().filter(user -> user.getId().
//
//    }
    public static User getUserByUserId(Integer id){
        return null;
    }

    //Task-8
    public static List<User> deleteUser(String firstName) {
        return null;
    }

    //Task-9
    public static List<Project> updateProjectStatus(Status oldStatus, Status newStatus) {
        return null;
    }

    //Task-10
    public static List<Project> findProjectByManager(User manager) {
        return null;
    }

    //Task-11 - Period
    public static Integer totalProjectDurationForManager(User manager) {
        return null;
    }

    //Task-12
    public static long findTotalMaleInCompany() {
        return 0;
    }
}
