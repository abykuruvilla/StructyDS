package com.kaby.ds.dynamic;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;

public class ArrayStepper {

    /**
     *
     * Write a function, arrayStepper, that takes in an array of numbers as an argument.
     * You start at the first position of the array. The function should return a boolean indicating whether or not
     * it is possible to reach the last position of the array. When situated at some position of the array, you may
     * take a maximum number of steps based on the number at that position.
     *
     * For example, given:
     *
     *     idx =  0  1  2  3  4  5
     * numbers = [2, 4, 2, 0, 0, 1]
     *
     * The answer is true.
     * We start at idx 0, we could take 1 step or 2 steps forward.
     * The correct choice is to take 1 step to idx 1.
     * Then take 4 steps forward to the end at idx 5.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        Boolean result0 = arrayStepper(new int[] {2, 4, 2, 0, 0, 1}); // -> true
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Possible to array step to end index?", Boolean.TRUE, result0);
        resultPair0.assertMatch();

        // == test_01: ==

        Boolean result1 = arrayStepper(new int[] {2, 3, 2, 0, 0, 1}); // -> false
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Possible to array step to end index?", Boolean.FALSE, result1);
        resultPair1.assertMatch();

        // == test_02: ==

        Boolean result2 = arrayStepper(new int[] {3, 1, 3, 1, 0, 1}); // -> true
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Possible to array step to end index?", Boolean.TRUE, result2);
        resultPair2.assertMatch();

        // == test_03: ==

        Boolean result3 = arrayStepper(new int[] {4, 1, 5, 1, 1, 1, 0, 4}); // -> true
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Possible to array step to end index?", Boolean.TRUE, result3);
        resultPair3.assertMatch();

        // == test_04: ==

        Boolean result4 = arrayStepper(new int[] {4, 1, 2, 1, 1, 1, 0, 4}); // -> false
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Possible to array step to end index?", Boolean.FALSE, result4);
        resultPair4.assertMatch();

        // == test_05: ==

        Boolean result5 = arrayStepper(new int[] {1, 1, 1, 1, 1, 0}); // -> true
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("Possible to array step to end index?", Boolean.TRUE, result5);
        resultPair5.assertMatch();

        // == test_06: ==

        Boolean result6 = arrayStepper(new int[] {1, 1, 1, 1, 0, 0}); // -> false
        ResultPair<Boolean, Boolean> resultPair6 = new ResultPair<>("Possible to array step to end index?", Boolean.FALSE, result6);
        resultPair6.assertMatch();

        // == test_07: ==

        Boolean result7 = arrayStepper(new int[] {
                31, 30, 29, 28, 27,
                26, 25, 24, 23, 22,
                21, 20, 19, 18, 17,
                16, 15, 14, 13, 12,
                11, 10, 9, 8, 7, 6,
                5, 3, 2, 1, 0, 0, 0
}); // -> false
        ResultPair<Boolean, Boolean> resultPair7 = new ResultPair<>("Possible to array step to end index?", Boolean.FALSE, result7);
        resultPair7.assertMatch();


    }

    private static Boolean arrayStepper(int[] numbers) {
//        return arrayStepperBF(numbers, 0);
        return arrayStepperMemoized(numbers, 0, new HashMap<Integer, Boolean>());
    }

    // MEMOIZED
    // Only the value of index changes, so the key of the memo is just the index
    private static Boolean arrayStepperMemoized(int[] numbers, int index, HashMap<Integer, Boolean> memo) {
        // check memo first
        if(memo.containsKey(index)) {
            return memo.get(index);
        }

        // check for out of bounds and last value of numbers array
        if(index >= numbers.length - 1) {
            return true;
        }

        // max possible steps that can be stepped through as defined at index
        var maxStep = numbers[index];

        // if it is possible to reach the end from index+step, return true
        for(int step = 1; step <= maxStep; step++) {
            if(arrayStepperMemoized(numbers, index + step, memo) == Boolean.TRUE) {
                return Boolean.TRUE;
            }
        }

        // None of the recursive calls above led to us being able to reach the end of the array
        return Boolean.FALSE;
    }

    private static Boolean arrayStepperBF(int[] numbers, int index) {
        // if we have reached end of numbers array return true
        // note the >= here is to capture any out of bounds
        if(index >= numbers.length - 1) {
            return true;
        }

        // The max number of steps at index that we can step through based on value of index
        var maxStep = numbers[index];

        // Recursively call method for each possible step variation
        for(int step = 1; step <= maxStep; step++) {
            // if it is possible to reach the end from index+step, return true
            if(arrayStepperBF(numbers, index + step) == Boolean.TRUE) {
                return Boolean.TRUE;
            }
        }

        // None of the recursive calls above wre able to reach the end, so return false
        return Boolean.FALSE;

    }

}
