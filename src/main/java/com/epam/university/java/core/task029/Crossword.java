package com.epam.university.java.core.task029;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class Crossword {

    private final Collection<String> crossword = new ArrayList<>();

    /**
     * Fill crossword recursively.
     * @param rows crossword grid
     * @param words words to fill the crossword
     */
    public void fill(Collection<String> rows, Collection<String> words) {
        final List<String> pullOfRows = new ArrayList<>(rows);
        final List<String> pullOfWords = new ArrayList<>(words);

        if (words.isEmpty()) {
            crossword.clear();
            crossword.addAll(rows);
            return;
        }

        for (String current : words) {
            Deque<Character> deque = new ArrayDeque<>();
            deque.addAll(current.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
            Cell d = nextCell(pullOfRows);
            if (d.getHorizontal() < pullOfRows.get(d.getVertical()).length() - 1
                    && pullOfRows.get(d.getVertical()).charAt(d.getHorizontal() + 1) != '+') {
                if (d.getHorizontal() > 0
                        && pullOfRows.get(d.getVertical()).charAt(d.getHorizontal() - 1) != '+') {
                    if (pullOfRows.get(d.getVertical())
                            .charAt(d.getHorizontal() - 1) != deque.pollFirst()) {
                        continue;
                    }
                }
                while (!deque.isEmpty()) {
                    if (d.getHorizontal() > pullOfRows.get(d.getVertical()).length() - 1
                            || pullOfRows.get(d.getVertical()).charAt(d.getHorizontal()) == '+') {
                        break;
                    }

                    if (addChar(pullOfRows, d, deque)) {
                        d.setHorizontal(d.getHorizontal() + 1);
                    } else {
                        break;
                    }

                }
            } else {
                if (d.getVertical() > 0
                        && pullOfRows.get(d.getVertical() - 1)
                        .charAt(d.getHorizontal()) != '+') {
                    if (pullOfRows.get(d.getVertical() - 1)
                            .charAt(d.getHorizontal()) != deque.pollFirst()) {
                        continue;
                    }
                }

                while (!deque.isEmpty()) {
                    if (d.getVertical() > pullOfRows.size() - 1
                            || pullOfRows.get(d.getVertical()).charAt(d.getHorizontal()) == '+') {
                        break;
                    }

                    if (addChar(pullOfRows, d, deque)) {
                        d.setVertical(d.getVertical() + 1);
                    } else {
                        break;
                    }

                }
            }

            if (deque.isEmpty()) {
                pullOfWords.remove(current);
                fill(pullOfRows, pullOfWords);
            }
        }
    }

    /**
     * Calculate next cell, in which we can put character.
     * @param strings rows of a crossword
     * @return cell
     */
    private Cell nextCell(List<String> strings) {
        Cell next = new Cell(-1, -1);
        for (int i = 0; i < strings.size(); i++) {
            int j = strings.get(i).indexOf('-');
            if (j > -1) {
                next.setHorizontal(j);
                next.setVertical(i);
                break;
            }
        }
        return next;
    }

    /**
     * Try to add one character to the crossword. Return true if successful.
     * @param rows rows of the crossword
     * @param cell position where character is planned to put
     * @param pullOfChars character to fill the cell
     * @return true if the cell if filled, false otherwise
     */
    private boolean addChar(List<String> rows, Cell cell, Deque<Character> pullOfChars) {

        if (rows.get(cell.getVertical()).charAt(cell.getHorizontal()) == '-') {
            StringBuilder newRow = new StringBuilder(rows.get(cell.getVertical()));
            newRow.setCharAt(cell.getHorizontal(), pullOfChars.pollFirst());
            rows.set(cell.getVertical(), newRow.toString());
            return true;
        } else if (rows.get(cell.getVertical())
                .charAt(cell.getHorizontal()) == pullOfChars.peekFirst()) {
            pullOfChars.pollFirst();
            return true;
        }

        return false;
    }

    /**
     * Get filled crossword, like collection of its rows.
     * @return crossword
     */
    public Collection<String> getCrossword() {
        return crossword;
    }

    /**
     * Inner class representing one cell of the crossword.
     */
    private class Cell {
        private int horizontal;
        private int vertical;

        private Cell(int horizontal, int vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }

        private int getHorizontal() {
            return horizontal;
        }

        private int getVertical() {
            return vertical;
        }

        private void setHorizontal(int horizontal) {
            this.horizontal = horizontal;
        }

        private void setVertical(int vertical) {
            this.vertical = vertical;
        }
    }
}
