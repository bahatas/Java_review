package com.cybertek.leetcode.codewars.kyu5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import  static org.junit.Assert.assertEquals;

public class GreedIsGood {

    public static void main(String[] args) {
        greedy(new int[]{5,1,3,4,1});
    }
    @Test
    public void testExample() {
        assertEquals("Score for [5,1,3,4,1] must be 250:", 250, GreedIsGood.greedy(new int[]{5,1,3,4,1}));
        assertEquals("Score for [1,1,1,3,1] must be 1100:", 1100, GreedIsGood.greedy(new int[]{1,1,1,3,1}));
        assertEquals("Score for [2,4,4,5,4] must be 450:", 450, GreedIsGood.greedy(new int[]{2,4,4,5,4}));

    }

    /**
     * Best Solution
     * int n[] = new int[7];
     *     for (int d : dice) n[d]++;
     *     return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;

     */
    public static int greedy(int[] dice){
        int result=0;
        Map<Integer, Integer> diceMap = new HashMap<>();
        IntStream.range(1,7).forEach(e->diceMap.put(e,0));

        for(int num: dice) {
        diceMap.replace(num, diceMap.get(num)+1);
        }
        System.out.println("diceMap = " + diceMap);
        for(int i =1; i<=6; i++){
                if(i==1) result+=diceMap.get(i)%3*100;
                if(i==5) result+=diceMap.get(i)%3*50;
           if(diceMap.get(i)>=3){
               if(i==1){
                   result+=1000;
               }else{
                   result+=i*100;
               }
           }
        }
        return result;
    }
}
/**
 *  public static int greedy(int[] dice) {
 *         return Arrays.stream(dice)
 *                 .boxed()
 *                 .collect(Collectors.groupingBy(item -> item, Collectors.counting()))
 *                 .entrySet()
 *                 .stream()
 *                 .mapToInt(item -> calculate(item.getKey(), item.getValue().intValue()))
 *                 .sum();
 *     }
 */