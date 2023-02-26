package com.kaby.ds.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DecompressBraces {
    // Possible number digits
    public static String numbers = "0123456789";

    /**
     * Write a function, decompressBraces, that takes in a compressed string as an argument.
     * The function should return the string decompressed.
     * @param args
     */
    public static void main(String[] args) {

        String result1 = decompressBraces("2{q}3{tu}v", "qqtututuv"); // -> qqtututuv
        String result2 = decompressBraces("ch3{ao}", "chaoaoao");    // -> chaoaoao
        String result3 = decompressBraces("2{y3{o}}s", "yoooyooos");  // -> yoooyooos
        String result4 = decompressBraces("z3{a2{xy}b}", "zaxyxybaxyxybaxyxyb");// -> zaxyxybaxyxybaxyxyb
        
    }

    private static String decompressBraces(String str, String expected) {
        System.out.println("INPUT => " + str + ", EXPECTED => " + expected);

        // let's store the Characters to the stack
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            // If it is a letter or number store it to the stack
            if(str.charAt(i) != '{' && str.charAt(i) != '}') {
                stack.push(String.valueOf(str.charAt(i)));
            } else if(str.charAt(i) == '}') {
                // If it is an open brace { ignore it
                // If it is a close brace we have reached the end of a group, so we need to pop the stack
                // pop the stack until the top of the stack is a number
                String segment = "";
                // While there is a letter pop, stop when a number is next on the top of stack
                while(!numbers.contains(stack.peek())) {
                    // Note : the popped value goes first ex if u have tu as a segment that needs to be repeated
                    segment = stack.pop() + segment;
                }
                int repeatFreq = 0;
                if(numbers.contains(stack.peek())) {
                    // Get the number of times the segment should repeat
                    repeatFreq = Integer.parseInt(stack.pop());
                    // Repeat the segment repeat freq times and store it back on the stack
                    stack.push(segment.repeat(repeatFreq));
                }
            }
        }

        // Now that we have gone through the input string and
        // transformed it lets pop the stack and append to form a combined string
        String result = "";
        while(!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        System.out.println("RESULT of decompress => " + result);

        return result;

    }
}
