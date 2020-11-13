package com.epam.university.java.core.task060;

/**
 * Factory for creating new cache instance.
 */
public interface CacheFactory {
    /**
     * Create new cache instance.
     * @param size of new cache
     * @return new cache instance
     */
    Cache newInstance(int size);
}
