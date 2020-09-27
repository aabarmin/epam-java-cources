package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * author Dmitry Novikov 02-Sep-20.
 */
public class Task24Impl implements Task24 {
    @Override
    public Collection<String> getWordsCount(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>();

        int startIndex;
        int endIndex = 0;

        for (int i = 0; i < source.length(); i++) {
            if (Character.isUpperCase(source.charAt(i)) || i == source.length() - 1) {
                startIndex = endIndex;
                endIndex = i != source.length() - 1 ? i : i + 1;
                String temp = source.substring(startIndex, endIndex).toLowerCase();
                if (!temp.isEmpty()) {
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
