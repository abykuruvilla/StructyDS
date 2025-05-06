package com.kaby.ds.mixed;


import com.kaby.ds.binarytree.Node;
import com.kaby.ds.helper.ResultPair;

import java.util.*;

// BINARY TREE
public class LowestCommonAncestor {


    /**
     * Write a function, lowestCommonAncestor, that takes in the root of a binary tree and two values.
     * The function should return the value of the lowest common ancestor of the two values in the tree.
     * <p>
     * You may assume that the tree values are unique and the tree is non-empty.
     * <p>
     * Note that a node may be considered an ancestor of itself.
     *
     * @param args
     */
    public static void main(String[] args) {


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

        //      a
        //    /    \
        //   b      c
        //  / \      \
        // d   e      f
        //    / \
        //    g  h

        // == test_00 ==
        String lowestCommonAncestor1 = lowestCommonAncestor(a, "d", "h"); // b
        ResultPair<String, String> resultPair1 = new ResultPair<>("Lowest common ancestor of d and h is", "b", lowestCommonAncestor1);
        resultPair1.assertMatch();

        // == test_01 ==
        String lowestCommonAncestor2 = lowestCommonAncestor(a, "d", "g"); // b
        ResultPair<String, String> resultPair2 = new ResultPair<>("Lowest common ancestor of d and g is", "b", lowestCommonAncestor2);
        resultPair2.assertMatch();

        // == test_02 ==
        String lowestCommonAncestor3 = lowestCommonAncestor(a, "g", "c"); // a
        ResultPair<String, String> resultPair3 = new ResultPair<>("Lowest common ancestor of g and c is", "a", lowestCommonAncestor3);
        resultPair3.assertMatch();

        // == test_03 ==
        String lowestCommonAncestor4 = lowestCommonAncestor(a, "b", "g"); // b
        ResultPair<String, String> resultPair4 = new ResultPair<>("Lowest common ancestor of b and g is", "b", lowestCommonAncestor4);
        resultPair4.assertMatch();

        // == test_04 ==
        String lowestCommonAncestor5 = lowestCommonAncestor(a, "f", "c"); // c
        ResultPair<String, String> resultPair5 = new ResultPair<>("Lowest common ancestor of f and c is", "c", lowestCommonAncestor5);
        resultPair5.assertMatch();


    }

    // The time complexity is about O(4n) which simplifies to O(n)
    private static String lowestCommonAncestor(Node<String> root, String val1, String val2) {

        // Get the path from root to val1
        List<String> path1 = getPath(root, val1);
        // Get the path from root to val2
        List<String> path2 = getPath(root, val2);
        // Let's convert the second path to a set, to reduce lookup time to O(1)
        Set<String> path2AsSet = new HashSet<>(path2);

        // Iterate over the first path and check if the second path contains it
        // The first repeating element is the lowest common ancestor
        // Ex getPath(root, d) = [d, b, a]
        // getPath(root, h) = [e, b, a]
        // Hence lowest ancestor is b
        for(String val : path1) {

            if(path2AsSet.contains(val)) {
                return val;
            }
        }

        return null;
    }

    // Helper function to get a path from root node to target value
    // In above test if we call this with getPath(root, "g") we should get [g, e, b, a]
    // Type of DFS
    private static List<String> getPath(Node<String> root, String targetVal) {

        // Base case - if root is null return a null
        if(root == null) {
            return null;
        }

        // Base Case 2 - if root has the target value we were looking for
        if(root.val.equals(targetVal)) {
            return new ArrayList<>(Arrays.asList(root.val));
        }

        // The target value might be in the left or right subtree.
        // Recursively call the getPath for left subtree with same target value
        List<String> leftPath = getPath(root.leftNode, targetVal);
        if(leftPath != null) {
            leftPath.add(root.val);
            return leftPath;
        }

        // Recursively call the getPath for right subtree with same target value
        List<String> rightPath = getPath(root.rightNode, targetVal);
        if(rightPath != null) {
            rightPath.add(root.val);
            return rightPath;
        }

        return null;

    }
}
