package com.kaby.ds.linkedlist;

import com.kaby.ds.helper.ResultPair;

public class LongestStreak {


    /**
     * Write a function, longestStreak, that takes in the head of a linked list as an argument.
     * The function should return the length of the longest consecutive streak of the same value within the list.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00:

        var a = new Node<>(5);
        var b = new Node<>(5);
        var c = new Node<>(7);
        var d = new Node<>(7);
        var e = new Node<>(7);
        var f = new Node<>(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        // 5 -> 5 -> 7 -> 7 -> 7 -> 6

        var result0 = longestStreak(a); // 3
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("The longest streak is of ", 3, result0);
        resultPair0.printResultPair();

        // == test_01:

        var a1 = new Node<>(3);
        var b1 = new Node<>(3);
        var c1 = new Node<>(3);
        var d1 = new Node<>(3);
        var e1 = new Node<>(9);
        var f1 = new Node<>(9);

        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        e1.next = f1;
        // 3 -> 3 -> 3 -> 3 -> 9 -> 9

        var result1 = longestStreak(a1); // 4
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("The longest streak is of ", 4, result1);
        resultPair1.printResultPair();

        // == test_02:

        var a2 = new Node<>(9);
        var b2 = new Node<>(9);
        var c2 = new Node<>(1);
        var d2 = new Node<>(9);
        var e2 = new Node<>(9);
        var f2 = new Node<>(9);

        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        d2.next = e2;
        e2.next = f2;
        // 9 -> 9 -> 1 -> 9 -> 9 -> 9

        var result2 = longestStreak(a2); // 3
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("The longest streak is of ", 3, result2);
        resultPair2.printResultPair();

        // == test_03:

        var a3 = new Node<>(5);
        var b3 = new Node<>(5);

        a3.next = b3;
        // 5 -> 5

        var result3 = longestStreak(a3); // 2
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("The longest streak is of ", 2, result3);
        resultPair3.printResultPair();

        // == test_04:

        var a4 = new Node<>(4);
        // 4

        var result4 = longestStreak(a4); // 1
        ResultPair<Integer, Integer> resultPair4 = new ResultPair<>("The longest streak is of ", 1, result4);
        resultPair4.printResultPair();

        // == test_05:

        var result5 = longestStreak(null); // 0
        ResultPair<Integer, Integer> resultPair5 = new ResultPair<>("The longest streak is of ", 0, result5);
        resultPair5.printResultPair();


    }

    private static Integer longestStreak(Node<Integer> head) {

        int maxStreak = 0;
        int currentStreak = 0;
        Integer previousVal = null;

        var currentNode = head;

        while(currentNode != null) {

            if(currentNode.val == previousVal) {
                // we are in a streak
                currentStreak += 1;
            } else {
                // we have broken a streak, starting a new one
                currentStreak = 1;
            }

            // was the current streak greater than the max streak?
            maxStreak = Math.max(maxStreak, currentStreak);

            previousVal = currentNode.val;
            currentNode = currentNode.next;
        }

        return maxStreak;

    }
}
