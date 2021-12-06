package com.cybertek.leetcode.linkedList.implementation;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next=null;
    }
}
public class Main {
    public static void printList(Node head ){
        Node prt = head;
        while(prt != null){
            System.out.println(prt.data + " - > ");
            prt=prt.next;
        }
        System.out.println("null");
    }

    // Naive function for linked list implementation containing four nodes
    public static Node constructList(){

        Node first = new Node(1);
        Node second = new Node(2);
        Node thirth = new Node(3);
        Node fourth = new Node(4);

        //rearrange reference to construct to list

        Node head = first;
        first.next=second;
        second.next=thirth;
        thirth.next=fourth;

        //retrun reference to the first node in the list
        return head;

    }

    private static void main(String[] args) {
        //head points to the head node of the linked list
        Node head = constructList();

        //print linked list
        printList(head);
    }
}
