package com.epam.university.java.core.task019;

/**
 * {@inheritDoc}
 */
public class RobotPositionImpl implements RobotPosition {
    private int x;
    private int y;

    /**
     * Create position of Robot with designed coords.
     *
     * @param x X coord
     * @param y y coord
     */
    public RobotPositionImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }
}
