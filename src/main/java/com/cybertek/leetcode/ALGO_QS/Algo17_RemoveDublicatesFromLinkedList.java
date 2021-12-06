package com.cybertek.leetcode.ALGO_QS;

import java.util.Iterator;
import java.util.LinkedList;

public class Algo17_RemoveDublicatesFromLinkedList {

    public static void main(String[] args) {

    }

    static LinkedList<Integer> removeDublicate(LinkedList<Integer> given) {

        Node head = new Node(given.get(0));
        Node curr=head;
        while (curr.next != null) {
            if(curr.value==curr.next.value){
                curr.next=curr.next.next;
            }else curr=curr.next;
        }
        return given;
    }

    static LinkedList<Integer> removeDublicate3(LinkedList<Integer> given) {
         Iterator<Integer> it = given.iterator();
         int prev = it.next();

         return null;
    }



    static LinkedList<Integer> removeDublicate2(LinkedList<Integer> linkedList, Node head){
        Node current = head;
        Node nextNode;
        if(head == null) return linkedList;

        while (current.next != null){
            nextNode = current.next;
            if(current.value == nextNode.value){
                //if(temp.next == null) linkedList.tail = temp;
                current.next = nextNode.next;
                nextNode.next = null;
            }else current = current.next;
        }
        return linkedList;
    }
//    public void removeDuplicatesFromLinkedListPure() {
//        if (length < 2) return;
//        Node current = head;
//        while (current.next != null) {
//            if (current.value == current.next.value) {
//                current.next = current.next.next;
//            } else {
//                current = current.next;
//            }
//        }
//    }
}


class Node {

    Node next;
    int value;

    Node(int value) {
        this.value = value;
    }

    public Node() {

    }
}


/**
 * Question # 17
 * Description:
 * Remove Duplicates From Linked List
 * Difficulty: Easy Category: Linked Lists
 * <p>
 * You're given the head of a Singly Linked List whose nodes are in sorted order with respect to
 * their values. Write a function that returns a modified version of the Linked List that doesn't
 * contain any nodes with duplicate values. The Linked List should be modified in place (i.e.,
 * you shouldn't create a brand new list), and the modified Linked List should still have its
 * nodes sorted with respect to their values. Each LinkedList node has an integer value as well
 * as a next node pointing to the next node in the list or to None / null if it's the tail of the list.
 * <p>
 * Sample Input
 * <p>
 * linkedList = 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6 // the head node with value 1
 * <p>
 * Sample Output 1 -> 3 -> 4 -> 5 -> 6 // the head node with value 1
 * Good luck!
 * Fatih
 */

