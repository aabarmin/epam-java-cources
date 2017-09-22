package com.epam.university.java.core.task019;

/**
 * Created by ilya on 21.09.17.
 */
public class ModificationMatrix {

    private int[][] matrix = new int[][]{
        {1, 0},
        {0, 1}
    };

    /**
     * Apply right modification matrix.
     *
     * @return itself
     */
    public ModificationMatrix right() {
        this.matrix = new int[][]{
            {0, 1},
            {-1, 0}
        };
        return this;
    }

    /**
     * Apply left modification matrix.
     *
     * @return itself
     */
    public ModificationMatrix left() {
        this.matrix = new int[][]{
            {0, -1},
            {1, 0}
        };
        return this;
    }

    /**
     * Modify direction with modification matrix.
     *
     * @param direction direction to modify
     * @return new direction
     */
    public Direction modify(Direction direction) {
        int dirX = direction.getDirX() * matrix[0][0] + direction.getDirY() * matrix[0][1];
        int dirY = direction.getDirX() * matrix[1][0] + direction.getDirY() * matrix[1][1];

        return new Direction(dirX, dirY);
    }
}
