package com.epam.university.java.core.task019;

/**
 * Created by Romin Nuro on 08.09.2020 12:57.
 */
public class RobotPositionImpl implements RobotPosition {

    private int x;
    private int y;

    public RobotPositionImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get x value.
     *
     * @return value
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Get y value.
     *
     * @return value
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Set x value.
     *
     * @param x value
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set y value.
     *
     * @param y value
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }
}
