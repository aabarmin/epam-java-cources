package com.epam.university.java.core.task015;

/**
 * {@inheritDoc}
 */
public class SquareFactoryImpl implements SquareFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public Square newInstance(Point first, Point second) {
        return new SquareImpl(first, second);
    }
}
