package com.kaby.ds.binarytree;

public class Node<T> {

    public T val;
    public Node<T> leftNode;
    public Node<T> rightNode;

    public Node(final T val) {
        this.val = val;
        this.leftNode = null;
        this.rightNode = null;
    }
}
