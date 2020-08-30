package com.epam.university.java.core.task004;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Docs.
 */
public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        String[] intersection = {};
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        } else {
            HashSet<String> set = new HashSet<>();

            set.addAll(Arrays.asList(first));

            set.retainAll(Arrays.asList(second));

            intersection = set.toArray(intersection);
        }
        return intersection;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        String[] union = {};
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        } else {
            HashSet<String> set = new LinkedHashSet<>();
            set.addAll(Arrays.asList(first));
            set.addAll(Arrays.asList(second));

            union = set.toArray(union);
        }
        return union;
    }
}
