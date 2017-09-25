package com.epam.university.java.core.task022;

import java.util.Collection;
import java.util.Comparator;

/**
 * Simple implementation of the binary heap. Root element is the maximum.
 * @param <T> type of the items. Must be comparable
 */
public class MaxHeap<T extends Comparable<T>> extends AbstractBinaryHeap<T> {

    /**
     * Constructs MaxHeap containing elements from the <code>items</code>.
     * Elements are compared in reversed order (maximum first).
     * @param items collection of elements to store in the heap
     */
    public MaxHeap(Collection<T> items) {
        super(items, Comparator.reverseOrder());
    }

    /**
     * Constructs empty MaxHeap. Elements are compared in reversed order (maximum first).
     */
    public MaxHeap() {
        super(Comparator.reverseOrder());
    }

}
