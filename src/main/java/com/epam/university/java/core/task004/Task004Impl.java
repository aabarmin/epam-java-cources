package com.epam.university.java.core.task004;

import java.util.ArrayList;
import java.util.Arrays;

public class Task004Impl implements Task004 {

    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first != null && second != null) {
            ArrayList<String> firstAsList = new ArrayList<>(Arrays.asList(first));
            ArrayList<String> resultList = new ArrayList<>();
            for (int i = 0; i < first.length; i++) {
                if (firstAsList.contains(second[i])) {
                    resultList.add(second[i]);
                }
            }
            return resultList.toArray(new String[0]);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (first != null && second != null) {
            ArrayList<String> firstAsList = new ArrayList<>(Arrays.asList(first));
            firstAsList.addAll(Arrays.asList(second));
            return firstAsList.stream()
                    .distinct().toArray(String[]::new);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
