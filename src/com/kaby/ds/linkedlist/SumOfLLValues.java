package com.kaby.ds.linkedlist;

public class SumOfLLValues {

    /**
     * Write a function, sumList, that takes in the head of a linked list containing numbers as an argument.
     * The function should return the total sum of all values in the linked list.
     *
     * @param args
     */
    public static void main(String[] args) {
        Node<Integer> a = new Node<>(2);
        Node<Integer> b = new Node<>(8);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(-1);
        Node<Integer> e = new Node<>(7);

        // A -> B -> C -> D -> E -> null
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println("Sum of values of list; Expected = 19: Actual = " + sumOfLLValues(a));
        System.out.println("Sum of values of list; Expected = 19: Actual = " + sumOfLLValuesRecursive(a));

    }

    private static Integer sumOfLLValues(Node<Integer> head) {

        int totalSum = 0;
        Node<Integer> current = head;

        while(current != null) {
            totalSum += current.val;
            current = current.next;
        }
        return totalSum;
    }

    private static Integer sumOfLLValuesRecursive(Node<Integer> head) {
        if(head == null) {
            return 0;
        }
        return head.val + sumOfLLValuesRecursive(head.next);
    }

}
