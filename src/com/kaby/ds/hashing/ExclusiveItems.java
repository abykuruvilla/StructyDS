package com.kaby.ds.hashing;

import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExclusiveItems {

    /**
     * Write a function, exclusive_items, that takes in two lists, a,b, as arguments.
     * The function should return a new list containing elements that are in either list but not both lists.
     *
     * You may assume that each input list does not contain duplicate elements.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        List<Integer> result0 = exclusiveItems(List.of(4, 2, 1, 6), List.of(3, 6, 9, 2, 10));
        ResultPair<List<Integer>, List<Integer>> resultPair0 = new ResultPair<>("Exclusive items in the two lists ", List.of(4, 1, 3, 9, 10), result0);
        resultPair0.printResultPair();

    }

    public static List<Integer> exclusiveItems(List<Integer> a, List<Integer> b) {

        // Use sets for fast lookup
        Set<Integer> setA = new HashSet<>(a);
        Set<Integer> setB = new HashSet<>(b);

        // Create a result list
        List<Integer> result = new ArrayList<>();

        // Add items in a which are not in b
        for(int i = 0; i < a.size(); i++) {
            if(!setB.contains(a.get(i))) {
                result.add(a.get(i));
            }
        }

        // Add items in b which are not in a
        for(int i = 0; i < b.size(); i++) {
            if(!setA.contains(b.get(i))) {
                result.add(b.get(i));
            }
        }

        return result;
    }
}
