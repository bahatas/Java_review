package com.cybertek.leetcode.ALGO_QS;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {

    }

    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindrome(ListNode head) {


        ListNode slow = head;
        boolean ispalindrome = true;
        Stack<Integer> stack = new Stack<Integer>();

        while (slow != null) {
            stack.push(slow.value);
            slow = slow.next;
        }

        while (head != null) {

            int i = stack.pop();
            if (head.value == i) {
                ispalindrome = true;
            } else {
                ispalindrome = false;
                break;
            }
            head = head.next;
        }
        return ispalindrome;
    }

    //    public static boolean isPalindrome2(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//            // find the mid
//            ListNode fast = head;
//            ListNode slow = head;
//            while (fast.next != null && fast.next.next != null) {
//                fast = fast.next.next;
//                slow = slow.next;
//            }
//            ListNode temp = slow.next;
//            slow.next = null;
//            // reverse  the second half
//            ListNode c1 = temp;
//            ListNode c2 = c1.next;
//            while (c1 != null && c2 != null) {
//                ListNode dummy = c2.next;
//                c2.next = c1;
//                c1 = c2;
//                c2 = dummy;
//
//            }
//            temp.next = null;
//            ListNode i = (c2 == null ? c1 : c2);
//            ListNode j = head;
//            while (i != null) {
//                if (i.val != j.val) {
//                    return false;
//
//                }
//                i = i.next;
//                j = j.next;
//            }
//            return true;
//        }
//    }
    public static boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // find middle point
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse 2nd half of linked list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // palindrome checking : first half and second half
        ListNode left = head;
        ListNode right = prev;
        while (right != null) {
            if (left.value != right.value) {
                return false;
            } else {
                left = left.next;
                right = right.next;
            }
        }

        return true;
    }
}


