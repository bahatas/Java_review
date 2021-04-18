package com.cybertek.core;


public class SelectionStatements {


    static String userName = "Ozzy";

    public static void demoIfStatement() {

        String userName = "Ozzy";
        if (userName.equals("Ozzy")) {
            System.out.println("PASS");
        } else if (userName.equals("Mike")) {
            System.out.println("FAIL");
        } else {
            System.out.println("Not Valid");
        }
    }

    public static void demoSwitchCaseStatement() {

        String name = "Ozzy";

        switch (name) {
            case "Ozzy":
                System.out.println("PASS");
                break;
            case "Mike":
                System.out.println("FAIL");
                break;
            default:
                System.out.println("NOT VALID");
        }

    }
}
