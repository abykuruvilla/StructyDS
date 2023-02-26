package com.kaby.ds.stack;

import java.util.Stack;

public class BefittingBrackets {

    /**
     * Write a function, befittingBrackets, that takes in a string as an argument.
     * The function should return a boolean indicating whether or not the string contains
     * correctly matched brackets.
     *
     * You may assume the string contains only characters: ( ) [ ] { }
     * @param args
     */
    public static void main(String[] args) {
        boolean result1 = befittingBrackets("(){}[](())"); // -> true
        System.out.println("(){}[](()) is a well formed brackets : Actual = " + result1);
        boolean result2 = befittingBrackets("[][}"); // -> false
        System.out.println("[][} is NOT a well formed brackets : Actual = " + result2);
        boolean result3 = befittingBrackets("({[]})"); // -> true
        System.out.println("({[]}) is a well formed brackets: Actual = " + result3);
    }

    private static boolean befittingBrackets(String str) {
        // Create a stack to store the openings of the brackets
        Stack<Character> stack = new Stack<>();

        // Store all the brackets on the stack
        for(int i = 0; i < str.length(); i++) {
            // if we have an opening bracket store it on the stack
            if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else if(str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}') {
                // if we have a closing bracket, check if the top of the stack has an opening bracket
                if(stack.peek() == '(' && str.charAt(i) == ')' ||
                        stack.peek() == '[' && str.charAt(i) == ']' ||
                        stack.peek() == '{' && str.charAt(i) == '}') {
                    stack.pop();
                }
            }
        }

        // If at the end the stack is not empty we do not have befitting brackets
        return stack.isEmpty();
    }
}
