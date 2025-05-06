package com.kaby.ds.heap;

import com.kaby.ds.helper.ResultPair;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

    /**
     * You are given an array of integers stones where stones[i] is the weight of the ith stone.
     *
     * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
     * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
     *
     *     If x == y, both stones are destroyed, and
     *     If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
     *
     * At the end of the game, there is at most one stone left.
     *
     * Return the weight of the last remaining stone. If there are no stones left, return 0.
     *
     * Example: for stones [2, 7, 4, 1, 8, 1]
     * Explanation:
     * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
     * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
     * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
     * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test00 ==
        int[] stones0 = new int[] {2,7,4,1,8,1};
        int expected0 = 1;
        int actual0 = lastStoneWeight(stones0);
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("The weight of the last stone is ", expected0, actual0);
        resultPair0.assertMatch();


        // == test01 ==
        int[] stones1 = new int[] {1};
        int expected1 = 1;
        int actual1 = lastStoneWeight(stones1);
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("The weight of the last stone is ", expected1, actual1);
        resultPair1.assertMatch();

        // == test02 ==
        int[] stones2 = new int[] {2,7,4,1,8,1,1};
        int expected2 = 0;
        int actual2 = lastStoneWeight(stones2);
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("The weight of the last stone is ", expected2, actual2);
        resultPair2.assertMatch();

    }

    private static int lastStoneWeight(int[] stones) {

        // We are going to implement this using a max heap, which stores the largest value on top
        // In Java the PriorityQueue is a min heap by default. We use Collections.reverseOrder() to convert this to a max Heap
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {
            // Pop the two highest values - if they are equal we already removed them from the heap
            int highest = maxHeap.poll();
            int secondHighest = maxHeap.poll();

            // if the values are not equal we need to add a new element y - x
            if(highest != secondHighest) {
                int newVal = highest - secondHighest;
                maxHeap.offer(newVal);
            }
        }

        // The max heap might have a corner case where it has no values left, in that case append 0
        // In all other cases there should be only one element left now
        maxHeap.offer(0);
        return maxHeap.poll();
    }
}
