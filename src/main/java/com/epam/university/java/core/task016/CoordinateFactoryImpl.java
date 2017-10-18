package com.epam.university.java.core.task016;

/**
 * {@inheritDoc}
 */
public class CoordinateFactoryImpl implements CoordinateFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public Coordinate newInstance(int x, int y) {
        return new CoordinateImpl(x, y);
    }
}
