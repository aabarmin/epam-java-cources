package com.epam.university.java.core.task016;

/**
 * Implementation class for CoordinateFactory.
 *
 * @author Sergei Titov
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
