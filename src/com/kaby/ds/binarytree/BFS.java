package com.kaby.ds.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    // This can only be implemented iteratively
    public static List<String> bfsIterative(Node root) {
        List<String> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        // Add root node to queue
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        // While there are still elements on the queue
        while(!queue.isEmpty()) {
            // remove the current node off of the queue and add to result list
            Node currentNode = queue.poll();
            result.add((String) currentNode.val);

            // Level Order
            // If the current node has children add them to the queue, left first and then right
            if(currentNode.leftNode != null) {
                queue.add(currentNode.leftNode);
            }
            if(currentNode.rightNode != null) {
                queue.add(currentNode.rightNode);
            }
        }

        return result;
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

        List<String> result = bfsIterative(a);
        System.out.println(result);
    }
}
