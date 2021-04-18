package com.cybertek.lambda.sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
                list.add(5);
                list.add(15);
                list.add(3);
                list.add(500);
                list.add(25);

        System.out.println(list);

        Collections.sort(list);// sort ascdending

        System.out.println(list);

        Collections.sort(list,new MyComperator());
        System.out.println(list);

        //with lamda

        //ascending order

        Collections.sort(list);
        System.out.println(list);//[3, 5, 15, 25, 500]

        //descending order
        Collections.sort(list,(((o1, o2) -> (o1>o2)?-1:(o2>o1)?1:0)));
        System.out.println(list);//[500, 25, 15, 5, 3]

        list.sort(((o1, o2) -> o1.compareTo(o2)));
        System.out.println(list);//[3, 5, 15, 25, 500]

        list.sort(((o1, o2) -> o2.compareTo(o1)));
        System.out.println(list); //[500, 25, 15, 5, 3]




    }
}
