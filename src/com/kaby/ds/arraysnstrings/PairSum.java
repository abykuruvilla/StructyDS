package com.kaby.ds.arraysnstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairSum {

    // Given an array of numbers and a target sum as inputs, return a pair of indices whose
    // sum is equal to the target
    public static void main(String[] args) {

        int[] input1 = {3, 2, 5, 4, 1}; // [0,2]
        int target1 = 8;
        int[] input2 = {4, 7, 9, 2, 5, 1}; // [0,5]
        int target2 = 5;

        System.out.println("For input array " + input1 + ", and target sum = " + target1 + "expected indices are [0, 2] ; Actual = " + Arrays.toString(pairSum(input1, target1)));
        System.out.println("For input array " + input2 + ", and target sum = " + target2 + "expected indices are [0, 5] ; Actual = " + Arrays.toString(pairSum(input2, target2)));

    }

    // Using a HashMap we improve time complexity to O(n) vs O(n^2) for naive approach, space complexity is also O(n) for Hashmap
    private static int[] pairSum(int[] input, int target) {
        // In a Hashmap lets store the character and their indices
        Map<Integer, Integer> digitIndexMap = new HashMap<>();
        for(int i = 0; i < input.length; i++) {
            digitIndexMap.put(input[i], i);
            // Each time taking the difference from the target and checking if the map has it (complement),
            // return these two indexes
            int complement = target - input[i];
            if(digitIndexMap.containsKey(complement)) {
                return new int[] {digitIndexMap.get(complement), i};
            }
        }

        return new int[0];
    }
}
