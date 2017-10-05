package com.epam.university.java.core.task029;

import java.util.Collection;

public class Task029Impl implements Task029 {
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        char[][] chars = convertToInts(rows);
        return null;
    }

    private char[][] convertToInts(Collection<String> rows) {
        String[] stringRows = rows.toArray(new String[rows.size()]);
        char[][] result = new char[stringRows[0].length()][stringRows.length];
        for (int i = 0; i < stringRows.length; i++) {
            result[i] = stringRows[i].toCharArray();
        }
        return result;
    }

    private char[] takeRow(char[][] chars, int row) {
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i][row];
        }
        return result;
    }

    private int putWordInChar(char[] chars, String word) {
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < chars.length - wordChars.length; i++) {
            if (check(chars, wordChars, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean check(char[] chars, char[] word, int stPos) {
        if (chars.length < word.length + stPos) {
            return false;
        }
        for (int i = 0; i < word.length; i++) {
            if (chars[stPos + i] != '+') {
                return false;
            }
        }
        return true;
    }
}

