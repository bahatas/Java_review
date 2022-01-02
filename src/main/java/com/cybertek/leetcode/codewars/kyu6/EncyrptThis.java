package com.cybertek.leetcode.codewars.kyu6;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


public class EncyrptThis {

    public static void main(String[] args) {

        System.out.println("encryptThis(\"hello world\") = " + encryptThis("A wise old owl lived in an oak"));
    }
    public static String encryptThis(String text) {
        if(text=="") return text;
        String result = "";

        for (String each: text.split(" ") ) {
            if(each.length()==1){

                result+=(int)each.charAt(0)+" ";
            }else if(each.length()==2){
                result+=(int)each.charAt(0)+""+each.charAt(1)+" ";
            }else

            result+=(int)each.charAt(0)+""+each.charAt(each.length()-1)+each.substring(2,each.length()-1)+each.charAt(1)+" ";
        }
        return result.trim();
    }
    @Test
    public void exampleTests() {
        assertEquals("", EncyrptThis.encryptThis(""));
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", EncyrptThis.encryptThis("A wise old owl lived in an oak"));
        assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp", EncyrptThis.encryptThis("The more he saw the less he spoke"));
        assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare", EncyrptThis.encryptThis("The less he spoke the more he heard"));
        assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri", EncyrptThis.encryptThis("Why can we not all be like that wise old bird"));
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", EncyrptThis.encryptThis("Thank you Piotr for all your help"));
    }

}

/**
 * You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:
 *
 * Your message is a string containing space separated words.
 * You need to encrypt each word in the message using the following rules:
 * The first letter must be converted to its ASCII code.
 * The second letter must be switched with the last letter
 * Keepin' it simple: There are no special characters in the input.
 * Examples:
 * Kata.encryptThis("Hello") => "72olle"
 * Kata.encryptThis("good") => "103doo"
 * Kata.encryptThis("hello world") => "104olle 119drlo"
 */