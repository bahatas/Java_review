package com.cybertek;

import com.cybertek.core.Loops;
import com.cybertek.core.Methods;
import com.cybertek.core.SelectionStatements;
import com.cybertek.enums.Gender;
import com.cybertek.enums.Status;
import com.cybertek.oop.abstraction.implementation.UserServiceImplementation;
import com.cybertek.oop.abstraction.service.UserService;
import com.cybertek.oop.encapculation.Role;
import com.cybertek.oop.encapculation.User;
import com.cybertek.oop.inheritance.BaseEntity;
import com.cybertek.oop.inheritance.Project;
import com.cybertek.oop.polymorphism.Employee;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        //********CORE***********//

        Methods methods = new Methods();
        Methods berkay  = new Methods();
        berkay.name = "berkay";
        methods.methodA();
        methods.methodB("Apple");
        //methods.methodB();
        System.out.println(methods.methodB());
        methods.methodB(5);

        //static methodu calsıtırdık bu static methodu obje ile calıstırabilir miyiz?
        // MethodC

        Methods.methodC();


        System.out.println("methods.name = " + methods.name);
        methods.name="Berkay";
        System.out.println("methods.name = " + methods.name);
        System.out.println("methods.id = " + methods.id);


        //**********LOOP************//

    Loops loops = new Loops();
    Loops.demoForEach();

    //*******SELECTON STATEMENTS******//
        SelectionStatements.demoIfStatement();
        SelectionStatements.demoSwitchCaseStatement();



        //*************OOP & Encapsulation*****//

        User user = new User("Mike","Smith",new Role(2,"Manager"), Gender.MALE);

        System.out.println(user.getFirstName()); // print the first name getter kullandık
        System.out.println(user.getRole().getDescription());
        System.out.println(user.getRole().getDescription());



        //*************Inheritance*****//
        Project project = new Project(1, LocalDateTime.now(),1,LocalDateTime.now().minusHours(5),
                1,"PRJ001","Human Resource",new User("Mike","Smith",new Role(1,"Manager"),Gender.MALE)
                , LocalDate.now(),LocalDate     .now().plusMonths(6),Status.IN_PROGRESS,"HCRM Detail Information");



        //**********OOP-Interface**************//

        UserService userService = new UserService();
        System.out.println(userService.usrByFirstname("Mike").getLastName());

        //*************Polymorphism*****//

        Employee employee = new Employee();

        BaseEntity employee2 = new Employee();

        employee.baseEntityMethod();
        employee2.baseEntityMethod();



        //(Employee)employee2.employeeMethod();



        UserServiceImplementation userServiceImplementation = new UserService();

        employee.getEmployeeHours(); // this method belong to this class

       //  employee2.getEmployeeHours(); error cunku hangi methoda gidecegimize sol tarf karar verir
        ((Employee)employee2).getEmployeeHours(); // down  casting



        //*************ENUM**************//

        System.out.println(Gender.MALE);
        System.out.println(Status.IN_PROGRESS.getValue().substring(2));














    }
}