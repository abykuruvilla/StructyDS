package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;
import com.kaby.ds.linkedlist.Node;

import java.util.ArrayList;
import java.util.Collections;

// LINKED LIST
public class LinkedPalindrome {

    /**
     * Write a function, linkedPalindrome, that takes in the head of a linked list as an argument.
     * The function should return a boolean indicating whether or not the linked list is a palindrome.
     * A palindrome is a sequence that is the same both forwards and backwards.
     *
     * @param args
     */
    public static void main(String[] args) {

        // === test_00: ===

        Node<Integer> a = new Node<>(3);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(7);
        Node<Integer> d = new Node<>(7);
        Node<Integer> e = new Node<>(2);
        Node<Integer> f = new Node<>(3);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        // 3 -> 2 -> 7 -> 7 -> 2 -> 3
        boolean actualResult = linkedPalindrome(a); // true
        ResultPair<Boolean, Boolean> resultPair = new ResultPair<>("Is 3 -> 2 -> 7 -> 7 -> 2 -> 3 a linked palindrome ", Boolean.TRUE, actualResult);
        resultPair.printResultPair();

        // =========================

        // === test_01: ===

        Node<Integer> a1 = new Node<>(3);
        Node<Integer> b1 = new Node<>(2);
        Node<Integer> c1 = new Node<>(4);

        a1.next = b1;
        b1.next = c1;


        // 3 -> 2 -> 4
        boolean actualResult2 = linkedPalindrome(a1); // false

        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Is 3 -> 2 -> 4 a linked palindrome ", Boolean.FALSE, actualResult2);
        resultPair1.printResultPair();

        // =========================

    }

    private static boolean linkedPalindrome(Node<Integer> head) {

        var values = new ArrayList<Integer>();
        var current = head;

        while (current != null) {
            // Iterate over the linked list and store each element in a list
            values.add(current.val);

            // Go to next node
            current = current.next;
        }

        // Reverse the list and check to see if both the lists are the same
        var reverseValues = new ArrayList<>(values);
        Collections.reverse(reverseValues);

        return values.equals(reverseValues);
    }

}
