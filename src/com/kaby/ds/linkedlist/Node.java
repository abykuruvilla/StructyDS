package com.kaby.ds.linkedlist;

public class Node<T> {

    public T val;
    public Node<T> next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }
}
