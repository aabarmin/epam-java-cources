package com.epam.university.java.core.task015;

/**
 * Square definition with two opposite points.
 */
public interface Square {
    /**
     * Get first point of square.
     * @return point value
     */
    Point<Integer> getFirst();

    /**
     * Get second point of square.
     * @return point value
     */
    Point<Integer> getSecond();

    /**
     * Set first point of square.
     * @param first point value
     */
    void setFirst(Point<Integer> first);

    /**
     * Set second point of square.
     * @param second point value
     */
    void setSecond(Point<Integer> second);
}
