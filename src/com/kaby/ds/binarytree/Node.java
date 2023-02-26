package com.kaby.ds.binarytree;

public class Node<T> {

    T val;
    Node<T> leftNode;
    Node<T> rightNode;

    public Node(final T val) {
        this.val = val;
        this.leftNode = null;
        this.rightNode = null;
    }
}
