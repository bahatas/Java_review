package com.cybertek.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidswithGreatestNumberOfCandy {

    public static void main(String[] args) {

        int[] candiess = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        System.out.println("kidsWithCandies2(candiess, extraCandies) = " + kidsWithCandies2(candiess, extraCandies));
        System.out.println("kidsWithCandies(candiess, extraCandies) = " + kidsWithCandies(candiess, extraCandies));

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {


        List<Boolean> result = new ArrayList<>();
        int maxCandy = Arrays.stream(candies).max().getAsInt();

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandy)
                result.add(true);
            else {
                result.add(false);
            }

        }

        return result;

    }


    public static List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {


        List<Boolean> result = new ArrayList<>();
        int[] sortedArray = Arrays.copyOf(candies, candies.length);

        Arrays.sort(sortedArray);

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= sortedArray[sortedArray.length - 1])
                result.add(true);
            else {
                result.add(false);
            }

        }


        return result;
    }

}



