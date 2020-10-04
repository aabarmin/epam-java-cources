package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

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
        if (collection == null || collection.length == 0) {
            throw new IllegalArgumentException();
        }
        int len = collection.length;
        int absPos = (josephus(len, 2) - 2);
        int pos = 0;
        if (absPos > 0) {
            pos = absPos % len;
        } else {
            pos = (len + 2 - absPos) % len;
        }
        return collection[pos];

    }


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
     * Implementation with ArrayList
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */
    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        int len = collection.size();
        int absPos = (josephus(len, 2) - 2);
        int pos = 0;
        if (absPos > 0) {
            pos = absPos % len;
        } else {
            pos = (len + 2 - absPos) % len;
        }
        return collection.get(pos);
    }

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
     * Implementation with LinkedList
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */
    @Override
    public String getLastName(LinkedList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        int len = collection.size();
        int absPos = (josephus(len, 2) - 2);
        int pos = 0;
        if (absPos > 0) {
            pos = absPos % len;
        } else {
            pos = (len + 2 - absPos) % len;
        }
        return collection.get(pos);
    }

    /**
     * Method that solves Josephus Problem.
     *
     * @param n number of elements
     * @param k interval
     * @return position of the last element (counts from 1)
     */
    static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }
}
