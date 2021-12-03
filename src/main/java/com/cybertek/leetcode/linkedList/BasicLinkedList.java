package com.cybertek.leetcode.linkedList;

public class BasicLinkedList {
    // DoublyLinkedList
    public Node head;
    public Node tail;

    public void setHead(Node node) {
        node.next = head;
        node.prev = null;
        head.prev = node;
        this.head = node;
    }

    public void setTail(Node node) {
        tail.next = node;
        node.prev = tail;
        node.next = null;
        this.tail = node;
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        nodeToInsert.next = node;
        nodeToInsert.prev = node.prev;
        node.prev.next = nodeToInsert;
        node.prev = nodeToInsert;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        nodeToInsert.prev = node;
        nodeToInsert.next = node.next;
        node.next.prev = nodeToInsert;
        node.next = nodeToInsert;
    }

    public void insertAfterValue(Node node, int value) {
        Node current = head;
        while (current != null && current.value != value) {
            current = current.next;
        }
        if (current != null) insertAfter(current, node);
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        Node current = head;
        int index = 0;
        while (index < position && current != null) {
            current = current.next;
        }
        if (current != null) insertAfter(current, nodeToInsert);
    }

    public void removeNodesWithValue(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                current = current.next;
                remove(current.prev);
            }
        }
    }

    public void remove(Node node) {
        if (node != head) node.prev.next = node.next;
        if (node != tail) node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public int indexOf(int value) {
        Node current = head;
        int index = 0;
        while (current != null && current.value != value) {
            current = current.next;
            index++;
        }
        return current == null ? -1 : index;
    }

    public boolean containsNodeWithValue(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) return true;
            current = current.next;
        }
        return false;
    }
}
// Do not edit the class below.
//    class Node {
//        public int value;
//        public Node prev;
//        public Node next;
//
//        public Node(int value) {
//            this.value = value;
//        }
//    }
//}
