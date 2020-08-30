package com.epam.university.java.core.task004;

import java.util.Arrays;
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
    public String[] intersection(String[] first, String[] second) throws IllegalArgumentException {
        if (first == null || second == null) {
            System.out.println("Error in intersection operation");
            throw new IllegalArgumentException();
        }
        Set<String> setOfIntersections = new LinkedHashSet<>();
        for (String comparingValue :
                first) {
            for (String comparedValue :
                    second) {
                if (comparingValue.equals(comparedValue)) {
                    setOfIntersections.add(comparingValue);
                }
            }
        }
        String[] arrayofIntersections = setOfIntersections.toArray(new String[0]);
        return arrayofIntersections;
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
    public String[] union(String[] first, String[] second) throws IllegalArgumentException {
        if (first == null || second == null) {
            System.out.println("Error in intersection operation");
            throw new IllegalArgumentException();
        }
        Set<String> setOfUnions = new LinkedHashSet<>();
        setOfUnions.addAll(Arrays.asList(first));
        setOfUnions.addAll(Arrays.asList(second));
        String[] arrayOfUnions = setOfUnions.toArray(new String[0]);
        return arrayOfUnions;
    }
}
