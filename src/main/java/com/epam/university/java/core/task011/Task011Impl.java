package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        if (collection == null || collection.length == 0) {
            throw new IllegalArgumentException("Array not provided!");
        }
        if (collection.length == 1) {
            return collection[0];
        }
        int i = 0;
        int count = 0;
        while (true) {
            collection[i] = null;
            i += 2;
            count++;
            if (i >= collection.length) {
                i %= collection.length;
                String[] intermediateStr = new String[collection.length - count];
                for (int j = 0, k = 0; j < collection.length; j++) {
                    if (collection[j] != null) {
                        intermediateStr[k++] = collection[j];
                    }
                }
                collection = intermediateStr;
                if (collection.length == 1) {
                    return collection[0];
                }
                count = 0;
            }
        }
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("Array list not provided!");
        }
        return getLastName(new LinkedList<>(collection));
    }


    @Override
    public String getLastName(LinkedList<String> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("Linked list not provided!");
        }
        if (collection.size() == 1) {
            return collection.get(0);
        }
        int i = 0;
        while (true) {
            collection.remove(i);
            i++;
            if (i >= collection.size()) {
                i %= collection.size();
            }
            if (collection.size() == 1) {
                return collection.get(0);
            }
        }
    }
}