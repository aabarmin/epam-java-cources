package com.epam.university.java.core.task019;

/**
 * Implementation class for RobotPosition.
 *
 * @author Sergei Titov
 */
public class RobotPositionImpl implements RobotPosition {

    private int abscissa = 0;
    private int ordinate = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    public int getX() {
        return abscissa;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getY() {
        return ordinate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(int x) {
        this.abscissa = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(int y) {
        this.ordinate = y;
    }
}
