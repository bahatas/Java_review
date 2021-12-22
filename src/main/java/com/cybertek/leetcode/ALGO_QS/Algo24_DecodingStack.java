package com.cybertek.leetcode.ALGO_QS;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class Algo24_DecodingStack {

    public static void main(String[] args) {

        String s = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";
        decoding(s);
        decoding(s2);
        decoding(s3);
//     decodeString(s);
//    decodeString(s2);
//    decodeString(s3);
//    }
        int i = 0;
    }
     static String decodeString(String s){

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i<s.length() && s.charAt(i) != ']'){
            if(Character.isDigit(s.charAt(i))){
                int k=0;
                while(i<s.length() && Character.isDigit(s.charAt(i)));
                    k=k*10 +s.charAt(i++)-'0';
                i++;
                String r = decodeString(s);
                while(k-->0)
                    result.append(result);

                i++;
            }else result.append(s.charAt(i++));
        }

//       return result.toString();
            return "";
    }

    static  String decoding(String s ){

        Map<Integer,String> map = new HashMap<>();
        Stack<String> ch = new Stack<>();

        String inners="";
        String printValue="";
        String printKey ="";
        int num=0;
        for(int i =0 ; i<s.length();i++){
            char c = s.charAt(i);
            if( c=='['){
                num=Integer.parseInt(printKey.replace("]",""));

                inners="";
                map.put(num,"");
                printKey="";
                continue;
            }else if(c==']' || Character.isDigit(c)){
                printValue=inners;
                printKey+=c;
                map.replace(num,printValue);
                continue;
            }
            ch.push(s);
            inners+=c;
        }

        String result ="";
        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            for(int i=1;i<= entry.getKey();i++){
                result+=entry.getValue();
            }
        }

        return  result;

    }
}


/**
 *  Question #24
 * Decode String(Leetcode #394)
 * Difficulty :Medium Category :Stacks
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed,
 * etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 * Constraints:
 * • 1 <= s.length <= 30
 * • s consists of lowercase English letters, digits, and square brackets '[]'.
 * • s is guaranteed to be a valid input.
 * • All the integers in s are in the range [1, 300]


 */