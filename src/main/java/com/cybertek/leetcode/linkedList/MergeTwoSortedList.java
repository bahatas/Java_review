package com.cybertek.leetcode.linkedList;

/**
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Input: l1 = [], l2 = []
 * Output: []
 * <p>
 * <p>
 * /**
 * * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode() {}
 * *     ListNode(int val) { this.val = val; }
 * *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * * }
 */

public class MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;

//        ListNode(int x) {
//            val = x;
//            next = null;
//        }

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(8);

        ListNode head3 = new ListNode(1);
        ListNode head4 = new ListNode(2);
        ListNode head5 = new ListNode(7);
        ListNode head6 = new ListNode(10);

        head.next = head1;
        head1.next=head2;
        head2.next=head3;

        head3.next=head4;
        head4.next=head5;
        head5.next=head6;


        ListNode listNode = mergeTwoLists(head, head3);

        while(listNode!= null){
            System.out.println("listNode.val = " + listNode.val);
            listNode=listNode.next;
        }


    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null) return l2;

        else if ( l2 == null)return l1 ;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
