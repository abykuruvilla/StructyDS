package com.kaby.ds.binarytree;

import com.kaby.ds.helper.ResultPair;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeafList {

    /**
     * Write a function, leafList, that takes in the root of a binary tree and
     * returns an array containing the values of all leaf nodes in leftNode-to-rightNode order.
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
        f.rightNode = h;

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f
        //    /       \
        //   g         h

        List<String> result = leafList(a); // -> [ 'd', 'g', 'h' ]
        ResultPair<List<String>, List<String>> resultPair = new ResultPair<>("== RECURSIVE ==", List.of("d", "g", "h"), result);
        System.out.println(resultPair);

        List<String> result2 = leafListDFSIterative(a); // -> [ 'd', 'g', 'h' ]
        ResultPair<List<String>, List<String>> resultPair2 = new ResultPair<>("== DFS ITERATIVE ==", List.of("d", "g", "h"), result2);
        System.out.println(resultPair2);

    }

    // DFS Iterative
    private static List<String> leafListDFSIterative(Node<String> root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<String> leaves = new ArrayList<>();

        Stack<Node<String>> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node<String> currentNode = stack.pop();
            if(currentNode.leftNode == null && currentNode.rightNode == null) {
                leaves.add(currentNode.val);
            }

            if(currentNode.rightNode != null) {
                stack.push(currentNode.rightNode);
            }

            if(currentNode.leftNode != null) {
                stack.push(currentNode.leftNode);
            }
        }

        return leaves;

    }


    // RECURSIVE
    private static List<String> leafList(Node<String> root) {
        List<String> result = new ArrayList<>();
        leafListHelper(root, result);
        return result;
    }

    private static  void leafListHelper(Node<String> root, List<String> result) {

        if(root == null) {
            return;
        }

        if(root.leftNode == null && root.rightNode == null) {
            // this is a leaf node
            result.add(root.val);
        }

        if(root.leftNode != null) {
            leafListHelper(root.leftNode, result);
        }

        if(root.rightNode != null) {
            leafListHelper(root.rightNode, result);
        }

    }

}
