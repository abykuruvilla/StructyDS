package com.kaby.ds.stack;

import java.util.Stack;

public class NestingScores {

    /**
     * Write a function, nestingScore, that takes in a string of brackets as an argument.
     * The function should return the score of the string according to the following rules:
     *
     *     [] is worth 1 point
     *     XY is worth m + n points where X, Y are substrings of well-formed brackets and
     *     m, n are their respective scores
     *     [S] is worth 2 * k points where S is a substring of well-formed brackets and k
     *     is the score of that substring
     * @param args
     */
    public static void main(String[] args) {
        int result1 = nestingScore("[]", 1); // -> 1
        int result2 = nestingScore("[[]]", 2); // -> 2
        int result3 = nestingScore("[[][][]]", 6); // -> 6
        int result4 = nestingScore("[][[][]][[]]", 7); // -> 7
    }

    private static int nestingScore(String str, int expected) {
        System.out.println("INPUT => " + str + ", EXPECTED => " + expected);

        // initialize a stack with 0 on it
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // assuming an empty string as input has 0 as score

        // Loop through the string
        for(int i = 0; i < str.length(); i++) {
            // for each opening bracket push a 0 onto the stack
            if(str.charAt(i) == '[') {
                stack.push(0);
            } else {
                // If we encounter a closing bracket
                // pop the top value
                int popped = stack.pop();

                if(popped == 0) {
                    // If the popped value was a zero, add 1 to the top value of the stack
                    stack.push(stack.pop() + 1);
                } else {
                    // we have a nested bracket, so pop the top, multiply by 2 and save back to the stack
                    stack.push(stack.pop() + 2 * popped);
                }
            }

        }
        // Stack has the result with the score
        int result = stack.pop();
        System.out.println("ACTUAL => " + result +  "\n");

        return result;
    }
}
