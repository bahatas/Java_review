package com.cybertek.lambda.sorting;

import java.util.Comparator;

public class MyComperator implements Comparator<Integer> {
    /*
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1< o2){
                return 1;

            }else if(o1>o2){
                return -1;
            }else{
                return 0;
            }
        }

     */

    //ternary operator is the best implementation
    @Override
    public int compare(Integer o1, Integer o2) {

        return (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0;
    }
}
