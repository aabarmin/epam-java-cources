package com.epam.university.java.core.task003;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Romin Nuro on 19.08.2020 1:20.
 */
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
        String[] result = new String[source.length];
        for (int i = 0; i < source.length; i++) {
            result[source.length - i - 1] = source[i];
        }
        return result;
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
        String[] result = Stream.of(first, second)
                .flatMap(Stream::of)
                .toArray(String[]::new);
        return result;
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
        if (source == null
                || source.length == 0) {
            throw new IllegalArgumentException();
        }
        int result = Arrays.stream(source).max().getAsInt();
        return result;
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
        String[] result = Arrays.stream(source).filter(condition::isValid).toArray(String[]::new);

        return result;
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
        List<String> listToRemove = Arrays.asList(toRemote);
        String[] result = Arrays.stream(source)
                .filter(s -> !listToRemove.contains(s))
                .toArray(String[]::new);
        return result;
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
        String[] result = Arrays.stream(source).map(operation::map).toArray(String[]::new);
        return result;
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
        Set<String> resultSet = Arrays.stream(source)
                .map(operation::flatMap)
                .flatMap(Stream::of)
                .collect(Collectors.toCollection(() -> {
                    return new TreeSet<>((s1, s2) -> {
                        return Integer.compare(Integer.parseInt(s2), Integer.parseInt(s1));
                    });
                }));
        String[] resultArray = new String[resultSet.size()];
        resultSet.toArray(resultArray);
        return resultArray;
    }
}