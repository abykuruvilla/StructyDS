package com.kaby.ds.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSIterative {

    public static List<String> dfsIterative(Node root) {
        List<String> result = new ArrayList<>();

        if(root == null) {
            System.out.print(result);
            return result;
        }

        Stack<Node> stack = new Stack<>();

        // Add the root to the stack
        stack.push(root);

        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            // Anything we pop off the stack let's add to the result;
            result.add((String) currentNode.val);

            // Add the children to the stack if they exist
            // Note: add the right node first and then the left node so that we can pop the left node first
            if(currentNode.rightNode != null) {
                stack.push(currentNode.rightNode);
            }
            if(currentNode.leftNode != null) {
                stack.push(currentNode.leftNode);
            }
        }

        System.out.println(result);

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

        List<String> result = dfsIterative(a);
    }
}
