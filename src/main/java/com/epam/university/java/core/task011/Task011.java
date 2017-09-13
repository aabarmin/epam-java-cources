package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Remove items from collection.
 */
public interface Task011 {
    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     *
     * <p>
     *     Example: source collection: Homer Bart Maggie Lisa Marge
     *     First iteration: Homer leaves, Bart Maggie Lisa Marge remained
     *     Second iteration: Maggie leaves, Bart Lisa Marge remained
     *     Third iteration: Marge leaves, Bart and Lisa remained
     *     Fourth iteration: Lisa leaves, Bart is the last one
     * </p>
     * <p>
     *     Implementation with arrays
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */
    String getLastName(String[] collection);

    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     *
     * <p>
     *     Example: source collection: Homer Bart Maggie Lisa Marge
     *     First iteration: Homer leaves, Bart Maggie Lisa Marge remained
     *     Second iteration: Maggie leaves, Bart Lisa Marge remained
     *     Third iteration: Marge leaves, Bart and Lisa remained
     *     Fourth iteration: Lisa leaves, Bart is the last one
     * </p>
     * <p>
     *     Implementation with ArrayList
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */
    String getLastName(ArrayList<String> collection);

    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     *
     * <p>
     *     Example: source collection: Homer Bart Maggie Lisa Marge
     *     First iteration: Homer leaves, Bart Maggie Lisa Marge remained
     *     Second iteration: Maggie leaves, Bart Lisa Marge remained
     *     Third iteration: Marge leaves, Bart and Lisa remained
     *     Fourth iteration: Lisa leaves, Bart is the last one
     * </p>
     * <p>
     *     Implementation with LinkedList
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */
    String getLastName(LinkedList<String> collection);
}
