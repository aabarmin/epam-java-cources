package com.epam.university.java.core.task003;

import com.epam.university.java.core.util.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of the methods for work with arrays and simple algorithms.
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
    public String[] invert(String[] source) throws IllegalArgumentException {
        Utils.assertArrayNonNull(source);
        List<String> res = Arrays.asList(source);
        Collections.reverse(res);
        return res.toArray(new String[res.size()]);
    }

    /**
     * Join two arrays.
     *
     * @param first first array
     * @param second second array
     * @return new array which contains items from first and second arrays
     * @throws IllegalArgumentException if arrays not provided
     */
    @Override
    public String[] join(String[] first, String[] second) throws IllegalArgumentException {
        Utils.assertArrayNonNull(first);
        Utils.assertArrayNonNull(second);
        String[] res = new String[first.length + second.length];
        System.arraycopy(first, 0, res, 0, first.length);
        System.arraycopy(second, 0, res, first.length, second.length);
        return res;
    }

    /**
     * Find max element in array.
     *
     * @param source source array
     * @return value of maximal element in array
     * @throws IllegalArgumentException if array not provided
     */
    @Override
    public int findMax(int[] source) throws IllegalArgumentException {
        Utils.assertArrayNonNull(source);
        OptionalInt max = Arrays.stream(source).max();
        if (max.isPresent()) {
            return max.getAsInt();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Filter array elements in accordance with condition.
     *
     * @param source source array
     * @param condition condition instance
     * @return filtered array
     * @throws IllegalArgumentException if array or condition not provided
     */
    @Override
    public String[] filter(String[] source, FilteringCondition condition)
        throws IllegalArgumentException {
        Utils.assertArrayNonNull(source);
        Utils.assertNonNull(condition);
        return Stream.of(source)
            .filter(condition::isValid)
            .toArray(String[]::new);
    }

    /**
     * Remove elements from source array.
     *
     * @param source source array
     * @param toRemove elements to remove
     * @return new array without removed elements
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] removeElements(String[] source, String[] toRemove)
        throws IllegalArgumentException {
        Utils.assertArrayNonNull(source);
        Utils.assertArrayNonNull(toRemove);
        Set<String> removeSet = Stream.of(toRemove).collect(Collectors.toSet());
        return Stream.of(source)
            .filter(str -> !removeSet.contains(str))
            .toArray(String[]::new);
    }

    /**
     * Convert source array in accordance with provided operation.
     *
     * @param source source array
     * @param operation operation instance
     * @return converted array
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] map(String[] source, MappingOperation operation)
        throws IllegalArgumentException {
        Utils.assertArrayNonNull(source);
        Utils.assertNonNull(operation);
        return Stream.of(source)
            .map(operation::map)
            .toArray(String[]::new);
    }

    /**
     * Convert source array in accordance with provided operation.
     *
     * @param source source array
     * @param operation operation instance
     * @return converted array
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        Utils.assertArrayNonNull(source);
        Utils.assertNonNull(operation);
        return Stream.of(source)
            .flatMap(s -> Stream.of(operation.flatMap(s)))
            .distinct()
            .sorted((o1, o2) -> // sort by length. if length is equal use default String comparator
                o1.length() > o2.length() ? -1 : o2.length() > o1.length() ? 1 : o2.compareTo(o1)
            )
            .toArray(String[]::new);
    }

}
