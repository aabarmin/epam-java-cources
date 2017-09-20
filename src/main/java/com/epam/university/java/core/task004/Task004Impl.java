package com.epam.university.java.core.task004;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Doomsday Device on 20.09.2017.
 */
public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        Set<String> intersectionSet = new HashSet<>();
        Set<String> setSecond = new HashSet<>();

        for (String elem : first) {
            intersectionSet.add(elem);
        }

        for (String elem : second) {
            setSecond.add(elem);
        }

        intersectionSet.retainAll(setSecond);

        String[] result = new String[intersectionSet.size()];

        return intersectionSet.toArray(result);
    }

    /**
     * Find union of two arrays.
     *
     * @param first first array
     * @param second second array
     * @return array of all elements of array
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        List<String> unionArray = new ArrayList<>();

        for (String elem : first) {
            unionArray.add(elem);
        }
        for (String elem : second) {
            if (!unionArray.contains(elem)) {
                unionArray.add(elem);
            }
        }

        String[] result = new String[unionArray.size()];

        return unionArray.toArray(result);
    }
}
