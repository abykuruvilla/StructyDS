package com.kaby.ds.gb75.w2;


import com.kaby.ds.helper.ResultPair;

// KADANE's ALGORITHM
public class MaximumSubArray {


    /**
     * Given an integer array nums, find the
     * subarray
     * with the largest sum, and return its sum.
     *
     * Example 1:
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        int result0 = maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}); // -> 6
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Sum of max subarray for [-2,1,-3,4,-1,2,1,-5,4] is ", 6, result0);
        resultPair0.assertMatch();

        // == test_01: ==

        int result1 = maxSubArray(new int[] {1}); // -> 1
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Sum of max subarray for [1] is ", 1, result1);
        resultPair1.assertMatch();

        // == test_02: ==

        int result2 = maxSubArrayNeet(new int[] {5,4,-1,7,8}); // -> 23
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Sum of max subarray for [5,4,-1,7,8] is ", 23, result2);
        resultPair2.assertMatch();

    }


    // This is Kadane's Algorithm
    public static int maxSubArray(int[] nums) {

        int n = nums.length;
        // Initialize our variables using the first element.
        int currSum = nums[0];
        int maxSubArraySum = nums[0];

        // Start with the 2nd element since we already used the first one
        for(int i = 1; i < n; i++) {
            // If current subarray sum becomes negative, throw it away. Otherwise, keep adding to it
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSubArraySum = Math.max(maxSubArraySum, currSum);
        }

        return maxSubArraySum;

    }

    // Same thing as above, just different style from Neetcode
    public static int maxSubArrayNeet(int[] nums) {

        int n = nums.length;
        int currSum = nums[0];
        int maxSubArraySum = nums[0];

        for(int i = 1; i < n; i++) {
            if(currSum < 0) {
                currSum = 0;
            }
            currSum = currSum + nums[i];
            maxSubArraySum = Math.max(maxSubArraySum, currSum);
        }

        return maxSubArraySum;

    }
}
