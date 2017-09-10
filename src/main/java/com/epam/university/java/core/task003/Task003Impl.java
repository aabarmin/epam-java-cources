package com.epam.university.java.core.task003;

import javax.naming.PartialResultException;
import java.util.Arrays;


public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        String[] destination = new String[source.length];
        for (int i = 0; i < destination.length; i++) {
            destination[i] = source[source.length - 1 - i];
        }
        return destination;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] destination = new String[first.length + second.length];
        int destIndex = 0;
        for (int i = 0; i < first.length; i++) {
            destination[destIndex++] = first[i];
        }
        for (int i = 0; i < second.length; i++) {
            destination[destIndex++] = second[i];
        }
        return destination;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < source.length; i++) {
            if (max < source[i]) {
                max = source[i];
            }
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        }
        int validCounter = 0;
        for (int i = 0; i < source.length; i++) {
            if (condition.isValid(source[i])) {
                validCounter++;
            }
        }

        String[] destination = new String[validCounter];
        int destIndex = 0;
        for (int i = 0; i < source.length; i++) {
            if (condition.isValid(source[i])) {
                destination[destIndex++] = source[i];
            }
        }
        return destination;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        }
        String[] sourceCopy = Arrays.copyOf(source, source.length);
        int deletedCount = 0;
        for (int i = 0; i < sourceCopy.length; i++) {
            for (int j = 0; j < toRemote.length; j++) {
                if (sourceCopy[i].equals(toRemote[j])) {
                    sourceCopy[i] = null;
                    deletedCount++;
                    break;
                }
            }
        }
        String[] destination = new String[sourceCopy.length - deletedCount];
        int destIndex = 0;
        for (int i = 0; i < sourceCopy.length; i++) {
            if (null != sourceCopy[i]) {
                destination[destIndex++] = sourceCopy[i];
            }
        }

        return destination;
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
        String tmp = "";
        for (int i = 0; i < source.length; i++) {
            if (tmp.equals("")) {
                tmp = source[i];
            } else {
                tmp = tmp + ',' + source[i];
            }
        }

        return operation.flatMap(tmp);
    }
}
