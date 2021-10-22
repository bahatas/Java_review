package com.cybertek.lambda;

import java.io.IOException;


public class example {
    public static void main(String[] args) throws IOException {
        while (true) {

            int read =System.in.read();
            System.out.println("input"+read);
            if(filter(read)){
                process(read);
            }
        }

    }

    public static boolean filter( int read){

        return read != '\n' && read != 'a';

    }

    private static void process( int arg){
        if(Math.max(arg,90)%2 ==0){
            System.out.println("!");
        }
    }

}
