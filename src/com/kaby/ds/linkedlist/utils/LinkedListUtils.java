package com.kaby.ds.linkedlist.utils;

import com.kaby.ds.linkedlist.Node;

import java.util.HashSet;
import java.util.Set;

public class LinkedListUtils {

    // Print a circular linked list with loop-back ASCII art
    public static <T> void printCircularListAscii(Node<T> head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }

        // First line: list traversal
        Node<T> current = head;
        StringBuilder line1 = new StringBuilder();
        int headStartIndex = 0;
        boolean first = true;

        do {
            if (!first) {
                line1.append(" -> ");
            } else {
                headStartIndex = line1.length();
                first = false;
            }
            line1.append(current.val.toString());
            current = current.next;
        } while (current != head);

        line1.append(" --|");

        // Second line: loop-back arrow
        StringBuilder line2 = new StringBuilder(" ".repeat(headStartIndex));
        line2.append("^");
        for (int i = headStartIndex + 1; i < line1.length(); i++) {
            line2.append("-");
        }
        line2.append("|");

        System.out.println(line1);
        System.out.println(line2);
    }

    // Print a list that is possibly cyclic
    public static <T> void printPossiblyCyclicList(Node<T> head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }

        Set<Node<T>> visited = new HashSet<>();
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.val);

            if (visited.contains(current)) {
                System.out.print(" (cycle detected back to " + current.val + ")");
                break;
            }

            visited.add(current);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    // Regular print method for singly linked list
    public static <T> void printList(Node<T> head) {
        if(head == null) {
            System.out.println("(empty list)");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

}
