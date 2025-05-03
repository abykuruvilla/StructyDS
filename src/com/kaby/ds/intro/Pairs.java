package com.kaby.ds.intro;

import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.List;

public class Pairs {

    /**
     * Write a function, pairs, that takes in a list as an argument.
     * The function should return a list containing all unique pairs of elements.
     *
     * You may return the pairs in any order and the order of elements within a single pair does not matter.
     *
     * You can assume that the input list contains unique elements.
     * @param args
     */
    public static void main(String[] args) {

        List<List<String>> result0 =  pairs(List.of("a", "b", "c"));
        ResultPair<List<List<String>>, List<List<String>>> resultPair0 = new ResultPair<>("Pairs of elements are ", List.of(List.of("a", "b"), List.of("a", "c"), List.of("b", "c")), result0);
        resultPair0.printResultPair();
        // ->
        // [
        //    ["a", "b"],
        //    ["a", "c"],
        //    ["b", "c"]
        // ]

        List<List<String>> result1 =  pairs(List.of("a", "b", "c", "d"));
        ResultPair<List<List<String>>, List<List<String>>> resultPair1 = new ResultPair<>("Pairs of elements are ", List.of(List.of("a", "b"), List.of("a", "c"), List.of("a", "d"), List.of("b", "c"), List.of("b", "d"), List.of("c", "d")), result1);
        resultPair1.printResultPair();
        // ->
        // [
        //    ["a", "b"],
        //    ["a", "c"],
        //    ["a", "d"],
        //    ["b", "c"],
        //    ["b", "d"],
        //    ["c", "d"]
        // ]


    }

    public static List<List<String>> pairs(List<String> elements) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            for (int j = i + 1; j < elements.size(); j++) { // Note: j is initialized to i + 1 to avoid pair of same elements
                List<String> pair = List.of(elements.get(i), elements.get(j));
                result.add(pair);
            }
        }

        return result;
    }
}
