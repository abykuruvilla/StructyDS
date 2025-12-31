package com.kaby.ds.cip.ch3;

import com.kaby.ds.helper.ResultPair;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A custom implementation of a Least Recently Used (LRU) cache using LinkedHashMap.
 */
public class LRUCacheUsingLinkedHashMap extends LinkedHashMap<Integer, Integer> {

    private final int capacity;


    /**
     * Constructs a new LRUCacheUsingLinkedHashMap with the specified capacity.
     *
     * @param capacity The maximum number of entries the cache can hold.
     */
    public LRUCacheUsingLinkedHashMap(int capacity) {
        super(capacity, 0.75F, true); // accessOrder keeps the order, loadFactor of 0.75 decides when to extend cache
        this.capacity = capacity;
    }


    /**
     * This method determines whether the eldest entry should be removed from the cache.
     * It checks if adding a new entry would exceed the capacity of the cache.
     *
     * @param eldest The eldest entry to consider for removal
     * @return True if the eldest entry should be removed, false otherwise
     */
    @Override
    public boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > capacity;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param key The key for which to retrieve the value. If this key does not exist in the cache,
     *           returns -1.
     * @return The value associated with the key, or -1 if the key is not available.
     */
    @Override
    public Integer get(Object key) {
        Integer result =  super.get(key);
        if (result == null) {
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        LRUCacheUsingLinkedHashMap cache = new LRUCacheUsingLinkedHashMap(3);
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
