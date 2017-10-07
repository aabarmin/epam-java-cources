package com.epam.university.java.core.task004;

import com.epam.university.java.core.ChecksHelper;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * implementation class for Task004.
 *
 * @author Sergei Titov
 */
public class Task004Impl implements Task004 {

    /**
     * gets common part of two arrays.
     *
     * @param first first array
     * @param second second array
     *
     * @returns an array, consisting of elements presented in both input arrays
     *
     * @throws IllegalArgumentException if both of input arrays are nulls
     */
    @Override
    public String[] intersection(String[] first, String[] second) throws IllegalArgumentException {

        // check for argument's absence
        ChecksHelper.checkForNullBothArguments(first, second);
        if (null == first || null == second) {
            return null;
        }

        return Arrays.stream(first)
                .filter((l) -> Arrays.asList(second).contains(l))
                .collect(Collectors.toSet())
                .toArray(new String[0]);
    }

    /**
     * gets a composite array with elements from two arrays.
     *
     * @param first first array
     * @param second second array
     *
     * @returns an array, consisting of elements, presented either in any or both of input arrays
     *
     * @throws IllegalArgumentException if both of input arrays are nulls
     */
    @Override
    public String[] union(String[] first, String[] second) throws IllegalArgumentException {

        // check for argument's absence
        ChecksHelper.checkForNullBothArguments(first, second);
        if (null == first) {
            return second;
        }
        if (null == second) {
            return first;
        }

        // at first just take the first array wholly
        List<String> list = new ArrayList<>(Arrays.asList(first));
        // then add absent elements from the second array
        for (String entry : second) {
            if (!list.contains(entry)) {
                list.add(entry);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
