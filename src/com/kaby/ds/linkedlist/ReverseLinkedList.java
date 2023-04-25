package com.kaby.ds.linkedlist;

public class ReverseLinkedList {

    /**
     * Write a function, reverseList, that takes in the head of a linked list as an argument.
     * The function should reverse the order of the nodes in the linked list in-place and return
     * the new head of the reversed linked list.
     *
     * @param args
     */
    public static void main(String[] args) {
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");

        // A -> B -> C -> D -> null
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println("Iterative Reverse");
        Node<String> reversedHead1 = reverseLL(a);
        printLL(reversedHead1);

        System.out.println("Recursive Reverse");
        Node<String> reversedHead2 = reverseLLRecursive(d, null);
        printLL(reversedHead2);

    }

    private static Node<String> reverseLLRecursive(Node<String> head, Node<String> previous) {
        // Just like the iterative soln if current node is null, the previous is pointing to the new head
        if(head == null) {
            return previous;
        }
        // Keep track the next node without losing it
        Node<String> next = head.next;
        // Get the current node's next to point left
        head.next = previous;

        // next is the new head and head is the new previous
        return reverseLLRecursive(next, head);
    }

    private static Node<String> reverseLL(Node<String> head) {
        // null <- A    B -> C -> D -> null
        //                       prev   cur  next
        Node<String> previous = null;
        Node<String> current = head;
        Node<String> next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    private static void printLL(Node<String> head) {
        Node<String> current = head;

        while(null != current) {
            System.out.println(current.val);
            current = current.next;
        }

    }
}
