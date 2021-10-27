package com.cybertek.leetcode.String;

import com.cybertek.stream.excercises.sort.Sort;

import java.security.cert.CollectionCertStoreParameters;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Stream;
public class StringExample {



    public static void main(String[] args) {

        String characters = "!veDJaCyd vaeo perelo xw";
        String document = "Cydeo Java Developer!";

        String chars = "docudocu";
        String doc = "document";


        long start = System.nanoTime();

        System.out.println(isGenerated(characters, document));
        System.out.println(isGenerated(chars, doc));
        long end = System.nanoTime();

        long elapsedTime = end - start;

        System.out.println("elapsedTime = " + elapsedTime);


        long start2 = System.nanoTime();
        System.out.println(isGenerated2(chars, doc));
        //System.out.println(isGenerated2(characters, document));

        long end2 = System.nanoTime();

        long elapsedTime2 = end2 - start2;

        System.out.println("elapsedTime2 = " + elapsedTime2);


    }


    //characters = "!veDJaCyd vaeo perelo xw"
    //document = "Cydeo Java Developer!"
    /**
     * characters must be same ?
     * spaces  are counted?
     * is it sorted ?
     *
     * Stringde ilk sorulmasi geren sey case sensitivie mi?
     *Spaceler ayri bir karakter olacarak degerlendirilecek mi ?
     * String buffer kullanilmasi gerekir mi ?
     *
     * Special karakterler dikkate alincak mi?
     * Bos olmasi gerektiginde ?
     *
     * Sorulardan sonra :
     * Ikinci asama?
     *
     *
     * Bir yerde frekans soruluyorsa bizi set ya da mape yonlendiriyor demektir..
     * Asil ulasmak istedigimiz yer burasi mi >?
     *
     */


    public static boolean isGenerated(String chars, String doc) {

        /**
         * arrays sort --> O(n log(n)).
         */
        if (chars.length()<doc.length()) return false;
        else {

            chars = chars.replace(" ", "").trim().toLowerCase();
            doc = doc.replace(" ", "").trim().toLowerCase();


            char[] charsAr = chars.toCharArray();
            char[] docAr = doc.toCharArray();

            Arrays.sort(charsAr);
            Arrays.sort(docAr);

            String sortedChar = new String(charsAr);
            String sortedDoc = new String(docAr);


            while (sortedDoc.length()>0) {

                if (sortedChar.indexOf(sortedDoc.charAt(0)) != -1){

                    sortedDoc = sortedDoc.replaceFirst(sortedDoc.charAt(0) + "", ""); // replace all chars in sortedChars with empty string if fail return false if success return true
                    sortedChar = sortedChar.replaceFirst(sortedChar.charAt(0) + "", ""); // replace all chars in sortedChars with empty string if fail return false if success return true

                }



            }
            return true;



        }

    }


    public static boolean isGenerated2(String chars, String doc) {
/**
 *
 * O(N) time
 *
 */


        Map<Character, Integer> mapOfDoc = new HashMap<>();
        Map<Character, Integer> mapOfChar = new HashMap<>();

        int lengthOfDoc = doc.length();
        int lengthOfChars = chars.length();
        char charKeyOfMap;
        int freqValOfMap = 1;

        if (lengthOfDoc > lengthOfChars) return false;
        else {
            for (int i = 0; i < lengthOfChars; i++) {
                charKeyOfMap = chars.charAt(i);

                if (!mapOfChar.containsKey(charKeyOfMap))
                    mapOfChar.put(charKeyOfMap, freqValOfMap);
                else {
                    mapOfChar.replace(charKeyOfMap, mapOfChar.get(charKeyOfMap) + 1);
                }
            }

            for (int i = 0; i < lengthOfDoc; i++) {
                charKeyOfMap = doc.charAt(i);

                if (!mapOfDoc.containsKey(charKeyOfMap))
                    mapOfDoc.put(charKeyOfMap, freqValOfMap);
                else {
                    mapOfDoc.replace(charKeyOfMap, mapOfDoc.get(charKeyOfMap) + 1);
                }
            }

            /**
             * get or default methodu varmis map de o value
             */
            try {
                for (char k : mapOfDoc.keySet()) {

                    if (mapOfDoc.get(k) > mapOfChar.get(k))
                        return false;

                }

            } catch (NullPointerException np) {
                return false;
            }
            return true;

        }


    }



    public static boolean isGenerated4(String chars, String doc) {

        if (doc.equals("")) return true;
        if (chars.length() < doc.length()) return false;

        int i = 0, j = 0;
        char[] charArr = chars.toCharArray();
        char[] docArr = doc.toCharArray();
        Arrays.sort(charArr);
        Arrays.sort(docArr);

        while (i < charArr.length && j < docArr.length) {
            if (charArr[i++] == docArr[j]) j++;
        }

        return j == docArr.length;

    }


}
    /**
     * Matt  abi
    public class GenerateDocument {

    public static void main(String[] args) {
        System.out.println(canGenerate4("!veDJaCyd vaeo perelo xw","Cydeo Java Developer!"));
    }

    public static boolean canGenerate(String characters, String document){
        if(document.equals("")) return true;
        if(characters.length()<document.length()) return false;

        int charLength, docLength;

        while(document.length()>0){
            charLength=characters.length();
            docLength=document.length();

            characters = characters.replace(document.charAt(0)+"","");
            document = document.replace(document.charAt(0)+"","");

            if(charLength-characters.length()<docLength-document.length()) return false;
        }
        return true;
    }


    public static boolean canGenerate2(String characters, String document){
        if(document.equals("")) return true;
        if(characters.length()<document.length()) return false;

        Map<Character,Integer> indices = new HashMap<>();

        for(char each:document.toCharArray()){
            indices.putIfAbsent(each,0);
            if(indices.get(each)>=characters.length()) return false;

            for(int i = indices.get(each);i<characters.length();i++){
                if(characters.charAt(i) == each){
                    indices.put(each,i+1);
                    break;
                }//else if(i==characters.length()-1) return false;
            }
            return false;
        }
        return true;
    }

    public static boolean canGenerate3(String characters, String document){

        if(document.equals("")) return true;
        if(characters.length()<document.length()) return false;
        String distinct = Arrays.stream(document.split("")).distinct().reduce("",(x,y)->x+y);

        for(char each:distinct.toCharArray()){
            long charCount = Arrays.stream(characters.split("")).filter(x->x.equals(each+"")).count();
            long docCount = Arrays.stream(document.split("")).filter(x->x.equals(each+"")).count();
            if(charCount<docCount) return false;
        }
        return true;
    }

    public static boolean canGenerate4(String characters, String document){

        if(document.equals("")) return true;
        if(characters.length()<document.length()) return false;

        int i=0,j=0;
        char[] charArr=characters.toCharArray();
        char[] docArr=document.toCharArray();
        Arrays.sort(charArr);
        Arrays.sort(docArr);

        while(i<charArr.length && j< docArr.length){
            if(charArr[i++] == docArr[j]) j++;
        }
        return j == docArr.length;
    }
}
```||
     */


/**
 * Fatih hoca
 *
 * public class GenerateDocument_Optimalsolution {
 *
 *     // O(n + m) time | O(c) space - where n is the number of characters, m is
 *     // the length of the document, and c is the number of unique characters in the
 *     // characters string
 *     public static void main(String[] args) {
 *         String characters= "veDJaCyd vaeo perelo xw!";
 *         String document="Cydeo Java Developer!";
 *
 *         System.out.println((generateDocumentOptimal(characters, document)));
 *     }
 *     public static boolean generateDocumentOptimal(String characters, String document) {
 *         HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>();
 *         for (int idx = 0; idx < characters.length(); idx++) {
 *             char character = characters.charAt(idx);
 *             characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1);
 *         }
 *         for (int idx = 0; idx < document.length(); idx++) {
 *             char character = document.charAt(idx);
 *             if (!characterCounts.containsKey(character) || characterCounts.get(character) ==0) {
 *             return false;
 *         }
 *         characterCounts.put(character, characterCounts.get(character) - 1);
 *     }
 *  return true;
 * }
 * }
 *
 * 1
 * [8:10 PM]
 * public class GenerateDocument_BruteForceSolution {
 *     public static void main(String[] args) {
 *         String characters= "veDJaCyd vaeo perelo xw!";
 *         String document="Cydeo Java Developer!";
 *
 *         System.out.println((generateDocumentBruteForce(characters, document)));
 *     }
 *         public static boolean generateDocumentBruteForce(String ch, String doc) {
 *             for (int idx = 0; idx < doc.length(); idx++) {
 *                 char character = doc.charAt(idx);
 *                 int documentFrequency = countCharacterFrequency(character, doc);
 *                 int charactersFrequency = countCharacterFrequency(character, ch);
 *                 if (documentFrequency > charactersFrequency) {
 *                     return false;
 *                 }
 *             }
 *             return true;
 *         }
 *         public static int countCharacterFrequency(char character, String target) {
 *             int frequency = 0;
 *             for (int idx = 0; idx < target.length(); idx++) {
 *                 char c = target.charAt(idx);
 *                 if (c == character) {
 *                     frequency += 1;
 *                 }
 *             }
 *             return frequency;
 *         }
 *
 *
 * }
 * [8:10 PM]
 * import java.util.HashSet;
 * import java.util.Set;
 *
 * public class GenerateDocument_Solution2 {
 *     public static void main(String[] args) {
 *         String characters= "veDJaCyd vaeo perelo xw!";
 *         String document="Cydeo Java Developer!";
 *
 *         System.out.println((generateDocumentSolution2(characters, document)));
 *     }
 *     // O(c * (n + m)) time | O(c) space - where n is the number of characters,
 *     // the length of the document, and c is the number of unique characters in
 *     // document
 *     public static boolean generateDocumentSolution2(String characters, String document) {
 *         Set<Character> alreadyCounted = new HashSet<Character>();
 *         for (int idx = 0; idx < document.length(); idx++) {
 *             char character = document.charAt(idx);
 *             if (alreadyCounted.contains(character)) {
 *                 continue;
 *             }
 *             int documentFrequency = countCharacterFrequency(character, document);
 *             int charactersFrequency = countCharacterFrequency(character, characters);
 *             if (documentFrequency > charactersFrequency) {
 *                 return false;
 *             }
 *             alreadyCounted.add(character);
 *         }
 *         return true;
 *     }
 *     public static int countCharacterFrequency(char character, String target) {
 *         int frequency = 0;
 *         for (int idx = 0; idx < target.length(); idx++) {
 *             char c = target.charAt(idx);
 *             if (c == character) {
 *                 frequency += 1;
 *             }
 *         }
 *         return frequency;
 *     }
 *
 *
 * }
 */