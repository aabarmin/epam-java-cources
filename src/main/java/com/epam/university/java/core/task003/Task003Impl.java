package com.epam.university.java.core.task003;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }

        String[] res = new String[source.length];

        for (int i = source.length - 1; i >= 0; i--) {
            res[source.length - 1 - i] = source[i];
        }
        return res;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] res = new String[first.length + second.length];
        System.arraycopy(first, 0, res, 0, first.length);
        System.arraycopy(second, 0, res, first.length, second.length);
        return res;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(source).max().orElseThrow(IllegalArgumentException::new);

    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(source)
                .filter(condition::isValid).toArray(String[]::new);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(source).filter((e) -> {
            for (String s : toRemote) {
                if (s.equals(e)) {
                    return false;
                }
            }
            return true;
        }).toArray(String[]::new);

    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
        return Stream.of(source).map(operation::map).toArray(String[]::new);
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(source)
                .flatMap((e) -> Stream.of(operation.flatMap(e)))
                .distinct()
                .sorted((a, b) -> Integer.parseInt(b) - Integer.parseInt(a))
                .toArray(String[]::new);
    }
}
