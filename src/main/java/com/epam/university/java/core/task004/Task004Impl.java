package com.epam.university.java.core.task004;


import com.epam.university.java.core.task001.Task001Impl;
import com.epam.university.java.core.task003.Task003Impl;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        Task001Impl.nullChecker(first, second);

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i].equals(second[j])) {
                    buffer.append(second[j]).append(",");
                }
            }
        }
        String[] result = buffer.length() == 0 ? new String[0] : buffer.toString().split(",");
        return result;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        Task001Impl.nullChecker(first, second);
        String[] merged = new Task003Impl().join(first, second);
        int counter = 0;

        if (merged.length == 1)
            return merged;

        for (int i = 0; i < merged.length; i++) {
            if (merged[i] == null)
                continue;
            for (int j = i + 1; j < merged.length; j++) {
                if (merged[i] == merged[j]) {
                    merged[j] = null;
                    counter++;
                }
            }
        }
        String[] result = new String[merged.length - counter];
        counter = 0;
        for (String s : merged) {
            if (s != null)
                result[counter++] = s;
        }
        return result;
    }
}
