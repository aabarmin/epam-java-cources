package com.epam.university.java.core.task011;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
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

        return getLastName(new ArrayList<>(Arrays.asList(collection)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName(ArrayList<String> collection) {

        Collections.sort(collection, Collections.reverseOrder());
        for (; collection.size() > 1; collection.remove(0)) {};
        return collection.get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName(LinkedList<String> collection) {
        return getLastName(new ArrayList<>(collection));
    }
}
