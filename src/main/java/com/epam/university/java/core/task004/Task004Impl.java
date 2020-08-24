package com.epam.university.java.core.task004;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        validateInput(first, second);

        ArrayList<String> firstList = new ArrayList<>();
        ArrayList<String> secondList = new ArrayList<>();

        firstList.addAll(Arrays.asList(first));
        secondList.addAll(Arrays.asList(second));

        firstList.retainAll(secondList);

        String[] strings = new String[firstList.size()];
        firstList.toArray(strings);
        return strings;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        validateInput(first, second);

        Set<String> arrSet = new LinkedHashSet<>();

        arrSet.addAll(Arrays.asList(first));
        arrSet.addAll(Arrays.asList(second));

        String[] strings = new String[arrSet.size()];
        arrSet.toArray(strings);

        return strings;
    }

    private static void validateInput(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
    }
}
