package com.kaby.ds.arraysnstrings;

import com.kaby.ds.helper.ResultPair;

import java.util.HashSet;
import java.util.Set;

public class HasSubArraySum {

    /**
     * Write a function, hasSubarraySum, that takes in an array of numbers and a targetSum.
     * The function should return a boolean indicating whether or not there exists a subarray of numbers that sums to the given target.
     *
     * A subarray is a consecutive series of one or more elements of the array.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        boolean result0 = hasSubarraySum(new int[]{1, 3, 1, 4, 3}, 8); // true
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Has subarray sum ", true, result0);
        resultPair0.assertMatch();

        // == test1 ==
        boolean result1 = hasSubarraySum(new int[]{1, 3, 1, 4, 3}, 2); // false
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Has subarray sum ", false, result1);
        resultPair1.assertMatch();

        // == test2 ==
        boolean result2 = hasSubarraySum(new int[]{1, 3, 1, 1, 3}, 2); // true
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Has subarray sum ", true, result2);
        resultPair2.assertMatch();

        // == test3 ==
        boolean result3 = hasSubarraySum(new int[]{5}, 5); // true
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Has subarray sum ", true, result3);
        resultPair3.assertMatch();

        // == test4 ==
        boolean result4 = hasSubarraySum(new int[]{4, 2, 5, 1, 5, -2, 8}, 9); // true
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Has subarray sum ", true, result4);
        resultPair4.assertMatch();

        // == test5 ==
        boolean result5 = hasSubarraySum(new int[]{4, 2, 5, 1, 5, -2, 8}, 10); // false
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("Has subarray sum ", false, result5);
        resultPair5.assertMatch();

        // == test6 ==
        boolean result6 = hasSubarraySum(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}, 9); // true
        ResultPair<Boolean, Boolean> resultPair6 = new ResultPair<>("Has subarray sum ", true, result6);
        resultPair6.assertMatch();

        // == test7 ==
        boolean result7 = hasSubarraySum(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}, 10); // false
        ResultPair<Boolean, Boolean> resultPair7 = new ResultPair<>("Has subarray sum ", false, result7);
        resultPair7.assertMatch();


    }

    /**
     * We need to use a prefix sum and HashSet to detect if there's a subarray summing to the target. Here's the idea:
     * Keep a running prefixSum.
     * At each step, check if prefixSum - targetSum has been seen before — if so, there's a subarray ending at the current index that sums to targetSum.
     * @param nums
     * @param targetSum
     * @return
     */
    private static boolean hasSubarraySum(int[] nums, int targetSum) {

        // Initialize the prefixSum
        Set<Integer> prefixSums = new HashSet<>();

        int currentSum = 0;

        // initialize the first element
        prefixSums.add(0);

        for (int num : nums) {

            currentSum += num;

            // Check if the current prefix sum has been seen before.
            if(prefixSums.contains(currentSum - targetSum)) {
                return true;
            }

            // Add the current prefix sum to the set to detect duplicates.
            prefixSums.add(currentSum);
        }

        return false;
    }


    // DOES NOT WORK FOR NEGATIVE NUMBERS
    private static boolean hasSubarraySumSlidingWindow(int[] nums, int targetSum) {
        // Note: Using sliding window approach would fail if there are negative numbers in the array.
        // The sliding window approach relies on non-negative numbers — when you add a negative number,
        // shrinking the window doesn’t reliably reduce the sum to help you find the correct subarray.

        // So we will be using prefix sums

        int start = 0;
        int currentSum = 0;

        for (int end = 0; end < nums.length; end++) {

            currentSum += nums[end];

            // Shrink window while the sum is too large
            while (start <= end && currentSum > targetSum) {
                currentSum -= nums[start];
                start++;
            }

            // Check if current window matches the target sum
            if(currentSum == targetSum) {
                return true;
            }
        }

        return false;

    }
}
