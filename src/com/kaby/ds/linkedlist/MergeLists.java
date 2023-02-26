package com.kaby.ds.linkedlist;

import java.util.List;

public class MergeLists {

    /**
     * Write a function, mergeLists, that takes in the head of two sorted linked lists as arguments.
     * The function should merge the two lists together into single sorted linked list.
     * The function should return the head of the merged linked list.
     * <p>
     * Do this in-place, by mutating the original Nodes.
     * <p>
     * You may assume that both input lists are non-empty and contain increasing sorted numbers.
     *
     * @param args
     */
    public static void main(String[] args) {

        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(7);
        Node<Integer> c = new Node<>(10);
        Node<Integer> d = new Node<>(12);
        Node<Integer> e = new Node<>(20);
        Node<Integer> f = new Node<>(28);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        // 5 -> 7 -> 10 -> 12 -> 20 -> 28

        Node<Integer> q = new Node<>(1);
        Node<Integer> r = new Node<>(8);
        Node<Integer> s = new Node<>(9);
        Node<Integer> t = new Node<>(10);
        q.next = r;
        r.next = s;
        s.next = t;
        // 1 -> 8 -> 9 -> 10

        Node<Integer> result = mergeLists(a, q);
        // 1 -> 5 -> 7 -> 8 -> 9 -> 10 -> 10 -> 12 -> 20 -> 28

        while(result.next != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }

    }

    private static Node<Integer> mergeLists(Node<Integer> a, Node<Integer> b) {

        Node<Integer> currentA = a;
        Node<Integer> currentB = b;

        // Track the merged head
        Node<Integer> mergedHead = null;
        Node<Integer> mergedTail = mergedHead;

        // Initialize mergedHead to lowest value
        if(currentA.val < currentB.val) {
            mergedHead = currentA;
            mergedTail = mergedHead;
            currentA = currentA.next;
        } else {
            mergedHead = currentB;
            mergedTail = mergedHead;
            currentB = currentB.next;
        }

        while(currentA.next != null && currentB.next != null) {
            if(currentA.val < currentB.val) {
                mergedTail.next = currentA;
                currentA = currentA.next;
            } else {
                mergedTail.next = currentB;
                currentB = currentB.next;
            }
            mergedTail = mergedTail.next;
        }

        if(currentA.next != null && currentB.next == null) {
            mergedTail.next = currentA;
        }

        if(currentA.next == null && currentB.next != null) {
            mergedTail.next = currentB;
        }

        return mergedHead;
    }
}
