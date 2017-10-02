package com.epam.university.java.core.task011;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Collection;

/**
 * Created by Daniil Smirnov on 17.09.2017.
 * All copy registered MF.
 */
public class Task011Impl implements Task011 {

    @Override
    public String getLastName(String[] collection) {
        List<String> s = new ArrayList<>();
        Collections.addAll(s, collection);
        checkCollection(s);
        return removingForCollections(s).get(0);
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        checkCollection(collection);
        return removingForCollections(collection).get(0);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        checkCollection(collection);
        return removingForCollections(collection).get(0);

    }

    private List<String> removingForCollections(List<String> collection) {

        int i = 0;
        while (collection.size() != 1) {
            if (i > collection.size()) {
                i = 1;
            } else if (i == collection.size()) {
                i = 0;
            }
            collection.remove(i);
            i += 1;
        }
        return collection;
    }

    private void checkCollection(Collection collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
