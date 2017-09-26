package com.epam.university.java.core.task011;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Implementation class for Task011.
 *
 * @author Sergei Titov
 */
public class Task011Impl implements Task011 {
    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName(String[] collection) {

        // not fair :)
        //return getLastName(new ArrayList<>(Arrays.asList(collection)));

        int nullified = 0;
        boolean odd = false;

        for (int i = 0;; i = ++i % collection.length) {
            if (null != collection[i]) {
                // treat nullified as if they were absent
                if (nullified == collection.length - 1) {
                    return collection[i];
                }
                // nullify only one over one
                if (odd = !odd) {
                    nullified++;
                    collection[i] = null;
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName(ArrayList<String> collection) {

        return getLastName((AbstractList)collection);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName(LinkedList<String> collection) {

        return getLastName((AbstractList)collection);
    }


    /**
     * Base algorithm method.
     *
     * @param collection is a super class interface ref
     *
     * @return last man standing name
     */
    public String getLastName(AbstractList<String> collection) {

        for (int i = 0; collection.size() > 1; i++) {
            collection.remove(i % collection.size());
        }

        return collection.get(0);
    }
}
