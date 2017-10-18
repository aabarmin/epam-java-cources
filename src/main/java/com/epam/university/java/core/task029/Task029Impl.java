package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task029Impl implements Task029 {
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        //solved crossword to return
        Collection<String> result = new ArrayList<>();

        //making two-dimensional array as a matrix of chars
        String[] strings = rows.toArray(new String[rows.size()]);
        char[][] matrix = new char[rows.size()][strings[0].length()];
        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            System.arraycopy(chars, 0, matrix[i], 0, chars.length);
        }

        //trying to put each word somewhere
        for (String word : words) {
            postWord(matrix, word.toCharArray());
        }

        //check if crossword solved
        if (!isDone(matrix)) {
            //shuffle the order of words and try to solve again
            Collections.shuffle((List<?>) words);
            result = fillCrossword(rows, words);
        } else {
            //fill up result collection
            for (char[] chars : matrix) {
                result.add(String.valueOf(chars));
            }
        }

        return result;
    }

    /**
     * Post the word into the crossword if possible.
     *
     * @param matrix matrix of chars
     * @param word   word to post
     */
    private void postWord(char[][] matrix, char[] word) {
        //trying to put the word horizontal
        for (char[] row : matrix) {
            for (int startPosition = 0; startPosition < row.length; startPosition++) {
                if (fillRow(row, word, startPosition)) {
                    return;
                }
            }
        }

        //trying to put the word vertical
        for (int i = 0; i < matrix[0].length; i++) {
            //transforming column to row
            StringBuilder verticalString = new StringBuilder();
            for (char[] row : matrix) {
                verticalString.append(row[i]);
            }

            char[] verticalRow = verticalString.toString().toCharArray();
            for (int startPosition = 0; startPosition < verticalRow.length; startPosition++) {
                if (fillRow(verticalRow, word, startPosition)) {
                    //transforming row to column
                    for (int j = 0; j < verticalRow.length; j++) {
                        matrix[j][i] = verticalRow[j];
                    }
                    return;
                }
            }
        }
    }

    /**
     * Fill the row with the word.
     *
     * @param row           chars of row
     * @param word          chars of word
     * @param startPosition row start position
     * @return is possible to fill the row with the word
     */
    private boolean fillRow(char[] row, char[] word, int startPosition) {
        if (row.length < word.length + startPosition) {
            return false;
        }

        for (int i = 0; i < word.length; i++) {
            if (row[startPosition + i] != '-' && row[startPosition + i] != word[i]) {
                return false;
            }
        }

        //replacing row with a filled one
        System.arraycopy(word, 0, row, startPosition, word.length);
        return true;
    }

    /**
     * Check if crossword is solved.
     *
     * @param matrix matrix of chars
     * @return true if solved
     */
    private boolean isDone(char[][] matrix) {
        for (char[] chars : matrix) {
            if (String.valueOf(chars).contains("-")) {
                return false;
            }
        }

        return true;
    }
}
