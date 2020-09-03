package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task029Impl implements Task029 {

    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        Character[][] field = fillTheField(rows);
        List<String> wordsList = new ArrayList<>(words);

        Location start = null;
        StringBuilder prefixBuilder = new StringBuilder();
        Direction direction = null;
        int expectedSize = 0;
        int col = -1;
        int row = -1;
        for (int i = 0; i < field.length && row < 0; i++) {
            for (int j = 0; j < field[i].length && col < 0; j++) {
                if (field[i][j] == '-') {
                    row = i;
                    col = j;
                }
            }
        }

        if (col + 1 < field[row].length && field[row][col + 1] == '-') {
            direction = Direction.RIGHT;
            int start1 = col;
            for (int j = col - 1; j >= 0 && field[row][j] != '+'; j--) {
                prefixBuilder.append(field[row][j]);
                expectedSize++;
                start1 = j;
            }
            prefixBuilder.reverse();
            for (int j = col; j < field[row].length && field[row][j] != '+'; j++) {
                expectedSize++;
            }
            start = new Location(row, start1);
        } else {
            direction = Direction.DOWN;
            int start1 = row;
            for (int i1 = row; i1 < field.length && field[i1][col] == '-'; i1++) {
                expectedSize++;
            }
            for (int i1 = row - 1; i1 >= 0 && field[i1][col] != '+'; i1--) {
                prefixBuilder.append(field[i1][col]);
                expectedSize++;
                start1 = i1;
            }
            prefixBuilder.reverse();
            start = new Location(start1, col);
        }

        String prefix = prefixBuilder.toString();
        List<String> matching = new ArrayList<>();
        for (String word : wordsList) {
            if (word.length() == expectedSize && (prefix.isEmpty() || word.startsWith(prefix))) {
                matching.add(word);
            }
        }
        if (matching.isEmpty()) {
            return new ArrayList<>();
        }

        for (String matched : matching) {
            wordsList.remove(matched);

            if (direction == Direction.RIGHT) {
                for (int i = 0; i < matched.length(); i++) {
                    field[start.getRow()][start.getCol() + i] = matched.charAt(i);
                }
            } else {
                for (int i = 0; i < matched.length(); i++) {
                    field[start.getRow() + i][start.getCol()] = matched.charAt(i);
                }
            }
            Character[][] clone = clone(field);
            Collection<String> result = new ArrayList<>();
            if (!wordsList.isEmpty()) {
                result = fillCrossword(getFinalListFromArray(clone), wordsList);
            }
            if (result.isEmpty()) {
                wordsList.add(matched);
            } else {
                return result;
            }
        }

        List<String> res = getFinalListFromArray(field);


        return res;
    }

    private List<String> getFinalListFromArray(Character[][] field) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < field.length; i++) {
            Character[] row = field[i];
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                builder.append(row[j]);
            }
            strings.add(builder.toString());
        }

        return strings;
    }

    private static Character[][] clone(Character[][] board) {
        Character[][] result = new Character[board.length][];
        System.arraycopy(board, 0, result, 0, board.length);
        return result;
    }

    private Character[][] fillTheField(Collection<String> rows) {
        List<String> rowsList = new ArrayList<>(rows);

        Character[][] field = new Character[rows.size()][rowsList.get(0).length()];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = rowsList.get(i).charAt(j);
            }
        }
        return field;
    }
}
