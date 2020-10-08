package com.epam.university.java.core.task016;

/**
 * Created by Romin Nuro on 08.10.2020 13:16.
 */
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
