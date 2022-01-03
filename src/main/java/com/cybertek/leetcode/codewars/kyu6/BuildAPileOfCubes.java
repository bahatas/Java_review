package com.cybertek.leetcode.codewars.kyu6;
import static org.junit.Assert.*;

import org.junit.Test;

public class BuildAPileOfCubes {

    public static void main(String[] args) {
        System.out.println("findNb_(55100) = " + findNb_(55100));
    }
    @Test
    public void test1() {
        assertEquals(2022, BuildAPileOfCubes.findNb(4183059834009L));
    }
    @Test
    public void test2() {
        assertEquals(-1, BuildAPileOfCubes.findNb(24723578342962L));
    }
    @Test
    public void test3() {
        assertEquals(4824, BuildAPileOfCubes.findNb(135440716410000L));
    }
    @Test
    public void test4() {
        assertEquals(3568, BuildAPileOfCubes.findNb(40539911473216L));
    }
    @Test
    public void test5() {
        assertEquals(45, BuildAPileOfCubes.findNb(1071225L));
    }
    @Test
    public void test6() {
        assertEquals(55100, BuildAPileOfCubes.findNb(2304422822859511552L));
    }
    public static long findNb_(long i) {
        long sum =0; //sum of the cubes
         i = 55100; //counter


        while(i>0) {
            sum+=Math.pow(i, 3);
            i--;
        }


//        return sum==m?i-1:-1;
        return sum;
    }
    public static long findNb(long m) {
        long n=1;
        while (m>0){
            m-=Math.pow(n++,3);
        }
        return (m==0)?(long)n-1:-1;
    }
}
/**
 * Your task is to construct a building which will be a pile of n cubes. The cube at the bottom will have a volume of n^3, the cube above will have volume of (n-1)^3 and so on until the top which will have a volume of 1^3.
 *
 * You are given the total volume m of the building. Being given m can you find the number n of cubes you will have to build?
 *
 * The parameter of the function findNb (find_nb, find-nb, findNb, ...) will be an integer m and you have to return the integer n such as n^3 + (n-1)^3 + ... + 1^3 = m if such a n exists or -1 if there is no such n.
 *
 * Examples:
 * findNb(1071225) --> 45
 *
 * findNb(91716553919377) --> -1
 */