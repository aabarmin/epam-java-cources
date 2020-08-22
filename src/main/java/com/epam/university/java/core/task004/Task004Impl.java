package com.epam.university.java.core.task004;

import java.util.ArrayList;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> interArrays = new ArrayList<>();
        for (String firstString : first) {
            for (String secondString : second) {
                if (firstString.equals(secondString)) {
                    interArrays.add(firstString);
                    break;
                }
            }
        }
        return interArrays.toArray(new String[0]);
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> interArrays = new ArrayList<>();
        int firstIndex = 0;
        int secondIndex = 0;
        while (true) {
            while (firstIndex < first.length) {
                String firstValue = first[firstIndex];
                if (!interArrays.contains(firstValue)) {
                    interArrays.add(firstValue);
                }
                firstIndex++;
                break;
            }
            while (secondIndex < second.length) {
                String secondValue = second[secondIndex];
                if (!interArrays.contains(secondValue)) {
                    interArrays.add(secondValue);
                }
                secondIndex++;
                break;
            }
            if (firstIndex == first.length && secondIndex == second.length) {
                break;
            }
        }
        return interArrays.toArray(new String[0]);
    }
}
