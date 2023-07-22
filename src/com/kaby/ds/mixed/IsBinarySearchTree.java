package com.kaby.ds.mixed;

import com.kaby.ds.binarytree.Node;
import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.List;

// BINARY SEARCH TREE
// IN-ORDER TRAVERSAL
public class IsBinarySearchTree {

    /**
     * Write a function, isBinarySearchTree, that takes in the root of a binary tree. The function should return a
     * boolean indicating whether or not the tree satisfies the binary search tree property.
     * <p>
     * A Binary Search Tree is a binary tree where all values within a node's left subtree are smaller than the node's
     * value and all values in a node's right subtree are greater than or equal to the node's value.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==
        // == tree 1 ==

        var a = new Node<>(12);
        var b = new Node<>(5);
        var c = new Node<>(18);
        var d = new Node<>(3);
        var e = new Node<>(9);
        var f = new Node<>(19);

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;

        //      12
        //    /   \
        //   5     18
        //  / \     \
        // 3   9     19

        boolean result1 = isBinarySearchTree(a); // -> true
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Is the given tree a binary search tree? ", true, true);
        resultPair1.printResultPair();

        // == test_01: ==
        // == tree 2 ==

        var a1 = new Node<>(12);
        var b1 = new Node<>(5);
        var c1 = new Node<>(18);
        var d1 = new Node<>(3);
        var e1 = new Node<>(15);
        var f1 = new Node<>(19);

        a1.leftNode = b1;
        a1.rightNode = c1;
        b1.leftNode = d1;
        b1.rightNode = e1;
        c1.rightNode = f1;

        //      12
        //    /   \
        //   5     18
        //  / \     \
        // 3   15    19


        boolean result2 = isBinarySearchTree(a1); // -> false
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Is the given tree a binary search tree? ", false, result2);
        resultPair2.printResultPair();

        // == test_02: ==
        // == tree 3 ==

        var a2 = new Node<>(12);
        var b2 = new Node<>(5);
        var c2 = new Node<>(19);
        var d2 = new Node<>(3);
        var e2 = new Node<>(9);
        var f2 = new Node<>(19);

        a2.leftNode = b2;
        a2.rightNode = c2;
        b2.leftNode = d2;
        b2.rightNode = e2;
        c2.rightNode = f2;

        //      12
        //    /   \
        //   5     19
        //  / \     \
        // 3   9     19

        boolean result3 = isBinarySearchTree(a2); // -> true
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Is the given tree a binary search tree? ", true, result3);
        resultPair3.printResultPair();

        // == test_03: ==
        // == tree 4 ==

        var a3 = new Node<>(12);
        var b3 = new Node<>(5);
        var c3 = new Node<>(10);
        var d3 = new Node<>(3);
        var e3 = new Node<>(9);
        var f3 = new Node<>(19);

        a3.leftNode = b3;
        a3.rightNode = c3;
        b3.leftNode = d3;
        b3.rightNode = e3;
        c3.rightNode = f3;

        //      12
        //    /   \
        //   5     10
        //  / \     \
        // 3   9     19

        boolean result4 = isBinarySearchTree(a3); // -> false
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Is the given tree a binary search tree? ", false, result4);
        resultPair4.printResultPair();

        // == test_04: ==
        // == tree 5 ==

        var q = new Node<>(54);
        var r = new Node<>(42);
        var s = new Node<>(70);
        var t = new Node<>(31);
        var u = new Node<>(50);
        var v = new Node<>(72);
        var w = new Node<>(47);
        var x = new Node<>(90);

        q.leftNode = r;
        q.rightNode = s;
        r.leftNode = t;
        r.rightNode = u;
        s.rightNode = v;
        u.leftNode = w;
        v.rightNode = x;

        //       54
        //     /    \
        //    42     70
        //   / \      \
        // 31   50     72
        //     /        \
        //    47         90

        boolean result5 = isBinarySearchTree(q); // -> true
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("Is the given tree a binary search tree? ", true, result5);
        resultPair5.printResultPair();

    }

    private static boolean isBinarySearchTree(Node<Integer> root) {
        // Store the values of the tree when visting in-order
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        System.out.println(values.toString());

        // Check to see if the elements in the values list are sorted
        return isSorted(values);
    }

    private static boolean isSorted(List<Integer> values) {
        for(int i = 0; i < values.size() - 1; i++) {
            int current = values.get(i);
            int next = values.get(i + 1);

            if(next < current) {
                return false;
            }
        }
        return true;
    }

    private static void inorderTraversal(Node<Integer> root, List<Integer> values) {
        // If root is null we have reached end of tree
        if(root == null) {
            return;
        }
        // Visit left child
        inorderTraversal(root.leftNode, values);
        // Visit current Node
        values.add(root.val);
        // Visit right child
        inorderTraversal(root.rightNode, values);
    }
}
