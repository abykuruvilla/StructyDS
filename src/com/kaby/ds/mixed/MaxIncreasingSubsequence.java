package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

import java.util.Arrays;
import java.util.HashMap;

// DYNAMIC PROGRAMMING
public class MaxIncreasingSubsequence {

    /**
     * Write a function, maxIncreasingSubseq, that takes in an array of numbers as an argument.
     * The function should return the length of the longest subsequence of strictly increasing numbers.
     * <p>
     * A subsequence of an array can be created by deleting any elements of the array,
     * while maintaining the relative order of elements.
     *
     * @param args
     */
    public static void main(String[] args) {

        //== test_00: ==

        int[] numbers1 = new int[]{4, 18, 20, 10, 12, 15, 19};
        int result1 = maxIncreasingSubseq(numbers1); // -> 5
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Max increasing subsequence for " + Arrays.toString(numbers1) + " is", 5, result1);
        resultPair1.assertMatch();

        //== test_01: ==

        int[] numbers2 = new int[]{12, 9, 2, 5, 4, 32, 90, 20};
        int result2 = maxIncreasingSubseq(numbers2); // -> 4
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Max increasing subsequence for " + Arrays.toString(numbers2) + " is", 4, result2);
        resultPair2.assertMatch();

        //== test_06: ==

        int[] numbers6 = {
                1, 2, 300, 3, 4, 305, 5, 12, 6, 30, 7, 8, 9, 10, 10, 10, 15, 11, 12, 13, 10, 18, 14, 15, 16,
                17, 18, 19, 20, 21, 100, 101, 102, 103, 104, 105
        };
        int result6 = maxIncreasingSubseqOptimized(numbers6); // -> 27
        ResultPair<Integer, Integer> resultPair6 = new ResultPair<>("Max increasing subsequence for " + Arrays.toString(numbers6) + " is", 27, result6);
        resultPair6.assertMatch();

    }

    private static int maxIncreasingSubseq(int[] numbers) {
        // Start with the zeroth number
        // You need to track previously chosen number as next number needs to be larger to choose
        // To start with choose a low number
        return maxIncreasingSubseqHelper(numbers, 0, Integer.MIN_VALUE);
    }

    // Non memoized solution
    private static int maxIncreasingSubseqHelper(int[] numbers, int i, int previous) {

        // We have hit the end of the length of the number sequesnce
        if (i == numbers.length) {
            // Since there is no longer a sub-sequence possible
            return 0;
        }

        // I can either choose the current number or skip it
        int current = numbers[i];

        // Since we need a max subsequence, we need to take the greater of the two options below
        int[] options = new int[2];

        // OPT 1: If you don't take current number, previous does not change
        int dontTakeCurrent = maxIncreasingSubseqHelper(numbers, i + 1, previous);
        options[0] = dontTakeCurrent;

        // OPT 2: If I take the current number, increase size of longest subsequence, also current becomes previous
        // GUARD - We can take current only if it was greater than previous
        if (current > previous) {
            int takeCurrent = 1 + maxIncreasingSubseqHelper(numbers, i + 1, current);
            options[1] = takeCurrent;
        }

        return Math.max(options[0], options[1]);
    }

    private static int maxIncreasingSubseqOptimized(int[] numbers) {
        // Start with the zeroth number
        // You need to track previously chosen number as next number needs to be larger to choose
        // To start with choose a low number
        return maxIncreasingSubseqMemoHelper(numbers, 0, Integer.MIN_VALUE, new HashMap<String, Integer>());
    }

    // Memoized solution
    private static int maxIncreasingSubseqMemoHelper(int[] numbers, int i, int previous, HashMap<String, Integer> memo) {

        // The key in the memo includes the changing elements, the index + previous
        String key = i + "," + previous;
        // Check if memo has key
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // We have hit the end of the length of the number sequesnce
        if (i == numbers.length) {
            // Since there is no longer a sub-sequence possible
            return 0;
        }

        // I can either choose the current number or skip it
        int current = numbers[i];

        // Since we need a max subsequence, we need to take the greater of the two options below
        int[] options = new int[2];

        // OPT 1: If you don't take current number, previous does not change
        int dontTakeCurrent = maxIncreasingSubseqMemoHelper(numbers, i + 1, previous, memo);
        options[0] = dontTakeCurrent;

        // OPT 2: If I take the current number, increase size of longest subsequence, also current becomes previous
        // GUARD - We can take current only if it was greater than previous
        if (current > previous) {
            int takeCurrent = 1 + maxIncreasingSubseqMemoHelper(numbers, i + 1, current, memo);
            options[1] = takeCurrent;
        }

        // Store in memo the max subsequence value
        memo.put(key, Math.max(options[0], options[1]));

        return memo.get(key);
    }
}
