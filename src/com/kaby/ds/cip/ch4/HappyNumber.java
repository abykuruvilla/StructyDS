package com.kaby.ds.cip.ch4;

import com.kaby.ds.helper.ResultPair;

public class HappyNumber {


    /**
     * Determines if a given number is happy.
     *
     * A happy number is defined as a number that, when repeatedly subjected to the process of
     * squaring its digits and summing those squares, eventually leads to 1. An unhappy number
     * never reaches 1 during the process, and will be stuck in an infinite loop.
     *
     * This method uses a similar strategy like LinkedListLoop detection.
     * It uses fast and slow pointers.
     *
     * Time complexity of O(logn)
     * Space complexity is O(1)
     *
     * @param n The number to check for being happy
     * @return True if the number is happy, false otherwise
     */
    public static boolean happyNumber(int n) {
        // This uses a similar strategy like LinkedListLoop detection
        // We will us e fast and slow pointers

        int slow = n;
        int fast = n;

        while (true) {

            slow = getNextNum(slow);
            fast = getNextNum(getNextNum(fast));

            if (fast == 1) {
                return true;
            } else if (slow == fast) {
                // If the fast and slow pointers meet a cycle is detected - n is not a happy number
                return false;
            }

        }
    }

    private static int getNextNum(int x) {
        int nextNum = 0;

        while (x != 0) {
            // Extract the last digit
            int digit = x % 10;
            // Remove the last digit from the number
            x /= 10;
            // Add the square of the extracted digit to the sum
            nextNum += digit * digit;
        }

        return nextNum;
    }


    /**
     * A happy number is defined as a number that, when repeatedly subjected to the process of
     * squaring its digits and summing those squares, eventually leads to 1. An unhappy number
     * never reaches 1 during the process, and will be stuck in an infinite loop.
     *
     * Given an integer determine if it's a happy number.
     *
     * This is similar to the Floyd's Cycle Detection algorithm.
     *
     * Time complexity of O(logn)
     * Space complexity is O(1)
     * @param args
     */
    public static void main(String[] args) {

        // == test 0 ==
        int n1 = 23;
        boolean res1 = happyNumber(n1);
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("23 is a Happy Number? ", true, res1);
        resultPair1.assertMatch();

        // == test 1 ==
        int n2 = 116;
        boolean res2 = happyNumber(n2);
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("116 is a Happy Number? ", false, res2);
        resultPair2.assertMatch();
    }

}
