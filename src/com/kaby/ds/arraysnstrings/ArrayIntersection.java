package com.kaby.ds.arraysnstrings;

import java.util.*;

public class ArrayIntersection {


    public static void main(String[] args) {
        System.out.println("Intersection of [4,2,1,6], [3,6,9,2,10] is [2,6]: Actual = " + Arrays.toString(intersection(new Integer[] {4,2,1,6}, new Integer[] {3,6,9,2,10})));
        System.out.println("Intersection of [4,2,1], [1,2,4,6] is [1,2,4]: Actual = " + Arrays.toString(intersection(new Integer[] {4,2,1}, new Integer[] {1,2,4,6})));
    }

    private static Integer[] intersection(Integer[] arr1, Integer[] arr2) {
        List<Integer> result = new ArrayList<>();

        // Let's store the elements of one array into a HashSet
        Set<Integer> set = new HashSet<>(Arrays.asList(arr1));

        // Loop over the second array and check if the element is present in the Set, if yes add to the result
        for(int i = 0; i < arr2.length; i++) {
            if(set.contains(arr2[i])) {
                result.add(arr2[i]);
            }
        }

        return result.toArray(new Integer[0]);
    }
}
