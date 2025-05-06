package com.kaby.ds.mixed;

import com.kaby.ds.binarytree.Node;
import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BINARY TREE
public class PostOrder {

    /**
     * Write a function, postOrder, that takes in the root of a binary tree.
     * The function should return an array containing the post-ordered values of the tree.
     * <p>
     * Post-order traversal is when nodes are recursively visited in the order: leftNode child, rightNode child, self.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        var x = new Node<>('x');
        var y = new Node<>('y');
        var z = new Node<>('z');

        x.leftNode = y;
        x.rightNode = z;

        //       x
        //    /    \
        //   y      z

        Character[] values1 = postOrder(x); // ['y', 'z', 'x']
        ResultPair<String, String> resultPair1 = new ResultPair<>("The given tree in post order is ", Arrays.toString(new char[] {'y', 'z', 'x'}), Arrays.toString(values1));
        resultPair1.assertMatch();


        // == test_02: ==

        var a = new Node<>('a');
        var b = new Node<>('b');
        var c = new Node<>('c');
        var d = new Node<>('d');
        var e = new Node<>('e');
        var f = new Node<>('f');
        var g = new Node<>('g');
        var h = new Node<>('h');

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;
        e.leftNode = g;
        e.rightNode = h;

        //      a
        //    /    \
        //   b      c
        //  / \      \
        // d   e      f
        //    / \
        //    g  h

        Character[] values2 = postOrder(a); // [ 'd', 'g', 'h', 'e', 'b', 'f', 'c', 'a' ]
        ResultPair<String, String> resultPair2 = new ResultPair<>("The given tree in post order is ", Arrays.toString(new char[] {'d', 'g', 'h', 'e', 'b', 'f', 'c', 'a'}), Arrays.toString(values2));
        resultPair2.assertMatch();

        // == test_03: ==

        var l = new Node<>('l');
        var m = new Node<>('m');
        var n = new Node<>('n');
        var o = new Node<>('o');
        var p = new Node<>('p');
        var q = new Node<>('q');
        var r = new Node<>('r');
        var s = new Node<>('s');
        var t = new Node<>('t');

        l.leftNode = m;
        l.rightNode = n;
        n.leftNode = o;
        n.rightNode = p;
        o.leftNode = q;
        o.rightNode = r;
        p.leftNode = s;
        p.rightNode = t;

        //        l
        //     /     \
        //    m       n
        //         /    \
        //         o     p
        //        / \   / \
        //       q   r s   t

        Character[] values3 = postOrder(l); // [ 'm', 'q', 'r', 'o', 's', 't', 'p', 'n', 'l' ]
        ResultPair<String, String> resultPair3 = new ResultPair<>("The given tree in post order is ", Arrays.toString(new char[] {'m', 'q', 'r', 'o', 's', 't', 'p', 'n', 'l'}), Arrays.toString(values3));
        resultPair3.assertMatch();



        // == test_04: ==

        Character[] values4 = postOrder(null); // []
        ResultPair<String, String> resultPair4 = new ResultPair<>("The given tree in post order is ", Arrays.toString(new char[] {}), Arrays.toString(values4));
        resultPair4.assertMatch();


    }

    private static Character[] postOrder(Node<Character> root) {

        List<Character> values = new ArrayList<>();
        postOrderTraversal(root, values);

        return values.toArray(Character[]::new);
    }

    // In a postorder traversal you call leftChild -> rightChild -> parent
    private static void postOrderTraversal(Node<Character> root, List<Character> values) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.leftNode, values);
        postOrderTraversal(root.rightNode, values);
        values.add(root.val);
    }

}
