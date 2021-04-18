package com.cybertek.lambda.sorting;

import com.cybertek.oop.encapculation.Role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Mike", "Smith", "VA", new Role(1, "Developer"));
        Employee e2 = new Employee(11, "Ozzy", "Smith", "DC", new Role(2, "SDET"));
        Employee e3 = new Employee(67, "Ammy", "Smith", "IL", new Role(3, "DBA"));
        Employee e4 = new Employee(33, "Adam", "Smith", "FL", new Role(4, "Project Manager"));
        Employee e5 = new Employee(8, "Tammy", "Smith", "CA", new Role(5, "SM"));

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        System.out.println(employeeList);

        //Employee is ye gore sort yapacagız

        employeeList.sort((a,b)->a.getEmployeeId().compareTo(b.getEmployeeId()));
        System.out.println(employeeList);

//       employeeList.sort((a,b)->a.getRole().getId().compareTo(b.getRole().getId()) );
//        employeeList.sort((emp1, emp2) -> (emp1.getRole().getId().compareTo(emp2.getRole().getId())));

        //This 2 line didn't work on mine PC

    }
}
