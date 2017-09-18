package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Remove items from collection.
 */
public final class Task011Impl implements Task011 {
    /**
     * Given a circle of men, on each iteration one man leaves it
     * through one. You should determine name of last man.
     * <p>
     * <p>
     * Example: source collection: Homer Bart Maggie Lisa Marge
     * First iteration: Homer leaves, Bart Maggie List Marge remained
     * Second iteration: Maggie leaves, Bart List Marge remained
     * Third iteration: Marge leaves, Bart and Lise remained
     * Fourth iteration: Lisa leaves, Bart is the last one
     * </p>
     * <p>
     * Implementation with arrays
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */
    @Override
    public String getLastName(final String[] collection) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(collection));
        return getLastName(arrayList);
    }

    /**
     * Given a circle of men, on each iteration one man leaves it
     * through one. You should determine name of last man.
     * <p>
     * <p>
     * Example: source collection: Homer Bart Maggie Lisa Marge
     * First iteration: Homer leaves, Bart Maggie List Marge remained
     * Second iteration: Maggie leaves, Bart List Marge remained
     * Third iteration: Marge leaves, Bart and Lise remained
     * Fourth iteration: Lisa leaves, Bart is the last one
     * </p>
     * <p>
     * Implementation with ArrayList
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */
    @Override
    public String getLastName(final ArrayList<String> collection) {
        List<String> list = new ArrayList<>(collection);

        int i = 0;
        while (list.size() > 1) {
            if (i < list.size()) {
                list.remove(i);
                i++;
            } else {
                i = i - list.size();
            }
        }
        return list.get(0);
    }

    /**
     * Given a circle of men, on each iteration one man leaves it
     * through one. You should determine name of last man.
     * <p>
     * <p>
     * <p>
     * First iteration: Homer leaves, Bart Maggie List Marge remained
     * Second iteration: Maggie leaves, Bart List Marge remained
     * Third iteration: Marge leaves, Bart and Lise remained
     * Fourth iteration: Lisa leaves, Bart is the last one
     * </p>
     * <p>
     * Implementation with LinkedList
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */
    @Override
    public String getLastName(final LinkedList<String> collection) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(collection);
        return getLastName(arrayList);
    }
}
