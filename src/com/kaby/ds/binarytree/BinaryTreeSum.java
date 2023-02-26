package com.kaby.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSum {

    public static Integer treeTotalSumRecursive(Node<Integer> root) {
        // Base Scenario: If the root is null then the sum is zero
        if(root == null) {
            return 0;
        }

        // The total sum is sum of root node and elements of left and right subtree
        return root.val + treeTotalSumRecursive(root.leftNode) + treeTotalSumRecursive(root.rightNode);
    }

    public static Integer treeTotalSumBFS(Node<Integer> root) {
        if(root == null) {
            return 0;
        }

        Integer sum = 0;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Node<Integer> currentNode = queue.poll();
            sum += currentNode.val;

            if(currentNode.leftNode != null) {
                queue.offer(currentNode.leftNode);
            }

            if(currentNode.rightNode != null) {
                queue.offer(currentNode.rightNode);
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        Node<Integer> a = new Node<>(3);
        Node<Integer> b = new Node<>(11);
        Node<Integer> c = new Node<>(4);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(2);
        Node<Integer> f = new Node<>(1);

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;

        System.out.println("Recursive -> Expected value = 25, Actual value = " + treeTotalSumRecursive(a));
        System.out.println("BFS -> Expected value = 25, Actual value = " + treeTotalSumBFS(a));

    }
}
