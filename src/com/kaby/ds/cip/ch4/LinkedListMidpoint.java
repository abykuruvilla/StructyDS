package com.kaby.ds.cip.ch4;

import com.kaby.ds.helper.ResultPair;
import com.kaby.ds.linkedlist.Node;

public class LinkedListMidpoint {


    /**
     * Finds and returns the middle node of a singly linked list.
     * If there are two middle nodes, it returns the second one.
     * The time complexity is O(n) because we traverse the linked list linearly
     * The space complexity is O(1)
     *
     * @param head The head of the linked list to find the midpoint from.
     * @return The value of the middle node, or null if the list has an even number of elements.
     */
    private Node<Integer> linkedListMidpoint(Node<Integer> head) {

        // Using slow and fast pointers
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        // When the fast pointer reaches the end of the list,
        // the slow pointer will be at the midpoint of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    /**
     * Given a singly linked list, find and return the middle node.
     * If there are two middle nodes return the second one
     * @param args
     */
    public static void main(String[] args) {

        // == test 0 ==
        Node<Integer> head = new Node<>(1);
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n2 = new Node<>(4);
        Node<Integer> n3 = new Node<>(7);
        Node<Integer> n4 = new Node<>(3);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        LinkedListMidpoint linkedListMidpoint = new LinkedListMidpoint();
        int res1 = linkedListMidpoint.linkedListMidpoint(head).val;
        ResultPair<Integer, Integer> resultPair = new ResultPair<>("The middle node value is ", 4, res1);
        resultPair.assertMatch();


        // == test 1 ==
        Node<Integer> head2 = new Node<>(1);
        Node<Integer> n5 = new Node<>(2);
        Node<Integer> n6 = new Node<>(3);
        Node<Integer> n7 = new Node<>(7);

        head2.next = n5;
        n5.next = n6;
        n6.next = n7;

        int res2 = linkedListMidpoint.linkedListMidpoint(head2).val;
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("The middle node value is ", 3, res2);
        resultPair2.assertMatch();

    }


}
