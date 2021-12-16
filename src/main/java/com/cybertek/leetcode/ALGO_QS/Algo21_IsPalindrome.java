package com.cybertek.leetcode.ALGO_QS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Algo21_IsPalindrome {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(3);
        Node n5 = new Node(2);
        Node n6 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        LinkedList list = new LinkedList();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        list.add(n6);

        System.out.println("isPalindrome(n1) = " + isPalindrome(n1));
        System.out.println("isPalindrome2(n1) = " + isPalindrome2(n1));

    }


    public static boolean isPalindrome(Node head) {

        Node curr = head;
        boolean result = false;
        List<Integer> linkedList = new ArrayList<>();
        int size = 0;
        do{
            linkedList.add(head.value);
            head = head.next;
            size++;
        }
        while (head.next != null);
        linkedList.add(head.value);size ++;

        for (int i = size-1; i >size/2; i--) {
            result = linkedList.get(i) == curr.value;
            curr=curr.next;
        }

        return result;
    }

    public static boolean isPalindrome2(Node head) {
        boolean res = false;
        Node given = head;
        Node reverseNode = null;

        while(head.next!=null){
            Node newNode = new Node(head.value);
            head=head.next;
            reverseNode=head;
            reverseNode.next = newNode;
        }

        while(given != null && reverseNode !=null){
            if(given.value== reverseNode.value) res = true;
            given= given.next;
            reverseNode=reverseNode.next;
        }

        return res;
    }
    ListNode reverse(ListNode node){
        ListNode cur = null;
        while(node!=null){
            ListNode n = new ListNode(node.val);
            n.next = cur;
            cur = n;
            node = node.next;
        }
        return cur;
    }
    boolean isEqual(ListNode one,ListNode two){
        while(one != null && two != null){
            if(one.val != two.val){
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one==null && two==null;

    }

}

}
