package com.kaby.ds.arraysnstrings;

public class CompressString {


    public static void main(String[] args) {
        String input1 = "2c3at";
        String expInput1 = "ccaaat";

        String input2 = "2po5p";
        String expInput2 = "ppoppppp";

        System.out.println("Compressed string of " + expInput1 + " : Expected = " + input1 + "; Actual = " + compress(expInput1));
        System.out.println("Compressed string of " + expInput2 + " : Expected = " + input2 + "; Actual = " + compress(expInput2));

        System.out.println("Compressed string of " + expInput1 + " : Expected = " + input1 + "; Actual = " + compressPractice(expInput1));
        System.out.println("Compressed string of " + expInput2 + " : Expected = " + input2 + "; Actual = " + compressPractice(expInput2));


    }

    private static String compressPractice(String input) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        int j = 0;

        while(j <= input.length()) {
            if(j != input.length() && input.charAt(i) == input.charAt(j)) {
//                we are running a series
                j++;
            } else {
//                we have reached the end of a series
                int num = j - i;
                if(num != 1)
                    result.append(String.valueOf(num) + input.charAt(i));
                else
                    result.append(input.charAt(i));

                i = j;
                j++;
            }
        }

        return result.toString();

    }

    private static String compress(String input) {
        // Append the result to this string builder
        StringBuilder compressedResult = new StringBuilder();

        // 2 pointers
        // pointer i points to the start of a repetitive character streak
        // pointer j points to the end of a repetitive character streak; j is moving first
        int i = 0;
        int j = 0;

        while(j <= input.length()) {
            // If both the i and j pointers have the same character then we are still in a repetitive streak
            // So lets keep updating j
            // Note case where we are going outside the array length,
            // j will be updated to one element over the array length,
            // but we need to add a check to make sure we do not get an array out of bounds
            if(j != input.length() && input.charAt(i) == input.charAt(j)) {
                j++;
            } else {
                // We have ended a repetitive streak
                // The total number of repetitions is index of j - index of i
                int characterRepetitions = j - i;

                // Lets add this to our string builder result
                // exception to this is if the character repetitions is only 1
                if(characterRepetitions != 1) {
                    compressedResult.append(characterRepetitions);
                }
                // The character to append is the character pointed by i
                compressedResult.append(input.charAt(i));

                // Since we have ended a streak j is pointing to a new character
                // So lets move i to j
                i = j;
                // increment j
                j++;
            }
        }

        return compressedResult.toString();
    }
}
