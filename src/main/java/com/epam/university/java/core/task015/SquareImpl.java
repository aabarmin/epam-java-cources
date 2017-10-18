package com.epam.university.java.core.task015;

/**
 * {@inheritDoc}
 */
public class SquareImpl implements Square {

    private Point first;
    private Point second;

    /**
     * Create new instance of Square with designed Points.
     *
     * @param first  first Point of Square
     * @param second second Point of Square
     */
    public SquareImpl(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point getFirst() {
        return first;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point getSecond() {
        return second;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFirst(Point first) {
        this.first = first;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSecond(Point second) {
        this.second = second;
    }
}
