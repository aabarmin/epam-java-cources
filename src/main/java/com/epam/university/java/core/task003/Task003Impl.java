package com.epam.university.java.core.task003;

import java.util.ArrayList;

public class Task003Impl implements Task003 {

    @Override
    public String[] invert(String[] source) throws IllegalArgumentException {
        if (source == null) {
            System.out.println("Error in invert operation");
            throw new IllegalArgumentException();
        }
        String[] invertedArr = new String[source.length];
        for (int i = source.length - 1; i >= 0; i--) {
            for (int j = 0; j < invertedArr.length; ) {
                invertedArr[j] = source[i];
                j++;
            }
        }
        return source;
    }

    @Override
    public String[] join(String[] first, String[] second) throws IllegalArgumentException {
        if (first == null || second == null) {
            System.out.println("Error in join operation");
            throw new IllegalArgumentException();
        }
        String[] gluedArr = new String[first.length + second.length];
        for (int i = 0; i < first.length; i++) {
            gluedArr[i] = first[i];
        }
        for (int i = 0; i < second.length; i++) {
            gluedArr[gluedArr.length - (i + 1)] = second[second.length - (i + 1)];
        }
        return gluedArr;
    }

    @Override
    public int findMax(int[] source) throws IllegalArgumentException {
        if (source == null) {
            System.out.println("Error in findMax operation");
            throw new IllegalArgumentException();
        }
        int maxValue = Integer.MIN_VALUE;
        for (int sources :
                source) {
            if (sources > maxValue) {
                maxValue = sources;
            }
        }
        return maxValue;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition)
            throws IllegalArgumentException{
        if (source == null) {
            System.out.println("Error in filter operation");
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (String sources:
             source) {
            if (condition.isValid(sources)){
                count++;
            }
        }
        String[] resultedArr = new String[count];
        for (int i = 0; i < source.length; i++) {
            if (condition.isValid(source[i])) {
                for (int j = 0; j < resultedArr.length; j++) {
                    resultedArr[j] = source [i];
                }
            }
        }
        return resultedArr;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) throws IllegalArgumentException{
        if (source == null || toRemote == null) {
            System.out.println("Error in removing operation");
            throw new IllegalArgumentException();
        }
        ArrayList<String> resultedArrayList = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < toRemote.length; j++) {
                if (!source[i].equals(toRemote[j])){
                    resultedArrayList.add(source[i]);
                }
            }
        }
        String[] resultedArray = new String[resultedArrayList.size()];
        for (int i = 0; i < resultedArray.length; i++) {
            resultedArray[i] = resultedArrayList.get(i);
        }
        return resultedArray;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation)
            throws IllegalArgumentException {
        if (source == null || operation == null) {
            System.out.println("Error in mapping operation");
            throw new IllegalArgumentException();
        }
        for (String sources:
             source) {
            operation.map(sources);
        }
        return source;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        return new String[0];
    }
}
