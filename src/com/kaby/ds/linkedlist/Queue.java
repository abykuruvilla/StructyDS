package com.kaby.ds.linkedlist;

import com.kaby.ds.helper.ResultPair;

/**
 * A generic Queue class implemented using a linked list structure. This queue follows the first-in,
 * first-out (FIFO) principle where elements are added to the back of the queue and removed from the front.
 *
 * @param <T> the type of elements held in this queue
 */
public class Queue <T> {

    Node<T> head;
    Node<T> tail;
    int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds the specified value to the end of the queue. The method adheres to
     * the first-in, first-out (FIFO) principle by appending the new value
     * after the current tail, and updating the tail reference to the newly
     * added node.
     *
     * @param val the value to be added to the queue
     */
    public void enqueue(T val) {
        if(head == null) {
            head = new Node<>(val);
            tail = head;
        } else {
            tail.next = new Node<>(val);
            tail = tail.next;
        }
        size++;
    }


    /**
     * Removes and returns the element at the front of the queue, adhering to
     * the first-in, first-out (FIFO) order. If the queue is empty, returns null.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     */
    public T dequeue() {

        if(head == null) {
            return null;
        }

        T val = head.val;
        head = head.next;

        if(head == null) {
            tail = null;
        }

        size--;
        return val;
    }

    public int size() {
        return size;
    }

    /**
     * Implement the enqueue and dequeue methods for the existing class.
     * The enqueue method should add a given value into the queue.
     * The dequeue should return and remove an item from the queue following first-in, first-out order.
     * Your implementation should use a linked-list and not any built in containers.
     * @param args
     */
    public static void main(String[] args) {
        // == test 0 ==
        Queue<String> queue1 = new Queue<>();
        queue1.enqueue("a");
        int res1 = queue1.size(); // -> 1
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Queue 1 size ", 1, res1);
        resultPair0.assertMatch();
        queue1.dequeue(); // -> a
        queue1.enqueue("b");
        queue1.enqueue("c");
        int res2 = queue1.size(); // -> 2
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Queue 1 size ", 2, res2);
        resultPair1.assertMatch();
        queue1.dequeue(); // -> b
        queue1.dequeue(); // -> c
        int res3 = queue1.size(); // -> 0
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Queue 1 size ", 0, res3);
        resultPair2.assertMatch();


        // == test 1 ==
        Queue<String> queue2 = new Queue<>();
        queue2.enqueue("a");
        queue2.enqueue("b");
        queue2.enqueue("c");
        queue2.dequeue(); // -> a
        queue2.enqueue("d");
        queue2.enqueue("e");
        int res4 = queue2.size(); // -> 4
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("Queue 2 size ", 4, res4);
        resultPair3.assertMatch();
        queue2.dequeue(); // -> b
        queue2.dequeue(); // -> c
        queue2.dequeue(); // -> d
        queue2.dequeue(); // -> e
        queue2.enqueue("x");
        queue2.enqueue("y");
        int res5 = queue2.size(); // -> 2
        ResultPair<Integer, Integer> resultPair4 = new ResultPair<>("Queue 2 size ", 2, res5);
        resultPair4.assertMatch();
        queue2.dequeue(); // -> x
        queue2.dequeue(); // -> y
    }
}
