package com.epam.university.java.core.task008;

import java.util.Stack;

public class Task008Impl implements Task008 {
    /**
     * Given a string with mathematical expression like "(1 + 2) * {[-3] - 4}". You need to check,
     * are all braces correct. Ex:
     * <p>
     * "(1 + 2) * {[-3] - 4}" - correct
     * "(1 + [2) + 3 - 4]" - incorrect
     * In expression can be used the following kinds of braces: {}, (), [].
     * Tip: it's better to implement stack structure.
     * Tip: You also can use Stack class but it's not recommended.
     * </p>
     *
     * @param sourceString string to check
     * @return is braces valid or source string is empty
     */

    @Override
    public boolean isValid(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        if (sourceString.isEmpty()) {
            return true;
        }

        String onlyBracesSourceString = sourceString
                .replaceAll("[-+*/]*[\\d]*[\\s]*", "")
                .trim();

        while (containsBraces(onlyBracesSourceString)) {
            onlyBracesSourceString
                    .replaceAll("[\\[\\](){}]", "")
                    .trim();
        }

        if (onlyBracesSourceString.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean containsBraces(String str) {
        return str.contains("()")
                || str.contains("[]")
                || str.contains("{}");
    }
}
