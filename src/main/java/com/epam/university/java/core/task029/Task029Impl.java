package com.epam.university.java.core.task029;

import com.epam.university.java.core.utils.common.Validator;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Class implements <code>Task029</code> interface.
 */
public class Task029Impl implements Task029 {
    private List<String> solvedCross;

    /**
     * Get result of crossWord solving.
     *
     * @param crossWordMatrix crossWord matrix
     */
    private void returnResult(char[][] crossWordMatrix) {
        solvedCross = new LinkedList<>();
        for (int row = 0; row < 10; row++) {
            solvedCross.add(new String(crossWordMatrix[row]));
            System.out.println(new String(crossWordMatrix[row]));
        }
    }

    /**
     * Solve the crossWord by recursive call.
     *
     * @param crossWordMatrix          crossword
     * @param words                    words from the input
     * @param horizontalStartPositions possible horizontalStartPositions
     * @param verticalStartPositions   possible verticalStartPositions
     * @param checkedWords             checked words in set
     * @return <code>true</code> if position
     * is found for another word or crossword
     * is solved
     * @throws IllegalArgumentException if at least one of parameters is null
     */
    private boolean solveCross(char[][] crossWordMatrix, List<String> words,
                               List<Integer[]> horizontalStartPositions,
                               List<Integer[]> verticalStartPositions,
                               Set<String> checkedWords) {
        Validator.validateNotNull(crossWordMatrix, words,
                horizontalStartPositions,
                verticalStartPositions, checkedWords, Validator
                        .MESSAGE_FOR_FIRST_PARAMETER_IF_NULL, Validator
                        .MESSAGE_FOR_SECOND_PARAMETER_IF_NULL, Validator
                        .MESSAGE_FOR_THIRD_PARAMETER_IF_NULL, Validator
                        .MESSAGE_FOR_FOURTH_PARAMETER_IF_NULL, Validator
                        .MESSAGE_FOR_FIFTH_PARAMETER_IF_NULL);
        if (checkedWords.size() == words.size()) {
            returnResult(crossWordMatrix);
            return true;
        }
        for (String word : words) {
            if (!checkedWords.contains(word)) {
                boolean currentHorizontalCheck = checkPosition(crossWordMatrix,
                        checkedWords, words, horizontalStartPositions,
                        verticalStartPositions, word, true);
                return currentHorizontalCheck || checkPosition(crossWordMatrix,
                        checkedWords, words, horizontalStartPositions,
                        verticalStartPositions, word, false);
            }
        }
        return false;
    }

    /**
     * Check current word's horizontal or vertical position.
     *
     * @param crossWordMatrix          crossword
     * @param checkedWords             checked words in set
     * @param words                    words from the input
     * @param horizontalStartPositions possible horizontalStartPositions
     * @param verticalStartPositions   possible verticalStartPositions
     * @return <code>true</code> if position is found for current word or
     * crossword is solved
     * @throws IllegalArgumentException if word to check is null
     */
    private boolean checkPosition(char[][] crossWordMatrix,
                                  Set<String> checkedWords, List<String> words,
                                  List<Integer[]> horizontalStartPositions,
                                  List<Integer[]> verticalStartPositions,
                                  String wordToCheck, boolean isHorizontal) {
        Validator.validateNotNull(wordToCheck, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);
        List<Integer[]> currentStartPositions;
        if (isHorizontal) {
            currentStartPositions = horizontalStartPositions;
        } else {
            currentStartPositions = verticalStartPositions;
        }
        for (Integer[] pos : currentStartPositions) {
            int currentRow = pos[0];
            int currentCol = pos[1];
            boolean isFit = true;

            //save row/column
            char[] save = new char[10];
            if (isHorizontal) {
                save = Arrays.copyOf(crossWordMatrix[currentRow], 10);
            } else {
                for (int row = 0; row < 10; row++) {
                    save[row] = crossWordMatrix[row][currentCol];
                }
            }
            if (isHorizontal) {
                for (int i = currentCol; i < currentCol + wordToCheck.length();
                     i++) {
                    if (i >= 10 || crossWordMatrix[currentRow][i] == '+' || (
                            crossWordMatrix[currentRow][i] != '-') && (
                            crossWordMatrix[currentRow][i] != wordToCheck
                                    .charAt(
                                            i - currentCol))) {
                        isFit = false;
                        break;
                    }
                    crossWordMatrix[currentRow][i] = wordToCheck.charAt(
                            i - currentCol);
                }
            } else {
                for (int i = currentRow; i < currentRow + wordToCheck.length();
                     i++) {
                    if (i >= 10 || crossWordMatrix[i][currentCol] == '+' || (
                            crossWordMatrix[i][currentCol]
                                    != '-' && crossWordMatrix[i][currentCol]
                                    != wordToCheck.charAt(i - currentRow))) {
                        isFit = false;
                        break;
                    }
                    crossWordMatrix[i][currentCol] = wordToCheck.charAt(
                            i - currentRow);
                }
            }
            //recursion
            if (isFit) {
                checkedWords.add(wordToCheck);
                boolean isFound = solveCross(crossWordMatrix, words,
                        horizontalStartPositions, verticalStartPositions,
                        checkedWords);
                if (isFound) {
                    return true;
                }
                checkedWords.remove(wordToCheck);
            }
            if (isHorizontal) {
                crossWordMatrix[currentRow] = Arrays.copyOf(save, 10);
            } else {
                for (int row = 0; row < 10; row++) {
                    crossWordMatrix[row][currentCol] = save[row];
                }
            }
        }
        return false;
    }

    /**
     * Install crossword to two-dimensional matrix.
     *
     * @param rows input data
     * @return two-dimensional matrix with the input data
     * @throws IllegalArgumentException if input collection is null or empty
     */
    private char[][] crossWordToMatrix(Collection<String> rows) {
        Validator.validateNotNull(rows, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateEmpty(rows, Validator.MESSAGE_IF_COLLECTION_EMPTY);
        List<String> list = new LinkedList<>(rows);
        char[][] crossWordMatrix = new char[list.size()][list.get(0).length()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).length(); j++) {
                crossWordMatrix[i][j] = list.get(i).charAt(j);
            }
        }
        return crossWordMatrix;
    }

    /**
     * Add new possible start position for both horizontal and vertical cases.
     */
    private void addStartPosition(
            List<Integer[]> possibleStartPositions, char[][] crossWordMatrix,
            int
                    coordinateFirst, int coordinateSecond, boolean
                    isHorizontal) {


        if (isHorizontal) {
            while (coordinateFirst > 0
                    && crossWordMatrix[coordinateSecond][coordinateFirst - 1]
                    == '-') {
                coordinateFirst--;
            }
            possibleStartPositions.add(new Integer[]{
                    coordinateSecond,
                    coordinateFirst
            });
        } else {
            while (coordinateFirst > 0
                    && crossWordMatrix[coordinateFirst - 1][coordinateSecond]
                    == '-') {
                coordinateFirst--;
            }
            possibleStartPositions.add(new Integer[]{
                    coordinateFirst,
                    coordinateSecond
            });
        }
    }

    @Override
    public Collection<String> fillCrossword(Collection<String> rows,
                                            Collection<String> words) {
        Validator.validateNotNull(rows, words, Validator
                .MESSAGE_FOR_FIRST_PARAMETER_IF_NULL, Validator
                .MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        char[][] strings = crossWordToMatrix(rows);
        List<Integer[]> horizontalStartPositions = new ArrayList<>();
        List<Integer[]> verticalStartPositions = new ArrayList<>();
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (strings[r][c] == '-') {
                    addStartPosition(horizontalStartPositions, strings, c, r,
                            true);
                    addStartPosition(verticalStartPositions, strings, c, r,
                            false);
                }
            }
        }
        solveCross(strings, new ArrayList<>(words), horizontalStartPositions,
                verticalStartPositions, new HashSet<>());
        return solvedCross;
    }
}