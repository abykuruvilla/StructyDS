package com.kaby.ds.binarytree;

import com.kaby.ds.helper.ResultPair;

import java.util.LinkedList;
import java.util.Queue;

public class BottomRightValue {


    /**
     * Write a function, bottomRightValue, that takes in the root of a binary tree.
     * The function should return the right-most value in the bottom-most level of the tree.
     * <p>
     * You may assume that the input tree is non-empty.
     *
     * @param args
     */
    public static void main(String[] args) {

        ResultPair<Integer, Integer> result0 = test0();
        System.out.println(result0);
        ResultPair<Integer, Integer> result1 = test1();
        System.out.println(result1);
        ResultPair<Integer, Integer> result2 = test2();
        System.out.println(result2);
        ResultPair<Integer, Integer> result3 = test3();
        System.out.println(result3);

    }

    private static ResultPair<Integer, Integer> test3() {

        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(5);
        Node<Integer> f = new Node<>(6);

        a.leftNode = b;
        a.rightNode = c;
        b.rightNode = d;
        d.leftNode = e;
        e.rightNode = f;

        //      1
        //    /   \
        //   2     3
        //    \
        //     4
        //    /
        //   5
        //  /
        // 6

        int actual =  bottomRightValue(a); // -> 6
        return new ResultPair<>(6, actual);
    }

    private static ResultPair<Integer, Integer> test2() {

        Node<Integer> a = new Node<>(-1);
        Node<Integer> b = new Node<>(-6);
        Node<Integer> c = new Node<>(-5);
        Node<Integer> d = new Node<>(-3);
        Node<Integer> e = new Node<>(-4);
        Node<Integer> f = new Node<>(-13);
        Node<Integer> g = new Node<>(-2);
        Node<Integer> h = new Node<>(6);
        Node<Integer> i = new Node<>(7);


        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;
        e.leftNode = g;
        e.rightNode = h;
        f.leftNode = i;

        //        -1
        //      /   \
        //    -6    -5
        //   /  \     \
        // -3   -4   -13
        //     / \    /   
        //    -2  6  7

        int actual =  bottomRightValue(a); // -> 7
        return new ResultPair<>(7, actual);
    }

    private static ResultPair<Integer, Integer> test1() {

        Node<Integer> a = new Node<>(-1);
        Node<Integer> b = new Node<>(-6);
        Node<Integer> c = new Node<>(-5);
        Node<Integer> d = new Node<>(-3);
        Node<Integer> e = new Node<>(-4);
        Node<Integer> f = new Node<>(-13);
        Node<Integer> g = new Node<>(-2);
        Node<Integer> h = new Node<>(6);

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;
        e.leftNode = g;
        e.rightNode = h;

        //        -1
        //      /   \
        //    -6    -5
        //   /  \     \
        // -3   -4   -13
        //     / \       
        //    -2  6

        int actual =  bottomRightValue(a); // -> 6

        return new ResultPair<>(6,actual);
    }

    private static ResultPair<Integer, Integer> test0() {

        Node<Integer> a = new Node<>(3);
        Node<Integer> b = new Node<>(11);
        Node<Integer> c = new Node<>(10);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(-2);
        Node<Integer> f = new Node<>(1);

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;

        //       3
        //    /    \
        //   11     10
        //  / \      \
        // 4   -2     1

        int actual =  bottomRightValue(a); // -> 1
        return new ResultPair<>(1, actual);
    }

    private static int bottomRightValue(Node<Integer> root) {

        // Best way to solve the bottom right problem is to use BFS
        // The last not that gets off the queue should be the bottom right value

        // Since the input tree is non-empty there will at least be one value
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        Node<Integer> currentNode = null;

        while(!queue.isEmpty()) {
            currentNode = queue.poll();

            // Note: Add the left value first if you want to have the bottom value leave the queue last
            if(currentNode.leftNode != null) {
                queue.offer(currentNode.leftNode);
            }
            if(currentNode.rightNode != null) {
                queue.offer(currentNode.rightNode);
            }
        }

        return currentNode.val;
    }
}
