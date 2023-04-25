package com.kaby.ds.arraysnstrings;

import java.util.Arrays;

public class FiveSort {

    /**
     * Write a function, fiveSort, that takes in an array of numbers as an argument.
     * The function should rearrange elements of the array such that all 5s appear at the end.
     * Your function should perform this operation in-place by mutating the original array.
     * The function should return the array.
     *
     * Elements that are not 5 can appear in any order in the output, as long as all 5s are at the end of the array.
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("After 5 sort array [12, 5, 1, 5, 12, 7] will look like [12, 7, 1, 12, 5, 5] ");
        System.out.println("Actual = " + Arrays.toString(fiveSort(new int[] {12, 5, 1, 5, 12, 7})));
        System.out.println("After 5 sort array [5, 2, 5, 6, 5, 1, 10, 2, 5, 5] will look like [2, 2, 10, 6, 1, 5, 5, 5, 5, 5] ");
        System.out.println("Actual = " + Arrays.toString(fiveSort(new int[] {5, 2, 5, 6, 5, 1, 10, 2, 5, 5})));

    }

    // Time complexity of O(n) and space complexity of O(1)
    private static int[] fiveSort(int[] input) {
        // We start with two pointers
        // j is at the end of the array, and decrements till a non 5 element is encountered
        // i is at the beginning of the array, and increments until a 5 element is encountered
        // Swap i and j when the above happens
        int i = 0;
        int j = input.length - 1;

        // We stop when both the pointers meet
        while(i <= j) {
            // let's first move j till we  find a number not equal to 5
            if(input[j] == 5) {
                j--;
            } else if(input[i] == 5) {
                // if i is equal to 5 lets swap elements at i and j
                swap(input, i, j);
                // increment i;
                i++;
            } else {
                // if i is not equal to 5, just increment i
                i++;
            }
        }

        return input;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
