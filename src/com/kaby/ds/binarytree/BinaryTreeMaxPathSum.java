package com.kaby.ds.binarytree;

public class BinaryTreeMaxPathSum {


    public static Integer maxPathSumRecursive(Node<Integer> root) {
        // For a null node return negative infinity / MIN_VALUE
        if(root == null) {
            return Integer.MIN_VALUE;
        }

        // If it's a leaf node then return the value of the node
        if(root.leftNode == null && root.rightNode == null) {
            return root.val;
        }

        // Solving recursively we want the max of the left of right subtree of the node
        return root.val + Math.max(maxPathSumRecursive(root.leftNode), maxPathSumRecursive(root.rightNode));
    }

    //        Input Tree Structure
    //                5
    //               / \
    //              11   3
    //             / \    \
    //            4   2   1

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(11);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(2);
        Node<Integer> f = new Node<>(1);

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;

        System.out.println("Recursive -> Expected value = 20, Actual value = " + maxPathSumRecursive(a));
    }


}
