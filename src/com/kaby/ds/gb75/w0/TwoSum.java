package com.kaby.ds.gb75.w0;

import com.kaby.ds.helper.ResultPair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     * @param args
     */
    public static void main(String[] args) {

        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = {0, 1};
        ResultPair<String, String> result1 = new ResultPair<>("Indices that add to target are : ", Arrays.toString(expected1), Arrays.toString(twoSum(nums1, target1)));
        result1.assertMatch();

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] expected2 = {1, 2};
        ResultPair<String, String> result2 = new ResultPair<>("Indices that add to target are : ", Arrays.toString(expected2), Arrays.toString(twoSum(nums2, target2)));
        result2.assertMatch();

        // Test case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] expected3 = {0, 1};
        ResultPair<String, String> result3 = new ResultPair<>("Indices that add to target are : ", Arrays.toString(expected3), Arrays.toString(twoSum(nums3, target3)));
        result3.assertMatch();

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        // return empty array
        return new int[] {};
    }
}
