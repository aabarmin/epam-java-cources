package com.epam.university.java.core.task015;

/**
 * Square definition with two opposite points.
 */
public class SquareImpl implements Square {

    private final Point first;
    private final Point second;

    /**
     * Constructs a square by 2 points.
     * @param first first point
     * @param second second point
     */
    public SquareImpl(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Get first point of square.
     * @return point value
     */
    @Override
    public Point getFirst() {
        return first;
    }

    /**
     * Get second point of square.
     * @return point value
     */
    @Override
    public Point getSecond() {
        return second;
    }

    /**
     * Set first point of square.
     * @param first point value
     * @throws UnsupportedOperationException as modification is forbidden
     */
    @Override
    public void setFirst(Point first) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Set second point of square.
     * @param second point value
     * @throws UnsupportedOperationException as modification is forbidden
     */
    @Override
    public void setSecond(Point second) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

}
