package com.epam.university.java.core.task004;

import java.util.Set;
import java.util.LinkedHashSet;

public class Task004Impl implements Task004 {
    /**
     * Find intersection of two arrays.
     *
     * @param first  first array
     * @param second second array
     * @return array of common elements
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] intersection(String[] first, String[] second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        if (first.length == 0 || second.length == 0) {
            return new String[0];
        }

        Set<String> intersectionSet = new LinkedHashSet<>();

        for (String firstString : first) {
            for (String secondString : second) {
                if (firstString.equals(secondString)) {
                    intersectionSet.add(firstString);
                    break;
                }
            }
        }

        return intersectionSet.toArray(new String[intersectionSet.size()]);

    }

    /**
     * Find union of two arrays.
     *
     * @param first  first array
     * @param second second array
     * @return array of all elements of array
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] union(String[] first, String[] second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        if (first.length == 0 && second.length == 0) {
            return new String[0];
        }

        Set<String> unionSet = new LinkedHashSet<>();

        for (String firstString : first) {
            unionSet.add(firstString);
        }

        for (String secondString : second) {
            unionSet.add(secondString);
        }

        return unionSet.toArray(new String[unionSet.size()]);

    }
}
