package com.epam.university.java.core.task051;

import java.util.HashSet;
import java.util.Set;

public class Task051Impl implements Task051 {
    String str = "the ";
    @Override
    public String replace(String source) {
        if (source == null || source.equalsIgnoreCase("the")) {
            throw new IllegalArgumentException();
        }
        if (source.toUpperCase().equals(source)) {
            throw new IllegalArgumentException();
        }

        String[] words = source.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("the")) {
                words[i] = String.valueOf(words[i + 1].charAt(0))
                        .matches("[aeyoui]") ? "an" : "a";
            }
        }

        return String.join(" ", words);
    }
}
