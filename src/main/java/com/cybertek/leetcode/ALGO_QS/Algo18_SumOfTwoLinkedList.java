package com.cybertek.leetcode.ALGO_QS;

import java.util.LinkedList;

public class Algo18_SumOfTwoLinkedList {




    void printer(Node node){
        while(node != null){
            System.out.println(node.value + " ");
            node=node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {

    }

    public Node addTwoNumbers(Node l1, Node l2)
    {
        Node dummy=new Node(-1);
        Node ptr=dummy;
        Node tmp;
        int sum=0,carry=0;
        while(l1!=null || l2!=null)
        {
            if(l1!=null && l2!=null)
            {
                sum= l1.value+l2.value+carry;
                l1=l1.next;
                l2=l2.next;
            }
            // if the above condition fails it means either l1 or l2 is null so check
            else if(l1!=null)
            {
                sum=l1.value+carry;
                l1=l1.next;

            }
            else if(l2!=null)
            {
                sum=l2.value+carry;
                l2=l2.next;
            }
            // THis is part is common for all the above operation
            if(sum>9)
                carry=1; //the sum will be in between 0 and 18 so carry should be 1 or 0
            else
                carry=0;

            // creating a new Linked List
            tmp=new Node(sum%10);
            ptr.next=tmp;
            ptr=ptr.next;
        }
        // if carry is still left
        if(carry==1)
        {
            tmp=new Node(carry);
            ptr.next=tmp;
            ptr=ptr.next;
        }
        return dummy.next; // dummy.next is our head
    }
    static Node getSumOfLinkedLists(Node nodeOne, Node nodeTwo ){
        Node result =null;
        Node current;
        Node next= null;
        int sum,carryValue,val1,val2;
        sum=carryValue=val1=val2=0;


        while(nodeOne !=null || nodeTwo != null){
            if(nodeOne!=null && nodeTwo!=null) {
                sum= nodeOne.value+ nodeTwo.value+carryValue;
                nodeOne=nodeOne.next;
                nodeTwo=nodeTwo.next;
            }else if(nodeOne ==null){
                sum= nodeTwo.value+carryValue;
                nodeTwo=nodeTwo.next;
            }
            else if(nodeTwo ==null){
                sum= nodeOne.value+carryValue;
                nodeOne=nodeOne.next;
            }
            carryValue=(sum>=10)?1:0;
            sum%=10;
            current=new Node(sum);



            val1=nodeOne==null?0:nodeOne.value;
            val2=nodeTwo==null?0:nodeTwo.value;
            sum=val1+val2+carryValue;
            carryValue=(sum>10)?1:0;


            current =  new Node(sum);

            result=current;
            current=current.next;
            nodeOne=nodeOne.next;
            nodeTwo=nodeTwo.next;



        }
        return null;
    }
     private static LinkedList<Integer> getSumOfLinkedLists(LinkedList<Integer> linkedListOne, LinkedList<Integer> linkedListTwo){

        LinkedList<Integer> result = new LinkedList<>();

        int sum = 0;



        return null;

     }

     static Node getSumOfLinkedLists2(Node list1, Node list2){
        Node result = new Node(0);
        Node temp = result;
        int total = 0;
        int onHand = 0;


        while (list1 != null || list2 != null ){
            if(list1 != null && list2 != null){
                total =(list1.value + list2.value+onHand)%onHand;
                onHand=(list1.value + list2.value + onHand)/10;

                list1 = list1.next;
                list2 = list2.next;
                temp.next = new Node(total);
            }else if(list1 == null){
                total = (list2.value + onHand) % 10;
                onHand = (list2.value + onHand) /10;
                list2 = list2.next;
                temp.next = new Node(total);
            }else if(list2 == null ){
                total = total = (list1.value +onHand)%10;
                onHand = (list1.value + onHand)/10;
                list1 = list1.next;
                temp.next = new Node(total);
            }
            temp = temp.next;
        }
        if(onHand==1){
            temp.next= new Node(1);
        }
        return result.next;
     }

    public Node addTwoNumbers(Node l1, Node l2) {
        int sum = 0;

        Node head,current,n1=l1,n2=l2;
        head = current = new Node();
        while(true){
            if(n1!=null){
                sum+=n1.value;
                n1=n1.next;
            }
            if(n2!=null){
                sum+=n2.value;
                n2=n2.next;
            }

            current.value = sum % 10;
            sum /= 10;
            if(n1 == null && n2 == null && sum == 0) break;
            current.next = new Node();
            current = current.next;
        }
        return head;
    }
}

//class Node {
//
//    Node next;
//    int value;
//
//    Node(int value) {
//        this.value = value;
//    }
//
//    public Node() {
//
//    }
//}

/**
 * You're given two Linked Lists of potentially unequal length. Each Linked List represents a
 * non-negative integer, where each node in the Linked List is a digit of that integer, and the
 * first node in each Linked List always represents the least significant digit of the integer.
 * Write a function that returns the head of a new Linked List that represents the sum of the
 * integers represented by the two input Linked Lists. Each LinkedList node has an integer value
 * as well as a next node pointing to the next node in the list or to None / null if it's the tail of
 * the list. The value of each LinkedList node is always in the range of 0 - 9 .
 * Note: your function must create and return a new Linked List, and you're not allowed to
 * modify either of the input Linked Lists.
 * Sample Input
 * linkedListOne = 2 -> 4 -> 7 -> 1 // represents 1742 as a number
 * linkedListTwo = 9 -> 4 -> 5
 * Sample Output
 * 1 -> 9 -> 2 -> 2
 * // linkedListOne represents 1742
 * // linkedListTwo represents 549
 * // 1742 + 549 = 2291
 */