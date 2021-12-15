package com.cybertek.leetcode.ALGO_QS;

import java.util.LinkedList;

public class Algo20_ShiftSLinkedList {
    public static void main(String[] args) {
        Node n1  = new Node(0);
        Node n2 = new Node(1);
        Node n3  = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(4);
        Node n6 = new Node(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        LinkedList list = new LinkedList();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        list.add(n6);

//        System.out.println("getShiftedHead(n1,2).value = " + getShiftedHead(n1, 2).value);
//        System.out.println("getShiftedHead(n1,2).value = " + getShiftedHead1(n1, 3).value);
//        System.out.println("getShiftedHead(n1,2).value = " + getShiftedHead(n1, 2).value);
        System.out.println("getShiftedHead(n1,2).value = " + getShiftedHead(n1, 0).value);
        System.out.println("getShiftedHead(n1,2).value = " + getShiftedHead(n1, 1).value);
        System.out.println("getShiftedHead(n1,2).value = " + getShiftedHead(n1, 2).value);
        System.out.println("getShiftedHead(n1,2).value = " + getShiftedHead(n1, 3).value);

    }

    static Node getShiftedHead1(Node given, int k) {
        if (given == null || given.next == null) {
            return given;
        }

        int size = 1;
        while (given.next != null) {
            given = given.next;
            size++;
        }

        int shift_k = (Math.abs(k) > size) ? (k % size) : k;
        shift_k = (k < 0) ? size - k : k;

        Node prev = given;
        Node curr = given;
        // head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0 k = 2
        for (int i = 0; i < shift_k; i++) {
            curr = given;
            prev = given;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            curr.next = given;
            given = curr;
        }
        System.out.println(given.value);

        return given;
    }

    static Node getShiftedHead(Node given, int k) {  // head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0 k = 2

//        Node head = given;
//        int size = 1;
//        while (given.next != null) {
//            given = given.next;
//            size++;
//        }
//        int shift_k = (Math.abs(k) > size) ? k % size : k;
//        shift_k = (k < 0) ? size - shift_k : shift_k;
//         int shift_k = (Math.abs(k) > size) ? k % size : k;
        Node head = null;
        while (true) {
            Node curr = given;
            if (k == 0){
                return given;
            } else {
                while (true) {
                    curr = curr.next;
                    if (curr.next.next == null) {
                        curr.next.next = given; //circular
                        given = curr.next;
                        curr.next = null;
                         head = getShiftedHead(given, k - 1);
                        break;
                    }
                }
            }

            break;
        }
       return head;
    }
        static Node getShiftedHead2( Node given, int k){    // head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0 k = 2
            //* Sample Output
            // * 4 -> 5 -> 0 -> 1 -> 2 -> 3 // the new head node with value 4
        int shift =0;

        Node head = null;

        Node current = head = given;

        while(true){
            given = given.next;
            current = given ;
            shift++;
            if (true) break;
            continue;


        }

        return null;
    }

    public static LinkdList shiftLinkedList(LinkdList head, int k) {
        int listLength = 1;
        LinkdList listTail = head;
        while (listTail.next != null) {
            listTail = listTail.next;
            listLength++;
        }
        int offset = Math.abs(k) % listLength;
        if (offset == 0) return head;
        int newTailPosition = k > 0 ? listLength - offset : offset;
        LinkdList newTail = head;
        for (int i = 1; i < newTailPosition; i++){
            newTail = newTail.next;
    }

    LinkdList newHead = newTail.next;
            newTail.next= null;
         listTail.next = head;
         return newHead;
         }


    class LinkdList {
    public int value;
    public LinkdList next;

    public LinkdList(int value) {
        this.value = value;
        next = null;
    }
}

}


/**
 * Difficulty Hard Category :Linked Lists
 * Write a function that takes in the head of a Singly Linked List and an integer k , shifts the list in
 * place (i.e., doesn't create a brand new list) by k positions, and returns its new head. Shifting a
 * Linked List means moving its nodes forward or backward and wrapping them around the list
 * where appropriate. For example, shifting a Linked List forward by one position would make its tail
 * become the new head of the linked list. Whether nodes are moved forward or backward is
 * determined by whether k is positive or negative. Each LinkedList node has an integer value as well
 * as a next node pointing to the next node in the list or to None / null if it's the tail of the list. You
 * can assume that the input Linked List will always have at least one node; in other words, the head
 * will never be None / null .
 * Sample Input
 * head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0 k = 2
 * Sample Output
 * 4 -> 5 -> 0 -> 1 -> 2 -> 3 // the new head node with value 4
 * Good luck!
 * Fatih
 */