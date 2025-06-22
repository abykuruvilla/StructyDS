package com.kaby.ds.linkedlist;

import static com.kaby.ds.linkedlist.utils.LinkedListUtils.printList;

public class UndupeSortedLinkedList {


    /**
     * Write a function that takes in a linked list that contains values in increasing order.
     * The function should return a new linked list containing the original values, with duplicates removed.
     * The relative order of values in the resulting linked list should be unchanged.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        var a = new Node<>(4);
        var b = new Node<>(4);
        var c = new Node<>(6);
        var d = new Node<>(6);
        var e = new Node<>(6);
        var f = new Node<>(7);
        var g = new Node<>(7);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        // 4 -> 4 -> 6 -> 6 -> 6 -> 7 -> 7

        System.out.println("Expected: 4 -> 6 -> 7");
        System.out.print("Actual: ");
        printList(undupeSortedLinkedList(a)); // 4 -> 6 -> 7
        System.out.println("=====");

        // == test1 ==
        var w = new Node<>(5);
        var x = new Node<>(5);
        var y = new Node<>(5);
        var z = new Node<>(8);

        w.next = x;
        x.next = y;
        y.next = z;

        // 5 -> 5 -> 5 -> 8
        System.out.println("Expected: 5 -> 8");
        System.out.print("Actual: ");
        printList(undupeSortedLinkedList(x)); // 5 -> 8
        System.out.println("=====");

        // == test2 ==
        var p = new Node<>(10);
        var q = new Node<>(20);
        var r = new Node<>(30);

        p.next = q;
        q.next = r;

        // 10 -> 20 -> 30
        System.out.println("Expected: 10 -> 20 -> 30");
        System.out.print("Actual: ");
        printList(undupeSortedLinkedList(p)); // 10 -> 20 -> 30
        System.out.println("=====");

    }

    /**
     * Since the list is sorted:
     * Duplicates will appear next to each other.
     * We can iterate through the original list, compare each node with the previous value.
     * If it's a new value, we add it to a new list.
     * This avoids modifying the original list.
     * @param head
     * @return
     */
    public static Node<Integer> undupeSortedLinkedList(Node<Integer> head) {

        // Base case: if the list is empty or has only one node, return the head
        if(head == null || head.next == null) {
            return head;
        }

        // Create a dummy node to hold the head of the new list
        Node<Integer> dummyNode = new Node<>(0);
        Node<Integer> current = dummyNode;

        // Keep track of the last seen value to avoid adding duplicates
        int lastSeen = Integer.MIN_VALUE;

        // Iterate through the original list, comparing each node with the previous value
        while(head != null) {

            if(head.val != lastSeen) {
                // If the value is new, add it to the new list
                current.next = new Node<>(head.val);
                // Move the current pointer to the next node in the new list
                current = current.next;
                // Update the last seen value
                lastSeen = head.val;
            }

            // Move the head pointer to the next node in the original list
            head = head.next;
        }

        return dummyNode.next;
    }
}
