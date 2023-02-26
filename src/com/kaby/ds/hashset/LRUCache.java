package com.kaby.ds.hashset;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {

    Set<Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashSet<>(capacity);
        this.capacity = capacity;
    }
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(4);
        cache.refer(1);  // 1
        cache.refer(2);  // 1, 2
        cache.refer(3);  // 1, 2, 3
        cache.refer(1);  // 2, 3, 1
        cache.refer(4);  // 2, 3, 1, 4
        cache.refer(5);  // 3, 1, 4, 5

        cache.display();


    }

    private void display() {
        LinkedList<Integer> list = new LinkedList<>(cache);

        Iterator<Integer> itr = list.descendingIterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
    }

    // refer to the key within the LRU cache
    private void refer(int key) {
        if(!get(key)) {
            put(key);
        }
    }

    private void put(int key) {
        if(cache.size() == capacity) {
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }

        cache.add(key);
    }

    private boolean get(int key) {
        if(!cache.contains(key)) {
            return false;
        }
        // If cache contains key
        cache.remove(key);
        cache.add(key);
        return true;
    }
}
