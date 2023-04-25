package com.kaby.ds.linkedlist;

public class ZipperedLists {


    /**
     * Write a function, zipperLists, that takes in the head of two linked lists as arguments.
     * The function should zipper the two lists together into single linked list by alternating nodes.
     * If one of the linked lists is longer than the other, the resulting list should terminate with
     * the remaining nodes. The function should return the head of the zippered linked list.
     *
     * Do this in-place, by mutating the original Nodes.
     *
     * You may assume that both input lists are non-empty.
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

        Node<String> x = new Node<>("X");
        Node<String> y = new Node<>("Y");
        Node<String> z = new Node<>("Z");

        // X -> Y -> Z -> null
        x.next = y;
        y.next = z;

//        System.out.println("Iterative Print");
//        Node<String> zipperListHead = zipperLists(a, x);
//        printLL(zipperListHead);
        System.out.println("Recursive Print");
        Node<String> zipperListHead2 = zipperListsRecursive(a, x);
        printLL(zipperListHead2);


    }

    private static Node<String> zipperListsRecursive(Node<String> head1, Node<String> head2) {
        // Base Case 1 - if head1 and head2 are null return null
        if(head1 == null && head2 == null) {
            return null;
        }
        // Base Case 2 - if second list has more elements
        if(head1 == null) {
            return head2;
        }
        // Base Case 3 - if first list has more elements
        if(head2 == null) {
            return head1;
        }
        // Track next nodes so that we do not lose track of these when we run our recursive code below
        Node<String> next1 = head1.next;
        Node<String> next2 = head2.next;

        // Our recursive code
        head1.next = head2;
        head2.next = zipperListsRecursive(next1, next2);

        return head1;
    }

    private static Node<String> zipperLists(Node<String> head1, Node<String> head2) {
        // The head of the zip list is head1
        Node<String> zipperedHead = head1;
        // Track the tail of the zip list
        Node<String> zipperedTail = zipperedHead;
        // Pointers to track current node in each list
        Node<String> current1 = head1.next;
        Node<String> current2 = head2;

        // If the count is even we add the node from the second list
        int count = 0;

        // We only loop until either of the lists hits it's end,
        // this is so that we can tack on the remaining list if they are of unequal lengths
        while(current1 != null && current2 != null) {
            if(count % 2 == 0) {
                zipperedTail.next = current2;
                current2 = current2.next;
            } else {
                zipperedTail.next = current1;
                current1 = current1.next;
            }
            // Move along the tail
            zipperedTail = zipperedTail.next;
            // Update the count
            count += 1;
        }

        // In case there are more elements remaining tack then to the tail
        if(current1 != null) {
            zipperedTail.next = current1;
        }
        if(current2 != null) {
            zipperedTail.next = current2;
        }

        return zipperedHead;
    }

    private static void printLL(Node<String> head) {
        Node<String> current = head;

        while(current != null) {
            System.out.println(current.val);
            current = current.next;
        }

    }

}
