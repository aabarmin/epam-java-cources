package com.epam.university.java.core.task003;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        if (source.length == 0) {
            return source;
        }
        for (int i = 0; i < source.length / 2; i++) {
            String tmp = source[i];
            source[i] = source[source.length - i - 1];
            source[source.length - i - 1] = tmp;
        }
        return source;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        if (first.length == 0 && second.length == 0) {
            return first;
        }
        String[] both = Stream.concat(Arrays.stream(first), Arrays.stream(second))
                .toArray(String[]::new);
        return both;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null || source.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = Integer.MIN_VALUE;
        for (int i : source) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        }
        String[] arr = new String[source.length];
        int counter = 0;
        for (int i = 0; i < source.length; i++) {
            if (condition.isValid(source[i])) {
                arr[counter] = source[i];
                counter++;
            }
        }
        String[] result = new String[counter];
        for (int i = 0; i < counter; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemove) {
        if (source == null || toRemove == null) {
            throw new IllegalArgumentException();
        }
        List<String> sourceList = new ArrayList<>(Arrays.asList(source));
        for (String elem : toRemove) {
            sourceList.removeAll(Arrays.asList(elem));
        }
        String[] result = sourceList.toArray(new String[0]);
        return result;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < source.length; i++) {
            source[i] = operation.map(source[i]);
        }
        return source;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
        if (source.length == 0) {
            return source;
        }
        String[] previous = operation.flatMap(source[0]);
        String[] current = {};
        String[] bigArr = {};
        int pLen = previous.length;
        int cLen = current.length;
        for (int i = 1; i < source.length; i++) {
            current = operation.flatMap(source[i]);
            cLen = current.length;
            bigArr = new String[pLen + cLen];
            System.arraycopy(previous, 0, bigArr, 0, pLen);
            System.arraycopy(current, 0, bigArr, pLen, cLen);
            previous = bigArr;
            pLen = previous.length;
        }
        Integer[] numbers = new Integer[bigArr.length];
        for (int i = 0; i < bigArr.length; i++) {
            numbers[i] = Integer.valueOf(bigArr[i]);
        }
        Arrays.sort(numbers, Collections.reverseOrder());

        Set<Integer> mySet = new HashSet<>(Arrays.asList(numbers));
        Integer[] res = mySet.toArray(Integer[]::new);
        Arrays.sort(res, Comparator.reverseOrder());
        String[] result = new String[res.length];
        for (int i = 0; i < res.length; i++) {
            result[i] = res[i].toString();
        }
        return result;
    }
}
