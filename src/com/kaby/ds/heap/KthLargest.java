package com.kaby.ds.heap;

import com.kaby.ds.helper.ResultPair;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {

    // We are going to use a minHeap as we are asked for the kth largest value
    // The minHeap is limited to k elements when we add
    // The smallest value of the minHeap is hence the kth largest element
    Queue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] elements) {

        this.minHeap = new PriorityQueue<>();
        this.k = k;

        // initially add all alements to the heap
        for(int element : elements) {
            minHeap.offer(element);
        }

        // we want to limit the size of the heap to k elements, pop smallest off once we have hit the size
        if(minHeap.size() > k) {
            minHeap.poll();
        }

    }

    /**
     * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the
     * sorted order, not the kth distinct element.
     *
     * Implement KthLargest class:
     *
     *     KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
     *     int add(int val) Appends the integer val to the stream and returns the element representing the
     *     kth largest element in the stream.
     * @param args
     */
    public static void main(String[] args) {

        KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
        int result0 = kthLargest.add(3);   // return 4
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Kth largest value ", 4, result0);
        resultPair0.assertMatch();
        int result1 = kthLargest.add(5);   // return 5
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Kth largest value ", 5, result1);
        resultPair1.assertMatch();
        int result2 = kthLargest.add(10);  // return 5
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Kth largest value ", 5, result2);
        resultPair2.assertMatch();
        int result3 = kthLargest.add(9);   // return 8
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("Kth largest value ", 8, result3);
        resultPair3.assertMatch();
        int result4 = kthLargest.add(4);   // return 8
        ResultPair<Integer, Integer> resultPair4 = new ResultPair<>("Kth largest value ", 8, result4);
        resultPair4.assertMatch();

    }

    private int add(int num) {

        // add the element to the minHeap
        this.minHeap.offer(num);

        // if the size of the minHeap is greater than k, pop the smallest of the heap
        if(this.minHeap.size() > k) {
            this.minHeap.poll();
        }

        // return the smallest value which is the kth largest value
        return minHeap.peek();

    }
}
