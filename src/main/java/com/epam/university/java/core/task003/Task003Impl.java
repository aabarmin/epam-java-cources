package com.epam.university.java.core.task003;

import com.epam.university.java.core.validation.Validator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Александр on 06.09.2017.
 * Task003Impl
 */
public class Task003Impl implements Task003 {
    private static final Validator VALIDATOR = Validator.newInstance(Task003.class);

    /**
     * Invert array.
     *
     * @param source source array
     * @return inverted array
     * @throws IllegalArgumentException if array not provided
     */
    @Override
    public String[] invert(String[] source) {
        VALIDATOR.assertNotNull(source);

        List<String> list = Arrays.asList(source);
        Collections.reverse(list);
        return list.toArray(new String[source.length]);
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
        VALIDATOR.assertNotNull(first);
        VALIDATOR.assertNotNull(second);

        return Stream
                .of(first, second)
                .flatMap(Stream::of)
                .toArray(String[]::new);
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
        VALIDATOR.assertNotNull(source);

        return Arrays.stream(source).max().orElse(0);
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
        VALIDATOR.assertNotNull(source);
        VALIDATOR.assertNotNull(condition);

        return Arrays.stream(source)
                .filter(condition::isValid)
                .toArray(String[]::new);

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
        VALIDATOR.assertNotNull(source);
        VALIDATOR.assertNotNull(toRemote);

        return Arrays.stream(source)
                .filter((s) -> (Arrays.stream(toRemote).noneMatch(s::equals)))
                .toArray(String[]::new);
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
        VALIDATOR.assertNotNull(source);
        VALIDATOR.assertNotNull(operation);

        return Arrays.stream(source)
                .map(operation::map)
                .toArray(String[]::new);
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
        VALIDATOR.assertNotNull(source);
        VALIDATOR.assertNotNull(operation);

        return Arrays.stream(source)
                .flatMap(s -> Arrays.stream(s.split("[, ]+")))
                .distinct()
                .sorted((s1,s2) -> Integer.valueOf(s2).compareTo(Integer.valueOf(s1)))
                .toArray(String[]::new);
    }
}
