package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.List;

public class Task011Impl implements Task011 {

    /**
     * Given a circle of men, on each iteration one man leaves it through one.
     * You should determine name of last man.
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

        return getLastName(collection, 1);

    }

    /**
     * Given a circle of men, on each iteration one man leaves it through interval.
     * You should determine name of last man.
     *
     * <p>
     * Implementation with arrays
     * </p>
     *
     * @param collection collection of names
     * @param interval interval of leaving
     * @return name of last man
     */
    public String getLastName(String[] collection, int interval) {

        if (collection == null || collection.length == 0) {
            throw new IllegalArgumentException();
        }

        int countDown = 0;

        while (collection.length > 1) {

            int remainedCollectionLength =
                    (collection.length - countDown)
                    / (interval + 1)
                    * interval + countDown;

            String[] remainedCollection = new String[remainedCollectionLength];

            int j = 0;

            for (int i = 0; i < collection.length; i++) {

                if (countDown == 0) {
                    countDown = interval;
                } else {
                    remainedCollection[j] = collection[i];
                    j++;
                    countDown--;
                }

            }

            collection = remainedCollection;

        }

        return collection[0];
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

        String[] stringArray = collection.toArray(new String[collection.size()]);

        return getLastName(stringArray, 1);

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

        return getLastName(collection, 1);

    }

    /**
     * Given a circle of men, on each iteration one man leaves it through interval.
     * You should determine name of last man.
     *
     * <p>
     * Implementation with List
     * </p>
     *
     * @param collection collection of names
     * @param interval interval of leaving
     * @return name of last man
     */
    public String getLastName(LinkedList<String> collection, int interval) {

        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }

        int countDown = 0;

        while (collection.size() > 1) {

            ListIterator<String> iterator = collection.listIterator();

            while (iterator.hasNext()) {

                iterator.next();

                if (countDown == 0) {
                    iterator.remove();
                    countDown = interval;
                } else {
                    countDown--;
                }

            }

        }

        return collection.get(0);
    }


}
