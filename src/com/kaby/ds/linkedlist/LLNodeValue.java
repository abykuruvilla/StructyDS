package com.kaby.ds.linkedlist;

public class LLNodeValue {

    // Find the value at index provided
    public static void main(String[] args) {
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");

        // A -> B -> C -> D -> null
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println("Iterative Val at 2 , Expected = C ; Actual = " + getLLNodeValue(2, a));
        System.out.println("Iterative Val at 4 , Expected = null ; Actual = " + getLLNodeValue(4, a));
        System.out.println("Recursive Val at 2 , Expected = C ; Actual = " + getLLNodeValueRecursive(2, a));
        System.out.println("Recursive Val at 4 , Expected = null ; Actual = " + getLLNodeValueRecursive(4, a));

    }

    private static String getLLNodeValueRecursive(int index, Node<String> head) {
        // Base case : head is null then return null
        if(head == null) {
            return null;
        }
        // Base case 2: if decremented index position of 0 is reached we are at the element of interest
        if(index == 0) {
            return head.val;
        }

        // Reduce the index by 1 and send the nxt node
        return getLLNodeValueRecursive(index-1, head.next);

    }

    private static String getLLNodeValue(int index, Node<String> head) {
        Node<String> current = head;
        int position = 0;

        while(current != null) {
            if(position == index) {
                return current.val;
            }
            position++;
            current = current.next;
        }

        return null;
    }

}
