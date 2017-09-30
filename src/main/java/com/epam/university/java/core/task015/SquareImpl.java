package com.epam.university.java.core.task015;

/**
 * Implementation class for Square.
 *
 * @author Sergei Titov
 */
public class SquareImpl implements Square {

    protected Point point1;
    protected Point point2;

    /**
     * Constructor from 2 points.
     *
     * @param point1 A-vertex
     * @param point2 C-vertex
     */
    public SquareImpl(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    /**
     * Get first point of square.
     *
     * @return point value
     */
    @Override
    public Point getFirst() {

        return point1;
    }

    /**
     * Get second point of square.
     *
     * @return point value
     */
    @Override
    public Point getSecond() {
        return point2;
    }

    /**
     * Set first point of square.
     *
     * @param first point value
     */
    @Override
    public void setFirst(Point first) {
    }

    /**
     * Set second point of square.
     *
     * @param second point value
     */
    @Override
    public void setSecond(Point second) {
    }
}
