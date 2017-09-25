package com.epam.university.java.core.task022;

import java.util.Collection;
import java.util.Comparator;

/**
 * Simple implementation of the binary heap. Root element is the minimum.
 * @param <T> type of the items. Must be comparable
 */
public class MinHeap<T extends Comparable<T>> extends AbstractBinaryHeap<T> {

    /**
     * Constructs MinHeap containing elements from the <code>items</code>.
     * Elements are compared in natural order (minimum first).
     * @param items collection of elements to store in the heap
     */
    public MinHeap(Collection<T> items) {
        super(items, Comparator.naturalOrder());
    }

    /**
     * Constructs empty MinHeap. Elements are compared in natural order (minimum first).
     */
    public MinHeap() {
        super(Comparator.naturalOrder());
    }

}
