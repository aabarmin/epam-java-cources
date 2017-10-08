package com.epam.university.java.core.task029;

/**
 * Created by ilya on 03.10.17.
 */
public class Cell {

    private final int row;
    private final int column;

    private Cell link;

    private char letter;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int nextRow() {
        return row + 1;
    }

    public int nextColumn() {
        return column + 1;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getLetter() {
        return letter;
    }

    public Cell getLink() {
        return link;
    }

    public void setLink(Cell link) {
        this.link = link;
    }

    /**
     * Set letter in Cell.
     *
     * @param letter letter for setting
     * @return true - if can set, false if can't set
     */
    public boolean setLetter(char letter) {
        if (link == null) {
            this.letter = letter;
            return true;
        } else {
            if (link.letter == letter && link.letter != '\u0000') {
                this.letter = letter;
                return true;
            } else if (link.letter == '\u0000') {
                this.letter = letter;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;

        if (row != cell.row) {
            return false;
        }
        return column == cell.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }
}
