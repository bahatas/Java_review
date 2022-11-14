package com.cybertek.leetcode.ALGO_QS;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayProduct {
    public static void main(String[] args) {
        int[] arrayGiven = {1,2,3,4};
        System.out.println("Arrays.toString(arrayGiven) = " + Arrays.toString(arrayGiven));

        System.out.println("arrayOfProducts " + Arrays.toString(arrayOfProducts(arrayGiven)));
        System.out.println("array2 " + Arrays.toString(returnArray2(arrayGiven)));
        System.out.println("array3 " + Arrays.toString(returnArray3(arrayGiven)));

        returnArray4(arrayGiven);

    }

    public static int[] arrayOfProducts(int[] array) {
        int[] products = new int[array.length];
        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            products[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }
        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            products[i] *= rightRunningProduct;
            rightRunningProduct *= array[i];
        }
        return products;
    }


    public static int[] find(int[] num){


        int[] left = new int[num.length];
        int[] right = new int[num.length];
        int[] result = new int[num.length];

        left[0]= 1;
        right[num.length-1] = 1;

        for(int i=1;i<num.length;i++){
            left[i] = left[i-1]*num[i-1];
            right[num.length-i-1] = right[num.length-i]*num[num.length-i];
        }

        for(int i=0;i<num.length;i++)
            result[i] = left[i] * right[i];

        return result;
    }


    public static  int[] returnArray(int[] array){

        int [] result = new int[array.length];
        int eachLastNumber=1;

        for (int i=0; i<array.length;i++ ) {

            for (int k : array) {
                if (array[i] != k)
                    eachLastNumber *= k;
            }
            result[i] = eachLastNumber;
            eachLastNumber = 1;
        }
        return result;
    }

    public static int[] returnArray2(int[] array) {

        return IntStream.range(0, array.length)
                .map(i -> //0,1,2,3
                        Arrays.stream(array) //1,3,5,8
                                .filter(each -> array[i] != each)
                                .reduce(1, (a, b) -> Math.multiplyExact(a, b))
                ).toArray();
    }

    public static int[] returnArray3(int[] array) {
        return Arrays.stream(array).map(i -> Arrays.stream(array)
                .filter(each -> i != each)
                .reduce(1, Math::multiplyExact)).toArray();
    }


    public static void returnArray4(int[] array) {

        IntStream stream = Arrays.stream(array);
        stream.forEach(System.out::println);


        System.out.println(
                "Result: " +
                        Stream.of(1, 2, 3)
                                .flatMap(i -> Stream.of(i - 1, i, i + 1))
                                .flatMap(i -> Stream.of(i - 1, i, i + 1))
                                .filter(i -> {
                                    System.out.println(i);
                                    return true;
                                })
                                .findFirst()
                                .get()
        );

    }

    static void flatMap(int[][] grids){
        int[] ar1 = {1,2,3};
        int[] ar2 = {1,2,3};
        int x= ar1.length;
        int y= ar2.length;
        String CLEAN = "clean";
//        Arrays.stream(grids).flatMap(each-> Arrays.stream(Arrays.stream(each).map(value->3).toArray()).
//        IntStream.range(0,x)
//                    .flatMap(each ->
//                            IntStream.range(0,y)).forEach({
//                grids[each][]
//        });

//        Arrays.setAll(grids,each->{
//            Arrays.setAll(grids[x],y->Enum.valueOf(Area.class,CLEAN));
//        });
        System.out.println("Flat map");
        System.out.println(Arrays.toString (
                IntStream.range(0, ar1.length)
                        .flatMap(n -> Arrays.stream(ar2).map(i -> ar1[x] + i))
                        .toArray ()));

    }

    enum Area{
        CLEAN, DIRTY;
    }

}







