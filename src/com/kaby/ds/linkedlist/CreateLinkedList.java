package com.kaby.ds.linkedlist;

import static com.kaby.ds.linkedlist.utils.LinkedListUtils.printList;

public class CreateLinkedList {

    /**
     * Write a function, createLinkedList, that takes in an array of values as an argument.
     * The function should create a linked list containing each element of the array as the values of the nodes.
     * The function should return the head of the linked list.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        System.out.println("Expected: h -> e -> y");
        System.out.print("Actual: ");
        printList(createLinkedList(new String[]{"h", "e", "y"})); // h -> e -> y
        System.out.println("=====");

        // == test1 ==
        System.out.println("Expected: a");
        System.out.print("Actual: ");
        printList(createLinkedList(new String[]{"a"})); // a
        System.out.println("=====");

        // == test2 ==
        System.out.println("Expected: null");
        System.out.print("Actual: ");
        printList(createLinkedList(new String[]{})); // null
        System.out.println("=====");

        // == test0 ==
        System.out.println("Expected (recursive): h -> e -> y");
        System.out.print("Actual: ");
        printList(createLinkedListRecursive(new String[]{"h", "e", "y"})); // h -> e -> y
        System.out.println("=====");



    }

    // Recursive approach
    // Time complexity: O(n)
    // Space complexity: O(n)
    // where n is the number of elements in the array
    // We can create a dummy node to hold the head of the linked list and then append new nodes to the end of the linked list.
    private static Node<Object> createLinkedListRecursive(String[] values) {

        // Base case: if the array is empty, return null
        if(values == null || values.length == 0) {
            return null;
        }

        // Create a dummy node to hold the head of the linked list
        Node<Object> head = new Node<>(values[0]);
        // Recursive call to create the rest of the linked list
        head.next = createLinkedListRecursive(java.util.Arrays.copyOfRange(values, 1, values.length));

        // Return the head of the linked list
        return head;
    }

    // Iterative approach
    private static Node<String> createLinkedList(String[] values) {

        // Base case: if the array is empty, return null
        if(values == null || values.length == 0) {
            return null;
        }

        // Create a dummy node to hold the head of the linked list
        Node<String> head = new Node<>(values[0]);
        // Track current tail node to append new nodes to the end of the linked list
        Node<String> current = head;

        // Iterate through the array and create new nodes for each value
        for(int i = 1; i < values.length; i++) {
            current.next = new Node<>(values[i]);
            current = current.next;
        }

        // Return the head of the linked list
        return head;
    }



}
