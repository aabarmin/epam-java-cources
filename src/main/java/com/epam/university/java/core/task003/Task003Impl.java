package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import com.epam.university.java.core.ChecksHelper;

/**
 * implementation class for Task003.
 *
 * @author Sergei Titov
 */
public class Task003Impl implements Task003 {

    /**
     * inverts string array.
     *
     * @param source source array
     *
     * @returns inverted array
     *
     * @throws IllegalArgumentException if source is null
     */
    @Override
    public String[] invert(String[] source) throws IllegalArgumentException {

        ChecksHelper.checkForNull(source);
        String[] arrRetVal = new String[ source.length ];

        for (int i = 1; i <= source.length; i++) {
            arrRetVal[source.length - i] = source[i - 1];
        }

        return arrRetVal;
    }

    /**
     * merges two string arrays.
     *
     * @param first first array
     * @param second second array
     *
     * @returns merged array
     *
     * @throws IllegalArgumentException if both arrays are nulls
     */
    @Override
    public String[] join(String[] first, String[] second) throws IllegalArgumentException {

        ChecksHelper.checkForNullBothArguments(first, second);
        if (null == first) {
            return second;
        }
        if (null == second) {
            return first;
        }

        String[] arrRetVal = new String[first.length + second.length];
        System.arraycopy(first, 0, arrRetVal, 0, first.length);
        System.arraycopy(second, 0, arrRetVal, first.length, second.length);

        return arrRetVal;
    }

    /**
     * finds max value from int array.
     *
     * @param source source array
     *
     * @returns MAX value from source array
     *
     * @throws IllegalArgumentException if source is null
     */
    @Override
    public int findMax(int[] source) throws IllegalArgumentException {

        ChecksHelper.checkForEmptiness(source);
        int iRetVal = source[0];

        for (int i=1; i<source.length; i++) {
            if (source[i] > iRetVal) {
                iRetVal = source[i];
            }
        }

        return iRetVal;
    }

    /**
     * filters input array by condition rules.
     *
     * @param source source array
     * @param condition condition instance
     *
     * @returns array, filtered by FilteringCondition rules
     *
     * @throws IllegalArgumentException if both source and condition are nulls
     */
    @Override
    public String[] filter(String[] source, FilteringCondition condition) throws IllegalArgumentException {

        ChecksHelper.checkForNullBothArguments(source, condition);
        if (null == source) {
            return null;
        }
        if (null == condition) {
            return source;
        }
        List<String> filteredList = new ArrayList<>();

        for (int i=0; i<source.length; i++) {
            if (condition.isValid(source[i])) {
                filteredList.add(source[i]);
            }
        }

        String[] arrRetVal = new String[ filteredList.size() ];
        return filteredList.toArray(arrRetVal);
    }

    /**
     * removes some elements from array.
     *
     * @param source source array
     * @param toRemote elements to remove
     *
     * @returns an array, consisting of source array elements,
     * but not containing elements from "toRemote"
     *
     * @throws IllegalArgumentException if both source and toRemote are nulls
     */
    @Override
    public String[] removeElements(String[] source, String[] toRemote)
            throws IllegalArgumentException {

        ChecksHelper.checkForNullBothArguments(source, toRemote);
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < source.length; i++) {
            boolean exists = false;
            for (int j = 0; j < toRemote.length; j++) {
                if (source[i].equals(toRemote[j]))
                {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                newList.add(source[i]);
            }
        }

        String[] arrRetVal = new String[ newList.size() ];
        return newList.toArray( arrRetVal );
    }

    /**
     * maps elements of array by determined MappingOperation.
     *
     * @param source source array
     * @param operation operation instance
     *
     * @returns an array of source array elements, mapped by MappingOperation rules,
     * or returns source array intact if operation is null
     *
     * @throws IllegalArgumentException if both source and operation are nulls
     */
    @Override
    public String[] map(String[] source, MappingOperation operation)
            throws IllegalArgumentException {

        ChecksHelper.checkForNullBothArguments(source, operation);
        if (null == operation) {
            return source;
        }
        String[] arrRetVal = new String[ source.length ];

        for (int i=0; i<source.length; i++) {
            arrRetVal[i] = operation.map(source[i]);
        }

        return arrRetVal;
    }

    /**
     * maps elements of array by determined FlatMappingOperation.
     *
     * @param source source array
     * @param operation operation instance
     *
     * @returns an array of source array elements, mapped by FlatMappingOperation rules,
     * or returns source array intact if operation is null
     *
     * @throws IllegalArgumentException if both source and operation are nulls
     */
    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation)
            throws IllegalArgumentException {

        ChecksHelper.checkForNullBothArguments(source, operation);
        if (null == operation) {
            return source;
        }
        HashSet<String> set = new HashSet<>();

        // split and put in one set
        for (int i = 0; i < source.length; i++) {
            String[] arr = operation.flatMap(source[i]);
            for (int j = 0; j < arr.length; j++) {
                set.add(arr[j].trim());
            }
        }

        // put to array in descending order
        String[] arrRetVal = new String[ set.size() ];
        int i = set.size();
        for (String entry : set) {
            arrRetVal[--i] = entry;
        }

        return arrRetVal;
    }
}
