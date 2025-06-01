package com.kaby.ds.arraysnstrings;

import com.kaby.ds.helper.ResultPair;

import java.util.Arrays;

public class RunningSum {

    /**
     * Write a function, runningSum, that takes in an array of numbers.
     * The function should return a new array of the same length where each element contains the running sum up to that index of the original array.
     * <p>
     * For example, the i-th result should be the sum of all elements 0 to i:
     * result[i] = numbers[0] + numbers[1] + numbers[2] + ... + numbers[i]
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        int[] result0 = runningSum(new int[]{4, 2, 1, 6, 3, 6}); // -> [ 4, 6, 7, 13, 16, 22 ]
        ResultPair<String, String> resultPair0 = new ResultPair<>("The running sum is ", Arrays.toString(new int[] {4, 6, 7, 13, 16, 22}), Arrays.toString(result0));
        resultPair0.assertMatch();

        // == test1 ==
        int[] result1 = runningSum(new int[]{10, 5, -2, 1, 1}); // -> [ 10, 15, 13, 14, 15 ]
        ResultPair<String, String> resultPair1 = new ResultPair<>("The running sum is ", Arrays.toString(new int[] {10, 15, 13, 14, 15}), Arrays.toString(result1));
        resultPair1.assertMatch();

        // == test2 ==
        int[] result2 = runningSum(new int[]{12, 88, 0, -50, 30, 2}); // -> [ 12, 100, 100, 50, 80, 82 ]
        ResultPair<String, String> resultPair2 = new ResultPair<>("The running sum is ", Arrays.toString(new int[] {12, 100, 100, 50, 80, 82}), Arrays.toString(result2));
        resultPair2.assertMatch();

        // == test3 ==
        int[] result3 = runningSum(new int[]{2}); // -> [ 2 ]
        ResultPair<String, String> resultPair3 = new ResultPair<>("The running sum is ", Arrays.toString(new int[] {2}), Arrays.toString(result3));
        resultPair3.assertMatch();

        // == test4 ==
        int[] result4 = runningSum(new int[]{}); // -> [ ]
        ResultPair<String, String> resultPair4 = new ResultPair<>("The running sum is ", Arrays.toString(new int[] {}), Arrays.toString(result4));
        resultPair4.assertMatch();

    }

    /**
     * Calculates the running sum of the input array.
     * Each element in the result array is the sum of all previous elements up to that index.
     *
     * @param numbers The input array of integers.
     * @return A new array with the running sum.
     */
    public static int[] runningSum(int[] numbers) {

        // if input array is empty return empty array
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }

        // Result array to store the running sums
        int[] result = new int[numbers.length];

        // initialize the first element
        result[0] = numbers[0];

        // Loop through the array from the second element
        for (int i = 1; i < numbers.length; i++) {
            result[i] = numbers[i] + result[i - 1];
        }

        return result;
    }
}
