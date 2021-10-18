package com.cybertek.leetcode.String;

import java.util.Arrays;
import java.util.List;

public class RemVowel {

    /**
     * Input : welcome to geeksforgeeks
     * Output : wlcm t gksfrgks
     *
     * Input : what is your name ?
     * Output : wht s yr nm ?
     */


    public static void main(String[] args) {

        String input =" welcome to geeksforgeeks";

        System.out.println(remVowel(input));
        System.out.println(remVowel2(input));
    }

    public static String remVowel(String input){

        Character[] vowels = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};

        List<Character> a1= Arrays.asList(vowels);

        StringBuffer sb =new StringBuffer(input);

        for (int i = 0; i < sb.length(); i++) {
            if(a1.contains(sb.charAt(i))){
                sb.replace(i,i+1,"");
                i--;
            }
        }




        return sb.toString();

    }

    /**
     *
     * nice solution
     *
     */
    static String remVowel2(String str)
    {
        return str.replaceAll("[aeiouAEIOU]", "");
    }

}
