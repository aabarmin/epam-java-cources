package com.epam.university.java.core.task003;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> listStrings = new ArrayList<>(Arrays.asList(source));
        Collections.reverse(listStrings);
        String[] arrayStrings = new String[listStrings.size()];
        for (int i = 0; i < listStrings.size(); i++) {
            arrayStrings[i] = listStrings.get(i);
        }
        return arrayStrings;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        int sizeSumArrays = first.length + second.length;
        int index = 0;
        String[] arrayStrings = new String[sizeSumArrays];
        for (int i = 0; i < first.length; i++) {
            arrayStrings[index] = first[i];
            index++;
        }
        for (int i = 0; i < second.length; i++) {
            arrayStrings[index] = second[i];
            index++;
        }
        return arrayStrings;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null || source.length == 0) {
            throw new IllegalArgumentException();
        }
        int value = source[0];
        for (int nextValue : source) {
            if (nextValue > value) {
                value = nextValue;
            }
        }
        return value;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> correctStrings = new ArrayList<>();
        for (String string : source) {
            if (condition.isValid(string)) {
                correctStrings.add(string);
            }
        }
        return correctStrings.toArray(new String[0]);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> correctStrings = new ArrayList<>();
        for (String sourceString : source) {
            boolean isCorrectString = true;
            for (String toRemoteString : toRemote) {
                if (sourceString.equals(toRemoteString)) {
                    isCorrectString = false;
                    break;
                }
            }
            if (isCorrectString) {
                correctStrings.add(sourceString);
            }
        }
        return correctStrings.toArray(new String[0]);
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
        int arraySize = source.length;
        String[] correctStrings = new String[arraySize];
        for (int i = 0; i < source.length; i++) {
            correctStrings[i] = operation.map(source[i]);
        }
        return correctStrings;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
        Set<Integer> integersSet = new TreeSet<>();
        for (String sourceString : source) {
            for (String valueString : operation.flatMap(sourceString)) {
                int value = Integer.parseInt(valueString.replaceAll("[^0-9]", ""));
                integersSet.add(value);
            }
        }
        String[] values = new String[integersSet.size()];
        int i = integersSet.size() - 1;
        for (Integer value : integersSet) {
            values[i] = value.toString();
            i--;
        }
        return values;
    }
}
