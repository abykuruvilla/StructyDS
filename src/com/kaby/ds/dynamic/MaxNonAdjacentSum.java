package com.kaby.ds.dynamic;

import com.kaby.ds.helper.ResultPair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNonAdjacentSum {

    /**
     * Write a function, nonAdjacentSum, that takes in an array of numbers as an argument.
     * The function should return the maximum sum of non-adjacent elements in the array.
     * There is no limit on how many elements can be taken into the sum as long as they are not adjacent.
     * <p>
     * For example, given:
     * [2, 4, 5, 12, 7]
     * The maximum non-adjacent sum is 16, because 4 + 12.
     * 4 and 12 are not adjacent in the array.
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = {2, 4, 5, 12, 7};
        int maxNonAdjacentSumActual1 = nonAdjacentSum(nums); // -> 16
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("The max non-adjacent path sum for nums1 is ", 16, maxNonAdjacentSumActual1);
        resultPair1.printResultPair();

        int[] nums2 = {
                72, 62, 10, 6, 20, 19, 42, 46, 24, 78,
                30, 41, 75, 38, 23, 28, 66, 55, 12, 17,
                83, 80, 56, 68, 6, 22, 56, 96, 77, 98,
                61, 20, 0, 76, 53, 74, 8, 22, 92, 37,
                30, 41, 75, 38, 23, 28, 66, 55, 12, 17,
                72, 62, 10, 6, 20, 19, 42, 46, 24, 78,
                42
        };
        int maxNonAdjacentSumActual2 = nonAdjacentSumOptimized(nums2, 0, new HashMap<>()); // -> 1465
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("The max non-adjacent path sum for nums2 is ", 1465, maxNonAdjacentSumActual2);
        resultPair2.printResultPair();

    }

    private static Integer nonAdjacentSum(int[] nums) {

        // If I choose to include the first element of nums, then skip the next element
        // Note: Here we are slicing starting node 2 to end of nums array
        // copyOfRange is exclusive of last element
        if (nums.length > 1) {
//            System.out.println("DEBUG => Nums : " + Arrays.toString(nums) +
//                    ", IncludeFirst: " + Arrays.toString(Arrays.copyOfRange(nums, 2, nums.length)) +
//                    ", ExcludeFirst: " + Arrays.toString(Arrays.copyOfRange(nums, 1, nums.length)));

            Integer includeFirst = nums[0] + nonAdjacentSum(Arrays.copyOfRange(nums, 2, nums.length));

            // If we exclude first element
            Integer excludeFirst = nonAdjacentSum(Arrays.copyOfRange(nums, 1, nums.length));

            return Math.max(includeFirst, excludeFirst);
        }

        // We have hit a base case where the nums array is either empty or just one element(in which case we cannot exclude)
        return 0;

    }

    // Optimized using memoization
    private static Integer nonAdjacentSumOptimized(int[] nums, int i, Map<Integer, Integer> memo) {
        // Check if the memo has the value computed already
        if(memo.containsKey(i)) {
            return memo.get(i);
        }
        // Base case: i is the size of the array or i+2 or i+1 is greater than length of array
        if(i >= nums.length) {
            return 0;
        }

        // In this strategy we will stop creating sliced array copies which is very inefficient,
        // instead we are tracking the element we are operating on
        Integer includeFirst = nums[i] + nonAdjacentSumOptimized(nums, i + 2, memo);
        Integer excludeFirst = nonAdjacentSumOptimized(nums, i + 1, memo);

        memo.put(i, Math.max(includeFirst, excludeFirst));

        return memo.get(i);

    }
}
