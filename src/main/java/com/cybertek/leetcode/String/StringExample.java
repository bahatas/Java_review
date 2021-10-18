package com.cybertek.leetcode.String;

import com.cybertek.stream.excercises.sort.Sort;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class StringExample {


    public static void main(String[] args) {

        String characters = "!veDJaCyd vaeo perelo xw";
        String document = "Cydeo Java Developer!";

        String chars = "?><~@:}{";
        String doc = "{}:@~<>?";


        System.out.println(isGenerated(characters,document));
        System.out.println(isGenerated(chars, doc));




    }

    //characters = "!veDJaCyd vaeo perelo xw"
    //document = "Cydeo Java Developer!"

    /**
     * charactrerss must be same ?
     * spaces  are counted?
     * is it sorted ?
     */
    public static boolean isGenerated(String chars, String doc) {

        if (chars.equals(doc)) return true;
        else {

            chars = chars.replace(" ", "").trim().toLowerCase();
            doc = doc.replace(" ", "").trim().toLowerCase();


            char[] chars1 = chars.toCharArray();
            char[] chars2 = doc.toCharArray();

            Arrays.sort(chars1);
            Arrays.sort(chars2);
            String sorted = new String(chars1);
            String sorted2 = new String(chars2);

            return sorted.equals(sorted2);
        }

    }

    public static String sorted(String str) {
        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }

    public static boolean isGenerated2(String chars, String doc) {
        if (chars.equals(doc)) return true;
        else {

            chars = chars.replace(" ", "").trim().toLowerCase();
            doc = doc.replace(" ", "").trim().toLowerCase();


            char[] charsArray = chars.toCharArray();
            char[] docArray = doc.toCharArray();

            Arrays.sort(charsArray);
            Arrays.sort(docArray);
            String sorted = new String(charsArray);
            String sorted2 = new String(docArray);


        }

        return true;

    }

    public static boolean isGenerated3(String chars, String doc) {
        if (chars.equals(doc)) return true;
        else {

            char[] charsArray = chars.toCharArray();
            char[] docArray = doc.toCharArray();

            Arrays.sort(charsArray);
            Arrays.sort(docArray);
            String sortedChar = new String(charsArray);
            String sortedDoc = new String(docArray);

            int freqchar=0;
            int freqDoc=0;

            for (int i = 0; i <sortedChar.length()-1 ; i++) {




            }
            for (int j = 0; j < sortedDoc.length()-1; j++) {


            }

        }

        return true;

    }
    public static int ansiNumber(char c){

        return (byte) c;
    }
}
    /*
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