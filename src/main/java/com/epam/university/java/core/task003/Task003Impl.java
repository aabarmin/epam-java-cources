package com.epam.university.java.core.task003;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class Task003Impl implements Task003 {
    /**
     * Invert array.
     *
     * @param source source array
     * @return inverted array
     * @throws IllegalArgumentException if array not provided
     */
    @Override
    public String[] invert(String[] source) {

        if (source == null) {
            throw new IllegalArgumentException();
        }

        String[] invertedArray = new String[source.length];
        int sourceIndex = source.length - 1;

        for (int i = 0; i < invertedArray.length; i++) {
            invertedArray[i] = source[sourceIndex - i];
        }

        return invertedArray;
    }

    /**
     * Join two arrays.
     *
     * @param first  first array
     * @param second second array
     * @return new array which contains items from first and second arrays
     * @throws IllegalArgumentException if arrays not provided
     */
    @Override
    public String[] join(String[] first, String[] second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        String[] joinedArray = new String[first.length + second.length];

        int k;

        for (k = 0; k < first.length; k++) {
            joinedArray[k] = first[k];
        }

        for (int i = 0; i < second.length; i++) {
            joinedArray[i + k] = second[i];
        }

        return joinedArray;

    }

    /**
     * Find max element in array.
     *
     * @param source source array
     * @return value of maximal element in array
     * @throws IllegalArgumentException if array not provided
     */
    @Override
    public int findMax(int[] source) {

        if (source == null) {
            throw new IllegalArgumentException();
        }

        if (source.length == 0) {
            return 0;
        }

        int max = source[0];

        for (int i = 1; i < source.length; i++) {
            if (max < source[i]) {
                max = source[i];
            }
        }

        return max;

    }

    /**
     * Filter array elements in accordance with condition.
     *
     * @param source    source array
     * @param condition condition instance
     * @return filtered array
     * @throws IllegalArgumentException if array or condition not provided
     */
    @Override
    public String[] filter(String[] source, FilteringCondition condition) {

        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        }

        List<String> filteredList = new ArrayList<>();

        for (String sourceString : source) {
            if (condition.isValid(sourceString)) {
                filteredList.add(sourceString);
            }
        }

        return filteredList.toArray(new String[filteredList.size()]);

    }

    /**
     * Remove elements from source array.
     *
     * @param source   source array
     * @param toRemote elements to remove
     * @return new array without removed elements
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] removeElements(String[] source, String[] toRemote) {

        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        }

        List<String> filteredList = new ArrayList<>();

        for (String sourceString : source) {

            boolean remove = false;

            for (String removeString : toRemote) {
                if (sourceString.equals(removeString)) {
                    remove = true;
                    break;
                }
            }

            if (remove == false) {
                filteredList.add(sourceString);
            }

        }

        return filteredList.toArray(new String[filteredList.size()]);

    }

    /**
     * Convert source array in accordance with provided operation.
     *
     * @param source    source array
     * @param operation operation instance
     * @return converted array
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] map(String[] source, MappingOperation operation) {

        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }

        String[] mappedArray = new String[source.length];

        for (int i = 0; i < source.length; i++) {
            mappedArray[i] = operation.map(source[i]);
        }

        return mappedArray;

    }

    /**
     * Convert source array in accordance with provided operation.
     *
     * @param source    source array
     * @param operation operation instance
     * @return converted array
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {

        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }

        Set<String> mappedSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (o1.length() == o2.length()) {
                    return o2.compareTo(o1);
                } else {
                    return Integer.valueOf(o2.length()).compareTo(Integer.valueOf(o1.length()));
                }

            }
        });

        for (int i = 0; i < source.length; i++) {

            String[] temp = operation.flatMap(source[i]);

            for(String tempString : temp) {
                mappedSet.add(tempString.trim());
            }

        }

        return mappedSet.toArray(new String[mappedSet.size()]);

    }
}
