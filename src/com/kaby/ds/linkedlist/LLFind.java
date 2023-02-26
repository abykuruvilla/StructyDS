package com.kaby.ds.linkedlist;

public class LLFind {

    // Find if a target element is contained in the linked list
    public static void main(String[] args) {
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");

        // A -> B -> C -> D -> null
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println("Iterative Find C , Expected = true ; Actual = " + llFind("C", a));
        System.out.println("Iterative Find G , Expected = false ; Actual = " + llFind("G", a));
        System.out.println("Recursive Find C , Expected = true ; Actual = " + llFindRecursive("C", a));
        System.out.println("Recursive Find G , Expected = false ; Actual = " + llFindRecursive("G", a));

    }

    // O(n) time O(n) space for the call stack
    private static Boolean llFindRecursive(String target, Node<String> head) {

        // Base case 1: Head is null, in that case return false
        // Base case 2: Head equal the target, in that case return true
        if(head == null) {
            return Boolean.FALSE;
        }
        if(head.val.equals(target)) {
            return Boolean.TRUE;
        }

        // Call the function recursively and move the output up
        return llFindRecursive(target, head.next);
    }

    // O(n) time and O(1) space
    private static Boolean llFind(String target, Node<String> head) {
        Node<String> current = head;

        while(current != null) {
            if(current.val.equals(target)) {
                return Boolean.TRUE;
            }
            current = current.next;
        }

        return Boolean.FALSE;
    }

}
