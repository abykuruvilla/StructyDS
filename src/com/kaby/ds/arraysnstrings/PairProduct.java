package com.kaby.ds.arraysnstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairProduct {
    // Given an array of numbers and a target product as inputs, return a pair of indices whose
    // product is equal to the target
    public static void main(String[] args) {

        int[] input1 = {3, 2, 5, 4, 1}; // [1,2]
        int target1 = 10;
        int[] input2 = {4, 7, 9, 2, 5, 1}; // [4,5]
        int target2 = 5;

        System.out.println("For input array " + input1 + ", and target product = " + target1 + "expected indices are [1, 2] ; Actual = " + Arrays.toString(pairProduct(input1, target1)));
        System.out.println("For input array " + input2 + ", and target product = " + target2 + "expected indices are [4, 5] ; Actual = " + Arrays.toString(pairProduct(input2, target2)));

    }

    // Using a HashMap we improve time complexity to O(n) vs O(n^2) for naive approach, space complexity is also O(n) for Hashmap
    private static int[] pairProduct(int[] input, int target) {
        // In a Hashmap lets store the character and their indices
        Map<Double, Integer> digitIndexMap = new HashMap<>();
        for(int i = 0; i < input.length; i++) {
            digitIndexMap.put((double) input[i], i);
            // Each time taking the complement based on the target and checking if the map has it,
            // return these two indexes
            double complement = target / (double)input[i];
            if(digitIndexMap.containsKey(complement)) {
                return new int[] {digitIndexMap.get(complement), i};
            }
        }

        return new int[0];
    }
}
