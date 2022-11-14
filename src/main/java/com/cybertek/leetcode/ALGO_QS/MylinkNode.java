package com.cybertek.leetcode.ALGO_QS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



class MyLinkNode {
    int val;
    MyLinkNode next;

    MyLinkNode(int val) {
        this.val = val;

    }
}

class Intersection {
    MyLinkNode headA;
    MyLinkNode headB;

    public MyLinkNode getIntersection(MyLinkNode headA, MyLinkNode headB) {

        MyLinkNode currentA = headA;
        MyLinkNode currentB = headB;
        int numberA = 0;
        int numberB = 0;


        List<MyLinkNode> myLinkNodesA = new ArrayList<>();
        List<MyLinkNode> myLinkNodesB = new ArrayList<>();

        while (currentA != null) {

            currentA = currentA.next;
            numberA++;

        }
        while (currentB != null) {

            currentB = currentB.next;
            numberB++;
        }
        int diff = numberA - numberB;
        currentA = headA;
        currentB = headB;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                currentA = currentA.next;
            }

        } else if (diff < 0) {
            for (int i = 0; i < Math.abs(diff); i++) {
                currentB = currentB.next;
            }

        }
        while (currentA != null && currentB != null) {
            if (currentA == currentB) return currentA;
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
    }

    public MyLinkNode getIntersection2(MyLinkNode headA, MyLinkNode headB) {
        Set<MyLinkNode> set = new HashSet<>();
        MyLinkNode currentA = headA;
        MyLinkNode currentB = headB;


        while (currentA != null) {

            set.add(currentA);
            currentA = currentA.next;


        }
        while (currentB != null) {
            if (set.contains(currentB)) {
                return currentB;
            }
            currentB = currentB.next;

        }
        return null;
    }


}