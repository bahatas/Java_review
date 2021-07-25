package com.cybertek.leetcode.linkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 */
public class SwapNodesInPairs {

    public static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        ListNode head = new SwapNodesInPairs().swapPairs(listNode);
        while ( head != null){
            System.out.println("head.val = " + head.val);
            head = head.next;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode newHead = head.next;
        ListNode current = head.next;
        ListNode prev = head;
        ListNode prevPrev = new ListNode(-1);// dummy node

        while (current != null) {
            prev.next = current.next;
            current.next = prev;
            prevPrev.next = current;
            if (prev.next != null) {
                current = prev.next.next;
                prev = prev.next;
                prevPrev = prevPrev.next.next;

            } else {
                current = null;

            }
        }

        return newHead;
    }

}
