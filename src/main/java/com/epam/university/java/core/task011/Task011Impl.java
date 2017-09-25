package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Александр on 12.09.2017.
 */
public class Task011Impl implements Task011 {
    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     *
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
    public String getLastName(String[] collection) {
        return collection[collection.length - 1];
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
        return collection.get(collection.size() - 1);
    }

    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     * <p>
     * Example: source collection: Homer Bart Maggie Lisa Marge
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
    public String getLastName(LinkedList<String> collection) {
        return collection.getLast();
    }
}
