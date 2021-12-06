package com.cybertek.leetcode.linkedList.datastructureclass;



public class CyLinkedList {

    public Node first;
    public Node last;
    public int size ;




    public CyLinkedList (){
        this.first = null;
        this.last=null;
        this.size=0;

    }

    public boolean isEmpty(){
        return first ==null;
    }
}


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next=null;
    }
}
