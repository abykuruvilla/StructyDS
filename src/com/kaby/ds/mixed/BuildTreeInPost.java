package com.kaby.ds.mixed;

import com.kaby.ds.binarytree.BinaryTreePrinter;
import com.kaby.ds.binarytree.Node;

import java.util.Arrays;

// BINARY TREE
public class BuildTreeInPost {

    /**
     * Write a function, buildTreeInPost, that takes in an array of in-ordered values and an array of post-ordered values
     * for a binary tree. The function should build a binary tree that has the given in-order and post-order traversal structure.
     * The function should return the root of this tree.
     *
     * You can assume that the values of inorder and postorder are unique.
     * @param args
     */
    public static void main(String[] args) {

        // == test_00 ==

        Node<Character> root1 = buildTreeInPost(new char[] { 'y', 'x', 'z' }, new char[] {'y', 'z', 'x'});
        new BinaryTreePrinter<Character>(root1).print(System.out);
        //       x
        //    /    \
        //   y      z

        // == test_01 ==

        Node<Character> root2 = buildTreeInPost(new char[] { 'd', 'b', 'e', 'a', 'f', 'c', 'g' }, new char[] { 'd', 'e', 'b', 'f', 'g', 'c', 'a'});
        new BinaryTreePrinter<Character>(root2).print(System.out);
        //      a
        //    /    \
        //   b      c
        //  / \    / \
        // d   e  f   g

        // == test_03 ==

        Node<Character> root3 = buildTreeInPost(new char[] {'m', 'n'}, new char[] {'m', 'n'});
        new BinaryTreePrinter<Character>(root3).print(System.out);
        //       n
        //     /
        //    m

    }

    private static Node<Character> buildTreeInPost(char[] inOrder, char[] postOrder) {
        // The length of the inOrder and postOrder should be the same
        if(inOrder.length == 0) {
            return null;
        }

        // The last element of the postOrder has to be the root
        var value = postOrder[postOrder.length - 1];
        // Construct the root using this value
        var root = new Node<Character>(value);
        // The root node should be at the mid of the inOrder,
        // the values to the left form the left subtree
        // the values to the right form the right subtree
        var mid = new String(inOrder).indexOf(value);
        // The mid will be the slicing point of the left and right inOrder
        var leftInOrder = Arrays.copyOfRange(inOrder, 0, mid);
        var rightInOrder = Arrays.copyOfRange(inOrder, mid + 1, inOrder.length);
        // Now get elements from left and right postOrder,
        // this should be same number of elements from leftInOrder
        var leftPostOrder = Arrays.copyOfRange(postOrder, 0, leftInOrder.length);
        var rightPostOrder = Arrays.copyOfRange(postOrder, leftInOrder.length, postOrder.length - 1);

        // Recursively build the tree
        root.leftNode = buildTreeInPost(leftInOrder, leftPostOrder);
        root.rightNode = buildTreeInPost(rightInOrder, rightPostOrder);

        // Return the root of the tree constructed
        return root;
    }
}
