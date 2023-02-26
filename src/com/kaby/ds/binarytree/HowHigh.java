package com.kaby.ds.binarytree;

public class HowHigh {

    /**
     * Write a function, howHigh, that takes in the root of a binary tree.
     * The function should return a number representing the height of the tree.
     * <p>
     * The height of a binary tree is defined as the maximal number of edges from the root node
     * to any leaf node.
     * <p>
     * If the tree is empty, return -1.
     *
     * @param args
     */
    public static void main(String[] args) {

        // ==Test 1==
        Node<String> a = new Node<String>("a");
        Node<String> b = new Node<String>("b");
        Node<String> c = new Node<String>("c");
        Node<String> d = new Node<String>("d");
        Node<String> e = new Node<String>("e");
        Node<String> f = new Node<String>("f");

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f

        System.out.println("Expected height = 2; Actual = " + howHigh(a)); // -> 2
        System.out.println("Expected height = 0; Actual = " + howHigh(d)); // -> 0
        System.out.println("Expected height = 1; Actual = " + howHigh(c)); // -> 1
        System.out.println("Expected height = 1; Actual = " + howHigh(b)); // -> 1
        System.out.println("Expected height = -1; Actual = " + howHigh(null)); // -> -1


    }

    private static Integer howHigh(Node<String> root) {
        // If the node is null return a height of -1
        if(root == null) {
            return -1;
        }

//        // Not needed!!! If there is only one node or for the leaves return a height of 0
//        if(root.leftNode == null && root.rightNode == null) {
//            return 0;
//        }

        int leftNodeHeight = howHigh(root.leftNode);
        int rightNodeHeight = howHigh(root.rightNode);

        // The height of the node is the max of left and right subtree with 1 added (
        return Math.max(leftNodeHeight, rightNodeHeight) + 1;
    }
}
