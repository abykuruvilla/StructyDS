package com.kaby.ds.binarytree;

import java.util.*;

public class TreePathFinder {


    /**
     * Write a function, pathFinder, that takes in the root of a binary tree and a target value.
     * The function should return an array representing a path to the target value.
     * If the target value is not found in the tree, then return null.
     * <p>
     * You may assume that the tree contains unique values.
     *
     * @param args
     */
    public static void main(String[] args) {

        //        Input Tree Structure
        //                a
        //               / \
        //              b   c
        //             / \   \
        //            d   e   f

        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;

        String[] result = pathFinder(a, "e");
        System.out.println("DFS Recursive: Path to e -> " + Arrays.toString(result));
        String[] result2 = pathFinder(a, "f");
        System.out.println("DFS Recursive: Path to f -> " + Arrays.toString(result2));

    }

    private static String[] pathFinder(Node<String> root, String target) {
        Deque<String> result = pathFinderHelper(root, target);
        return result.toArray(new String[result.size()]);
    }


    private static Deque<String> pathFinderHelper(Node<String> root, String target) {
        // Base case: If the root is null return null
        if (root == null) {
            return null;
        }
        // Base case: If I found my target return an array with the element
        if (root.val.equals(target)) {
            Deque<String> res = new ArrayDeque<>();
            res.add(root.val);
            return res;
        }

        // Recursively call the method on the left and right subtree
        Deque<String> leftPath = pathFinderHelper(root.leftNode, target);
        Deque<String> rightPath = pathFinderHelper(root.rightNode, target);

        // If the leftPath is not null we have a value, so let's add the current root value to it
        if (leftPath != null) {
            leftPath.addFirst(root.val);
            return leftPath;
        }

        // Similarly, if the rightPath is not null we have a found a value on the right sub tree
        if (rightPath != null) {
            rightPath.addFirst(root.val);
            return rightPath;
        }

        // If the left and right subtree did not find a value return null
        return null;
    }
}
