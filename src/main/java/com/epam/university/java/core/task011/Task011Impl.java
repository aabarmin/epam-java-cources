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

        int i;
        int offset = 0;
        while (collection.size() > 1) {
            for (i = offset; i < collection.size(); i++) {
                collection.remove(i);
            }
            offset = (i == collection.size()) ? 0 : 1;
        }

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
