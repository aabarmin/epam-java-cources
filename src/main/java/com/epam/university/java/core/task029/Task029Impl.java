package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Task029Impl implements Task029 {

    private class WordPlace {
        public int index;
        public int row;

        public WordPlace(int index, int row) {
            this.index = index;
            this.row = row;
        }
    }

    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        //Для всех оставшихся слов
        for (String word : words) {
            //Пытаемся вставить слово
            Collection<String> newRows = addWord(rows, word);
            if (words.size() != 0) {
                if (newRows != null) {
                    Collection<String> newWords = new ArrayList<>(words);
                    newWords.remove(word);
                    return fillCrossword(newRows, newWords);
                }
            } else {
                return rows;
            }
        }
        return rows;
    }

    /**
     * determines if there current row starting from candidate place is suitable for adding word.
     *
     * @param row   source row
     * @param word  current word
     * @param place candidate place
     * @return true if <code>place</code> is suitable
     */
    private boolean canAddWordHor(String row, String word, WordPlace place) {
        if (row.length() <= place.index + word.length()) {
            return false;
        }
        CharSequence rowSequence = row.subSequence(place.index, place.index + word.length());
        int wordIndex = 0;
        while (wordIndex < rowSequence.length() && wordIndex < word.length()) {
            if (rowSequence.charAt(wordIndex) != '-'
                    && rowSequence.charAt(wordIndex) != word.charAt(wordIndex)) {
                return false;
            }
            wordIndex++;
        }
        if (place.index + word.length() < row.length()
                && row.charAt(place.index + word.length()) == '-') {
            return false;
        }
        return true;
    }

    /**
     * determines if there column starting from candidate place is suitable for adding word.
     *
     * @param rows  source collection of crossword
     * @param word  current word
     * @param place candidate place
     * @return true if <code>place</code> is suitable
     */
    private boolean canAddWordVert(List<String> rows, String word, WordPlace place) {
        int rowIndex = place.row;
        int wordIndex = 0;
        int inRowIndex = place.index;
        while (rowIndex < rows.size() && wordIndex < word.length()) {
            if (rows.get(rowIndex).charAt(inRowIndex) != '-'
                    && rows.get(rowIndex).charAt(inRowIndex) != word.charAt(wordIndex)) {
                return false;
            }
            rowIndex++;
            wordIndex++;
        }
        if (rowIndex >= rows.size() && wordIndex != word.length()) {
            return false;
        } else {
            if (rowIndex < rows.size() && rows.get(rowIndex).charAt(inRowIndex) == '-') {
                return false;
            }
        }

        return true;
    }

    /**
     * Find first free space for <code>word</code>.
     *
     * @param rows collection where to find
     * @param word current word
     * @return collection with added word or null if collection does not have enough space
     */
    private Collection<String> addWord(Collection<String> rows, String word) {
        List<String> rowsArr = new ArrayList<>(rows);
        Iterator<String> iterator = rows.iterator();
        int rowNumber = -1;
        while (iterator.hasNext()) {
            String row = iterator.next();
            rowNumber++;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) != '+') {
                    if (canAddWordHor(row, word, new WordPlace(i, rowNumber))) {
                        byte[] bytes = row.getBytes();
                        for (int j = i; j < i + word.length(); j++) {
                            bytes[j] = (byte) word.charAt(j - i);
                        }
                        rowsArr.set(rowNumber, new String(bytes));
                        return rowsArr;
                    }
                    if (canAddWordVert(rowsArr, word, new WordPlace(i, rowNumber))) {
                        for (int j = rowNumber; j < rowNumber + word.length(); j++) {
                            String curRow = rowsArr.get(j);
                            byte[] rowBytes = curRow.getBytes();
                            rowBytes[i] = (byte) word.charAt(j - rowNumber);
                            rowsArr.set(j, new String(rowBytes));
                        }
                        return rowsArr;
                    }
                }
            }
        }

        return null;
    }
}
