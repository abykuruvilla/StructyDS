package com.kaby.ds.recursion;

import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {


    /**
     * Write a function, permutations, that takes in an array an argument.
     * The function should return a 2D array where each subarray represents one of the possible permutations of the array.
     *
     * The subarrays may be returned in any order.
     *
     * You may assume that the input array contains unique elements.
     * @param args
     */
    public static void main(String[] args) {

        List<List<String>> actualPermutations = permutations(new String[]{"a", "b", "c"});
        String[][] expectedPermutations = new String[][]{
                {"a", "b", "c"},
                {"b", "a", "c"},
                {"b", "c", "a"},
                {"a", "c", "b"},
                {"c", "a", "b"},
                {"c", "b", "a"}
        };
        ResultPair<String, String> resultPair = new ResultPair<>("The possible permutations are ", Arrays.deepToString(expectedPermutations), actualPermutations.toString());
        resultPair.assertMatch();
    }

    private static List<List<String>> permutations(String[] input) {
        // List of permutations
        List<List<String>> permutations = new ArrayList<>();

        // For an empty array, we will pass back an empty 2D array
        if(input.length == 0) {
            permutations.add(new ArrayList<>());
            return permutations;
        }

        // Get the first item
        String firstElement = input[0];

        // We want to reduce the problem size, so say for an input [a, b, c] we get back [b, c] which has permutations as [b, c] and [c, b]
        // We want to add first element before b, between b and c, and after c to get [a, b, c], [b, a, c], [b, c, a], [a, c, b], [c, a, b], [c, b, a]
        List<List<String>> permutationsWithoutFirst = permutations(Arrays.copyOfRange(input, 1, input.length));
        for(List<String> perm : permutationsWithoutFirst) {
            for(int i = 0; i <= perm.size(); i++) {
                // Copy over the perm first and then place the first element at different positions as explained above
                List<String> permWithFirst = new ArrayList<>(perm);
                permWithFirst.add(i, firstElement);

                permutations.add(permWithFirst);
            }
        }

        return permutations;
    }
}
