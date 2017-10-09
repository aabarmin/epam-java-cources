package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation class for Task029.
 *
 * @author Sergei Titov
 */
public class Task029Impl implements Task029 {

    private char[][] crossword = new char[10][10];

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {

        // get list of words (access by index is convenient)
        List<String> list = new ArrayList<>(words);

        // init crossword panel
        int i = 0;
        for (String line : rows) {
            line.getChars(0, line.length(), crossword[i++], 0);
        }

        // start filling from first word
        fill(list, 0, 0, 1, false);

        // prepare and return result
        List<String> result = new ArrayList<>();
        for (int line = 0; line < 10; line++) {
            result.add(new String(crossword[line]));
        }
        return result;
    }


    // fill
    private boolean fill(List<String> words, int index, int row, int col, boolean horizontally) {

        String word = words.get(index);

        int dRow = 0;
        int dCol = 0;

        // write the word to crossword
        for (int i = 0; i < word.length(); i++) {
            crossword[row + dRow][col + dCol] = word.charAt(i);
            if (horizontally) {
                dCol++;
            } else {
                dRow++;
            }
        }
        // work is done if the last word is filled in
        if (index >= words.size() - 1) {
            return true;
        }

        // look for cross point
        String next = words.get(index + 1);
        while (row < 9 && col < 9) {

            if (horizontally) {
                col++;
            } else {
                row++;
            }
            int stepBack = sizeBack(row, col, !horizontally);
            int stepForward = sizeForward(row, col, !horizontally);

            // cross found
            if ((stepBack > 0 || stepForward > 0)
                    && next.length() == (stepBack + stepForward + 1)) {

                // compare letters
                if (crossword[row][col] != next.charAt(stepBack)) {
                    continue;
                }

                dRow = 0;
                dCol = 0;
                if (horizontally) {
                    dRow -= stepBack;
                } else {
                    dCol -= stepBack;
                }

                // try to fill from next word
                if (fill(words, index + 1, row + dRow, col + dCol, !horizontally)) {
                    return true;
                }

                next = words.get(++index + 1);
            }
        }
        return false;
    }


    // sizeBack
    private int sizeBack(int row, int col, boolean horizontally) {

        int size = 0;

        if (horizontally) {
            if (0 == col) {
                return 0;
            }
            while (--col >= 0 && '-' == crossword[row][col]) {
                size++;
            }
        } else {
            if (0 == row) {
                return 0;
            }
            while (--row >= 0 && '-' == crossword[row][col]) {
                size++;
            }
        }
        return size;
    }

    // sizeForward
    private int sizeForward(int row, int col, boolean horizontally) {

        int size = 0;

        if (horizontally) {
            if (9 == col) {
                return 0;
            }
            while (++col < 10 && '-' == crossword[row][col]) {
                size++;
            }
        } else {
            if (9 == row) {
                return 0;
            }
            while (++row < 10 && '-' == crossword[row][col]) {
                size++;
            }
        }
        return size;
    }
}
