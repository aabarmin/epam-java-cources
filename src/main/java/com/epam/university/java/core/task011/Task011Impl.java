package com.epam.university.java.core.task011;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.LinkedList;


public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        String[] intermediate = collection;
        String[] result = intermediate;
        int begin = 0;
        int length = collection.length;
        while (result.length != 1) {
            for (int i = begin; i < length; i += 2) {
                result = ArrayUtils.removeElement(result, intermediate[i]);
            }
            if (intermediate.length % 2 != 0) {
                begin = 1;
            } else {
                begin = 0;
            }
            length = result.length;
            intermediate = result;
        }
        return intermediate[0];
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        while (collection.size() != 1) {
            if (collection.size() % 2 != 0) {
                collection.removeIf(s -> collection.indexOf(s) % 2 == 0);
            } else {
                collection.removeIf(s -> collection.indexOf(s) % 2 != 0);
            }
        }
        return collection.get(0);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        while (collection.size() != 1) {
            collection.pop();
            String last = collection.pollFirst();
            collection.offer(last);
        }
        return collection.getFirst();
    }
}
