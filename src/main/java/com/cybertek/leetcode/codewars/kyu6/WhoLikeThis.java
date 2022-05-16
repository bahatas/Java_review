package com.cybertek.leetcode.codewars.kyu6;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
public class WhoLikeThis {
    @Test
    public void staticTests() {
        assertEquals("Peter likes this", WhoLikeThis.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", WhoLikeThis.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", WhoLikeThis.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", WhoLikeThis.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

    public static String whoLikesIt(String... names) {

        String str = "";


        if(names.length==0) {
            str="no one likes this";


        }else if (names.length==1) {
            str=names[0]+" likes this";
        }else if (names.length==2) {
            str =names[0]+" and "+names[1]+" like this";
        } else if (names.length==3) {
            str =names[0]+", "+names[1] +" and "+names[2]+" like this";
        }else if (names.length>3) {
            str =names[0]+", "+names[1] +" and "+(names.length-2)+" others"+" like this";
        }
        return str+ "";
    }
}

