package com.epam.university.java.core.task011;

import com.epam.university.java.core.util.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

/**
 * Remove items from collection.
 */
public class Task011Impl implements Task011 {

    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     *
     * <p>
     *     Example: source collection: Homer Bart Maggie Lisa Marge
     *     First iteration: Homer leaves, Bart Maggie List Marge remained
     *     Second iteration: Maggie leaves, Bart List Marge remained
     *     Third iteration: Marge leaves, Bart and Lise remained
     *     Fourth iteration: Lisa leaves, Bart is the last one
     * </p>
     * <p>
     *     Implementation with arrays
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */
    @Override
    public String getLastName(String[] collection) {
        Utils.assertArrayNonNull(collection);
        int size = collection.length;
        Utils.assertPositive(size);

        Set<Integer> removed = new HashSet<>();
        int idx = size - 1;
        while (removed.size() < size - 1) {
            idx = firstNonRemoved(
                size,
                firstNonRemoved(size, idx, removed) + 1,
                removed
            );
            removed.add(idx);
        }

        return collection[firstNonRemoved(size, idx, removed)];
    }

    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     *
     * <p>
     *     Example: source collection: Homer Bart Maggie Lisa Marge
     *     First iteration: Homer leaves, Bart Maggie List Marge remained
     *     Second iteration: Maggie leaves, Bart List Marge remained
     *     Third iteration: Marge leaves, Bart and Lise remained
     *     Fourth iteration: Lisa leaves, Bart is the last one
     * </p>
     * <p>
     *     Implementation with ArrayList
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */
    @Override
    public String getLastName(ArrayList<String> collection) {
        Utils.assertNonNull(collection);
        Utils.assertPositive(collection.size());
        int currIdx = 0;
        while (collection.size() > 1) {
            collection.remove(currIdx);
            currIdx = (currIdx + 1) % collection.size();
        }
        return collection.get(0);
    }

    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     *
     * <p>
     *     Example: source collection: Homer Bart Maggie Lisa Marge
     *     First iteration: Homer leaves, Bart Maggie List Marge remained
     *     Second iteration: Maggie leaves, Bart List Marge remained
     *     Third iteration: Marge leaves, Bart and Lise remained
     *     Fourth iteration: Lisa leaves, Bart is the last one
     * </p>
     * <p>
     *     Implementation with LinkedList
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */
    @Override
    public String getLastName(LinkedList<String> collection) {
        Utils.assertNonNull(collection);
        if (collection.isEmpty()) {
            throw new IllegalArgumentException();
        }
        ListIterator<String> it = collection.listIterator();
        boolean shouldRemove = true;
        while (it.hasNext()) {
            boolean hasPrev = it.hasPrevious();
            it.next();
            if (shouldRemove) {
                if (hasPrev || it.hasNext()) { // should not remove if size == 0
                    it.remove();
                }
                shouldRemove = false;
            } else {
                shouldRemove = hasPrev || it.hasNext(); // false if list.size() == 1
                if (!shouldRemove) {
                    break;
                }
            }
            if (it.hasPrevious() && !it.hasNext()) { // true at the end of the list
                it = collection.listIterator();
            }
        }
        return collection.getFirst();
    }

    private int firstNonRemoved(int size, int idx, Set<Integer> removed) {
        if (idx >= size || idx < 0) {
            idx = 0;
        }
        while (removed.contains(idx)) {
            idx = (idx + 1) % size;
        }
        return idx;
    }

}
