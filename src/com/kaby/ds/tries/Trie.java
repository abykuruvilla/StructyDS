package com.kaby.ds.tries;

import com.kaby.ds.helper.ResultPair;
import com.kaby.ds.tries.models.TrieNode;

public class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys
     * in a dataset of strings. There are various applications of this data structure, such as autocomplete and
     * spellchecker.
     * <p>
     * Implement the Trie class:
     * <p>
     * Trie() Initializes the trie object.
     * void insert(String word) Inserts the string word into the trie.
     * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
     * and false otherwise.
     * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the
     * prefix prefix, and false otherwise.
     *
     * @param args
     */
    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        Boolean result1 = trie.search("apple");   // return True
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Search apple", Boolean.TRUE, result1);
        resultPair1.printResultPair();

        Boolean result2 = trie.search("app");     // return False
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Search app", Boolean.FALSE, result2);
        resultPair2.printResultPair();

        Boolean result3 = trie.startsWith("app"); // return True
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Word starting with prefix app?", Boolean.TRUE, result3);
        resultPair3.printResultPair();

        trie.insert("app");
        Boolean result4 = trie.search("app");     // return True
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Search app?", Boolean.TRUE, result4);
        resultPair4.printResultPair();

        trie.insert("presentation");
        Boolean result5 = trie.search("presentation");     // return True
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("Search presentation?", Boolean.TRUE, result5);
        resultPair5.printResultPair();

        trie.delete("presentation");
        Boolean result6 = trie.search("presentation");     // return True
        ResultPair<Boolean, Boolean> resultPair6 = new ResultPair<>("Search presentation after delete?", Boolean.FALSE, result6);
        resultPair6.printResultPair();

        trie.delete("apple");
        Boolean result7 = trie.search("apple");
        ResultPair<Boolean, Boolean> resultPair7 = new ResultPair<>("Search apple after delete?", Boolean.FALSE, result7);
        resultPair7.printResultPair();
    }

    private Boolean startsWith(String prefix) {
        // Start at root
        TrieNode current = root;

        for (Character letter : prefix.toCharArray()) {
            if (!current.children.containsKey(letter)) {
                return Boolean.FALSE;
            }
            current = current.children.get(letter);
        }

        return Boolean.TRUE;
    }

    private Boolean search(String word) {
        // Start at root
        TrieNode current = root;

        for (Character letter : word.toCharArray()) {
            // if at any character the children map does not contain the char return false
            if (!current.children.containsKey(letter)) {
                return Boolean.FALSE;
            }
            // current is updated to the children of the current letter
            current = current.children.get(letter);

        }

        // the word passed in might be a prefix to a word inserted, hence let's see if this is end of word
        return current.endOfWord;
    }

    private void insert(String word) {

        // Start at root
        TrieNode current = root;

        // Add each character of the string to children
        for (Character letter : word.toCharArray()) {
            // If absent create a new TrieNode for letter
            current.children.computeIfAbsent(letter, l -> new TrieNode());
            current = current.children.get(letter);
        }

        // We are done with all characters so we should be at last char
        current.endOfWord = Boolean.TRUE;
    }

    public void delete(String word) {
        deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            return current.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = deleteHelper(node, word, index + 1) && !node.endOfWord;

        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            System.out.println("Removing " + ch);
            return current.children.isEmpty();
        }
        return false;
    }

}
