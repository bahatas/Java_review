package com.cybertek.leetcode.ALGO_QS.week27;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

public class NeedToBuyTickets {
    public static void main(String[] args) {

        System.out.println("getTimeReqToBuy(new int[]{5,1,1,1}, 0) = " + getTimeReqToBuy(new int[]{5, 1, 1, 1}, 0));
        System.out.println(getTimeReqToBuy(new int[]{2, 3, 2}, 2));
    }

    public static int getTimeReqToBuy(int[] arr, int k) {


        Queue<Integer> tickeetQue = new ArrayDeque<>();

        while (arr[k] != 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    continue;
                }
                if (arr[k] == 0) {
                    break;
                }
                tickeetQue.add(arr[i]--);
            }
        }

        return tickeetQue.size();

    }

    //new int[]{5,1,1,1}, 0)
    public static int getTimeReqToBuy2(int[] tickets, int k) {
        var ticketQueue = Arrays.stream(tickets)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));


        int totalTime = 0;
        int currentIndex = 0;
        while (!ticketQueue.isEmpty()) {

            if (ticketQueue.peek() != 0) {
                int currentTicketCount = ticketQueue.poll() - 1;
                ticketQueue.add(currentTicketCount);
                totalTime++;
                if (currentIndex == k && currentTicketCount == 0) {
                    break;
                }
            } else {
                ticketQueue.add(ticketQueue.poll());
            }

            currentIndex++;
            if (currentIndex == tickets.length) {
                currentIndex = 0;
            }
        }

        return totalTime;

    }
}
