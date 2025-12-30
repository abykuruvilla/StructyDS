package com.kaby.ds.cip.ch3;

import com.kaby.ds.helper.ResultPair;
import com.kaby.ds.linkedlist.Node;

public class LinkedListIntersection {


    /**
     * Return the node where two singly linked lists intersect. If the linked lists don't intersect, return null
     * @param args
     */
    public static void main(String[] args) {

        Node<Integer> head1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(3);
        Node<Integer> node3 = new Node<>(4);
        Node<Integer> node4 = new Node<>(8);
        Node<Integer> node5 = new Node<>(7);
        Node<Integer> node6 = new Node<>(2);
        Node<Integer> head2 = new Node<>(6);
        Node<Integer> node7 = new Node<>(4);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        head2.next = node7;
        node7.next = node4;

        Node<Integer> intersectingNode = linkedListIntersection(head1, head2);
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Intersecting node is : ", 8, intersectingNode.val);
        resultPair1.assertMatch();

    }

    private static Node<Integer> linkedListIntersection(Node<Integer> head1, Node<Integer> head2) {

        Node<Integer> ptr1 = head1;
        Node<Integer> ptr2 = head2;

        // Traverse through List1 with ptr1 and List2 with ptr2 until they have met
        while (ptr1 != ptr2) {
            // Traverse List1 -> List2 by first traversing ptr1 and then, upon reaching the end of List1,
            // continue the traversal from the head of List2
            if(ptr1 != null) {
                ptr1 = ptr1.next;
            } else {
                ptr1 = head2;
            }

            // Simultaneously, traverse List2 -> List1
            if(ptr2 != null) {
                ptr2 = ptr2.next;
            } else {
                ptr2 = head1;
            }
        }

        // At this point , ptr1 and ptr2 either point to the intersection node or both are null if the lists do not intersect.
        // Return either pointer
        return ptr1;

    }
}
