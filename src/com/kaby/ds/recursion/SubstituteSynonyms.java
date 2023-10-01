package com.kaby.ds.recursion;

import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SubstituteSynonyms {

    /**
     * Write a function, substitutingSynonyms, that takes in a sentence and an object as arguments.
     * The object contains words as keys whose values are arrays containing synonyms.
     * The function should return an array containing all possible sentences that can be
     * formed by substituting words of the sentence with their synonyms.
     * <p>
     * You may return the possible sentences in any order, as long as you return all of them.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        var sentence0 = "follow the yellow brick road";
        var synonyms0 = Map.of(
                "follow", List.of("chase", "pursue"),
                "yellow", List.of("gold", "amber", "lemon")
        );

        List<String> result0 = substituteSynonyms(sentence0, synonyms0);
        List<String> expected0 = List.of(
                "chase the gold brick road",
                "chase the amber brick road",
                "chase the lemon brick road",
                "pursue the gold brick road",
                "pursue the amber brick road",
                "pursue the lemon brick road"
        );
        ResultPair<List<String>, List<String>> resultPair0 = new ResultPair<>("Substituting Synonyms", expected0, result0);
        resultPair0.printResultPair();


        // == test_01: ==

        var sentence1 = "I think it's gonna be a long long time";
        var synonyms1 = Map.of(
                "think", List.of("believe", "reckon"),
                "long", List.of("lengthy", "prolonged")
        );

        List<String> result1 = substituteSynonyms(sentence1, synonyms1);
        List<String> expected1 = List.of(
                "I believe it's gonna be a lengthy lengthy time",
                "I believe it's gonna be a lengthy prolonged time",
                "I believe it's gonna be a prolonged lengthy time",
                "I believe it's gonna be a prolonged prolonged time",
                "I reckon it's gonna be a lengthy lengthy time",
                "I reckon it's gonna be a lengthy prolonged time",
                "I reckon it's gonna be a prolonged lengthy time",
                "I reckon it's gonna be a prolonged prolonged time"
        );
        ResultPair<List<String>, List<String>> resultPair1 = new ResultPair<>("Substituting Synonyms", expected1, result1);
        resultPair1.printResultPair();


        // == test_02: ==

        var sentence2 = "palms sweaty knees weak arms heavy";
        var synonyms2 = Map.of(
                "palms", List.of("hands", "fists"),
                "heavy", List.of("weighty", "hefty", "burdensome"),
                "weak", List.of("fragile", "feeble", "frail", "sickly")
        );

        List<String> result2 = substituteSynonyms(sentence2, synonyms2);
        List<String> expected2 = List.of(
                "hands sweaty knees fragile arms weighty",
                "hands sweaty knees fragile arms hefty",
                "hands sweaty knees fragile arms burdensome",
                "hands sweaty knees feeble arms weighty",
                "hands sweaty knees feeble arms hefty",
                "hands sweaty knees feeble arms burdensome",
                "hands sweaty knees frail arms weighty",
                "hands sweaty knees frail arms hefty",
                "hands sweaty knees frail arms burdensome",
                "hands sweaty knees sickly arms weighty",
                "hands sweaty knees sickly arms hefty",
                "hands sweaty knees sickly arms burdensome",
                "fists sweaty knees fragile arms weighty",
                "fists sweaty knees fragile arms hefty",
                "fists sweaty knees fragile arms burdensome",
                "fists sweaty knees feeble arms weighty",
                "fists sweaty knees feeble arms hefty",
                "fists sweaty knees feeble arms burdensome",
                "fists sweaty knees frail arms weighty",
                "fists sweaty knees frail arms hefty",
                "fists sweaty knees frail arms burdensome",
                "fists sweaty knees sickly arms weighty",
                "fists sweaty knees sickly arms hefty",
                "fists sweaty knees sickly arms burdensome"
        );
        ResultPair<List<String>, List<String>> resultPair2 = new ResultPair<>("Substituting Synonyms", expected2, result2);
        resultPair2.printResultPair();

    }

    private static List<String> substituteSynonyms(String sentence, Map<String, List<String>> synonyms) {

        // Split the sentence into words
        var words = sentence.split(" ");
        var subarrays = generate(words, synonyms);

        List<String> result = new ArrayList<>();

        for (List<String> subarray : subarrays) {
            // What is returned is a 2D List of strings, each list has all the substituted synonym combinations
            // We are joining each subarray as a string separated by a space
            String joined = String.join(" ", subarray);
            // String joined = subarray.stream().collect(Collectors.joining(" ")); // alternative to above

            result.add(joined);
        }

        return result;
    }

    static List<List<String>> generate(String[] words, Map<String, List<String>> synonyms) {
        // if the word is empty return and empty list
        if (words.length == 0) {
            return List.of(List.of());
        }

        // We are trying to reduce our word list
        // Get first word
        var firstWord = words[0];
        // Get remaining word list after removing first word
        var remainingWords = Arrays.copyOfRange(words, 1, words.length);

        // Run recursively on remaining words
        List<List<String>> subarrays = generate(remainingWords, synonyms);

        if (synonyms.containsKey(firstWord)) {
            // We need to substitute words as there is a synonym for first word
            List<List<String>> result = new ArrayList<>();

            // replace first word with each of the synonyms possible
            for (String synonym : synonyms.get(firstWord)) {
                for (List<String> subarray : subarrays) {
                    List<String> combined = new ArrayList<>();
                    combined.add(synonym);
                    combined.addAll(subarray);

                    result.add(combined);
                }
            }
            return result;
        } else {
            // We do not need to substitute words
            List<List<String>> result = new ArrayList<>();

            // first word did not have a synonym so add it at the beginning of list
            for (List<String> subarray : subarrays) {
                List<String> combined = new ArrayList<>();
                combined.add(firstWord);
                combined.addAll(subarray);

                result.add(combined);
            }
            return result;
        }
    }
}
