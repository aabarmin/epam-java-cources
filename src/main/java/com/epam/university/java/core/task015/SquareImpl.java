package com.epam.university.java.core.task015;

/**
 * Created by Romin Nuro on 31.08.2020 23:00.
 */
public class SquareImpl implements Square {
    private Point first;
    private Point second;


    public SquareImpl(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Get first point of square.
     *
     * @return point value
     */
    @Override
    public Point getFirst() {
        return first;
    }

    /**
     * Get second point of square.
     *
     * @return point value
     */
    @Override
    public Point getSecond() {
        return second;
    }

    /**
     * Set first point of square.
     *
     * @param first point value
     */
    @Override
    public void setFirst(Point first) {
        this.first = first;
    }

    /**
     * Set second point of square.
     *
     * @param second point value
     */
    @Override
    public void setSecond(Point second) {
        this.second = second;
    }
}
