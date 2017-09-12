package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(ArrayList<String> collection) {
        int i = 0;
        while (collection.size() != 1) {
            if (collection.size() > i + 1) {
                collection.remove(i);
                i++;
            } else {
                collection.remove(i);
                i = 1;
            }
        }
        return collection.get(0);
    }

    @Override
    public String getLastName(String[] collection) {
        return getLastName(new ArrayList<>(new ArrayList<>(
                Arrays.asList(collection))));
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        return getLastName(new ArrayList<>(collection));
    }
}