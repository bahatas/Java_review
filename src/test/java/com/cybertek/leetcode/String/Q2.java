package com.cybertek.leetcode.String;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to reserve a room? yes/no");
        String answer = input.next();

        String result = " ";

        while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
            System.out.println("Invalid answer. PLease re-enter again.");
            System.out.println("Do you want to reserve a room? yes/no");
            answer = input.next();


            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                if (answer.equalsIgnoreCase("yes")) {
                    System.out.println("Which type of room you want to reserve?King/Queen/Single");
                    String roomType = input.next();
                    switch (roomType.toLowerCase()) {
                        case "king":
                            result = "You reserved King bed. \nPrice $120";
                            break;
                        case "queen":
                            result = "You reserved Queen bed. \nPrice $100";
                            break;
                        case "single":
                            result = "You reserved Single bed. \nPrice $80";
                            break;
                    }

                } else {
                    System.out.println("Have a nice day!");
                }
                System.out.println(result);

            }
        }
    }



}


