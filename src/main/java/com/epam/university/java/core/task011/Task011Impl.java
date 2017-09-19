package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Daniil Smirnov on 17.09.2017.
 * All copy registered MF.
 */
public class Task011Impl implements Task011 {

    @Override
    public String getLastName(String[] collection) {

        String result = "";
        int countEmpty = 0;
        for (int i = 0;;i++) {

            if (i > collection.length) {
                int nextElement = 0;
                for (int j = 0; j < collection.length; j++) {
                    if (!collection[j].isEmpty()) {
                        nextElement++;
                        if (nextElement == 2) {
                            i = j;
                            break;
                        }
                    }
                }
            } else if (i == collection.length) {
                i = 0;
            }

            if (!collection[i].isEmpty()) {
                result = collection[i];
                collection[i] = "";
                countEmpty++;
                i++;
            }
            if (countEmpty == collection.length) {
                break;
            }
        }
        return result;
    }

    @Override
    public String getLastName(ArrayList<String> collection) {

        return removingForCollections(collection).get(0);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {

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
}
