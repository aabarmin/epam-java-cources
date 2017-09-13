package com.epam.university.java.core.task004;

import com.epam.university.java.core.util.Utils;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of the advanced tasks with arrays.
 */
public class Task004Impl implements Task004 {

    /**
     * Find intersection of two arrays.
     *
     * @param first first array
     * @param second second array
     * @return array of common elements
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] intersection(String[] first, String[] second) throws IllegalArgumentException {
        Utils.assertArrayNonNull(first);
        Utils.assertArrayNonNull(second);
        Set<String> set = Stream.of(second).collect(Collectors.toSet());
        return Stream.of(first)
            .filter(set::contains)
            .toArray(String[]::new);
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
    public String[] union(String[] first, String[] second) throws IllegalArgumentException {
        Utils.assertArrayNonNull(first);
        Utils.assertArrayNonNull(second);
        return Stream.concat(Stream.of(first), Stream.of(second))
            .distinct()
            .toArray(String[]::new);
    }

}
