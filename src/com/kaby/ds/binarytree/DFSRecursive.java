package com.kaby.ds.binarytree;

import java.util.ArrayList;
import java.util.List;

public class DFSRecursive {

    public static List<String> dfsRecursive(Node root) {

        List<String> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        List<String> leftValues = new ArrayList<>();
        //  we are initially passing b as root here ; get left subtree [b, d, e]
        leftValues.addAll(dfsRecursive(root.leftNode));
        System.out.println("left -> " + leftValues);

        List<String> rightValues = new ArrayList<>();
        //  we are initially passing c as root here ; get right subtree [c, f]
        rightValues.addAll(dfsRecursive(root.rightNode));
        System.out.println("right -> " + rightValues);

        result.add((String) root.val);
        result.addAll(leftValues);
        result.addAll(rightValues);

//        System.out.println("result -> " + result);

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

        List<String> result = dfsRecursive(a);
        System.out.println(result);
    }
}
