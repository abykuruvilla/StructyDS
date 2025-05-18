package com.kaby.ds.linkedlist;

import com.kaby.ds.linkedlist.utils.LinkedListUtils;

public class InsertLLNode {

    /**
     * Write a function, insert_node, that takes in the head of a linked list, a value, and an index.
     * The function should insert a new node with the value into the list at the specified index.
     * Consider the head of the linked list as index 0.
     * The function should return the head of the resulting linked list.
     *
     * Do this in-place.
     *
     * You may assume that the input list is non-empty and the index is not greater than the length of the input list.
     * @param args
     */
    public static void main(String[] args) {
        
        // == test0 ==
        Node<String> a = new Node<String>("a");
        Node<String> b = new Node<String>("b");
        Node<String> c = new Node<String>("c");
        Node<String> d = new Node<String>("d");

        a.next = b;
        b.next = c;
        c.next = d;

        // Insert 'x' at index 2
        Node<String> updatedHead = insertNode(a, "x", 2);
        System.out.println("test 0: Insert 'x' at index 2, Expected: a -> b -> x -> c -> d");
        System.out.print("Actual: ");
        LinkedListUtils.printList(updatedHead); // a -> b -> x -> c -> d

        // == test1 ==
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");
        Node<String> h = new Node<>("h");

        e.next = f;
        f.next = g;
        g.next = h;

        // Insert 'a' at index 0
        Node<String> updatedHead2 = insertNode(e, "a", 0); // a -> e -> f -> g -> h
        System.out.println("test 1: Insert 'a' at index 0, Expected: a -> e -> f -> g -> h");
        System.out.print("Actual: ");
        LinkedListUtils.printList(updatedHead2);

        // == test2 ==
        Node<String> a1 = new Node<String>("a");
        Node<String> b1 = new Node<String>("b");
        Node<String> c1 = new Node<String>("c");
        Node<String> d1 = new Node<String>("d");

        a1.next = b1;
        b1.next = c1;
        c1.next = d1;

        // Insert 'x' at index 2
        Node<String> updatedHead3 = insertNodeRecursive(a1, "x", 2);
        System.out.println("test2 Recursive: Insert 'x' at index 2, Expected: a -> b -> x -> c -> d");
        System.out.print("Actual: ");
        LinkedListUtils.printList(updatedHead3); // a -> b -> x -> c -> d
    }

    private static Node<String> insertNode(Node<String> head, String value, int index) {

        // Create the new node
        Node<String> newNode = new Node<>(value);

        // Special case: inserting at the head
        if(index == 0) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        int position = 0;

        // traverse the list till before the position to insert new node
        while(current != null && position < index - 1) {
            current = current.next;
            position++;
        }

        // Insert the new node here
        newNode.next = current.next;
        current.next = newNode;

        return head;

    }

    // recursive
    public static Node insertNodeRecursive(Node head, String value, int index) {

        // BASE CASE: we are inserting new node at index 0
        if(index == 0) {
            Node newNode = new Node(value);
            newNode.next = head;
            return newNode;
        }

        // Recursive Case: Recurse with head.next, decreasing the index,
        // and once the correct position is found, insert the node and rebuild the list on the way back up.
        head.next = insertNodeRecursive(head.next, value, index-1);

        return head;
    }

}
