package com.epam.university.java.core.task003;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Task003Impl implements Task003 {

    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        String[] output = new String[source.length];
        for (int i = 0; i < source.length; i++) {
            output[i] = source[source.length - 1 - i];
        }
        return output;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] output = new String[first.length + second.length];
        for (int i = 0; i < first.length; i++) {
            output[i] = first[i];
        }
        for (int i = 0; i < second.length; i++) {
            output[first.length + i] = second[i];
        }
        return output;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null || source.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = source[0];
        for (int i = 1; i < source.length; i++) {
            if (source[i] > max) max = source[i];
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        String[] output = new String[source.length];
        int outputIndex = 0;
        for (String x : source) {
            if (condition.isValid(x)) {
                output[outputIndex++] = x;
            }
        }
        String[] finalOutput = new String[outputIndex];
        for (int i = 0; i < finalOutput.length; i++) {
            finalOutput[i] = output[i];
        }
        return finalOutput;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        }
        String[] output = new String[source.length];
        int outputIndex = 0;
        for (int i = 0; i < source.length; i++) {
            boolean isToRemote = false;
            for (int j = 0; j < toRemote.length; j++) {
                if (source[i].equals(toRemote[j])) {
                    isToRemote = true;
                    break;
                }
            }
            if (!isToRemote) {
                output[outputIndex++] = source[i];
            }
        }
        String[] finalOutput = new String[outputIndex];
        for (int i = 0; i < finalOutput.length; i++) {
            finalOutput[i] = output[i];
        }
        return finalOutput;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        String[] output = new String[source.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = operation.map(source[i]);
        }
        return output;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        String[] tempArrayOfString = new String[0];

        String[] assistArray;
        for (String x : source) {
            assistArray = operation.flatMap(x);
            assistArray = this.removeElements(assistArray, tempArrayOfString);
            tempArrayOfString = this.join(tempArrayOfString, assistArray);
        }
        int[] intSource = new int[tempArrayOfString.length];
        for (int i = 0; i < tempArrayOfString.length; i++) {
            intSource[i] = Integer.valueOf(tempArrayOfString[i]);
        }

        for (int i = 1; i < intSource.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (intSource[j] > intSource[j-1]) {
                    intSource[j] += intSource[j-1];
                    intSource[j-1] = intSource[j] - intSource[j-1];
                    intSource[j] -= intSource[j-1];
                 }
            }
        }
        
        String[] output = new String[intSource.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = "" + intSource[i];
        }
        return output;
    }
}
