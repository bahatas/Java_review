package com.cybertek.leetcode.codewars;


import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The input consists of a single non-empty string,
 * consisting only of uppercase English letters, the string's length doesn't exceed 200 characters
 *
 * Output
 * Return the words of the initial song that Polycarpus used to make a dubsteb remix. Separate the words with a space.
 *
 * songDecoder("WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB")
 *   // =>  WE ARE THE CHAMPIONS MY FRIEND
 */
public class Polycarpus {

    public static void main(String[] args) {
        System.out.println(SongDecoder("WUBWUBABCWUB"));
        System.out.println(SongDecoder("RWUBWUBWUBLWUB"));

        System.out.println(SongDecoder3("WUBWUBABCWUB"));
        System.out.println(SongDecoder3("RWUBWUBWUBLWUB"));
    }

    public static String SongDecoder (String song)
    {
       return song.replace("WUBWUBWUB", " ")
               .replace("WUBWUB", " ")
               .replace("WUB", " ").trim();
    }

    public static String SongDecoder2 (String song)
    {
        return Arrays.stream(song.split("WUB"))
                .filter(i -> !"".equals(i))
                .collect(Collectors.joining(" "));
    }

    // best solution
    public static String SongDecoder3 (String song) {
        return Stream.of(song.split("WUB")).filter(s -> ! s.isEmpty()).collect(Collectors.joining());
    }
}
