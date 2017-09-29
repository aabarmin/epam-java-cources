package com.epam.university.java.core.task016;

/**
 * Factory for coordinate instance creation.
 */
public interface CoordinateFactory {
    /**
     * Create new coordinate instance with the following values.
     * @param x x coordinate
     * @param y y coordinate
     * @return coordinate instance
     */
    Coordinate newInstance(int x, int y);
}
