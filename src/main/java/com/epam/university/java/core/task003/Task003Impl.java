package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Mirabilis on 03.09.2017.
 */
public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        int length = source.length;
        String[] outString = new String[length];
        for (int i = 0; i < length; i++) {
            outString[i] = source[length - i - 1];
        }
        return outString;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] outString = new String[first.length + second.length];
        System.arraycopy(first,0,outString,0,first.length);
        System.arraycopy(second,0,outString,first.length, second.length);
        return outString;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        int max = source[0];
        for (int element:source) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        }
        List<String> buffer = new ArrayList<>();
        for (String current:source) {
            if (condition.isValid(current)) {
                buffer.add(current);
            }
        }
        String[] result = new String[buffer.size()];
        return buffer.toArray(result);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        }
        List<String> pullOfElements = new ArrayList<>();
        for (String current:source) {
            pullOfElements.add(current);
        }
        List<String> condition = Arrays.asList(toRemote);
        pullOfElements.removeAll(condition);
        String[] outString = new String[pullOfElements.size()];
        return pullOfElements.toArray(outString);
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
        String[] result = new String[source.length];
        for (int i = 0; i < source.length; i++) {
            result[i] = operation.map(source[i]);
        }
        return result;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
        List<String> buffer = new ArrayList<>();
        List<String> filtered = new ArrayList<>();
        for (String current:source) {
            buffer.addAll(Arrays.asList(operation.flatMap(current)));
            for (String element:buffer) {
                if (!filtered.contains(element)) {
                    filtered.add(element);
                }
            }
            buffer.clear();
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String e1, String e2) {
                Integer a = Integer.parseInt(e1);

                return a.compareTo(Integer.parseInt(e2)) * (-1);
            }
        };
        String[] result = new String[filtered.size()];
        result = filtered.toArray(result);
        Arrays.sort(result,comparator);
        return result;
    }
}
