package com.epam.university.java.core.task011;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        String[] result = collection;
        int i=0;
        while (result.length != 1) {
            if (i == 0) {
                result = ArrayUtils.remove(collection, i);
            } else if (i % 2 == 0 && i != 1 && i < 6) {
                result = ArrayUtils.removeElement(result, collection[i % collection.length]);
            } else if (i >= 6) {
                i=0;
            }
            i++;
        }
        return result[0];
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        return null;
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        return null;
    }
}
