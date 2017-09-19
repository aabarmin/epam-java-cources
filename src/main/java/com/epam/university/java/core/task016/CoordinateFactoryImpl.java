package com.epam.university.java.core.task016;

public class CoordinateFactoryImpl implements CoordinateFactory {
    /**
     * Create new coordinate instance with the following values.
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return coordinate instance
     */
    @Override
    public Coordinate newInstance(int x, int y) {
        return new CoordinateImpl(x, y);
    }
}
