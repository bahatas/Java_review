package com.cybertek.leetcode.linkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void setHead(Node node) {
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void setTail(Node node) {
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        if (size == 0) {
            head = nodeToInsert;
            tail = nodeToInsert;
        } else {
            if(node==tail) {
                nodeToInsert.next=null;
                nodeToInsert.prev=tail;
                tail.next=nodeToInsert;
                tail=nodeToInsert;
                return;
            }

            nodeToInsert.next = node.next;
            nodeToInsert.prev = node;
            node.next.prev = nodeToInsert;
            node.next = nodeToInsert;
        }
        size++;
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        if (size == 0) {
            head = nodeToInsert;
            tail = nodeToInsert;
        } else {
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            node.prev.next = nodeToInsert;
            node.prev = nodeToInsert;
        }

    }

    public void insertAfterValue(Node nodeToInsert, int value) {


        Node node = new Node(value);
        if (size == 0) {
            head = nodeToInsert;
            tail = nodeToInsert;
        } else {
            nodeToInsert.next = node.next;
            nodeToInsert.prev = node;
            node.next.prev = nodeToInsert;
            node.next = nodeToInsert;
        }
        size++;
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        Node node = nodeAt(position);
        if (size == 0) {
            head = nodeToInsert;
            tail = nodeToInsert;
        } else {
            nodeToInsert.next = node.next;
            nodeToInsert.prev = node.prev;
            node.next.prev = nodeToInsert;
            node.prev.next = nodeToInsert;
        }
    }

    public void remove(Node node) {
        if (node == head) {
            head = head.next;
            head.prev = null;
            size--;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
            size--;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    public void removeNodesWithValue(int value) {
        Node node = nodeAt(indexOf(value));
        if (node == head) {
            head = head.next;
            head.prev = null;
            size--;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
            size--;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    public boolean containsNodeWithValue(int value) {
        return (indexOf(value) != -1);
    }

    public void add(int data) {
        Node nodeToInsert = new Node(data);
        if (size == 0) {
            head = nodeToInsert;
            tail = nodeToInsert;
            nodeToInsert.prev = null;
            nodeToInsert.next = null;
        } else {
            tail.next = nodeToInsert;
            tail.next.prev = tail;
            tail = nodeToInsert;
        }
        size++;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (nodeAt(i).value == value) return i;
        }
        return -1;
    }

    public Node nodeAt(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) return head;
        if (index == size) return tail;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public String toString() {
        if (head == null) return "[]";
        else {
            String result = "[" + head.value;
            Node current = head.next;
            while (current != null) {
                result += ", " + current.value;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
    public void insertBefore3(Node node, Node nodeToInsert) {
        nodeToInsert.prev = node.prev;
        node.prev = nodeToInsert;
        nodeToInsert.next = node;

        if (nodeToInsert.prev != null){
            nodeToInsert.prev.next = nodeToInsert;
        }

    }

    public void insertBefore2(Node curr,int x) {
        Node newNode=new Node(x);
        // if the node is to be inserted before head
        if(curr==head) {
            newNode.prev=null;
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            return;
        }
        newNode.prev=curr.prev;
        newNode.next=curr;
        curr.prev.next=newNode;
        curr.prev=newNode;
    }

    public Node insertBefore(Node givenNode, int data) {
        Node newNode = new Node(data);
        newNode.prev = givenNode.prev;
        givenNode.prev = newNode;
        newNode.next = givenNode;

        if (newNode.prev != null) {
            newNode.prev.next = newNode;
        }

        return newNode;
    }
}
    // Do not edit the class below.
    class Node {
        public int value;
        public Node prev;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

