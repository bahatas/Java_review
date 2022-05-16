package com.cybertek.cuncerrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ConcurrentTask {

    public static void main(String[] args) {

        Runnable run = () -> System.out.println("This is runnable print "+Thread.currentThread().getName());
        Thread t = new Thread(run);
        t.start();
        System.out.println("Singleton print " + Thread.currentThread().getName());

        ExecutorService executorService = Executors.newCachedThreadPool(); // new Fixedthreadpool (10)


        List<Runnable> listOfRunnable = Arrays.asList(

                () -> System.out.println("Runnable 1 " + Thread.currentThread().getName()),
                () -> System.out.println("Runnable 2 " + Thread.currentThread().getName()),
                () -> System.out.println("Runnable 3 " + Thread.currentThread().getName()),
                () -> System.out.println("Runnable 4 "+ Thread.currentThread().getName()),
                () -> System.out.println("Runnable 5 " + Thread.currentThread().getName()),
                () -> System.out.println("Runnable 7 " + Thread.currentThread().getName()),
                () -> System.out.println("Runnable 8 " + Thread.currentThread().getName()),
                () -> System.out.println("Runnable 9 " + Thread.currentThread().getName())

        );
        System.out.println("list of callable print");
        IntStream.range(0,8).forEach(i->executorService.submit(listOfRunnable.get(i)));

        List<Callable<Integer>> callableList = Arrays.asList(
                () -> {
                    int a = 1;
                    System.out.println("Callable 1 "+ Thread.currentThread().getName());
                    return a;
                },
                () -> {
                    int a = 2;
                    System.out.println("Callable 2 " +Thread.currentThread().getName()));
                    return a;
                },
                () -> {
                    int a = 3;
                    System.out.println("Callable 3 ");
                    return a;
                },
                () -> {
                    int a = 4;
                    System.out.println("Callable 4 ");
                    return a;
                },
                () -> {
                    int a = 5;
                    System.out.println("Callable 5 ");
                    return a;
                },
                () -> {
                    int a = 6;
                    System.out.println("Callable 6 ");
                    return a;
                },
                () -> {
                    int a = 7;
                    System.out.println("Callable 7 ");
                    return a;
                },
                () -> {
                    int a = 8;
                    System.out.println("Callable 8 ");
                    return a;
                }

        );

        try {
            List<Future<Integer>> results = executorService.invokeAll(callableList);
            results.forEach(r -> {
                try {
                    System.out.println("Result: " + r.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
