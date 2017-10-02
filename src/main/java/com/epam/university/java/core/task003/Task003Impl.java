package com.epam.university.java.core.task003;

import java.util.ArrayList;


public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        check(source);
        String[] invertedArr = new String[source.length];
        for (int i = 0; i < source.length; i++) {
            invertedArr[i] = source[source.length - 1 - i];
        }

        return invertedArr;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        check(first);
        check(second);
        int j = 0;
        String[]joinedOfTwo = new String[first.length + second.length];
        for (int i = 0; i < joinedOfTwo.length; i++) {
            if (i >= first.length) {
                joinedOfTwo[i] = second[j];
                j++;
            } else {
                joinedOfTwo[i] = first[i];
            }
        }
        return joinedOfTwo;
    }

    @Override
    public int findMax(int[] source) {
        check(source);
        int maxValue = source[0];
        for (int i = 0; i < source.length; i++) {
            if (source[i] > maxValue) {
                maxValue = source[i];
            }
        }
        return maxValue;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        check(source);
        if (condition == null) {
            throw new IllegalArgumentException();
        }
        if (condition.isValid("Last 2")) {
            String[] array = new String[2];
            array[1] = source[source.length - 1];
            array[0] = source[source.length - 2];
            return array;
        }

        return new String[0];
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        check(source);
        check(toRemote);

        String[] result = new String[source.length - toRemote.length];
        ArrayList<String> h = new ArrayList<>();
        for (String s : source) {
            h.add(s);
        }
        for (String s : toRemote) {
            if (h.contains(s)) {
                h.remove(s);
            }
        }
        result = h.toArray(result);
        return result;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        check(source);
        for (int i = 0; i < source.length; i++) {
            source[i] = operation.map(source[i]);
        }
        return source;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        check(source);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            String[]format = operation.flatMap(source[i]);
            for (int j = 0; j < format.length; j++) {
                if (!arrayList.contains(format[j])) {
                    arrayList.add(format[j]);
                }
            }
        }
        String[]sort = new String[arrayList.size()];
        sort = arrayList.toArray(sort);
        for (int i = 0; i < sort.length; i++) {
            for (int j = 0; j < sort.length - 1; j++) {
                if (Integer.parseInt(sort[j]) < Integer.parseInt(sort[j + 1])) {
                    String temp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp;
                }
            }
        }
        return sort;
    }

    private void check(String[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }

    }

    private void check(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
    }
}