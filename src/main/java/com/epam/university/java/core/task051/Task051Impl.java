package com.epam.university.java.core.task051;

import java.util.List;

public class Task051Impl implements Task051 {
    @Override
    public String replace(String source) {
        if (source == null
                || source.trim().length() == 0
                || !source.toLowerCase().equals(source)
                || source.equals("the")) {
            throw new IllegalArgumentException();
        }
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'y');
        String[] words = source.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("the")) {
                if (vowels.contains(words[i + 1].charAt(0))) {
                    words[i] = "an";
                } else {
                    words[i] = "a";
                }
            }
        }
        return String.join(" ", words);
    }
}
