package com.epam.university.java.core.task029;

/**
 * Coordinate of the word's first letter in the crossword.
 */
public class Coord {

    private final int row;
    private final int col;
    private final Direction direction;

    /**
     * Constructs the coordinate object.
     * @param row coordinate that is parallel to the direction
     * @param col coordinate that is perpendicular to the direction
     * @param direction direction of the word (horizontal or vertical)
     */
    public Coord(int row, int col, Direction direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
    }

    /**
     * Get row value of point.
     * @return value
     */
    public int getRow() {
        return row;
    }

    /**
     * Get col value of point.
     * @return value
     */
    public int getCol() {
        return col;
    }

    /**
     * Get direction value of point.
     * @return value
     */
    public Direction getDirection() {
        return direction;
    }

}
