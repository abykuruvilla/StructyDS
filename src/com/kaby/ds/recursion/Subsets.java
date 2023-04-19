package com.kaby.ds.recursion;

import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {


    /**
     * Write a function, subsets, that takes in an array as an argument.
     * The function should return a 2D array where each subarray represents one of the possible subsets of the array.
     * <p>
     * The elements within the subsets and the subsets themselves may be returned in any order.
     * <p>
     * You may assume that the input array contains unique elements.
     *
     * @param args
     */
    public static void main(String[] args) {

        List<List<String>> actualSubsets = subsets(new String[]{"a", "b", "c"});
        String[][] expectedSubsets = new String[][]{
                {},
                {"b"},
                {"c"},
                {"b", "c"},
                {"a"},
                {"a", "b"},
                {"a", "c"},
                {"a", "b", "c"}
        };
        ResultPair<String, String> resultPair = new ResultPair<>("The possible subsets are ", Arrays.deepToString(expectedSubsets), actualSubsets.toString());
        resultPair.printResultPair();

        //========


        List<List<String>> actualSubsets2 = subsets(new String[]{});
        String[][] expectedSubsets2 = new String[][]{
                {}
        };
        ResultPair<String, String> resultPair2 = new ResultPair<>("The possible subsets are ", Arrays.deepToString(expectedSubsets2), actualSubsets2.toString());
        resultPair2.printResultPair();

        //========

    }

    private static List<List<String>> subsets(String[] input) {

        List<List<String>> subsets = new ArrayList<>();

        // BASE CASE:
        // Every subset result includes and empty array
        if (input.length == 0) {
            subsets.add(new ArrayList<>());
            return subsets;
        }
        // Now over a period of time try to reduce the size of the input
        // Get the first element
        String firstElement = input[0];

        // Now call the subsets method recursively without the first element(slicing the input array)
        // For input [a,b,c]
        // This should return the subsets without the first element like [],[b],[c],[b,c]
        // To add all subsets we should copy the above and add a to each
        // Resulting in [],[b],[c],[b,c],[a],[a,b],[a,c][a,b,c]
        List<List<String>> subsetsWithoutFirst = subsets(Arrays.copyOfRange(input, 1, input.length));

        for (List<String> sub : subsetsWithoutFirst) {
            List<String> subsetsWithFirst = new ArrayList<>();
            subsetsWithFirst.add(firstElement);
            subsetsWithFirst.addAll(sub);

            subsets.add(subsetsWithFirst);
        }
        subsets.addAll(subsetsWithoutFirst);

        return subsets;
    }
}
