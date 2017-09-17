package com.epam.university.java.core.task003;

import java.util.ArrayList;

/**
 * Created by Doomsday Device on 17.09.2017.
 */
public class Task003Impl implements Task003 {

    private ArrayList<Object> arrayList;

    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }

        String[] invertedSource = new String[source.length];

        for (int i = 0; i < source.length; i++) {
            invertedSource[i] = source[source.length - i - 1];
        }

        return invertedSource;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        String[] joinedArray = new String[first.length + second.length];

        if (joinedArray.length == 0) {
            return joinedArray;
        }

        for (int i = 0; i < first.length; i++) {
            joinedArray[i] = first[i];
        }
        for (int i = first.length; i < joinedArray.length; i++) {
            joinedArray[i] = second[i - first.length];
        }

        return joinedArray;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        int max = source[0];
        for (int i = 1; i < source.length; i++) {
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

        String[] buffer = new String[source.length];
        int count = 0;

        for (String elem : source) {
            if (condition.isValid(elem)) {
                buffer[count] = elem;
                count++;
            }
        }

        String[] result = new String[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = buffer[i];
        }

        return result;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        }

        String[] buffer = new String[source.length];

        int count = 0;
        boolean isToRemote = false;

        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < toRemote.length; j++) {
                if (source[i].equals(toRemote[j])) {
                    isToRemote = true;
                    break;
                }
            }
            if (isToRemote == false) {
                buffer[count] = source[i];
                count++;
            }
            isToRemote = false;
        }

        String[] result = new String[count];

        for (int i = 0; i < result.length; i++) {
            result[i] = buffer[i];
        }

        return result;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }

        String[] result = new String[source.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = operation.map(source[i]);
        }
        
        return result;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }

        String[][] buffer = new String[source.length][];

        for (int i = 0; i < source.length; i++) {
            String[] operatedElem = operation.flatMap(source[i]);
            buffer[i] = operatedElem;
        }

        String[] result = concatArrays(buffer);

        result = removeDuplicates(result);

        result = sort(result);
        System.out.println(result.toString());
        return result;
    }

    String[] concatArrays(String[][] arrays) {
        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            count += arrays[i].length;
        }
        String[] result = new String[count];
        count = 0;

        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, result, count, arrays[i].length);
            count += arrays[i].length;
        }

        return result;
    }

    String[] removeDuplicates(String[] array) {
        boolean[] mask = new boolean[array.length];
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (!mask[i]) {
                String tmp = array[i];

                for (int j = i + 1; j < array.length; j++) {
                    if (tmp.equals(array[j])) {
                        mask[j] = true;
                        count++;
                    }
                }
            }
        }

        String[] result = new String[array.length - count];

        for (int i = 0, j = 0; i < array.length; i++) {
            if (!mask[i]) {
                result[j++] = (array[i]);
            }
        }

        return result;
    }

    String[] sort(String[] array) {

        int[] buffer = new int[array.length];

        for (int i = 0; i < array.length; i++) {

            buffer[i] = Integer.parseInt(array[i]);
        }

        int length = buffer.length;

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (buffer[j] < buffer[i]) {
                    int temp = buffer[i];
                    buffer[i] = buffer[j];
                    buffer[j] = temp;
                }
            }
        }

        String[] result = new String[buffer.length];

        for (int i = 0; i < buffer.length; i++) {
            result[i] = String.valueOf(buffer[i]);
        }

        return result;
    }
}
