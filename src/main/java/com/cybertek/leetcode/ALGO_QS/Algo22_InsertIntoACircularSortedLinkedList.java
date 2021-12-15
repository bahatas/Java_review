package com.cybertek.leetcode.ALGO_QS;

import java.lang.annotation.Retention;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Algo22_InsertIntoACircularSortedLinkedList {

    public static void main(String[] args) {
        ListNode n1  = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3  = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(6);
        //5-->6
        //10-->0    0-->0/1

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n1;

        LinkedList list = new LinkedList();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        list.add(n6);

        System.out.println("insertNumberIntoCircular(n2,5) = " + insertNumberIntoCircular(n2,5).next.val);



    }

    static ListNode insertNumberIntoCircular(ListNode given, int insertVal) {

        ListNode insertNode = new ListNode(insertVal);
        ListNode maxNode = given;
        ListNode curr = given;

        if(given.next==given ) {
            given.next = insertNode;
            insertNode.next=given;
            return given;
        }else if (curr == null) {
            insertNode.next = insertNode;
            return insertNode;
        }

        while (curr.next != given) {
            if (maxNode.next.val> maxNode.val) maxNode = maxNode.next;
            if (insertNode.val <= curr.next.val && insertNode.val >= curr.val) {
                curr.next = insertNode;
                insertNode.next = curr.next;
                break;
            }
            curr=curr.next;

        }

        if(insertNode.val>= maxNode.val || insertNode.val==maxNode.next.val){
            insertNode.next=maxNode.next;
            maxNode.next=insertNode;
        }
        return insertNode;

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






