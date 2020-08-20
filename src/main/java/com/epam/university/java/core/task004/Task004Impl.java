package com.epam.university.java.core.task004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Romin Nuro on 19.08.2020 19:27.
 */
public class Task004Impl implements Task004 {
    /**
     * Find intersection of two arrays.
     *
     * @param first  first array
     * @param second second array
     * @return array of common elements
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        List<String> resultList = new ArrayList<>();
        for (String str : first) {
            if (Arrays.asList(second).contains(str)) {
                resultList.add(str);
            }
        }
        return resultList.toArray(new String[resultList.size()]);
    }

    /**
     * Find union of two arrays.
     *
     * @param first  first array
     * @param second second array
     * @return array of all elements of array
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        List<String> resultList = new ArrayList<>(Arrays.asList(first));
        for (String str : second) {
            if (!resultList.contains(str)) {
                resultList.add(str);
            }
        }
        return resultList.toArray(new String[resultList.size()]);
    }
}