package com.epam.university.java.core.task016;

/**
 * Factory for coordinate instance creation.
 */
public class CoordinateFactoryImpl implements CoordinateFactory {

    /**
     * Creates new coordinate instance with the following values.
     * @param x x coordinate
     * @param y y coordinate
     * @return coordinate instance
     */
    @Override
    public Coordinate newInstance(int x, int y) {
        return new CoordinateImpl(x, y);
    }

}
