package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        validateInput(collection);

        if (collection.length == 1) {
            return collection[0];
        } else if (collection.length % 2 != 0) {
            return collection[1];
        } else {
            String[] col = new String[collection.length / 2];

            for (int i = 0, j = 0; j < collection.length; i++, j += 2) {
                col[i] = collection[j + 1];
            }

            return getLastName(col);
        }
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        validateInput(collection);

        if (collection.size() == 1) {
            return collection.get(0);
        } else if (collection.size() % 2 != 0) {
            return collection.get(1);
        } else {
            ArrayList<String> list = new ArrayList<>();

            for (int j = 0; j < collection.size(); j += 2) {
                list.add(collection.get(j + 1));
            }

            return getLastName(list);
        }
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        validateInput(collection);

        if (collection.size() == 1) {
            return collection.get(0);
        } else if (collection.size() % 2 != 0) {
            return collection.get(1);
        } else {
            ArrayList<String> list = new ArrayList<>();

            for (int j = 0; j < collection.size(); j += 2) {
                list.add(collection.get(j + 1));
            }

            return getLastName(list);
        }
    }

    private void validateInput(Collection o) {
        if (o == null || o.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInput(String[] o) {
        if (o == null || o.length == 0) {
            throw new IllegalArgumentException();
        }
    }
}
