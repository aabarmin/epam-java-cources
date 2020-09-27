package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Some text.
 */
public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        if (collection == null || collection.length == 0) {
            throw new IllegalArgumentException();
        }
        List<String> newList = new ArrayList<>();
        for (String s : collection
        ) {
            newList.add(s);
        }
        int counter = 0;
        while (newList.size() > 1) {
            if (newList.size() == counter) {
                counter = 0;
                newList.remove(counter);
                counter++;
            } else if (newList.size() < counter) {
                counter = 1;
                newList.remove(counter);
                counter++;
            } else {
                newList.remove(counter);
                counter++;
            }
        }
        return newList.get(0);
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }

        int counter = 0;
        while (collection.size() > 1) {
            if (collection.size() == counter) {
                counter = 0;
                collection.remove(counter);
                counter++;
            } else if (collection.size() < counter) {
                counter = 1;
                collection.remove(counter);
                counter++;
            } else {
                collection.remove(counter);
                counter++;
            }
        }
        return collection.get(0);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }

        int counter = 0;
        while (collection.size() > 1) {
            if (collection.size() == counter) {
                counter = 0;
                collection.remove(counter);
                counter++;
            } else if (collection.size() < counter) {
                counter = 1;
                collection.remove(counter);
                counter++;
            } else {
                collection.remove(counter);
                counter++;
            }
        }
        return collection.get(0);
    }
}
