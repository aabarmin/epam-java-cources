package com.epam.university.java.core.task060;

/**
 * Interface for cache instance.
 */
public interface Cache {
    /**
     * Get Node from cache.
     * @param key of Node.
     * @return Node from cache.
     */
    String getNode(int key);

    /**
     * Add or update Node in cache.
     * @param key of Node.
     * @param value of Node.
     */
    void setNode(int key, String value);
}
