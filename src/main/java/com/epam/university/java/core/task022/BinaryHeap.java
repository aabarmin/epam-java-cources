package com.epam.university.java.core.task022;

import java.util.NoSuchElementException;

/**
 * Simple interface for binary heap.
 * @param <T> type of the items. Must be comparable
 */
public interface BinaryHeap<T extends Comparable<T>> {

    /**
     * Insert given item in the heap.
     * @param item item to be inserted
     */
    void insert(T item);

    /**
     * Remove root element from the heap and return it.
     * @return root element
     */
    T extract();

    /**
     * Check if heap is empty.
     * @return <code>true</code> if heap has no elements else <code>false</code>
     */
    boolean isEmpty();

    /**
     * Return amount of the elements in the heap.
     * @return heap size
     */
    int size();

    /**
     * Find index of the parent item for item with given index.
     * @param idx index of item
     * @return parent index
     * @throws NoSuchElementException if idx <= 0
     */
    default int parent(int idx) throws NoSuchElementException {
        if (idx <= 0) {
            throw new NoSuchElementException();
        }
        return (idx - 1) >>> 1;
    }

    /**
     * Find index of the left child item for item with given index.
     * @param idx index of item
     * @return left child index
     * @throws NoSuchElementException if idx < 0
     */
    default int leftChild(int idx) throws NoSuchElementException {
        if (idx < 0) {
            throw new NoSuchElementException();
        }
        return 1 + (idx << 1);
    }

    /**
     * Find index of the right child item for item with given index.
     * @param idx index of item
     * @return right child index
     * @throws NoSuchElementException if idx < 0
     */
    default int rightChild(int idx) throws NoSuchElementException {
        if (idx < 0) {
            throw new NoSuchElementException();
        }
        return (idx + 1) << 1;
    }

}
