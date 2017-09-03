package com.epam.university.java.core.task003;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        checkForNull(source);
        String[] result = new String[source.length];
        int j = 0;
        for (int i = source.length - 1; i >= 0; i--, j++) {
            result[j] = source[i];
        }
        return result;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        checkForNull(first, second);
        String[] result = new String[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }


    @Override
    public int findMax(int[] source) {
        checkForNull(source);
        return Arrays.stream(source)
                .max()
                .getAsInt();
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        checkForNull(source, condition);
        return Arrays.stream(source)
                .filter(condition::isValid)
                .toArray(String[]::new);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        checkForNull(source, toRemote);
        List<String> listToRemote = Arrays.asList(toRemote);
        return Arrays.stream(source)
                .filter(s -> !listToRemote.contains(s))
                .toArray(String[]::new);
    }


    @Override
    public String[] map(String[] source, MappingOperation operation) {
        checkForNull(source, operation);
        return Arrays.stream(source)
                .map(operation::map)
                .toArray(String[]::new);
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        checkForNull(source, operation);
        String[] fullArray = Arrays.stream(source)
                .flatMap(s -> Arrays.stream(operation.flatMap(s)))
                .map(String::trim)
                .toArray(String[]::new);
        Set<String> set = new TreeSet<>((o1, o2) -> -1 * (new Double(o1).compareTo(Double.parseDouble(o2))));
        set.addAll(Arrays.asList(fullArray));
        return set.toArray(new String[set.size()]);
    }

    private void checkForNull(Object... objects) {
        if (objects == null) {
            throw new IllegalArgumentException();
        }
        for (Object obj : objects) {
            if (obj == null) {
                throw new IllegalArgumentException();
            }
        }
    }
}
