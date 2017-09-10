package com.epam.university.java.core.task004;


import java.util.LinkedHashSet;
import java.util.Set;

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

        String[] union = new String[first.length + second.length];

        int x = 0;

        for (int i = 0; i < first.length; i++) {
            union[i + x] = first[i];
        }

        x = x + first.length;

        for (int i = 0; i < second.length; i++) {
            union[i + x] = second[i];
        }

        return union;

    }
}
