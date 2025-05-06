package com.kaby.ds.hashing;

import com.kaby.ds.helper.ResultPair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllUnique {


    /**
     * Write a function, all_unique, that takes in a list.
     * The function should return a boolean indicating whether or not the list contains unique items.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        boolean result0 = allUnique(List.of("q", "r", "s", "a"));
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("All unique items in the list ", true, result0);
        resultPair0.assertMatch();

        // == test1 ==
        boolean result1 = allUnique(List.of("q", "r", "s", "r", "a"));
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("All unique items in the list ", false, result1);
        resultPair1.assertMatch();

    }

    public static boolean allUnique(List<String> items) {

        // HashSet tracks items seen
        Set<String> seen = new HashSet<>();

        for(String item : items) {
            if(seen.contains(item)) {
                // if duplicate return immediately
                return false;
            } else {
                seen.add(item);
            }
        }

        // no duplicate found
        return true;
    }
}
