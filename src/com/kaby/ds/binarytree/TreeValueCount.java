package com.kaby.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeValueCount {

    /**
     * Write a function, treeValueCount, that takes in the root of a binary tree and a target value.
     * The function should return the number of times that the target occurs in the tree.
     *
     * @param args
     */
    public static void main(String[] args) {
        //      12
        //    /   \
        //   6     6
        //  / \     \
        // 4   6     12

        Node<Integer> a = new Node<>(12);
        Node<Integer> b = new Node<>(6);
        Node<Integer> c = new Node<>(6);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(6);
        Node<Integer> f = new Node<>(12);

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;

        System.out.println("===DFS Recursive===");
        int result1 = treeValueCount(a, 6); // -> 3
        System.out.println("Count of 6 in tree = 3, ACTUAL = " + result1);
        int result2 = treeValueCount(a, 12); // -> 2
        System.out.println("Count of 12 in tree = 2, ACTUAL = " + result2);

        System.out.println("\n===DFS Iterative===");
        int result3 = treeValueCountDFSIterative(a, 6); // -> 3
        System.out.println("Count of 6 in tree = 3, ACTUAL = " + result3);
        int result4 = treeValueCountDFSIterative(a, 12); // -> 2
        System.out.println("Count of 12 in tree = 2, ACTUAL = " + result4);

        System.out.println("\n===BFS===");
        int result5 = treeValueCountBFS(a, 6); // -> 3
        System.out.println("Count of 6 in tree = 3, ACTUAL = " + result5);
        int result6 = treeValueCountBFS(a, 12); // -> 2
        System.out.println("Count of 12 in tree = 2, ACTUAL = " + result6);

    }

    // DFS Recursive
    private static int treeValueCount(Node<Integer> root, int target) {
        // Base case: If node is null return 0
        if (root == null) {
            return 0;
        }
        // Base case: If our current node's value equal to target return 1, else return 0
        int count = root.val == target ? 1 : 0;

        // Total count is count of current root + count of left subtree + count of right subtree
        return count + treeValueCount(root.leftNode, target) + treeValueCount(root.rightNode, target);
    }

    // DFS Iterative
    private static int treeValueCountDFSIterative(Node<Integer> root, int target) {
        if (root == null) {
            return 0;
        }

        // Counter for target
        int targetCount = 0;

        // Push the root element on the stack
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);

        // If the stack is not empty
        while (!stack.isEmpty()) {
            Node<Integer> currentNode = stack.pop();
            if (currentNode.val == target) {
                targetCount += 1;
            }

            if (currentNode.rightNode != null) {
                stack.push(currentNode.rightNode);
            }

            if (currentNode.leftNode != null) {
                stack.push(currentNode.leftNode);
            }
        }

        return targetCount;
    }


    // BFS
    private static int treeValueCountBFS(Node<Integer> root, int target) {
        if (root == null) {
            return 0;
        }

        // Counter for target
        int targetCount = 0;

        // Push the root element on the Queue
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        // If the queue is not empty
        while (!queue.isEmpty()) {
            Node<Integer> currentNode = queue.poll();
            if (currentNode.val == target) {
                targetCount += 1;
            }

            if (currentNode.leftNode != null) {
                queue.offer(currentNode.leftNode);
            }
            if (currentNode.rightNode != null) {
                queue.offer(currentNode.rightNode);
            }

        }

        return targetCount;
    }
}
