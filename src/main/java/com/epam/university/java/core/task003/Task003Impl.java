package com.epam.university.java.core.task003;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        } else if (source.length == 0) {
            return new String[ 0 ];
        } else {
            ArrayUtils.reverse(source);
            return source;
        }
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        } else if (first.length == 0 || second.length == 0) {
            return new String[0];
        } else {
            return ArrayUtils.addAll(first, second);
        }
    }

    @Override
    public int findMax(int[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        } else {
            Arrays.sort(source);

            return source[source.length - 1];
        }

    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        } else {
            List<String> stream = Arrays
                    .stream(source)
                    .filter(condition::isValid)
                    .collect(Collectors.toList());

            return stream.toArray(new String[stream.size()]);
        }

    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {

        if (source == null || toRemote == null) {
            throw  new IllegalArgumentException();
        } else {
            List<String> result = Arrays
                    .stream(source)
                    .filter((String s) -> !ArrayUtils.contains(toRemote,s))
                    .collect(Collectors.toList());

            return result.toArray(new String[result.size()]);
        }
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        } else {
            List<String> stream = Arrays
                    .stream(source)
                    .map(operation::map)
                    .collect(Collectors.toList());

            return stream.toArray(new String[stream.size()]);
        }
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        } else {
            SortedSet<String> resultSet = new TreeSet<>();

            for (String s: source) {
                String[] s1 = operation.flatMap(s);
                resultSet.addAll(Arrays.asList(s1));
            }

            List<String> result = resultSet
                    .stream()
                    .map(Integer::parseInt)
                    .sorted(Comparator.reverseOrder())
                    .distinct()
                    .map(String::valueOf)
                    .collect(Collectors.toList());

            return  result.toArray(new String[resultSet.size()]);
        }
    }
}
