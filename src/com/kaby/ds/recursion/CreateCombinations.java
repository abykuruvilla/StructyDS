package com.kaby.ds.recursion;

import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateCombinations {

    /**
     * Write a function, createCombinations, that takes in an array and a length as arguments.
     * The function should return a 2D array representing all of the combinations of the specifized
     * length.
     * <p>
     * The items within the combinations and the combinations themselves may be returned in any
     * order.
     * <p>
     * You may assume that the input array contains unique elements and 1 <= k <= items.length.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        List<List<String>> result0 = createCombinations(Arrays.asList("a", "b", "c"), 2);
        List<List<String>> expected0 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("a", "c"),
                Arrays.asList("b", "c")
        );
        ResultPair<List<List<String>>, List<List<String>>> resultPair0 = new ResultPair<>("Combinations possible ", expected0, result0);
        resultPair0.assertMatch();


        // == test_01: ==

        List<List<String>> result1 = createCombinations(Arrays.asList("q", "r", "s", "t"), 2);
        List<List<String>> expected1 = Arrays.asList(
                Arrays.asList("q", "r"),
                Arrays.asList("q", "s"),
                Arrays.asList("q", "t"),
                Arrays.asList("r", "s"),
                Arrays.asList("r", "t"),
                Arrays.asList("s", "t")
        );
        ResultPair<List<List<String>>, List<List<String>>> resultPair1 = new ResultPair<>("Combinations possible ", expected1, result1);
        resultPair1.assertMatch();

        // == test_02: ==

        List<List<String>> result2 = createCombinations(Arrays.asList("q", "r", "s", "t"), 3);
        List<List<String>> expected2 = Arrays.asList(
                Arrays.asList("q", "r", "s"),
                Arrays.asList("q", "r", "t"),
                Arrays.asList("q", "s", "t"),
                Arrays.asList("r", "s", "t")
        );
        ResultPair<List<List<String>>, List<List<String>>> resultPair2 = new ResultPair<>("Combinations possible ", expected2, result2);
        resultPair2.assertMatch();

        // == test_03: ==

        List<List<String>> result3 = createCombinations(Arrays.asList("1", "28", "94"), 3);
        List<List<String>> expected3 = Arrays.asList(
                Arrays.asList("1", "28", "94")
        );
        ResultPair<List<List<String>>, List<List<String>>> resultPair3 = new ResultPair<>("Combinations possible ", expected3, result3);
        resultPair3.assertMatch();

    }

    private static List<List<String>> createCombinations(List<String> items, int k) {

        // base case 1: we have fewer items than k, so we cannot create a combination
        if (k > items.size()) {
            // There are zero combinations; equivalent to []
            // return Collections.emptyList(); -> another way to write below
            return List.of();
        }

        // base case 2 : k = 0
        if (k == 0) {
            // There is only one combination with zero values; equivalent to [[]]
            // return Collections.singletonList(Collections.emptyList()); -> another way to write below
            return List.of(List.of());
        }

        // remove the first element
        String firstElement = items.get(0);

        List<List<String>> result = new ArrayList<>();

        // Combinations with one item less, with k-1 combinations. We will add first element to each partial combination
        List<List<String>> partialCombinations = createCombinations(items.subList(1, items.size()), k - 1);
        List<List<String>> combinationsWithFirst = new ArrayList<>();
        for (List<String> partialCombo : partialCombinations) {
            List<String> listWithFirst = new ArrayList<>();
            listWithFirst.add(firstElement);
            listWithFirst.addAll(partialCombo);
            combinationsWithFirst.add(listWithFirst);
        }


        // Combinations without the first letter with k combinations
        List<List<String>> combinationsWithoutFirst = createCombinations(items.subList(1, items.size()), k);

        result.addAll(combinationsWithFirst);
        result.addAll(combinationsWithoutFirst);

        return result;
    }
}
