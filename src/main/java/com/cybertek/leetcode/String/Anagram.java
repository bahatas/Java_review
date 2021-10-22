package com.cybertek.leetcode.String;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Anagram {

    /*    Sample Input
        words = ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"]
        Sample Output
        [["yo", "oy"], ["flop", "olfp"], ["act", "tac", "cat"], ["foo"]]
        */
    public static void main(String[] args) {

        List<String> words = List.of("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp");
        System.out.println(words);
        System.out.println(groupAnagram(words));
        System.out.println(groupAnagram2(words));
    }


    static List<List<String>> groupAnagram(List<String> words) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, String> wordMap = new HashMap<>();

        for (String w : words) {
            wordMap.put(words.indexOf(w), w);
        }

        var collect = words.stream()
                .map(e -> {
                    char[] chars = e.toCharArray();
                    Arrays.sort(chars);
                    return chars;
                })
                .map(e -> new String(e))
                .collect(Collectors.toList());

        List<String> collect2 = List.copyOf(collect);

        while (collect.size() != 0) {


            List<String> innerList = new ArrayList<String>();
            innerList.add(words.get(collect2.indexOf(collect.get(0))));

            for (int j = 1; j < collect.size(); j++) {

                if (collect.get(0).equals(collect.get(j))) {


                    innerList.add(words.get(collect2.indexOf(collect.get(j))));
                    collect.remove(j);


                }

            }

            collect.remove(0);

            result.add(innerList);
        }


        return result;
    }


    static List<List<String>> groupAnagram2(List<String> words) {
        List<List<String>> result = new ArrayList<>();

        words.stream()
                .map(String::toCharArray)
                .map(e -> List.of(e).stream()
//                        .map(ch->)
//                        .reduce(0, (a, b) -> )
                )
                .collect(Collectors.toList());



        return result;

    }

    static List<List<String>> groupAnagram3(List<String> words) {
        List<List<String>> result = new ArrayList<>();

        Map<Integer, String> wordMap = new HashMap<>();

        for (String w : words) {
            wordMap.put(words.indexOf(w), w);
        }


        return result;

    }


}
