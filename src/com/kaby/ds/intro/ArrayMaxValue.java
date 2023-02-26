package com.kaby.ds.intro;

public class ArrayMaxValue {

    /**
     * Write a function, maxValue, that takes in array of numbers as an argument.
     * The function should return the largest number in the array.
     *
     * Solve this without using any built-in array methods.
     *
     * You can assume that the array is non-empty.
     * @param inputArray
     * @return
     */
    // time complexity = O(n) and space complexity is O(1)
    public static double maxValueInArray(double[] inputArray) {
        double max = Double.NEGATIVE_INFINITY;

        for(int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] > max) {
                max = inputArray[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        double[] input1 = {4, 7, 2, 8, 10, 9};
        double[] input2 = {10, 5, 40, 40.3};
        double[] input3 = {-5, -2, -1, -11};

        System.out.println("Max of " + input1 + " is: Expected output = 10 ; Actual output = " + maxValueInArray(input1));
        System.out.println("Max of " + input2 + " is: Expected output = 40.3 ; Actual output = " + maxValueInArray(input2));
        System.out.println("Max of " + input3 + " is: Expected output = -1 ; Actual output = " + maxValueInArray(input3));

    }
}
