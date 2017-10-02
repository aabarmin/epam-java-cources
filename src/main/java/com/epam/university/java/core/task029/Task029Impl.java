package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Recursion and crosswords and pain.
 */
public class Task029Impl implements Task029 {
    /**
     * Given 10x10 crossword grid, each line in <code>rows</code> collection presents single
     * line in a crossword. Cells in the grid have values + and -. Cells marked with a -
     * need to be filled up with an appropriate characters.
     *
     * <p>
     *     Example:
     *          source matrix is:
     *              +-++++++++
     *              +-++++++++
     *              +-++++++++
     *              +-----++++
     *              +-+++-++++
     *              +-+++-++++
     *              +++++-++++
     *              ++------++
     *              +++++-++++
     *              +++++-++++
     *          words list is [LONDON, DELHI, ICELAND, ANKARA]
     *          result matrix is
     *              +L++++++++
     *              +O++++++++
     *              +N++++++++
     *              +DELHI++++
     *              +O+++C++++
     *              +N+++E++++
     *              +++++L++++
     *              ++ANKARA++
     *              +++++N++++
     *              +++++D++++
     *
     * </p>
     *
     * @param rows crossword definition
     * @param words words to fill in
     * @return filled crossword
     */
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        //convert rows to char[][]
        char[][] matrix = new char[rows.size()][];
        int index = 0;
        for (String line : rows) {
            matrix[index] = line.toCharArray();
            index++;
        }

        List<String> wordsList = new ArrayList<>(words);

        Pair<Integer, Integer> pair = findFirstMinus(matrix);
        int i = 0;
        int j = 0;
        if (pair != null) {
            i = pair.getFirst();
            j = pair.getSecond();
        } else {
            throw new IllegalArgumentException();
        }


        if ((matrix[i][j] == '-') && (j < (matrix[i].length)) && (matrix[i][j + 1] == '-')) {
            processHorizontal(matrix, i, j, wordsList);
        } else {
            if ((matrix[i][j] == '-') && (i < (matrix.length)) && (matrix[i + 1][j] == '-')) {
                processVertical(matrix, i, j, wordsList);
            }
        }

        List<String> result = new ArrayList<>();
        for (i = 0; i < matrix.length; i++) {
            result.add(String.valueOf(matrix[i]));
        }

        return result;
    }

    /**
     * Find first minus from top to bottoom, left to right.
     * @param matrix of crossword
     * @return pair coordinates
     */
    private Pair<Integer, Integer> findFirstMinus(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '-') {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    /**
     * Write horizontal word.
     * @param matrix of crossword
     * @param i x coordinate of start.
     * @param j y coordinate of start.
     * @param words collection of words.
     */
    private void processHorizontal(char[][] matrix, int i, int j, Collection<String> words) {
        //find first
        while ((j > 0) && (matrix[i][j - 1] != '+')) {
            j--;
        }

        String word = words.stream().findFirst().orElse("");
        words.remove(word);

        List<Pair<Integer, Integer>> matches = new ArrayList<>();

        for (char ch : word.toCharArray()) {
            matrix[i][j] = ch;

            if ((i < (matrix.length - 1)) && (matrix[i + 1][j] == '-')) {
                Pair<Integer, Integer> newWord = new Pair<>(i, j);
                matches.add(newWord);
            }
            j++;
        }

        matches.forEach(p -> processVertical(matrix, p.getFirst(), p.getSecond(), words));
    }

    /**
     * Write vertical word.
     * @param matrix of crossword
     * @param i x coordinate of start.
     * @param j y coordinate of start.
     * @param words collection of words.
     */
    private void processVertical(char[][] matrix, int i, int j, Collection<String> words) {
        //find first
        while ((i > 0) && (matrix[i - 1][j] != '+')) {
            i--;
        }

        //init current word
        String word = words.stream().findFirst().orElse("");
        words.remove(word);

        List<Pair<Integer, Integer>> matches = new ArrayList<>();

        for (char ch : word.toCharArray()) {
            matrix[i][j] = ch;

            if ((j < (matrix[i].length - 1)) && (matrix[i][j + 1] == '-')) {
                Pair<Integer, Integer> newWord = new Pair<>(i, j);
                matches.add(newWord);
            }
            i++;
        }

        matches.forEach(p -> processHorizontal(matrix, p.getFirst(), p.getSecond(), words));
    }

}
