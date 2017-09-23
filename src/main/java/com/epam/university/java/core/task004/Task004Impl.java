package com.epam.university.java.core.task004;

import com.epam.university.java.core.ChecksHelper;

import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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

        HashSet<String> setSecond = new HashSet(Arrays.asList(second));
        List<String> intersectionList = new ArrayList<>();
        for (int i = 0; i < first.length; i++) {
            if (setSecond.contains(first[i])) {
                intersectionList.add(first[i]);
            }
        }
        String[] arrayRetVal = new String[intersectionList.size()];
        return intersectionList.toArray(arrayRetVal);
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
        for (int i = 0; i < second.length; i++) {
            if (!list.contains(second[i])) {
                list.add(new String(second[i]));
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
