package com.epam.university.java.core.task060;

/**
 * Implement an LRU (Least Recently Used) cache.
 * It should be able to be initialized with a cache size n.
 * If there are already n items in the cache and we are adding a new item,
 * then it should also remove the least recently used item.
 * If no such key exists, return 0.
 */
public interface Task060 {

    /**
     * Create new cache instance.
     * @param size of cache.
     * @return new cache instance.
     */
    Cache createCache(int size);

    /**
     * Sets key to value.
     * @param cache is used.
     * @param key of cache.
     * @param value of cache.
     */
    void set(Cache cache, int key, String value);

    /**
     * Gets the value at key.
     * @param cache is used.
     * @param key of cache.
     * @return value of cache.
     */
    String get(Cache cache, int key);
}
