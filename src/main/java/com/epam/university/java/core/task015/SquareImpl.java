package com.epam.university.java.core.task015;

/**
 * Implementation class for Square.
 *
 * @author Sergei Titov
 */
public class SquareImpl implements Square {

    protected Point<Integer> point1;
    protected Point<Integer> point2;

    /**
     * Constructor from 2 points.
     *
     * @param point1
     * @param point2
     */
    public SquareImpl (Point<Integer> point1, Point<Integer> point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    /**
     * Get first point of square.
     *
     * @return point value
     */
    @Override
    public Point<Integer> getFirst() {
        return point1;
    }

    /**
     * Get second point of square.
     *
     * @return point value
     */
    @Override
    public Point<Integer> getSecond() {
        return point2;
    }

    /**
     * Set first point of square.
     *
     * @param first point value
     */
    @Override
    public void setFirst(Point<Integer> first) {
    }

    /**
     * Set second point of square.
     *
     * @param second point value
     */
    @Override
    public void setSecond(Point<Integer> second) {
    }
}
