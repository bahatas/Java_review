package com.cybertek.leetcode.ALGO_QS;

import java.lang.annotation.Retention;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Algo22_InsertIntoACircularSortedLinkedList {

    public static void main(String[] args) {
        ListNode n1  = new ListNode(3);
        ListNode n2 = new ListNode(3);
        ListNode n3  = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        //5-->6
        //10-->0    0-->0/1

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next = n1;

        LinkedList list = new LinkedList();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        list.add(n6);

        System.out.println("insertNumberIntoCircular(n2,5) = " + insertNumberIntoCircular(n5, 6));
        System.out.println(n1.next.val);
        System.out.println(n2.next.val);
        System.out.println(n3.next.val);
        System.out.println(n4.next.val);
        System.out.println(n5.next.val);
        System.out.println(n6.next.val);


    }

    static ListNode insertNumberIntoCircular(ListNode given, int insertVal) {

        ListNode insertNode = new ListNode(insertVal);
        ListNode maxNode = given;
        ListNode curr = given;

        if (curr == null) {
            insertNode.next = insertNode;
            return insertNode;
        }else if(given.next==given ) {
            given.next = insertNode;
            insertNode.next=given;
            return given;
        }

        do {
            if (maxNode.next.val >= maxNode.val) maxNode = maxNode.next;
            if (insertNode.val <= curr.next.val && insertNode.val >= curr.val) {
                curr.next = insertNode;
                insertNode.next = curr.next;
                break;
            }
            curr = curr.next;
        }
        while (curr != given);
        if(insertNode.val>= maxNode.val || insertNode.val==maxNode.next.val){
            insertNode.next=maxNode.next;
            maxNode.next=insertNode;
        }
        return given;


    }

    static Node insertNumberIntoCircular2(Node given, int insertVal) {

        Node insertNode = new Node(insertVal);
        Node maxNode = given;
        Node curr = given;

        if (curr == null) {
            insertNode.next = insertNode;
            return insertNode;
        }else if(given.next==given ) {
            given.next = insertNode;
            insertNode.next=given;
            return given;
        }

        do {
            if (maxNode.next.value >= maxNode.value) maxNode = maxNode.next;
            if (insertNode.value <= curr.next.value && insertNode.value >= curr.value) {
                curr.next = insertNode;
                insertNode.next = curr.next;
                break;
            }
            curr = curr.next;
        }
        while (curr != given);
        if(insertNode.value>= maxNode.value || insertNode.value==maxNode.next.value){
            insertNode.next=maxNode.next;
            maxNode.next=insertNode;
        }
        return given;

    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * <p>
 * Given a Circular Linked List node, which is sorted in ascending order, write a function to insert a
 * value insertVal into the list such that it remains a sorted circular list. The given node can be a reference to
 * any single node in the list and may not necessarily be the smallest value in the circular list.
 * If there are multiple suitable places for insertion, you may choose any place to insert the new value. After
 * the insertion, the circular list should remain sorted.
 * If the list is empty (i.e., the given node is null), you should create a new single circular list and return the
 * reference to that single node. Otherwise, you should return the originally given node.
 * <p>
 * <p>
 * <p>
 * Input: head = [3,4,1], insertVal = 2
 * Output: [3,4,1,2]
 * <p>
 * <p>
 * <p>
 * Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to
 * the node with value 3, and we need to insert 2 into the list. The new node should be inserted between node 1
 * and node 3. After the insertion, the list should look like this, and we should still return node 3.
 */

/**
 * Given a Circular Linked List node, which is sorted in ascending order, write a function to insert a
 * value insertVal into the list such that it remains a sorted circular list. The given node can be a reference to
 * any single node in the list and may not necessarily be the smallest value in the circular list.
 * If there are multiple suitable places for insertion, you may choose any place to insert the new value. After
 * the insertion, the circular list should remain sorted.
 * If the list is empty (i.e., the given node is null), you should create a new single circular list and return the
 * reference to that single node. Otherwise, you should return the originally given node.
 *
 *
 *
 * Input: head = [3,4,1], insertVal = 2
 * Output: [3,4,1,2]
 *
 *
 *
 * Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to
 * the node with value 3, and we need to insert 2 into the list. The new node should be inserted between node 1
 * and node 3. After the insertion, the list should look like this, and we should still return node 3.
 *
 *
 *
 */



/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }

        Node prev = head;
        Node curr = head.next;
        boolean insertPlaceFound = false;

        do {
            if (prev.value <= insertVal && insertVal <= curr.value) {
                insertPlaceFound= true;
            } else if (prev.value > curr.value) {

                if (insertVal >= prev.value || insertVal <= curr.value)
                    insertPlaceFound = true;
            }//elseif

            if (insertPlaceFound) {
                prev.next = new Node(insertVal, curr);
                return head;
            } //endif

            prev = curr;
            curr = curr.next;

        }  while(prev!=head) ;

        prev.next = new Node(insertVal, curr);
        return head;
    }
}


