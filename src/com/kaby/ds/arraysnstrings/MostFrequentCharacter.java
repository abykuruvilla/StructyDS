package com.kaby.ds.arraysnstrings;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentCharacter {


    /**
     * Write a function, mostFrequentChar, that takes in a string as an argument.
     * The function should return the most frequent character of the string.
     * If there are ties, return the character that appears earlier in the string.
     * @param args
     */
    public static void main(String[] args) {
        String input1 = "bookeeper"; // e
        String input2 = "potato";    // t
        String input3 = "david";     // d

        System.out.println("Most frequent char for " + input1 + " ; Expected is e, Actual is => " + mostFreqChar(input1));
        System.out.println("Most frequent char for " + input2 + " ; Expected is o, Actual is => " + mostFreqChar(input2));
        System.out.println("Most frequent char for " + input3 + " ; Expected is d, Actual is => " + mostFreqChar(input3));

    }

    private static String mostFreqChar(String input) {
        // Find the character count of each string and store in a counter Map
        Map<Character, Integer> characterCountMap = new HashMap<>();
        populateCharacterCount(input, characterCountMap);

        Character characterWithMaxCount = null;
        for(int j = 0; j < input.length(); j++) {
            // if the character with max count is null or if the count of the current character is
            // greater than that of previous max count character update the character
            if(characterWithMaxCount == null || characterCountMap.get(input.charAt(j)) > characterCountMap.get(characterWithMaxCount)) {
                characterWithMaxCount = input.charAt(j);
            }
        }

        return characterWithMaxCount.toString();
    }

    private static void populateCharacterCount(String input, Map<Character, Integer> characterCountMap) {
        for(int i = 0; i < input.length(); i++) {
            if(!characterCountMap.containsKey(input.charAt(i))) {
                characterCountMap.put(input.charAt(i), 1);
            } else {
                int currentCount = characterCountMap.get(input.charAt(i));
                characterCountMap.put(input.charAt(i), ++currentCount);
            }
        }
    }
}
