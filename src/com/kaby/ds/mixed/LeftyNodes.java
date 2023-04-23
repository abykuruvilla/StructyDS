package com.kaby.ds.mixed;

import com.kaby.ds.binarytree.Node;
import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BINARY TREE
public class LeftyNodes {

    /**
     * Write a function, leftyNodes, that takes in the root of a binary tree.
     * The function should return an array containing the left-most value on every level of the tree.
     * The array must be ordered in a top-down fashion where the root is the first element.
     * <p>
     * Note that the left-most node on a level may not necessarily be a left child.
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

        //      a
        //    /    \
        //   b      c
        //  / \      \
        // d   e      f
        //    / \
        //    g  h

        List<String> actualLeftyNodes1 = leftyNodes(a); // [ 'a', 'b', 'd', 'g' ]
        ResultPair<List<String>, List<String>> resultPair1 = new ResultPair<>("Left Nodes for tree", Arrays.asList("a", "b", "d", "g"), actualLeftyNodes1);
        resultPair1.printResultPair();

        // ===============

        // == test_01 ==

        Node<String> u = new Node<>("u");
        Node<String> t = new Node<>("t");
        Node<String> s = new Node<>("s");
        Node<String> r = new Node<>("r");
        Node<String> q = new Node<>("q");
        Node<String> p = new Node<>("p");

        u.leftNode = t;
        u.rightNode = s;
        s.rightNode = r;
        r.leftNode = q;
        r.rightNode = p;

        //     u
        //  /    \
        // t      s
        //         \
        //         r
        //        / \
        //        q  p

        List<String> actualLeftyNodes2 = leftyNodes(u); // [ 'u', 't', 'r', 'q' ]
        ResultPair<List<String>, List<String>> resultPair2 = new ResultPair<>("Left Nodes for tree", Arrays.asList("u", "t", "r", "q"), actualLeftyNodes2);
        resultPair2.printResultPair();

    }

    private static List<String> leftyNodes(Node<String> root) {
        // All the "lefty" nodes
        List<String> values = new ArrayList<>();

        // We are checking recursively at every level,root is at level 0
        traverseTree(root, 0, values);

        return values;
    }

    private static void traverseTree(Node<String> root, int level, List<String> values) {
        // Base case : if root is null
        if (root == null) {
            return;
        }

        // Populate the values based on the level we are at. If no value stored at level add to level
        if (values.size() == level) {
            values.add(root.val);
        }

        // If the root node is null let's check on the left and right
        // We update the level to + 1 from previous level
        // Note: Since we are looking at lefty node, we are also traversing left to right in our DFS
        // NOTE: So if at a level, the left node is null we will add the right node to the values
        traverseTree(root.leftNode, level + 1, values);
        traverseTree(root.rightNode, level + 1, values);
    }
}
