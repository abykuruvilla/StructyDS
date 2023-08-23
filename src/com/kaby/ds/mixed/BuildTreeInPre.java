package com.kaby.ds.mixed;

import com.kaby.ds.binarytree.BinaryTreePrinter;
import com.kaby.ds.binarytree.Node;

import java.util.Arrays;

public class BuildTreeInPre {

    /**
     * Write a function, buildTreeInPre, that takes in an array of in-ordered values and an array of
     * pre-ordered values for a binary tree. The function should build a binary tree that has the given
     * in-order and pre-order traversal structure. The function should return the root of this tree.
     * <p>
     * You can assume that the values of inorder and preorder are unique.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00 ==

        Node<Character> root1 = buildTreeInPre(
                new char[]{'z', 'y', 'x'},
                new char[]{'y', 'z', 'x'}
        );
        new BinaryTreePrinter<Character>(root1).print(System.out);
        //       y
        //    /    \
        //   z      x

        // == test_01 ==

        Node<Character> root2 = buildTreeInPre(
                new char[]{'y', 'z', 'x'},
                new char[]{'y', 'x', 'z'}
        );
        new BinaryTreePrinter<Character>(root2).print(System.out);
        //       y
        //        \
        //         x
        //        / 
        //       z

        // == test_02 ==

        Node<Character> root3 = buildTreeInPre(
                new char[]{'d', 'b', 'g', 'e', 'h', 'a', 'c', 'f'},
                new char[]{'a', 'b', 'd', 'e', 'g', 'h', 'c', 'f'}
        );
        new BinaryTreePrinter<Character>(root3).print(System.out);
        //       a
        //    /    \
        //   b      c
        //  / \      \
        // d   e      f
        //    / \
        //    g  h

        // == test_03 ==

        Node<Character> root4 = buildTreeInPre(
                new char[]{'t', 'u', 's', 'q', 'r', 'p'},
                new char[]{'u', 't', 's', 'r', 'q', 'p'}
        );
        new BinaryTreePrinter<Character>(root4).print(System.out);
        //     u
        //  /    \
        // t      s
        //         \
        //         r
        //        / \
        //        q  p

        // == test_04 ==

        Node<Character> root5 = buildTreeInPre(
                new char[]{'m', 'l', 'q', 'o', 'r', 'n', 's', 'p', 't'},
                new char[]{'l', 'm', 'n', 'o', 'q', 'r', 'p', 's', 't'}
        );
        new BinaryTreePrinter<Character>(root5).print(System.out);
        //        l
        //     /     \
        //    m       n
        //         /    \
        //         o     p
        //        / \   / \
        //       q   r s   t

    }

    private static Node<Character> buildTreeInPre(char[] inOrder, char[] preOrder) {

        // The length of the inOrder and preOrder should be the same
        if(inOrder.length == 0) {
            return null;
        }

        // The root node is first node of preOrder
        var value = preOrder[0];
        var root = new Node<Character>(value);
        // The root node should be at the mid of the inOrder,
        // the values to the left form the left subtree
        // the values to the right form the right subtree
        var mid = new String(inOrder).indexOf(value);
        // The mid will be the slicing point of the left and right inOrder
        var leftInOrder = Arrays.copyOfRange(inOrder, 0, mid);
        var rightInOrder = Arrays.copyOfRange(inOrder, mid + 1, inOrder.length);
        // Now get elements from left and right preOrder,
        // this should be same number of elements from leftInOrder
        var leftPreOrder = Arrays.copyOfRange(preOrder, 1, leftInOrder.length + 1);
        var rightPreOrder = Arrays.copyOfRange(preOrder, leftPreOrder.length + 1, preOrder.length);

        // Recursively build the tree
        root.leftNode = buildTreeInPre(leftInOrder, leftPreOrder);
        root.rightNode = buildTreeInPre(rightInOrder, rightPreOrder);


        return root;

    }
}
