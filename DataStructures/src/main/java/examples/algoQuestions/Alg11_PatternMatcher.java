package examples.algoQuestions;

import java.util.HashMap;

public class Alg11_PatternMatcher {
    public static void main(String[] args) {

        String pattern = "xxyxxy"; //2x1y2x1y
        String given = "gogopowerrangergogopowerranger";

        patternMatcher(pattern,given);

    }
    //x,2 y,1 x,2 y,1

    static String[] patternMatcher(String pattern, String given) {
        String[] result = new String[2];
        HashMap<Character,Integer> hm = new HashMap<>();

        int freqCounter =1;
        hm.put(pattern.charAt(0),1);
        String patternFreq="";//x

        for (int i = 0; i < pattern.length()-1; i++) {

            if(pattern.charAt(i)==pattern.charAt(i+1)){ //last char of pattern is dublicated?
              hm.replace(pattern.charAt(i), hm.get(pattern.charAt(i))+1);

            }else {
                hm.put(pattern.charAt(i),1);
            }
        }
        System.out.println("hm "+hm);


        for (int i = 0; i < pattern.length()-1; i++) {
            //char lastCharOfPatternFreq = patternFreq.charAt(patternFreq.length()-1);

            if(pattern.charAt(i)==pattern.charAt(i+1)){ //last char of pattern is dublicated?
               freqCounter++;
               continue;
            }else {
                patternFreq+=""+freqCounter+pattern.charAt(i);
                freqCounter=1;
            }
        }
        System.out.println("patternFreq="+patternFreq); //x2x1y1x2x1y--> 2x1y2x1y

        if(!patternFreq.contains("2") && pattern.length()%2==0){
           return result;
        }else{
            if(!patternFreq.contains("2")){

            }else{

            }
        }

        return result;
    }

    static String[] patternMatcher2(String pattern, String given) {

        String[] result = new String[2];

        HashMap<Character, Integer> hm = new HashMap<>();
        int charCounterValue = 1;
        char charKeyOfMap;

        for (int i = 0; i < pattern.length(); i++) {
            charKeyOfMap = pattern.charAt(i);
            if (!hm.containsKey(charKeyOfMap)) {
                hm.put(charKeyOfMap, charCounterValue);
            } else {
                hm.replace(charKeyOfMap, hm.get(charKeyOfMap) + 1);
            }
        }


        for (int i = 0; i < given.length(); i++) {
            charKeyOfMap = pattern.charAt(i);
            if (!hm.containsKey(charKeyOfMap)) {
                hm.put(given.charAt(i), charCounterValue);
            } else {
                hm.replace(charKeyOfMap, hm.get(charKeyOfMap) + 1);
            }
        }

        return result;

//
//        for (int i = 0; i > given.length(); i++) {
//
//        }
    }


}


/**
 * Question # 11
 * Description:
 * Pattern Matcher
 * Difficulty: Medium Category: String
 * You're given two non-empty strings. The first one is a pattern consisting of only "x" s and / or
 * "y" s; the other one is a normal string of alphanumeric characters. Write a function that
 * checks whether the normal string matches the pattern. A string S0 is said to match a pattern
 * if replacing all "x" s in the pattern with some non-empty substring S1 of S0 and replacing all
 * "y" s in the pattern with some non-empty substring S2 of S0 yields the same string S0 . If the
 * input string doesn't match the input pattern, the function should return an empty array;
 * otherwise, it should return an array holding the strings S1 and S2 that represent "x" and "y"
 * in the normal string, in that order. If the pattern doesn't contain any "x" s or "y" s, the
 * respective letter should be represented by an empty string in the final array that you return.
 * You can assume that there will never be more than one pair of strings S1 and S2 that
 * appropriately represent "x" and "y" in the normal string.
 * Sample Input
 * pattern = "xxyxxy" string = "gogopowerrangergogopowerranger"
 * yxxxyyyyxy
 * yxyxyx  -> 0
 * malsinmalsinmal kenarlar esit
 * <p>
 * ma lsin ma lsin ma lsin   xxy
 * sivanvansi sivanvansi --> xx--> xyyx xyyx
 * sivasvassi sivasvassi  --> xyyxxyyx
 * 8444844884
 * pulgarippul pulgarippul xyx xyx  12 2xy
 * pgpgpg    xyxxyx
 * <p>
 * abidikg ubudik abidikg ubudik --> xyxy---> return
 * aaiaaiaaiabla aaiaaiaaiabla --> xxxyyxxxyy
 * x3y2
 * Sample Output
 * ["go", "powerranger"]
 * <p>
 * <p>
 * xyxyx --> return 0;
 * <p>
 * xyxyx --> check last words eq
 * <p>
 * else : chech yanayanafind replace empt str
 */