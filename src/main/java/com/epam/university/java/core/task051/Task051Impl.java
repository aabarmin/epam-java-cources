package com.epam.university.java.core.task051;

import java.util.List;

public class Task051Impl implements Task051 {
    @Override
    public String replace(String source) {
        if (source == null || source.isEmpty() || source.isBlank()) {
            throw new IllegalArgumentException();
        }
        List<Character> vowels = List.of('a', 'e', 'u', 'i', 'o');
        if (!source.contains("the")) {
            throw new IllegalArgumentException();
        }

        while (source.contains("the")) {
            int beginIndex = source.indexOf("the");
            if (beginIndex + 4 >= source.length()) {
                throw new IllegalArgumentException();
            }
            char nextWordLetter = source.charAt(beginIndex + 4);
            if (vowels.contains(nextWordLetter)) {
                source = source.replaceFirst("the", "an");
            } else {
                source = source.replaceFirst("the", "a");
            }
        }

        return source;
    }
}
