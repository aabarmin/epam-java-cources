package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for different operations with Arrays.
 * Task003 implementation.
 */
public final class Task003Impl implements Task003 {

    /**
     * * Message for source not provided error.
     */
    private static final String MSG_NULL_SOURCE = "source not provided";

    @Override
    public String[] invert(final String[] source) {
        if (source == null) {
            throw new IllegalArgumentException(MSG_NULL_SOURCE);
        }
        String[] result = new String[source.length];
        int j = 0;
        for (int i = source.length - 1; i >= 0; i--, j++) {
            result[j] = source[i];
        }
        return result;
    }

    @Override
    public String[] join(final String[] first, final String[] second) {
        if ((first == null) || (second == null)) {
            throw new IllegalArgumentException(MSG_NULL_SOURCE);
        }
        String[] result = new String[first.length + second.length];
        for (int i = 0; i < first.length; i++) {
            result[i] = first[i];
        }
        for (int i = 0; i < second.length; i++) {
            result[first.length + i] = second[i];
        }
        return result;
    }

    @Override
    public int findMax(final int[] source) {
        if ((source == null) || (source.length == 0)) {
            throw new IllegalArgumentException(MSG_NULL_SOURCE);
        }
        int max = source[0];
        for (int i : source) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public String[] filter(final String[] source, final FilteringCondition condition) {
        if ((source == null) || (condition == null)) {
            throw new IllegalArgumentException(MSG_NULL_SOURCE);
        }
        List<String> resultList = new ArrayList<>();
        for (String s : source) {
            if (condition.isValid(s)) {
                resultList.add(s);
            }
        }

        String[] resultArray = new String[resultList.size()];
        resultArray = resultList.toArray(resultArray);

        return resultArray;
    }

    @Override
    public String[] removeElements(final String[] source, final String[] toRemote) {
        if ((source == null) || (toRemote == null)) {
            throw new IllegalArgumentException(MSG_NULL_SOURCE);
        }
        List<String> elementsToRemove = Arrays.asList(toRemote);
        List<String> sourceList = Arrays.asList(source);
        List<String> resultList = new ArrayList<>();
        resultList.addAll(sourceList);
        resultList.removeAll(elementsToRemove);

        String[] resultArray = new String[resultList.size()];
        resultArray = resultList.toArray(resultArray);

        return resultArray;
    }

    @Override
    public String[] map(final String[] source, final MappingOperation operation) {
        if ((source == null) || (operation == null)) {
            throw new IllegalArgumentException(MSG_NULL_SOURCE);
        }
        List<String> resultList = new ArrayList<>();
        for (String s : source) {
            resultList.add(operation.map(s));
        }

        String[] resultArray = new String[resultList.size()];
        resultArray = resultList.toArray(resultArray);

        return resultArray;
    }

    @Override
    public String[] flatMap(final String[] source, final FlatMappingOperation operation) {
        if ((source == null) || (operation == null)) {
            throw new IllegalArgumentException(MSG_NULL_SOURCE);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : source) {
            stringBuilder.append(s);
            stringBuilder.append(",");

        }
        String allStrings = stringBuilder.toString();
        return operation.flatMap(allStrings);
    }
}
