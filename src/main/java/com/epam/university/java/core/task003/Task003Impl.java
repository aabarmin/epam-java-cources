package com.epam.university.java.core.task003;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by A.Sluzhbin on 23.08.2020
 */

public class Task003Impl implements Task003 {

    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        for (int i = 0; i < source.length / 2; i++) {
            String temp = source[i];
            source[i] = source[source.length - i - 1];
            source[source.length - i - 1] = temp;
        }
        return source;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        String[] sumArray = new String[first.length + second.length];
        for (int i = 0; i < first.length; i++) {
            sumArray[i] = first[i];
        }
        for (int j = 0; j < second.length; j++) {
            sumArray[first.length + j] = second[j];
        }
        return sumArray;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null || source.length == 0) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        Integer max = Arrays.stream(source).max().getAsInt();
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null || condition == null || source.length == 0) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        String[] filteredArr = Arrays.stream(source)
                .filter(condition::isValid).toArray(String[]::new);
        return filteredArr;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        List removedList = Arrays.asList(toRemote);
        String[] resultArr = (String[]) Arrays.stream(source)
                .filter(s -> !removedList.contains(s)).toArray();
        return resultArr;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source == null || operation == null || source.length == 0) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        String[] resultArr = Arrays.stream(source).map(operation::map).toArray(String[]::new);
        return resultArr;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        return Arrays.stream(source).flatMap((e) -> Stream.of(operation.flatMap(e)))
                .distinct().sorted((a, b) -> Integer.parseInt(b) - Integer.parseInt(a))
                .toArray(String[]::new);
    }
}

