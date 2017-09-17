package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;


public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        int index = 0;
        while (collection.length > 1) {

            collection[index] = null;
            index = (index + 1);
            if (index == collection.length) {
                index = 1;
            }
            if (index == collection.length - 1) {
                index = 0;
            }
            collection = Arrays.stream(collection).filter(Objects::nonNull).toArray(String[]::new);
        }
        return collection[0];
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        int index = 0;
        do {
            collection.remove(collection.get(index));
            if (index == collection.size()) {
                index = 1;
            } else if (index == collection.size() - 1) {
                index = 0;
            } else {
                index = (index + 1);
            }
        } while (collection.size() > 1);

        return collection.get(0);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        while (collection.size() > 1) {
            collection.removeFirst();
            collection.addLast(collection.pop());
        }
        return collection.peek();
    }
}
