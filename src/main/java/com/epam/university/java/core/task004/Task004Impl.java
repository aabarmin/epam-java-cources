package com.epam.university.java.core.task004;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] strings = new String[first.length];
        int k = 0;
        for (int j = 0; j < first.length; j++) {
            for (int i = 0; i < second.length; i++) {
                if (first[j].equals(second[i])) {
                    strings[k++] = first[j];
                }

            }
        }
        String[] result = new String[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = strings[i];
        }
        return result;
    }

    @Override
    public String[] union(String[] first, String[] second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] array;

        array = join(first, second);

        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(array));


        return set.toArray(new String[0]);
    }

    public  String[] join(String[] first, String[] second) {
        int lengthFirst = first.length;
        int lengthSecond = second.length;
        int lengthNew = lengthFirst + lengthSecond;

        String[] newArray = new String[lengthNew];
        System.arraycopy(first, 0, newArray, 0, lengthFirst);
        System.arraycopy(second, 0, newArray, lengthFirst, lengthSecond);

        return newArray;
    }
}
