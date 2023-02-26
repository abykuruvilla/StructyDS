package com.kaby.ds.arraysnstrings;

import java.util.ArrayList;
import java.util.List;

public class UncompressString {

    public static void main(String[] args) {
        String input1 = "2c3a1t";
        String expInput1 = "ccaaat";

        String input2 = "2p1o5p";
        String expInput2 = "ppoppppp";

        System.out.println("Uncompressed string of " +input1 + " : Expected = " + expInput1 + "; Actual = " + uncompress(input1));
        System.out.println("Uncompressed string of " +input2 + " : Expected = " + expInput2 + "; Actual = " + uncompress(input2));

        System.out.println("Uncompressed string of " +input1 + " : Expected = " + expInput1 + "; Actual = " + uncompressPractice(input1));
        System.out.println("Uncompressed string of " +input2 + " : Expected = " + expInput2 + "; Actual = " + uncompressPractice(input2));

    }

    private static String uncompressPractice(String input) {
        StringBuilder uncompressedString = new StringBuilder();
        String possibleNumbers = "0123456789";

        int i = 0;
        int j = 0;

        while(j < input.length()) {
            if(possibleNumbers.contains(String.valueOf(input.charAt(j)))){
                // its a number so move ahead pointer
                j++;
            } else {
                // we have reached a character, so find the number part
                int numberPart = Integer.parseInt(input.substring(i, j));
                for(int k = 0; k < numberPart; k++) {
                    uncompressedString.append(input.charAt(j));
                }
                // increment j
                j++;
                i = j;
            }
        }

        return uncompressedString.toString();

    }

    private static String uncompress(String input) {
        StringBuilder uncompressedString = new StringBuilder();
        String possibleNumbers = "0123456789"; // possible numbers we need to match with

        // 2 pointer strategy
        int i = 0;
        int j = 0;

        // j will move
        // i is the pointer at the start of a number group
        // j is the pointer at the end of a number group, j will be eventually at the character/letter
        while (j < input.length()) {
            // move j until we encounter a letter
            if(possibleNumbers.contains(String.valueOf(input.charAt(j)))) {
                j++;
            } else {
                // we have encountered a letter
                // get the number of times we want to repeat the letter
                int repeatNum = Integer.parseInt(input.substring(i, j));
                // loop though and add the character to the result 'm' times
                for(int x = 0; x < repeatNum; x++) {
                    uncompressedString.append(input.charAt(j));
                }
                // increment j
                j++;
                // move i to the same location which is the start of the next group
                i = j;
            }
        }

        return uncompressedString.toString();
    }
}
