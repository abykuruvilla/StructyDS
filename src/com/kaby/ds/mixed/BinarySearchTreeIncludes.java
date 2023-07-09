package com.kaby.ds.mixed;

import com.kaby.ds.binarytree.Node;
import com.kaby.ds.helper.ResultPair;

// BINARY SEARCH TREE
public class BinarySearchTreeIncludes {

    /**
     * Write a function, binarySearchTreeIncludes, that takes in the root of a binary search tree containing numbers
     * and a target value. The function should return a boolean indicating whether or not the target is found
     * within the tree.
     * <p>
     * A Binary Search Tree is a binary tree where all values within a node's leftNode subtree are smaller than the node's
     * value and all values in a node's right subtree are greater than or equal to the node's value.
     * <p>
     * Your solution should have a best case runtime of O(log(n)).
     *
     * @param args
     */
    public static void main(String[] args) {

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

        // == test_00: ==

        boolean result1 = binarySearchTreeIncludes(a, 9); // -> true
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("The binary search tree includes target ", true, result1);
        resultPair1.printResultPair();

        // == test_01: ==

        boolean result2 = binarySearchTreeIncludes(a, 15); // -> false
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("The binary search tree includes target ", false, result2);
        resultPair2.printResultPair();

        // == test_02: ==

        boolean result3 = binarySearchTreeIncludes(a, 1); // -> false
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("The binary search tree includes target ", false, result3);
        resultPair3.printResultPair();

        // == test_03: ==

        boolean result4 = binarySearchTreeIncludes(a, 12); // -> true
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("The binary search tree includes target ", true, result4);
        resultPair4.printResultPair();

        // == tree 2 ==

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

        // == test_04: ==

        boolean result5 = binarySearchTreeIncludes(q, 55); // -> false
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("The binary search tree includes target ", false, result5);
        resultPair5.printResultPair();

        // == test_05: ==

        boolean result6 = binarySearchTreeIncludes(q, 47); // -> true
        ResultPair<Boolean, Boolean> resultPair6 = new ResultPair<>("The binary search tree includes target ", true, result6);
        resultPair6.printResultPair();

        // == test_06: ==

        boolean result7 = binarySearchTreeIncludes(q, 49); // -> false
        ResultPair<Boolean, Boolean> resultPair7 = new ResultPair<>("The binary search tree includes target ", false, result7);
        resultPair7.printResultPair();

        // == test_07: ==

        boolean result8 = binarySearchTreeIncludes(q, 70); // -> true
        ResultPair<Boolean, Boolean> resultPair8 = new ResultPair<>("The binary search tree includes target ", true, result8);
        resultPair8.printResultPair();

        // == test_08: ==

        boolean result9 = binarySearchTreeIncludes(q, 100); // -> false
        ResultPair<Boolean, Boolean> resultPair9 = new ResultPair<>("The binary search tree includes target ", false, result9);
        resultPair9.printResultPair();

    }

    // In a balanced binary search tree, the left subtree values are always lesser than the root value
    // and the right subtree values are always greater than the root value
    private static boolean binarySearchTreeIncludes(Node<Integer> root, int target) {

        boolean result = false;

        // Base case: we have hit an empty subtree, so return false
        if(root == null) {
            return false;
        }

        // Base case: we have found our target value
        if(root.val == target) {
            return true;
        }

        // If the target value is greater than the root value, look to the right subtree
        if(target > root.val) {
            result = binarySearchTreeIncludes(root.rightNode, target);
        } else {
            // If the target value is lesser than the root value, look to the left subtree
            result = binarySearchTreeIncludes(root.leftNode, target);
        }

        return result;
    }
}
