package com.kaby.ds.cip.ch3;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;
import java.util.Map;

/**
 * This implementation uses a LinkedList and HashMap to keep get and put with time complexity of O(1)
 * Space complexity is O(n)
 */
public class LRUCache {

    /**
     * The head side of the DLL  is the least frequently used, the tail size of the DLL is the most frequently used
     * @param <K>
     * @param <V>
     */
    static class DLLNode<K, V> {

        DLLNode<K, V> prev;
        DLLNode<K, V> next;
        K key;
        V value;

        public DLLNode(K key, V value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    int capacity; // capacity of the LRU cache
    Map<Integer, DLLNode<Integer, Integer>> map;
    DLLNode<Integer, Integer> head;
    DLLNode<Integer, Integer> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // A HashMap that maps keys to Nodes
        this.map = new HashMap<>();
        // Initialize the head and tail dummy nodes and connect them to each other to establish a basic two-node DLL
        this.head = new DLLNode<>(-1, -1);
        this.tail = new DLLNode<>(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void put(int key, int value) {
        // If the node with this key already exists, remove its node and re-add it to the tail of the DLL
        if(map.containsKey(key)) {
            removeNode(map.get(key));
        }
        DLLNode<Integer, Integer> newNode = new DLLNode<>(key, value);
        map.put(key, newNode);
        // Remove the least recently used node from the cache if adding this new node will result in an overflow
        if(map.size() >= capacity) {
            map.remove(head.next.key);
            removeNode(head.next);
        }
        addNodeToTail(newNode);
    }

    public int get(int key) {
        // Map does not contain they key, return -1
        if(!map.containsKey(key)) {
            return -1;
        }

        // Since this key was accessed, this key becomes the most recently used,
        // remove its node and re-add it to the tail of the linked list.
        removeNode(map.get(key));
        addNodeToTail(map.get(key));

        return map.get(key).value;
    }

    private void addNodeToTail(DLLNode<Integer, Integer> node) {
        // The new node should be added after the previous node and before the tail node
        DLLNode<Integer, Integer> prevNode = tail.prev;
        node.prev = prevNode;
        prevNode.next = node;
        node.next = tail;
        tail.prev = node;
    }

    private void removeNode(DLLNode<Integer, Integer> node) {
        // To remove a node we make the two adjacent nodes to the node point to each other
        DLLNode<Integer, Integer> prevNode = node.prev;
        DLLNode<Integer, Integer> nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }


    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache that supports
     * 1. LRU Cache takes a capacity when it is initialized
     * 2. get(key) - Returns value associated with key. Return -1 if the key is not available
     * 3. put(key, val) - Add a key and its value to the cache.
     * If adding the key results in cache exceeding its capacity, evict the least recently used element.
     * If key exists in cache, update its value
     * @param args
     */
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);
        cache.put(1, 100); // cache = [1:100]
        cache.put(2, 250); // cache = [1:100, 2:250]
        int res1 = cache.get(2); // 250
        ResultPair<Integer, Integer> resultPair = new ResultPair<>("Key = 2 : ", 250, res1);
        resultPair.assertMatch();
        cache.put(4, 300); // cache = [1:100, 2:250, 4:300]
        cache.put(3, 200); // cache = [2:250, 4:300, 3:200]
        int res2 = cache.get(4); // 300
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Key = 4 : ", 300, res2);
        resultPair2.assertMatch();
        int res3 = cache.get(1); // key 1 was evicted; return -1
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("Key = 1 : ", -1, res3);
        resultPair3.assertMatch();

    }

}
