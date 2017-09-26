package com.epam.university.java.core.task019;

public class RobotPositionImpl implements RobotPosition {

    private int x;
    private int y;


    /**
     * Get x value.
     *
     * @return value
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Get y value.
     *
     * @return value
     */
    @Override
    public int getY() {
        return y;
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
