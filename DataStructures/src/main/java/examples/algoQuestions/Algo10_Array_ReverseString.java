package examples.algoQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class Algo10_Array_ReverseString {
    public static void main(String[] args) {
        String given = "Cydeo is the best!";
        System.out.println("reverseString(given) = " + reverseString(given));
        System.out.println("reverseString2(given) = " + reverseString2(given));
        System.out.println("reverseString3(given) = " + reverseString3(given));
        System.out.println("reverseString4(given) = " + reverseString4(given));
    }

    static String reverseString(String given) {

        StringBuilder result = new StringBuilder();
        String[] split = given.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {

            result.append(split[i]).append(" ");
        }

        return result.toString().trim();
    }

    static String reverseString2(String given) {

        String eachWord ="";
        String result = "";
        HashMap<Integer, String> hm = new HashMap<>();

        int index=0;
        for (int i = 0; i < given.length(); i++) {
            eachWord+=""+given.charAt(i);
            if(given.charAt(i)==' ' || i==given.length()-1){
                hm.put(index++,eachWord );
                eachWord="";
            }
        }
        System.out.println(hm);
        for(int i = hm.size()-1; i>=0 ;i--){
            result+=hm.get(i)+" ";
        }

        return result.trim();
    }



    static String reverseString3(String given) {
        Deque<String> deque= new ArrayDeque<>();
        String eachWord ="";

        for (int i = 0; i < given.length(); i++) {
            eachWord+=""+given.charAt(i);
            if(given.charAt(i)==' ' || i==given.length()-1){
                deque.push(eachWord+" ");
                eachWord="";
            }
        }
        return deque.stream().reduce("", (a,b)->a+b).trim();
    }



    static String reverseString4(String given) {

        String eachWord ="";
        String result = "";
     Stack<String> stack= new Stack<>();
     Deque<String> deque= new ArrayDeque<>();



        for (int i = 0; i < given.length(); i++) {

            eachWord+=""+given.charAt(i);

            if(given.charAt(i)==' ' || i==given.length()-1){
             stack.push(eachWord);
             deque.push(eachWord);
                eachWord="";
            }
        }
        System.out.println(stack);
        System.out.println(deque);

        List<String> stackStream = stack.stream().collect(Collectors.toList());//stackStream = [Cydeo , is , the , best!]
        List<String> dequeStream = deque.stream().collect(Collectors.toList());//dequeStream = [best!, the , is , Cydeo ]



        System.out.println("dequeStream = " + stack.stream().reduce("", (a,b)->a+b));
        System.out.println("stackStream = " + stackStream);
        

        return result.trim();
    }

}

/**
 * Write a function that takes in a string of words separated by one or more whitespaces and
 * returns a string that has these words in reverse order. For example, given the string "tim is
 * great", your function should return "great is tim". For this problem, a word can contain
 * special characters, punctuation, and numbers. The words in the string will be separated by
 * one or more whitespaces, and the reversed string must contain the same whitespaces as the
 * original string. For example, given the string "whitespaces 4" you would be expected to
 * return "4 whitespaces". Note that you're not allowed to use any built-in split or reverse
 * methods/functions. However, you are allowed to use a built-in join method/function. Also
 * note that the input string isn't guaranteed to always contain words.
 * Sample Input
 * string = "Cydeo is the best!"
 * Sample Output
 * "best! the is Cydeo"
 */


/**
 * One more reason to use Deque over Stack is Deque has the ability to use streams convert to list with keeping LIFO concept applied while Stack does not.
 *
 * Stack<Integer> stack = new Stack<>();
 * Deque<Integer> deque = new ArrayDeque<>();
 *
 * stack.push(1);//1 is the top
 * deque.push(1)//1 is the top
 * stack.push(2);//2 is the top
 * deque.push(2);//2 is the top
 *
 * List<Integer> list1 = stack.stream().collect(Collectors.toList());//[1,2]
 *
 * List<Integer> list2 = deque.stream().collect(Collectors.toList());//[2,1]
 */