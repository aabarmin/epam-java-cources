package com.epam.university.java.core.task011;

import sun.reflect.Reflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Remove items from collection.
 */
public class Task011Impl implements Task011 {
    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     *
     * <p>
     * Example: source collection: Homer Bart Maggie Lisa Marge
     * First iteration: Homer leaves, Bart Maggie List Marge remained
     * Second iteration: Maggie leaves, Bart Lisa Marge remained
     * Third iteration: Marge leaves, Bart and Lisa remained
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
    public String getLastName(String[] collection) {
        if (collection.length == 0) {
            throw new IllegalArgumentException();
        }

        List<String> result = new ArrayList<>(Arrays.asList(collection));
        for (int toRemove = 0, i = 0;
             result.size() > 1;
             i++, toRemove = (toRemove + 2) % result.size()) {
            result.remove(toRemove);
        }

        return result.get(0);
    }

    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     * <p>
     * Example: source collection: Homer Bart Maggie Lisa Marge
     * First iteration: Homer leaves, Bart Maggie List Marge remained
     * Second iteration: Maggie leaves, Bart Lisa Marge remained
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
    public String getLastName(ArrayList<String> collection) {
        if (collection.size() == 0) {
            throw new IllegalArgumentException();
        }

        List<String> result = new ArrayList<>(collection);
        for (int toRemove = 0, i = 0;
             result.size() > 1;
             i++, toRemove = (toRemove + 2) % result.size()) {
            result.remove(toRemove);
        }

        return result.get(0);
    }

    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     * <p>
     * Example: source collection: Homer Bart Maggie Lisa Marge
     * First iteration: Homer leaves, Bart Maggie Lisa Marge remained
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
    public String getLastName(LinkedList<String> collection) {
        if (collection.size() == 0) {
            throw new IllegalArgumentException();
        }

        List<String> result = new ArrayList<>(collection);
        for (int toRemove = 0, i = 0;
             result.size() > 1;
             i++, toRemove = (toRemove + 2) % result.size()) {
            result.remove(toRemove);
        }

        return result.get(0);
    }
}
