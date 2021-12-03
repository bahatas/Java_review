package com.cybertek.leetcode.crackingBook.linkedList;

import java.util.HashSet;

public class RemoveDuplicates {


    static void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;

        while (n != null) {
            if (set.contains(n.data)) {
            }
        }
    }


}

class LinkedListNode {

    LinkedListNode next;

    int data;

    public LinkedListNode(int data) {
        this.data = data;
        next=null;
    }
}

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * <p>
 * Answer:
 * <p>
 * SOLUTION
 * pg94
 * In order to remove duplicates from a linked list, we need to be able to track duplicates. A simple hash table
 * will work well here.
 * In the below solution, we simply iterate through the linked list, adding each element to a hash table. When
 * we discover a duplicate element, we remove the element and continue iterating. We can do this all in one
 * pass since we are using a linked list.
 */


/**
 * Answer:
 *
 * SOLUTION
 * pg94
 * In order to remove duplicates from a linked list, we need to be able to track duplicates. A simple hash table
 * will work well here.
 * In the below solution, we simply iterate through the linked list, adding each element to a hash table. When
 * we discover a duplicate element, we remove the element and continue iterating. We can do this all in one
 * pass since we are using a linked list.
 */