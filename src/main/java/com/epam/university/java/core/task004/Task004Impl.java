package com.epam.university.java.core.task004;

import com.epam.university.java.core.task003.Task003Impl;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Arrays not provided!");
        }
        boolean[] mask = new boolean[first.length];
        int intersecCount = 0;
        for (int i = 0; i < first.length; i++) {
            for (String s : second) {
                if (first[i].equals(s)) {
                    mask[i] = true;
                    intersecCount++;
                }
            }
        }
        String[] arrIntersec = new String[intersecCount];
        for (int i = 0, j = 0; i < first.length && j < arrIntersec.length; i++) {
            if (mask[i]) {
                arrIntersec[j++] = first[i];
            }
        }
        return arrIntersec;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Arrays not provided!");
        }
        String[] finalString = new String[first.length + second.length];
        for (int i = 0, j = 0, k = 0; i < finalString.length; i++) {
            if (i < first.length) {
                finalString[i] = first[j++];
            } else {
                finalString[i] = second[k++];
            }
        }
        finalString = Task003Impl.removeDuplicates(finalString);
        return finalString;
    }
}
