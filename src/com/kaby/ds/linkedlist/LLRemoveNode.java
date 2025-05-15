package com.kaby.ds.linkedlist;

import com.kaby.ds.linkedlist.utils.LinkedListUtils;

import java.util.HashSet;
import java.util.Set;

import static com.kaby.ds.linkedlist.utils.LinkedListUtils.printList;

public class LLRemoveNode {

    /**
     * Write a function, remove_node, that takes in the head of a linked list and a target value as arguments.
     * The function should delete the node containing the target value from the linked list and return the head of the resulting linked list.
     * If the target appears multiple times in the linked list, only remove the first instance of the target in the list.
     *
     * Do this in-place.
     * You may assume that the input list is non-empty.
     * You may assume that the input list contains the target.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        // a -> b -> c -> d -> e -> f, remove "c"
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println("Test 0: ");
        System.out.println("Expected: a -> b -> d -> e -> f");
        System.out.print("Actual: ");
        printList(removeNode(a, "c")); // Expected: a -> b -> d -> e -> f

        // == test1 ==
        // x -> y -> z, remove "z"
        Node<String> x = new Node<>("x");
        Node<String> y = new Node<>("y");
        Node<String> z = new Node<>("z");
        x.next = y;
        y.next = z;

        System.out.println("Test 1: ");
        System.out.println("Expected: x -> y");
        System.out.print("Actual: ");
        printList(removeNode(x, "z")); // Expected: x -> y

        // == test2 ==
        // q -> r -> s, remove "q"
        Node<String> q = new Node<>("q");
        Node<String> r = new Node<>("r");
        Node<String> s = new Node<>("s");
        q.next = r;
        r.next = s;

        System.out.println("Test 2: ");
        System.out.println("Expected: r -> s");
        System.out.print("Actual: ");
        printList(removeNode(q, "q")); // Expected: r -> s

        // == test3 ==
        // h -> i -> j -> i, remove first "i"
        Node<String> h = new Node<>("h");
        Node<String> i1 = new Node<>("i");
        Node<String> j = new Node<>("j");
        Node<String> i2 = new Node<>("i");
        h.next = i1;
        i1.next = j;
        j.next = i2;
        System.out.println("Test 3: ");
        System.out.println("Expected: h -> j -> i: ");
        System.out.print("Actual: ");
//        printList(removeNode(h, "i")); // Expected: h -> j -> i
        printList(removeNodeRecursive(h, "i"));

        // == test4 ==
        // t, remove "t" (only node)
        Node<String> t = new Node<>("t");
        System.out.println("Test 4: ");
        System.out.println("Expected: (empty list): ");
        System.out.print("Actual: ");
        printList(removeNode(t, "t")); // Expected: (empty)

    }

    // iterative
    private static Node<String> removeNode(Node<String> head, String target) {

        // If head node contains the target value
        if(head != null && head.val.equals(target)) {
            return head.next;
        }

        Node<String> current = head;

        // Search for node with target value
        while(current.next != null) {
            if(current.next.val.equals(target)) {
                // Remove the target value by updating the next pointer
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }

        return head;
    }

    // recursive
    private static Node<String> removeNodeRecursive(Node<String> head, String target) {
        // BASE CASE : if node is null
        if(head == null) {
            return null;
        }

        // if current node is the target, return the next node
        if(head.val.equals(target)) {
            return head.next;
        }

        head.next = removeNodeRecursive(head.next, target);

        return head;
    }


}
