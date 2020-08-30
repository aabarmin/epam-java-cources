package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Task003Impl implements Task003 {
    /**
     * Invert array.
     *
     * @param source source array
     * @return inverted array
     * @throws IllegalArgumentException if array not provided
     */
    @Override
    public String[] invert(String[] source) throws IllegalArgumentException {
        if (source == null) {
            System.out.println("Error in invert operation");
            throw new IllegalArgumentException();
        }
        String[] invertedArr = new String[source.length];
        for (int i = 0; i < source.length; i++) {
            invertedArr[source.length - i - 1] = source[i];
        }
        return invertedArr;
    }

    /**
     * Join two arrays.
     *
     * @param first  first array
     * @param second second array
     * @return new array which contains items from first and second arrays
     * @throws IllegalArgumentException if arrays not provided
     */
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

    /**
     * Find max element in array.
     *
     * @param source source array
     * @return value of maximal element in array
     * @throws IllegalArgumentException if array not provided
     */
    @Override
    public int findMax(int[] source) throws IllegalArgumentException {
        if (source == null || source.length == 0) {
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

    /**
     * Filter array elements in accordance with condition.
     *
     * @param source    source array
     * @param condition condition instance
     * @return filtered array
     * @throws IllegalArgumentException if array or condition not provided
     */
    @Override
    public String[] filter(String[] source, FilteringCondition condition)
            throws IllegalArgumentException {
        if (source == null || condition == null) {
            System.out.println("Error in filter operation");
            throw new IllegalArgumentException();
        }
        List<String> list = new ArrayList<>(Arrays.asList(source));
        for (int i = 0; i < list.size(); i++) {
            if (!condition.isValid(list.get(i))) {
                list.remove(list.get(i));
                i--;
            }
        }
        return list.toArray(new String[0]);
    }

    /**
     * Remove elements from source array.
     *
     * @param source   source array
     * @param toRemote elements to remove
     * @return new array without removed elements
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] removeElements(String[] source, String[] toRemote)
            throws IllegalArgumentException {
        if (source == null || toRemote == null) {
            System.out.println("Error in removing operation");
            throw new IllegalArgumentException();
        }
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(source));
        for (int i = 0; i < toRemote.length; i++) {
            for (int j = 0; j < listOfStrings.size(); j++) {
                if (toRemote[i].equals(listOfStrings.get(j))) {
                    listOfStrings.remove(listOfStrings.get(j));
                    j--;
                }
            }
        }
        return listOfStrings.toArray(new String[0]);
    }

    /**
     * Convert source array in accordance with provided operation.
     *
     * @param source    source array
     * @param operation operation instance
     * @return converted array
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] map(String[] source, MappingOperation operation)
            throws IllegalArgumentException {
        if (source == null || operation == null) {
            System.out.println("Error in mapping operation");
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < source.length; i++) {
            String temp = operation.map(source[i]);
            source[i] = temp;
        }
        return source;
    }

    /**
     * Convert source array in accordance with provided operation.
     *
     * @param source    source array
     * @param operation operation instance
     * @return converted array
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation)
            throws IllegalArgumentException {
        // Checking for Exception
        if (source == null || operation == null) {
            System.out.println("Error in flat mapping operation");
            throw new IllegalArgumentException();
        }
        // Convert source Array to the ArrayList of Arrays
        List<String[]> arrayListOfArrays = new ArrayList<>();
        int lengthOfArray = 0;
        for (int i = 0; i < source.length; i++) {
            String[] flattedArrayOfStrings = operation.flatMap(source[i]);
            arrayListOfArrays.add(flattedArrayOfStrings);
            lengthOfArray += flattedArrayOfStrings.length;
        }
        // Convert Arraylist to Array
        String[] arrayOfStrings = new String[lengthOfArray];
        int n = 0;
        for (String[] singleArray :
                arrayListOfArrays) {
            System.arraycopy(singleArray, 0, arrayOfStrings, n, singleArray.length);
            n += singleArray.length;
        }
        // Transfer values from array to Set
        // for deleting repeated values
        // Parse to integer for sorting it correctly
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < arrayOfStrings.length; i++) {
            int temp = Integer.parseInt(arrayOfStrings[i]);
            set.add(temp);
        }
        // Convert from set to arr for returning right type of value
        Integer[] intArray = set.toArray(new Integer[0]);
        String[] strArrayNotSorted = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            strArrayNotSorted[i] = String.valueOf(intArray[i]);
        }
        String[] invertedArray = invert(strArrayNotSorted);
        return invertedArray;
    }
}
