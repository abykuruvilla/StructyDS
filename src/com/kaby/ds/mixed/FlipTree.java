package com.kaby.ds.mixed;

import com.kaby.ds.binarytree.Node;


// BINARY TREE
public class FlipTree {

    /**
     * Write a function, flipTree, that takes in the root of a binary tree.
     * The function should flip the binary tree, turning left subtrees into right subtrees and vice-versa.
     * This flipping should occur in-place by modifying the original tree.
     * The function should return the root of the tree.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00 ==

        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");
        Node<String> h = new Node<>("h");

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;
        e.leftNode = g;
        e.rightNode = h;

        // Original Tree
        //      a
        //    /    \
        //   b      c
        //  / \      \
        // d   e      f
        //    / \
        //    g  h

        Node<String> flipped = flipTree(a);

        // Flipped Tree
        //       a
        //    /    \
        //   c      b
        //  /     /   \
        // f     e    d
        //     /  \
        //    h    g




    }

    // This algorithm has O(n) time and space complexity
    private static Node<String> flipTree(Node<String> root) {

        // Base case: if our root is null we will return null
        if(root == null) {
            return null;
        }

        // We need to flip the tree recursively at every level on the left and right
        // We will get the root of each subtree here
        Node<String> left = flipTree(root.leftNode);
        Node<String> right = flipTree(root.rightNode);

        // Flip the right at left at current level
        root.leftNode = right;
        root.rightNode = left;

        // We need to return the root of the flipped tree
        return root;
    }
}
