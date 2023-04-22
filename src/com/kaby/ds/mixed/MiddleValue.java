package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;
import com.kaby.ds.linkedlist.Node;

import java.util.ArrayList;
import java.util.List;

public class MiddleValue {

    /**
     * Write a function, middleValue, that takes in the head of a linked list as an argument.
     * The function should return the value of the middle node in the linked list.
     * If the linked list has an even number of nodes, then return the value of the second middle node.
     * <p>
     * You may assume that the input list is non-empty.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        Node<String> a = new Node("a");
        Node<String> b = new Node("b");
        Node<String> c = new Node("c");
        Node<String> d = new Node("d");
        Node<String> e = new Node("e");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        // a -> b -> c -> d -> e
        String actualValBF = middleValueBruteForce(a); // c
        ResultPair<String, String> resultPair = new ResultPair<>("BF: The middle value of a -> b -> c -> d -> e is ", "c", actualValBF);
        resultPair.printResultPair();

        // a -> b -> c -> d -> e
        String actualValTwoPointer = middleValueTwoPointer(a); // c
        ResultPair<String, String> resultPair2 = new ResultPair<>("2 Pointer: The middle value of a -> b -> c -> d -> e is ", "c", actualValTwoPointer);
        resultPair2.printResultPair();

        //===================

        // == test_01: ==

        Node<String> a1 = new Node("a");
        Node<String> b1 = new Node("b");
        Node<String> c1 = new Node("c");
        Node<String> d1 = new Node("d");
        Node<String> e1 = new Node("e");
        Node<String> f1 = new Node("f");

        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        e1.next = f1;

        // a -> b -> c -> d -> e -> f
        String actualValBF1 = middleValueBruteForce(a1); // d
        ResultPair<String, String> resultPair3 = new ResultPair<>("BF: The middle value of a -> b -> c -> d -> e -> f is ", "d", actualValBF1);
        resultPair3.printResultPair();

        // a -> b -> c -> d -> e -> f
        String actualValTwoPointer1 = middleValueTwoPointer(a1); // d
        ResultPair<String, String> resultPair4 = new ResultPair<>("2 Pointer: The middle value of a -> b -> c -> d -> e -> f is ", "d", actualValTwoPointer1);
        resultPair4.printResultPair();

    }

    // This solution is O(n) - linear time, and O(1) - constant space
    private static String middleValueTwoPointer(Node<String> head) {

        // Slow pointer moves one position at a time
        Node<String> slowPointer = head;
        // Fast pointer moves 2 nodes at a time
        Node<String> fastPointer = head;

        // Iterate through the LL
        // NOTE: The fast pointer might reach null or the node right before null
        while(!(fastPointer == null || fastPointer.next == null)) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer.val;

    }


    // This solution is linear time and space i.e. O(n)
    private static String middleValueBruteForce(Node<String> head) {
        List<String> values = new ArrayList<>();
        Node<String> current = head;

        // Last node of a LL is null
        while(current != null) {
            // Store each value in the list
            values.add(current.val);
            current = current.next;
        }

        // Using the size find the middle position
        int middlePosition = values.size()/2;

        return values.get(middlePosition);
    }

}
