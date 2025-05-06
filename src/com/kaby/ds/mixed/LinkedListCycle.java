package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;
import com.kaby.ds.linkedlist.Node;

import java.util.HashSet;
import java.util.Set;


// LINKED LIST
public class LinkedListCycle {


    /**
     * Write a function, linkedListCycle, that takes in the head of a linked list as an argument.
     * The function should return a boolean indicating whether or not the linked list contains a cycle.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b; // cycle

        //         _______
        //       /        \
        // a -> b -> c -> d
        Boolean isCycle = linkedListCycleUsingSet(a);  // true
        ResultPair<Boolean, Boolean> resultPair = new ResultPair<>("Is a -> b -> c -> d -> b a cycle ", Boolean.TRUE, isCycle);
        resultPair.assertMatch();

        Boolean isCycle2 = linkedListCycleUsingTwoPointer(a);  // true
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Is a -> b -> c -> d -> b a cycle ", Boolean.TRUE, isCycle2);
        resultPair2.assertMatch();

        // == test_02 ==

        Node<String> a1 = new Node<>("a");
        Node<String> b1 = new Node<>("b");
        Node<String> c1 = new Node<>("c");
        Node<String> d1 = new Node<>("d");

        a1.next = b1;
        b1.next = c1;
        c1.next = d1;

        // a -> b -> c -> d
        Boolean isCycle3 = linkedListCycleUsingSet(a1);  // false
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Is a -> b -> c -> d a cycle ", Boolean.FALSE, isCycle3);
        resultPair3.assertMatch();

        Boolean isCycle4 = linkedListCycleUsingTwoPointer(a1);  // false
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Is a -> b -> c -> d a cycle ", Boolean.FALSE, isCycle4);
        resultPair4.assertMatch();

    }

    private static Boolean linkedListCycleUsingSet(Node<String> head) {
        Node<String> current = head;
        Set<String> uniqueElements = new HashSet<>();
        Boolean thereIsACycle = Boolean.FALSE;

        // Add each element to a set, if the element is already there we are in a cycle
        while (current != null) {
            if (uniqueElements.contains(current.val)) {
                return Boolean.TRUE;
            }
            uniqueElements.add(current.val);
            current = current.next;
        }

        return thereIsACycle;
    }

    // The slow pointer moves one node and the fast pointer moves 2 nodes at a time
    // If the LL is cyclic both the fast and slow pointer will overlap
    private static Boolean linkedListCycleUsingTwoPointer(Node<String> head) {
        Boolean llIsCyclic = Boolean.FALSE;
        Node<String> slowPointer = head;
        Node<String> fastPointer = head;

        // The fast pointer can land up on the null node or at the node before null
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                return Boolean.TRUE;
            }
        }

        return llIsCyclic;
    }


}
