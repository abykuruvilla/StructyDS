package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

// BINARY SEARCH
public class BinarySearch {

    /**
     * Write a function, binarySearch, that takes in a sorted array of numbers and a target.
     * The function should return the index where the target can be found within the array.
     * If the target is not found in the array, then return -1.
     *
     * You may assume that the input array contains unique numbers sorted in increasing order.
     *
     * Your function must implement the binary search algorithm.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00 ==

        int result1 = binarySearch(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}, 6); // -> 6
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Index of target is ", 6, result1);
        resultPair1.printResultPair();

        // == test_01 ==

        int result2 = binarySearch(new int[] {0, 6, 8, 12, 16, 19, 20, 24, 28}, 27); // -> -1
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Index of target is ", -1, result2);
        resultPair2.printResultPair();

        // == test_02 ==

        int result3 = binarySearch(new int[] {0, 6, 8, 12, 16, 19, 20, 28}, 8); // -> 2
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("Index of target is ", 2, result3);
        resultPair3.printResultPair();

        // == test_03 ==

        int result4 = binarySearch(new int[] {0, 6, 8, 12, 16, 19, 20, 24, 28}, 28); // -> 8
        ResultPair<Integer, Integer> resultPair4 = new ResultPair<>("Index of target is ", 8, result4);
        resultPair4.printResultPair();

        // == test_08 ==

        int result5 = binarySearch(new int[] {}, 7); // -> -1
        ResultPair<Integer, Integer> resultPair5 = new ResultPair<>("Index of target is ", -1, result5);
        resultPair5.printResultPair();
        
    }

    // We will assume that the numbers array is sorted in an ascending order
    private static int binarySearch(int[] numbers, int target) {
        // low pointer
        int low = 0;
        // high pointer
        int high = numbers.length - 1;

        // Iterate while low <= high
        while(low <= high) {

            // Find the mid point index
            int mid = (low + high) / 2;

            // If target value is less than value at mid index,
            // the number is to the left of the mid index
            if(target < numbers[mid]) {
                high = mid - 1;
            } else if (target > numbers[mid]) {
                // number is to the right of the mid index
                low = mid + 1;
            } else {
                // target is equal to the mid index value
                return mid;
            }

        }

        // Could not find anything
        return -1;

    }
}
