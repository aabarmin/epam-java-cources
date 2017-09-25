package com.epam.university.java.core.task016;

/**
 * Created by Александр on 25.09.2017.
 */
public class CoordinateImpl implements Coordinate {
    int x;
    int y;

    CoordinateImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get x coordinate value.
     *
     * @return coordinate value
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Set x coordinate value.
     *
     * @param x coordinate value
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get y coordinate value.
     *
     * @return coordinate value
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Set y coordinate value.
     *
     * @param y coordinate value
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }
}
