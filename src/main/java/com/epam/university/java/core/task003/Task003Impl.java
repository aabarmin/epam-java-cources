package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        validateInput(source);

        List<String> strings = new ArrayList<>(Arrays.asList(source));
        Collections.reverse(strings);

        String[] result = convertToArray(strings);

        return result;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        validateInput(first, second);

        List<String> strings = new ArrayList<>();
        strings.addAll(Arrays.asList(first));
        strings.addAll(Arrays.asList(second));

        String[] result = convertToArray(strings);

        return result;
    }

    @Override
    public int findMax(int[] source) {
        validateInput(source);

        Arrays.sort(source);

        return source[source.length - 1];
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        validateInput(source, condition);

        List<String> strings = new ArrayList<>();
        for (String s : source) {
            if (condition.isValid(s)) {
                strings.add(s);
            }
        }

        String[] result = convertToArray(strings);

        return result;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        validateInput(source, toRemote);

        List<String> stringsSource = new ArrayList<>(Arrays.asList(source));
        List<String> stringsToRemote = new ArrayList<>(Arrays.asList(toRemote));

        stringsSource.removeAll(stringsToRemote);

        String[] result = convertToArray(stringsSource);

        return result;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        validateInput(source, operation);

        for (int i = 0; i < source.length; i++) {
            source[i] = operation.map(source[i]);
        }
        return source;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        validateInput(source, operation);

        Set<Integer> integers = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < source.length; i++) {
            String[] current = operation.flatMap(source[i]);
            for (String s : current) {
                integers.add(Integer.parseInt(s));
            }
        }


        List<String> strings = new ArrayList<>();
        Iterator iter = integers.iterator();
        while (iter.hasNext()) {
            strings.add(String.valueOf(iter.next()));
        }

        String[] result = convertToArray(strings);

        return result;
    }

    private void validateInput(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInput(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInput(int[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInput(String[] source, FilteringCondition condition) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInput(String[] source, MappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInput(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
    }

    private String[] convertToArray(Collection<String> collection) {
        String[] result = new String[collection.size()];
        collection.toArray(result);
        return result;
    }
}
