package com.kaby.ds.tries.models;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public Map<Character, TrieNode> children = new HashMap<>();
    public Boolean endOfWord = Boolean.FALSE;

    public TrieNode() {
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "children=" + children +
                ", endOfWord=" + endOfWord +
                '}';
    }
}
