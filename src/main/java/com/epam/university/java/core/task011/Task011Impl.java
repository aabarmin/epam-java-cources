package com.epam.university.java.core.task011;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        ArrayList<String> names = new ArrayList<>(collection.length);
        names.addAll(Arrays.asList(collection));
        return getLastName(names);
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        if (collection.size() == 1) {
            return collection.get(0);
        }
        ArrayList<String> names = new ArrayList<>(collection);
        int index = 0;
        while (names.size() > 1) {
            names.remove(index);
            index = (++ index) % names.size();
        }
        return names.get(0);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        ArrayList<String> names = new ArrayList<>(collection.size());
        names.addAll(collection);
        return getLastName(names);
    }
}
