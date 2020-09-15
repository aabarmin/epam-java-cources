package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Task011Impl implements Task011 {

    @Override
    public String getLastName(String[] collection) {

        if (collection == null || collection.length == 0) {
            throw new IllegalArgumentException();
        }
        if (collection.length == 1) {
            return collection[0];
        } else if (collection.length % 2 != 0) {
            return collection[1];
        } else {
            String[] elems = new String[collection.length / 2];
            for (int i = 0, j = 0; j < collection.length; i++, j += 2) {
                elems[i] = collection[j + 1];
            }
            return getLastName(elems);
        }
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        if (collection.size() == 1) {
            return collection.get(0);
        } else if (collection.size() % 2 != 0) {
            return collection.get(1);
        } else {
            ArrayList<String> arr = new ArrayList<>();
            for(int i = 0; i < collection.size(); i += 2) {
                arr.add(collection.get(i + 1));
            }
            return getLastName(arr);
        }
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        if (collection.size() == 1) {
            return collection.get(0);
        } else if (collection.size() % 2 != 0) {
            return collection.get(1);
        } else {
            LinkedList<String> list = new LinkedList<>();
            for(int i = 0; i < collection.size(); i += 2) {
                list.add(collection.get(i + 1));
            }
            return getLastName(list);
        }
    }
}
