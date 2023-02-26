package com.kaby.ds.stack;

import java.util.Stack;

public class PairedParenthesis {

    /**
     * Write a function, pairedParentheses, that takes in a string as an argument.
     * The function should return a boolean indicating whether or not the string has well-formed parentheses
     * @param args
     */
    public static void main(String[] args) {
        boolean result1 = pairedParentheses("(david)((abby))"); // -> true
        System.out.println("(david)((abby)) is a well formed parenthesis : Actual = " + result1);
        boolean result2 = pairedParentheses("()rose(jeff"); // -> false
        System.out.println("()rose(jeff is NOT a well formed parenthesis : Actual = " + result2);
        boolean result3 = pairedParenthesesCounter("(((potato())))"); // -> true
        System.out.println("(((potato()))) is a well formed parenthesis (COUNTER) : Actual = " + result3);
    }

    // Using a STACK
    private static boolean pairedParentheses(String str) {

        // Create a Stack to store the open parenthesis
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            // if it is an open parens push it onto the stack
            if(str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            // If the current char is a closing parens, check the stack to make sure that it is not empty
            // and the top of the stack has an open parens. If it does pop the top of the stack as there is a matching pair
            if(str.charAt(i) == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }

        // The parenthesis is well formed if the stack is empty at this point
        return stack.isEmpty();
    }

    // Using a counter
    private static boolean pairedParenthesesCounter(String str) {
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                count += 1;
            } else if(str.charAt(i) == ')') {
                if(count == 0) {
                    return false;
                }
                count -= 1;
            }
        }

        return count == 0;
    }
}
