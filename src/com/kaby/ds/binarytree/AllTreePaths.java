package com.kaby.ds.binarytree;

import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllTreePaths {

    /**
     * DIFFICULT - PRACTICE
     * Write a function, allTreePaths, that takes in the root of a binary tree.
     * The function should return a 2-Dimensional array where each subarray represents a
     * root-to-leaf path in the tree.
     * <p>
     * The order within an individual path must start at the root and end at the leaf,
     * but the relative order among paths in the outer array does not matter.
     * <p>
     * You may assume that the input tree is non-empty.
     *
     * @param args
     */
    public static void main(String[] args) {

        ResultPair<String[][], String[][]> result0 = test0();
        System.out.println("Expected: " + Arrays.deepToString(result0.getExpectedVal()) +
                "\nActual: " + Arrays.deepToString(result0.getActualVal()));
        ResultPair<String[][], String[][]> result1 = test1();
        System.out.println("\nExpected: " + Arrays.deepToString(result1.getExpectedVal()) +
                "\nActual: " + Arrays.deepToString(result1.getActualVal()));

    }

    private static ResultPair<String[][], String[][]> test1() {

        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");
        Node<String> h = new Node<>("h");
        Node<String> i = new Node<>("i");

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;
        e.leftNode = g;
        e.rightNode = h;
        f.leftNode = i;

        //         a
        //      /    \
        //     b      c
        //   /  \      \
        //  d    e      f
        //      / \    /
        //     g  h   i

        String[][] actual = allTreePaths(a); // ->
        // [
        //   [ "a", "b", "d" ],
        //   [ "a", "b", "e", "g" ],
        //   [ "a", "b", "e", "h" ],
        //   [ "a", "c", "f", "i" ]
        // ]
        String[][] expected = new String[][]{
                {"a", "b", "d"},
                {"a", "b", "e", "g"},
                {"a", "b", "e", "h"},
                {"a", "c", "f", "i"}
        };

        return new ResultPair<>(expected, actual);
    }

    private static ResultPair<String[][], String[][]> test0() {
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

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f

        String[][] actual = allTreePaths(a); // ->
        // [
        //   [ "a", "b", "d" ],
        //   [ "a", "b", "e" ],
        //   [ "a", "c", "f" ]
        // ]

        String[][] expected = new String[][]{
                {"a", "b", "d"},
                {"a", "b", "e"},
                {"a", "c", "f"}
        };

        return new ResultPair<>(expected, actual);
    }

    private static String[][] allTreePaths(Node<String> root) {
        List<List<String>> result = allTreePathsHelper(root);

        return result.stream()
                .map(res -> res.toArray(new String[res.size()]))
                .toArray(String[][]::new);

    }

    private static List<List<String>> allTreePathsHelper(Node<String> root) {

        // Base case: Guard against null root - return an empty list
        if (root == null) {
            return new ArrayList<>();
        }

        // Base Case: If leaf node return an array with just the node
        if (root.leftNode == null && root.rightNode == null) {
            List<List<String>> paths = new ArrayList<>();
            paths.add(Arrays.asList(root.val));
            return paths;
        }

        // Return List of all paths
        List<List<String>> allPaths = new ArrayList<>();

        // Get the list of sub paths of left subtree
        List<List<String>> leftSubPaths = allTreePathsHelper(root.leftNode);
        for (List<String> subPath : leftSubPaths) {
            List<String> path = new ArrayList<>();
            path.add(root.val); // Add the root value first and then its sub paths
            path.addAll(subPath); // this will give something like [a, b, d] for root of a
            allPaths.add(path);
        }

        // Get the list of sub paths of right subtree
        List<List<String>> rightSubPaths = allTreePathsHelper(root.rightNode);
        for (List<String> subPath : rightSubPaths) {
            List<String> path = new ArrayList<>();
            path.add(root.val);
            path.addAll(subPath);
            allPaths.add(path);
        }

        return allPaths;
    }


}
