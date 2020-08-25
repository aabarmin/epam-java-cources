package com.epam.university.java.core.task008;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        if (sourceString != null) {
            sourceString = sourceString
                    .replaceAll("[-+*/]*[0-9]*", "")
                    .trim();
            while (containsBracket(sourceString)) {
                sourceString = sourceString
                        .replaceAll("[\\[\\](){}]", "");
            }
            return sourceString.trim().isEmpty();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean containsBracket(String sourceStr) {
        return sourceStr.contains("()") || sourceStr.contains("{}") || sourceStr.contains("[]");
    }
}
