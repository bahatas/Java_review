package com.cybertek.leetcode.String;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Anagram {

    /*    Sample Input
        words = ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"]
        Sample Output
        [["yo", "oy"], ["flop", "olfp"], ["act", "tac", "cat"], ["foo"]]
        */
    public static void main(String[] args) {

        List<String> words = List.of("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp","tac","ang");
        List<String> words2 = List.of("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp","tac","ang","gan","nag");
        System.out.println(words);
        System.out.println(groupAnagram(words));
        System.out.println(groupAnagram(words2));
    }


    static List<List<String>> groupAnagram(List<String> words) {
        List<List<String>> result = new ArrayList<>();
        var collect = words.stream()
                .map(e -> {
                    char[] chars = e.toCharArray();
                    Arrays.sort(chars);
                    return chars;
                })
                .map(e -> new String(e))
                .collect(Collectors.toList());

        List<String> numberList = new ArrayList<>();
        IntStream.range(0,words.size()).forEach(e->numberList.add(""));

        for (int i = 0; i<collect.size(); i++) {
            List<String> innerList = new ArrayList<>();
            if(!collect.get(i).isBlank()){
                innerList.add(words.get(i));
            }else {
                continue;
            }
            for (int j = i+1; j < collect.size(); j++) {
                if ( collect.get(i).equals(collect.get(j)) ) {
                    innerList.add(words.get(j));
                    collect.set(j,"");
                }
            }
            collect.set(i,"");
            result.add(innerList);
            if(collect.equals(numberList)) break;
        }
        return result;
    }

    /**
     * Fatih solv
     * @param words
     * @return List<List<String>>
     * @BigO
     */

    
        public static List<List<String>> groupAnagrams(List<String> words) {
            Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
            for (String word : words) {

                char[] charArray = word.toCharArray();
                Arrays.sort(charArray);
                String sortedWord = new String(charArray);

                anagrams.putIfAbsent(sortedWord, new ArrayList<String>());
                anagrams.get(sortedWord).add(word);
            }
            return new ArrayList<>(anagrams.values());
        }




}
