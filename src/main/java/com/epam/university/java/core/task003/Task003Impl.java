package com.epam.university.java.core.task003;

import java.util.*;

public class Task003Impl implements Task003 {

    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
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

        String[] tmp = new String[first.length + second.length];

        int index = 0;
        for (int i = 0; i < first.length; i++) {
            tmp[index] = first[i];
            index++;
        }
        for (int i = 0; i < second.length; i++) {
            tmp[index] = second[i];
            index++;
        }

        return tmp;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null || source.length == 0) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(source);

        return source[source.length - 1];
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {

        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        }

        LinkedList<String> list = new LinkedList<>();
        for (String line : source) {
            if (condition.isValid(line)) {
                list.add(line);
            }
        }
        String[] tmp = new String[list.size()];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = list.get(i);
        }

        return tmp;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        }

        int size = source.length;
        for (int i = 0; i < toRemote.length; i++) {
            for (int j = 0; j < source.length; j++) {
                if (source[j].equals(toRemote[i])) {
                    source[j] = "";
                    size--;
                    break;
                }
            }
        }

        String[] tmp = new String[size];
        int index = 0;

        for (int i = 0; i < source.length; i++) {
            if (!source[i].equals("")) {
                tmp[index] = source[i];
                index++;
            }
        }

        return tmp;
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

        String str = "";
        for (String line : source) {
            str += line + " ";
        }
        String[] output = operation.flatMap(str);
//        System.out.println(Arrays.toString(output));
        return output;
    }


}
