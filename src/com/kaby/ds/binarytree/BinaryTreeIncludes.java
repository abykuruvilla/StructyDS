package com.kaby.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeIncludes {

    public static boolean treeIncludesBFS(Node root, String target) {

        if(root == null) {
            return false;
        }

        // Add the root node to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        // While the queue is not empty,
        // remove the element from the end of the queue and check if its value is equal to the target
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if(currentNode.val == target) {
                return true;
            }

            // Add the children if they exist
            if(currentNode.leftNode != null) {
                queue.offer(currentNode.leftNode);
            }
            if(currentNode.rightNode != null) {
                queue.offer(currentNode.rightNode);
            }
        }

        return false;
    }

    public static boolean treeIncludesDFS(Node root, String target) {

        if(root == null) {
            return false;
        }

        if(root.val == target) {
            return true;
        }

        // Trickle up and do a logical OR between the left and right subtree till you reach root, which will be the answer.
        return treeIncludesDFS(root.leftNode, target) || treeIncludesDFS(root.rightNode, target);
    }


    public static void main(String[] args) {

//        Input Tree Structure
//                a
//               / \
//              b   c
//             / \   \
//            d   e   f

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

        boolean result = treeIncludesBFS(a,"e");
        System.out.println("BFS : Tree contains e -> " + result);

        boolean result2 = treeIncludesBFS(a,"j");
        System.out.println("BFS : Tree contains j -> " + result2);

        boolean result3 = treeIncludesDFS(a,"e");
        System.out.println("DFS : Tree contains e -> " + result3);

        boolean result4 = treeIncludesDFS(a,"j");
        System.out.println("DFS : Tree contains j -> " + result4);

    }
}
