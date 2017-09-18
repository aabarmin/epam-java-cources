package com.epam.university.java.core.task017;

import java.util.Collection;

/**
 * Instance with children.
 * @param <T> type of child
 */
public interface Container<T> {
    /**
     * Get collection of child instances.
     * @return collection of children
     */
    Collection<T> getChildren();

    /**
     * Add instance as child.
     * @param child instance to add
     */
    void addChild(T child);
}
