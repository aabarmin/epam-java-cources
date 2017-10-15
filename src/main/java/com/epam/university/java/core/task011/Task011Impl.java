package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName(String[] collection) {
        if (collection == null || collection.length == 0) {
            throw new IllegalArgumentException();
        }
        return getLastName(new ArrayList<>(Arrays.asList(collection)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        if (collection.size() == 1) {
            return collection.get(0);
        }
        int counter = 0;
        String result = "";
        while (collection.size() > 1) {
            if (counter >= collection.size()) {
                counter = counter % collection.size();
            }
            collection.remove(counter);
            counter++;
        }
        return collection.get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName(LinkedList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        if (collection.size() == 1) {
            return collection.get(0);
        }
        boolean blackMark = true;
        while (collection.size() > 1) {
            Iterator<String> iterator = collection.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (blackMark) {
                    iterator.remove();
                    blackMark = !blackMark;
                } else {
                    blackMark = !blackMark;
                }
            }
        }
        return collection.peek();
    }
}
