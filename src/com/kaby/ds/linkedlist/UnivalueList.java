package com.kaby.ds.linkedlist;

import com.kaby.ds.helper.ResultPair;

public class UnivalueList {


    /**
     * Write a function, isUnivalueList, that takes in the head of a linked list as an argument.
     * The function should return a boolean indicating whether or not the linked list contains exactly one unique value.
     * <p>
     * You may assume that the input list is non-empty.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        var a = new Node<>(7);
        var b = new Node<>(7);
        var c = new Node<>(7);

        a.next = b;
        b.next = c;
        // 7 -> 7 -> 7

        Boolean result0 = isUnivalueList(a); // true
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Is univalue list? ", Boolean.TRUE, result0);
        resultPair0.printResultPair();

        // == test_01: ==

        var a1 = new Node<>(7);
        var b1 = new Node<>(7);
        var c1 = new Node<>(4);

        a1.next = b1;
        b1.next = c1;
        // 7 -> 7 -> 4

        Boolean result1 = isUnivalueList(a1); // false
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Is univalue list? ", Boolean.FALSE, result1);
        resultPair1.printResultPair();

        // == test_02: ==

        var u = new Node<>(2);
        var v = new Node<>(2);
        var w = new Node<>(2);
        var x = new Node<>(2);
        var y = new Node<>(2);

        u.next = v;
        v.next = w;
        w.next = x;
        x.next = y;
        // 2 -> 2 -> 2 -> 2 -> 2

        Boolean result2 = isUnivalueList(u); // true
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Is univalue list? ", Boolean.TRUE, result2);
        resultPair2.printResultPair();

        // == test_03: ==

        var u1 = new Node<>(2);
        var v1 = new Node<>(2);
        var w1 = new Node<>(3);
        var x1 = new Node<>(3);
        var y1 = new Node<>(2);

        u1.next = v1;
        v1.next = w1;
        w1.next = x1;
        x1.next = y1;
        // 2 -> 2 -> 3 -> 3 -> 2

        Boolean result3 = isUnivalueList(u1); // false
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Is univalue list? ", Boolean.FALSE, result3);
        resultPair3.printResultPair();

        // == test_04: ==

        var z = new Node<>(7);
        // z

        Boolean result4 = isUnivalueList(z); // true
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Is univalue list? ", Boolean.TRUE, result4);
        resultPair4.printResultPair();
        
    }

    private static Boolean isUnivalueList(Node<Integer> head) {

        var current = head;

        while(current != null) {
            if(current.val != head.val) {
                return Boolean.FALSE;
            }
            current = current.next;
        }

        return Boolean.TRUE;
    }
}
