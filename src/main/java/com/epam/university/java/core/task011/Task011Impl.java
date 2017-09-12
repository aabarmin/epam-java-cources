package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ilya on 11.09.17.
 */
public class Task011Impl implements Task011 {

    @Override
    public String getLastName(String[] collection) {
        LinkedList<String> result = new LinkedList<>();
        result.addAll(Arrays.asList(collection));
        return getLastName(result);
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        LinkedList<String> result = new LinkedList<>();
        result.addAll(collection);
        return getLastName(result);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        List<String> result = (LinkedList<String>) collection.clone();

        int i = 0;

        while (result.size() != 1) {
            if (i < result.size()) {
                result.remove(i);
            } else {
                result.remove(result.size() - 1);
            }
            i++;
        }

        return result.get(0);
    }
}
