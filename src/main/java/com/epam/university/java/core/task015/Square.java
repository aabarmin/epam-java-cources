package com.epam.university.java.core.task015;

/**
 * Square definition with two opposite points.
 */
public interface Square {
    /**
     * Get first point of square.
     * @return point value
     */
    Point getFirst();

    /**
     * Get second point of square.
     * @return point value
     */
    Point getSecond();

    /**
     * Set first point of square.
     * @param first point value
     */
    void setFirst(Point first);

    /**
     * Set second point of square.
     * @param second point value
     */
    void setSecond(Point second);
}
