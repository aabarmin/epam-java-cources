package com.epam.university.java.core.task004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Task004Impl implements Task004 {

    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        ArrayList<String> firstList = new ArrayList<String>(Arrays.asList(first));
        ArrayList<String> secondList = new ArrayList<String>(Arrays.asList(second));
        ArrayList<String> resultList = new ArrayList<String>();
        for (int i = 0; i < secondList.size(); i++) {
            if (firstList.contains(secondList.get(i))) {
                resultList.add(secondList.get(i));
            }
        }
        String[] resultArr = new String[resultList.size()];
        resultList.toArray(resultArr);
        return resultArr;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        LinkedHashSet<String> resultSet = new LinkedHashSet<>();
        resultSet.addAll(Arrays.asList(first));
        resultSet.addAll(Arrays.asList(second));
        String[] resultArr = new String[resultSet.size()];
        resultSet.toArray(resultArr);
        return resultArr;
    }

}
