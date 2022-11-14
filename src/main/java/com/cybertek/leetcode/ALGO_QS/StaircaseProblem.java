package com.cybertek.leetcode.ALGO_QS;

public class StaircaseProblem {
    public static void main(String[] args) {
        System.out.println("wayOfCount(7) = " + wayOfCount(5));
    }

    static int wayOfCount(int N) {


        return wayOfCount(N - 1) + wayOfCount(N - 2) + wayOfCount(N - 3);
    }
}


class Solution2 {

    public static void main(String[] args) {
        MyLinkNode head;
        head= new MyLinkNode(3);
        head.next = new MyLinkNode(2);
        head.next.next = new MyLinkNode(0);
        head.next.next.next = new MyLinkNode(4);
        head.next.next.next.next = head.next;
        System.out.println(head);
    }

    static MyLinkNode detectCycle(MyLinkNode myLinkNode) {

        return null;
    }
}