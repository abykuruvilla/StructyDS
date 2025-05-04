package com.kaby.ds.hashing;

import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionWithDupes {

    /**
     * Write a function, intersection_with_dupes, that takes in two lists, a,b, as arguments.
     * The function should return a new list containing elements that are common to both input lists.
     * The elements in the result should appear as many times as they occur in both input lists.
     *
     * You can return the result in any order.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        List<String> result0 = intersectionWithDupes(List.of("a", "b", "c", "b"), List.of("x", "y", "b", "b"));
        ResultPair<List<String>, List<String>> resultPair0 = new ResultPair<>("Intersection of the two lists with duplicate elements ", List.of("b", "b"), result0);
        resultPair0.printResultPair();

        // == test1 ==
        List<String> result1 = intersectionWithDupes(List.of("a", "b", "c", "b"), List.of("x", "y", "b"));
        ResultPair<List<String>, List<String>> resultPair1 = new ResultPair<>("Intersection of the two lists with duplicate elements ", List.of("b"), result1);
        resultPair1.printResultPair();

    }

    private static List<String> intersectionWithDupes(List<String> a, List<String> b) {

        // Let's store the count of each element in a HashMap
        Map<String, Integer> countAMap = new HashMap<>();
        Map<String, Integer> countBMap = new HashMap<>();

        // count the number of times each element occurs in the list a and b
        for(String item : a) {
            countAMap.put(item, countAMap.getOrDefault(item, 0) + 1);
        }
        for(String item : b) {
            countBMap.put(item, countBMap.getOrDefault(item, 0) + 1);
        }

        List<String> result = new ArrayList<>();

        // For each item in countAMap, check if it's in countBMap too
        for(String key : countAMap.keySet()) {
            if(countBMap.containsKey(key)) {
                // check the min of the two counts to get the number of times the element occurs in both lists
                int times = Math.min(countAMap.get(key), countBMap.get(key));
                // add the element to the result list the number of times it occurs in both lists
                for(int i = 0; i < times; i++) {
                    result.add(key);
                }
            }
        }

        return result;

    }


}
