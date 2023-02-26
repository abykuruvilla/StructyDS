package com.kaby.ds.linkedlist;

public class PrintLinkedList {


    public static void main(String[] args) {
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");

        // A -> B -> C -> D -> null
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println("Iterative Print");
        printLL(a);
        System.out.println("Recursive Print");
        printLLRecursive(a);

    }

    private static void printLLRecursive(Node<String> head) {
        // If head (currentNode of each subset) is null return
        if(head == null) {
            return;
        }
        // Print value of current node
        System.out.println(head.val);
        // Call recursively with next node as new head
        printLLRecursive(head.next);
    }

    private static void printLL(Node<String> head) {
        Node<String> current = head;

        while(current != null) {
            System.out.println(current.val);
            current = current.next;
        }

    }
}
