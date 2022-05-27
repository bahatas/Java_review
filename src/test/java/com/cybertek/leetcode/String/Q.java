package com.cybertek.leetcode.String;

import java.util.Scanner;

public class Q {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to reserve a room? yes/no");
        String answer = input.next();

        String result = " ";


        while (true) {
            if (answer.equalsIgnoreCase("no")) {
                System.out.println("Have a nice day!");
                break;
            }

            if (!answer.equalsIgnoreCase("yes")) {

                System.out.println("Invalid answer. PLease re-enter again.");
                System.out.println("Do you want to reserve a room? yes/no");
                answer = input.next();
            } else {
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
                System.out.println(result);
                break;

            }


        }

    }


}
