package com.kaby.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeMin {

    public static Integer treeMinValRecursive(Node<Integer> root) {
        // Base case where a node is null, return INFINITY/MAX_VALUE
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        // Recursively call the method to get the min value of the left and right subtree
        Integer leftMin = treeMinValRecursive(root.leftNode);
        Integer rightMin = treeMinValRecursive(root.rightNode);

        // The min value of the tree is the min of the root, left subtree and right subtree
        return(Math.min(root.val, Math.min(leftMin, rightMin)));

    }

    public static Integer treeMinValDFS(Node<Integer> root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        // Track the smallest value
        Integer smallest = Integer.MAX_VALUE;

        // Create a stack and push the root on it
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            // While stack is not empty pop the top node from the stack
            Node<Integer> currentNode = stack.pop();
            // Track the running smallest value after you pop the current node
            smallest = Math.min(smallest, currentNode.val);

            // If the current node has children add them to the stack
            if(currentNode.leftNode != null) {
                stack.push(currentNode.leftNode);
            }
            if(currentNode.rightNode != null) {
                stack.push(currentNode.rightNode);
            }

        }

        return smallest;
    }

    public static Integer treeMinValBFS(Node<Integer> root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        // Track the smallest value
        Integer smallest = Integer.MAX_VALUE;

        // Create a queue and push the root on it
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            // While queue is not empty pop the top node from the stack
            Node<Integer> currentNode = queue.poll();
            // Track the running smallest value after you pop the current node
            smallest = Math.min(smallest, currentNode.val);

            // If the current node has children add them to the stack
            if(currentNode.leftNode != null) {
                queue.offer(currentNode.leftNode);
            }
            if(currentNode.rightNode != null) {
                queue.offer(currentNode.rightNode);
            }

        }

        return smallest;
    }


    //        Input Tree Structure
    //                5
    //               / \
    //              11   3
    //             / \    \
    //            4   15   12

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(11);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(15);
        Node<Integer> f = new Node<>(12);

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;

        System.out.println("Recursive -> Expected value = 3, Actual value = " + treeMinValRecursive(a));
        System.out.println("DFS Iterative -> Expected value = 3, Actual value = " + treeMinValDFS(a));
        System.out.println("BFS -> Expected value = 3, Actual value = " + treeMinValBFS(a));
    }
}
