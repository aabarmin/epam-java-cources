package com.epam.university.java.core.task029;

import java.util.List;

/**
 * Created by ilya on 03.10.17.
 */
public class Placement {

    private final List<Cell> cells;

    public Placement(List<Cell> cells) {
        this.cells = cells;
    }

    private boolean canPlace(int length) {
        return this.cells.size() == length;
    }

    public List<Cell> getCells() {
        return cells;
    }

    /**
     * Place word to placement.
     *
     * @param word word for place
     * @return true - if can place this word, false - if can't
     */
    public boolean place(String word) {
        if (canPlace(word.length())) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (!cells.get(i).setLetter(chars[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean contains(int row, int column) {
        return cells.stream()
            .anyMatch(c -> c.getColumn() == column && c.getRow() == row);
    }
}
