package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

import java.util.Arrays;

// SORTING
public class MergeSort {

    /**
     * Write a function, mergeSort, that takes in an array of numbers as an argument.
     * The function should return a new array containing elements of the original array
     * sorted in ascending order. Your function must implement the merge sort algorithm.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00 ==

        int[] numbers1 = new int[]{10, 4, 42, 5, 8, 100, 5, 6, 12, 40};
        int[] sorted1 = mergeSort(numbers1);
        int[] expected1 = new int[]{4, 5, 5, 6, 8, 10, 12, 40, 42, 100};
        ResultPair<String, String> resultPair1 = new ResultPair<>("Sorted using merge sort ", Arrays.toString(expected1), Arrays.toString(sorted1));
        resultPair1.assertMatch();

        // == test_01 ==

        int[] numbers2 = new int[]{7, -30, -4, -1, 12, 0, 20};
        int[] sorted2 = mergeSort(numbers2);
        int[] expected2 = new int[]{-30, -4, -1, 0, 7, 12, 20};
        ResultPair<String, String> resultPair2 = new ResultPair<>("Sorted using merge sort ", Arrays.toString(expected2), Arrays.toString(sorted2));
        resultPair2.assertMatch();

        // == test_03 ==

        int[] numbers3 = new int[]{
                72, 42, 16, 81, 84, 17, 2, 81, 22, 79, 86, 38,
                77, 80, 81, 70, 81, 80, 35, 21, 89, 38, 57, 28,
                4, 17, 50, 38, 68, 82, 22, 76, 45, 40, 67, 94,
                37, 27, 81, 53, 36, 18, 28, 60, 45, 74, 40, 29,
                18, 6, 28, 57, 42, 60, 64, 12, 78, 97, 96, 1,
                20, 20, 61, 67, 82, 10, 63, 71, 39, 52, 37, 69,
                37, 24, 66, 74, 15, 92, 49, 31, 56, 67, 50, 57,
                79, 0, 21, 56, 82, 22, 4, 20, 91, 72, 58, 93,
                99, 14, 42, 91
        };
        int[] sorted3 = mergeSort(numbers3);
        int[] expected3 = new int[]{
                0, 1, 2, 4, 4, 6, 10, 12, 14, 15, 16, 17,
                17, 18, 18, 20, 20, 20, 21, 21, 22, 22, 22, 24,
                27, 28, 28, 28, 29, 31, 35, 36, 37, 37, 37, 38,
                38, 38, 39, 40, 40, 42, 42, 42, 45, 45, 49, 50,
                50, 52, 53, 56, 56, 57, 57, 57, 58, 60, 60, 61,
                63, 64, 66, 67, 67, 67, 68, 69, 70, 71, 72, 72,
                74, 74, 76, 77, 78, 79, 79, 80, 80, 81, 81, 81,
                81, 81, 82, 82, 82, 84, 86, 89, 91, 91, 92, 93,
                94, 96, 97, 99
        };
        ResultPair<String, String> resultPair3 = new ResultPair<>("Sorted using merge sort ", Arrays.toString(expected3), Arrays.toString(sorted3));
        resultPair3.assertMatch();

    }

    // Merge Sort is one of the more efficient sorting algorithms and has a time complexity of O(nlogn)
    // Array of 8 elements > broken to 2 arrays of 4 each > broken to 4 arrays of 2 each > broken to 8 arrays of 1 each -> logn
    // But at each level we still always have 8 elements (n)
    // Thus complexity is nlogn
    // Understanding log -> Exponent 2^4 = 16 , Therefore ln(16) = 4, i.e. log to base 2 of 16 is 4 - we need to divide 16, 4 times by 2
    private static int[] mergeSort(int[] numbers) {

        // BASE CASE
        // If my numbers array is of length 1 then its is already sorted
        if (numbers.length == 1) {
            return numbers;
        }

        // Now let's shrink this array to meet this base case
        int midPoint = numbers.length / 2;
        // slice the input array into 2 around the midpoint and run mergeSort on each half
        int[] leftSorted = mergeSort(Arrays.copyOfRange(numbers, 0, midPoint));
        int[] rightSorted = mergeSort(Arrays.copyOfRange(numbers, midPoint, numbers.length));

        // Now that we have a sorted left and right half, let's sort and merge the sorted arrays
        return mergeSortedArrays(leftSorted, rightSorted);
    }

    private static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        // NOTE: Assuming when this is called a and b arrays are already sorted in ascending order
        int[] merged = new int[nums1.length + nums2.length];

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        // pointer for nums1
        int p1 = 0;
        // pointer for nums2
        int p2 = 0;
        // pointer for merged
        int pm = 0;

        // Keep iterating while both arrays have elements remaining
        while (p1 < nums1Length && p2 < nums2Length) {
            if (nums1[p1] < nums2[p2]) {
                merged[pm] = nums1[p1];
                p1++;
            } else {
                merged[pm] = nums2[p2];
                p2++;
            }
            pm++;
        }

        // If there are items remaining in nums1, they are already sorted, hence add to merged
        while (p1 < nums1Length) {
            merged[pm] = nums1[p1];
            pm++;
            p1++;
        }
        // If there are items remaining in nums2, they are already sorted, hence add to merged
        while (p2 < nums2Length) {
            merged[pm] = nums2[p2];
            pm++;
            p2++;
        }


        return merged;
    }
}
