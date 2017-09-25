package com.epam.university.java.core.task022;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Partial implementation of the binary heap. Requires comparator for items.
 * @param <T> type of the items. Must be comparable
 */
public abstract class AbstractBinaryHeap<T extends Comparable<T>> implements BinaryHeap<T> {

    protected final ArrayList<T> items;
    private final Comparator<T> itemsComparator;

    /**
     * Constructs a binary heap containing elements from the <code>items</code>.
     * @param items collection of elements to store in the heap
     * @param comparator comparator for heap elements
     */
    public AbstractBinaryHeap(Collection<T> items, Comparator<T> comparator) {
        this.itemsComparator = comparator;
        this.items = new ArrayList<>(items);
        for (int i = this.items.size() / 2 - 1; i >= 0; --i) {
            siftDown(i);
        }
    }

    /**
     * Constructs empty a binary heap.
     * @param comparator comparator for heap elements
     */
    public AbstractBinaryHeap(Comparator<T> comparator) {
        this.itemsComparator = comparator;
        this.items = new ArrayList<>();
    }

    /**
     * Insert given item in the heap.
     * @param item item to be inserted
     */
    @Override
    public void insert(T item) {
        items.add(item);
        siftUp(items.size() - 1);
    }

    /**
     * Remove root element from the heap and return it.
     * @return root element
     */
    @Override
    public T extract() {
        final int lastIdx = items.size() - 1;
        Collections.swap(items, 0, lastIdx);
        final T item = items.get(lastIdx);
        items.remove(lastIdx);
        siftDown(0);
        return item;
    }

    /**
     * Check if heap is empty.
     * @return <code>true</code> if heap has no elements else <code>false</code>
     */
    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Return amount of the elements in the heap.
     * @return heap size
     */
    @Override
    public int size() {
        return items.size();
    }

    /**
     * Swap item with it's parent while item is less than the parent due
     * to <code>itemsComparator</code>.
     * @param idx index of the element to "bubble up"
     */
    private void siftUp(int idx) {
        while (idx > 0 && itemsComparator.compare(items.get(idx), items.get(parent(idx))) < 0) {
            Collections.swap(items, idx, parent(idx));
            idx = parent(idx);
        }
    }

    /**
     * Swap item with it's child while child is less than this item due to
     * <code>itemsComparator</code>.
     * @param idx index of the element to "drown"
     */
    private void siftDown(int idx) {
        int idxToSwap = idx;
        final int leftIdx = leftChild(idx);
        if (leftIdx < items.size()
            && itemsComparator.compare(items.get(leftIdx), items.get(idx)) < 0) {
            idxToSwap = leftIdx;
        }
        final int rightIdx = rightChild(idx);
        if (rightIdx < items.size()
            && itemsComparator.compare(items.get(rightIdx), items.get(idx)) < 0) {
            idxToSwap = rightIdx;
        }
        if (idx != idxToSwap) {
            Collections.swap(items, idx, idxToSwap);
            siftDown(idxToSwap);
        }
    }

}
