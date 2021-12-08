package com.cybertek.leetcode.ALGO_QS;

import java.util.LinkedList;

public class Algo19_MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(5);

        l11.next=l12;
        l12.next=l13;

        l21.next=l22;
        l22.next=l23;


        LinkedList<ListNode> linkedList1 = new LinkedList<>();
        linkedList1.add(l11);
        linkedList1.add(l12);
        linkedList1.add(l13);
        LinkedList<ListNode> linkedList2 = new LinkedList<>();
        linkedList2.add(l21);
        linkedList2.add(l22);
        linkedList2.add(l23);

        ListNode listNode = mergeTwoLists(l11, l21);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prevHead = new ListNode(-100,null);;
        ListNode current = prevHead;

        while(true){

            if(list1.val<= list2.val){

                current.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            }else
                if(list1!= null && list2!= null){
                current.next=new ListNode(Math.min(list1.val, list2.val));
                prevHead.next=current.next;
                current = current.next;

            }else if(list1!=null && list2 == null){
                current.next=new ListNode(list1.val);
                list1 = list1.next;
            }

        }

        current=current.next;

        return prevHead.next;
    }
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {




        int value = -100;
        value= Math.min(list1.val, list2.val);

        if(list1==null){
            value= list2.val;
        }
        ListNode dummy = new ListNode(-100,null);;
        ListNode current = dummy;

        while ( list1!=null && list2 != null){


            dummy.next = (list1.val<= list2.val)?list1:list2;

            current.next = new ListNode(Math.min(list1.val, list2.val));
            current = current.next;
            if(dummy==list1);list1= list1.next;
            if(dummy==list2);list2= list2.next;

        }

        while ( list1!=null || list2 != null){



            if(list1.val<= list2.val){
                current.next=list1;
               value=list1.val;
                list1=list1.next;

            }else{

                current.next=list2;
               value= list2.val;
                list2=list2.next;
            }

            current= new ListNode(value,null);
//            outPut.next=pointer;

        }

        if(list1 == null && list2 != null){
            return list2;
        }else if(list1 != null && list2 == null) {
            return list1;
        }else if(list1 == null && list2 == null){
            return null;
        }
        return dummy;
    }


}


//  Definition for singly-linked list.
   class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


//*********************************
/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */

