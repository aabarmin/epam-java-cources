package com.epam.university.java.core.task011;

import com.epam.university.java.core.task003.SimpleNullChecker;
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
        new SimpleNullChecker().check(collection);
        if (collection.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<String> result = (LinkedList<String>) collection.clone();

        int i = 0;

        while (result.size() != 1) {
            result.remove(i % result.size());
            i += 2;
        }

        return result.get(0);
    }
}
