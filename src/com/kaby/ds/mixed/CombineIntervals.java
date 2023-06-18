package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// ARRAYS
public class CombineIntervals {

    /**
     * Write a function, combineIntervals, that takes in an array of intervals as an argument.
     * Each interval is an array containing a pair of numbers representing a start and end time.
     * Your function should combine overlapping intervals and return an array containing the combined intervals.
     * <p>
     * For example:
     * Given two intervals:
     * [1, 4] and [3, 7]
     * The intervals overlap and should be combined into: [1, 7]
     * <p>
     * You may return the combined intervals in any order.
     * You can assume that the input array contains at least one interval and all intervals are valid
     * with start < end.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00 ==

        int[][] intervals1 = {
                {1, 4},
                {12, 15},
                {3, 7},
                {8, 13},
        };
        int[][] result1 = combineIntervals(intervals1); // -> [ [1, 7], [8, 15] ]
        int[][] expected1 = new int[][]{{1, 7}, {8, 15}};
        ResultPair<String, String> resultPair1 = new ResultPair<>("The combined interval for intervals " + Arrays.deepToString(intervals1) + " is ", Arrays.deepToString(expected1), Arrays.deepToString(result1));
        resultPair1.printResultPair();

        // == test_01 ==

        int[][] intervals2 = {
                {6, 8},
                {2, 9},
                {10, 12},
                {20, 24},
        };
        int[][] result2 = combineIntervals(intervals2); // -> [ [2, 9], [10, 12], [20, 24] ]
        int[][] expected2 = new int[][]{{2, 9}, {10, 12}, {20, 24}};
        ResultPair<String, String> resultPair2 = new ResultPair<>("The combined interval for intervals " + Arrays.deepToString(intervals2) + " is ", Arrays.deepToString(expected2), Arrays.deepToString(result2));
        resultPair2.printResultPair();

        // == test_02 ==

        int[][] intervals3 = {
                {3, 7},
                {5, 8},
                {1, 5},
        };
        int[][] result3 = combineIntervals(intervals3); // -> [ [1, 8] ]
        int[][] expected3 = new int[][]{{1, 8}};
        ResultPair<String, String> resultPair3 = new ResultPair<>("The combined interval for intervals " + Arrays.deepToString(intervals3) + " is ", Arrays.deepToString(expected3), Arrays.deepToString(result3));
        resultPair3.printResultPair();

        // == test_03 ==

        int[][] intervals4 = {
                {3, 7},
                {10, 13},
                {5, 8},
                {27, 31},
                {1, 5},
                {12, 16},
                {20, 22},
        };
        int[][] result4 = combineIntervals(intervals4); // -> [ [1, 8], [10, 16], [20, 22], [27, 31] ]
        int[][] expected4 = new int[][]{{1, 8}, {10, 16}, {20, 22}, {27, 31}};
        ResultPair<String, String> resultPair4 = new ResultPair<>("The combined interval for intervals " + Arrays.deepToString(intervals4) + " is ", Arrays.deepToString(expected4), Arrays.deepToString(result4));
        resultPair4.printResultPair();

    }

    // O(nlogn) - Time Complexity for sorting O(n) - Space Complexity
    private static int[][] combineIntervals(int[][] intervals) {

        // Sort the intervals array based on the starting index
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        // Initialize the combined interval to first interval
        List<int[]> combinedIntervals = new ArrayList<>(Arrays.asList(intervals[0]));

        // We need to compare starting at first element
        for (int i = 1; i < intervals.length; i++) {

            int[] currentInterval = intervals[i];
            int currentStartTime = currentInterval[0];
            int currentEndTime = currentInterval[1];

            int[] lastCombinedInterval = combinedIntervals.get(combinedIntervals.size() - 1);
            int lastCombStartTime = lastCombinedInterval[0];
            int lastCombEndTime = lastCombinedInterval[1];

            // if startTime of current interval is before or equal to endTime of combinedInterval let's merge
            if (currentStartTime <= lastCombEndTime) {
                // here the current interval might be fully encompassing withing the last combined interval, do nothing
                if (currentEndTime > lastCombEndTime) {
                    lastCombinedInterval[1] = currentEndTime;
                    // Update the combined intervals
                    combinedIntervals.set(combinedIntervals.size() - 1, lastCombinedInterval);
                }
            } else {
                // Add this as a new interval
                combinedIntervals.add(currentInterval);
            }
        }

        return combinedIntervals.toArray(int[][]::new);
    }
}
