package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Task029Impl implements Task029 {
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        List<String> result;
        do {
            char[][] chars = collectionToChars(rows);
            List<String> words2 = new ArrayList<>(words);
            Collections.shuffle(words2);
            result = tryPutWords(chars, words2);
        } while (result == null);
        return result;
    }

    private List<String> tryPutWords(char[][] chars, List<String> words) {
        final Iterator<String> it = words.iterator();
        loop:
        while (it.hasNext()) {
            String word = it.next();
            char[] wordChars = word.toCharArray();
            for (char[] row : chars) {
                for (int stPos = 0; stPos < chars.length - wordChars.length + 1; stPos++) {
                    if (checkRow(row, wordChars, stPos)) {
                        it.remove();
                        continue loop;
                    }
                }

            }
            for (int nColumn = 0; nColumn < chars[0].length; nColumn++) {
                for (int stPos = 0; stPos < chars.length - wordChars.length + 1; stPos++) {
                    if (checkColumn(chars, wordChars, nColumn, stPos)) {
                        it.remove();
                        continue loop;
                    }
                }
            }
        }
        if (words.isEmpty()) {
            return charsToCollection(chars);
        }
        return null;
    }

    private List<String> charsToCollection(char[][] chars) {
        final List<String> list = new ArrayList<>();
        for (char[] aChar : chars) {
            list.add(new String(aChar));
        }
        return list;
    }

    private char[][] collectionToChars(Collection<String> rows) {
        final String[] stringRows = rows.toArray(new String[rows.size()]);
        char[][] result = new char[stringRows[0].length()][stringRows.length];
        for (int i = 0; i < stringRows.length; i++) {
            result[i] = stringRows[i].toCharArray();
        }
        return result;
    }

    private boolean checkColumn(char[][] chars, char[] word, int column, int stPos) {
        if (chars[column].length < word.length + stPos) {
            return false;
        }
        for (int i = 0; i < word.length; i++) {
            if (chars[stPos + i][column] != '-' && chars[stPos + i][column] != word[i]) {
                return false;
            }
        }
        for (int i = 0; i < word.length; i++) {
            chars[stPos + i][column] = word[i];
        }
        return true;
    }

    private boolean checkRow(char[] chars, char[] word, int stPos) {
        if (chars.length < word.length + stPos) {
            return false;
        }
        for (int i = 0; i < word.length; i++) {
            if (chars[stPos + i] != '-' && chars[stPos + i] != word[i]) {
                return false;
            }
        }
        System.arraycopy(word, 0, chars, stPos, word.length);
        return true;
    }
}

