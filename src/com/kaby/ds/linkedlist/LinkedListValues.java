package com.kaby.ds.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListValues {

    /**
     * Write a function, linkedListValues, that takes in the head of a linked list as an argument.
     * The function should return an array containing all values of the nodes in the linked list.
     * @param args
     */
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
        System.out.println(Arrays.toString(llValues(a)));
        System.out.println("Recursive Print");
        System.out.println(llValuesRecursive(a));

    }

    // Iterative
    private static String[] llValues(Node<String> head) {
        List<String> listElements = new ArrayList<>();

        Node<String> current = head;
        while(current != null) {
            listElements.add(current.val);
            current = current.next;
        }

        return listElements.toArray(new String[listElements.size()]);
    }

    // Recursive - Both Iterative have complexity of O(N)
    private static List<String> llValuesRecursive(Node<String> head) {
        List<String> listElements = new ArrayList<>();
        // Helper function to fill the list recursively
        fillValues(listElements, head);
        return listElements;
    }

    private static void fillValues(List<String> listElements, Node<String> head) {
        // if head is null we have reached the end of the list
        if(head == null) {
            return;
        }
        // If not the end of the list add the val to the list
        listElements.add(head.val);
        // Call the fill helper recursively with the next node as new head
        fillValues(listElements, head.next);
    }
}
