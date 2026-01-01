package com.kaby.ds.cip.ch4;

import com.kaby.ds.helper.ResultPair;
import com.kaby.ds.linkedlist.Node;

import java.util.HashSet;
import java.util.Set;

public class LinkedListLoop {


    /**
     * This is Floyd's Cycle Detection algorithm
     * Determines if a singly linked list contains a cycle using the optimized approach.
     * It uses slow and fast pointers to optimize for space
     * It has a time complexity of O(n) and space complexity of O(1)
     *
     * @param head The head of the linked list to check for cycles.
     * @return True if the linked list contains a cycle, false otherwise.
     */
    private boolean linkedListLoopOptimized(Node<Integer> head) {
        // Using fast and slow pointers
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        // Check both fast and fast.next to avoid NPE
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    /**
     * Determines if a singly linked list contains a cycle by traversing the list and tracking visited nodes using a HashSet.
     * This approach has O(n) time but also uses O(n) space due to the HashSet
     *
     * @param head The head of the linked list to check for cycles.
     * @return True if the linked list contains a cycle, false otherwise.
     */
    private boolean linkedListLoopNaive(Node<Integer> head) {
        Set<Node<Integer>> visited = new HashSet<>(); // track nodes that were visited

        Node<Integer> cur = head;
        while (cur != null) {
            // Cycle is detected if the curr node is in the visited set
            if (visited.contains(cur)) {
                return true;
            }
            visited.add(cur);
            cur = cur.next;
        }

        return false;
    }


    /**
     * Given a singly linked list, determine if it contains a cycle
     * (a node's next pointer references an earlier node in the list causing a loop)
     * @param args
     */
    public static void main(String[] args) {

        Node<Integer>  head = new Node<>(0);
        Node<Integer>  n1 = new Node<>(1);
        Node<Integer>  n2 = new Node<>(2);
        Node<Integer>  n3 = new Node<>(3);
        Node<Integer>  n4 = new Node<>(4);
        Node<Integer>  n5 = new Node<>(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        LinkedListLoop linkedListLoop = new LinkedListLoop();
        boolean result1 = linkedListLoop.linkedListLoopNaive(head);
        ResultPair<Boolean, Boolean> resultPair = new ResultPair<>("Naive Approach - Is there a loop ? ", true, result1);
        resultPair.assertMatch();

        boolean result2 = linkedListLoop.linkedListLoopOptimized(head);
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Optimized Approach - Is there a loop ? ", true, result2);
        resultPair2.assertMatch();

    }

}
