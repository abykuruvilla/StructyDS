package com.kaby.ds.linkedlist;

public class Node<T> {

    T val;
    Node<T> next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }
}
