package com.cybertek.leetcode;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Delete {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inhabitants = scanner.nextInt();

        for (int i = 0; i <=7; i++) {

            System.out.println("DAY " + " " + i + " [" + inhabitants + " ]");

            inhabitants/=2;
            switch (inhabitants){
                case 0:

                    System.out.println("----EXTINCT----");
                    break;
            }

        }


    }
}

