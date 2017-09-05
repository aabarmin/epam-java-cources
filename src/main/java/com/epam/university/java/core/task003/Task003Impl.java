package com.epam.university.java.core.task003;

import java.util.*;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        checkArguments(source);

        for (int i = 0; i < source.length / 2; i++) {
            String temp = source[i];
            source[i] = source[source.length - 1 - i];
            source[source.length - 1 - i] = temp;
        }

        return source;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        checkArguments(first, second);

        int size = first.length + second.length;
        String[] result = new String[size];

        System.arraycopy(first, 0, result, 0, first.length);

        return result;
    }

    @Override
    public int findMax(int[] source) {
        checkArguments(source);

        int max = source[0];

        for (int i = 1; i < source.length; i++) {
            if (source[i] > max) {
                max = source[i];
            }
        }

        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        checkArguments(source, condition);

        ArrayList<String> result = new ArrayList<>();

        for (String element : source) {
            if (condition.isValid(element)) {
                result.add(element);
            }
        }

        return result.toArray(new String[0]);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        checkArguments(source, toRemote);

        List<String> sourceList = Arrays.asList(source);
        List<String> removeList = Arrays.asList(toRemote);

        List<String> result = new ArrayList(sourceList);
        result.removeAll(removeList);

        return result.toArray(new String[0]);
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        checkArguments(source, operation);

        ArrayList<String> result = new ArrayList<>();

        for (String element : source) {
            result.add(operation.map(element));
        }

        return result.toArray(new String[0]);
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        checkArguments(source, operation);

        Set<Integer> intSet = new HashSet<>();

        for (String str : source) {
            String[] resultArray = operation.flatMap(str);
            for (String result : resultArray) {
                intSet.add(Integer.parseInt(result.trim()));
            }
        }

        List<Integer> sortedList = new ArrayList(intSet);
        sortedList.sort(Collections.reverseOrder());

        List<String> result = new ArrayList();

        for (int i : sortedList) {
            result.add(String.valueOf(i));
        }

        return result.toArray(new String[0]);
    }

    private void checkArguments(Object firstArg) {
        if (firstArg == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(Object firstArg, Object secondArg) {
        if (firstArg == null || secondArg == null) {
            throw new IllegalArgumentException();
        }
    }
}