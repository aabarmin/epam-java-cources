package com.epam.university.java.core.task015;

/**
 * {@inheritDoc}
 */
public class PointFactoryImpl implements PointFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public Point newInstance(double x, double y) {
        return new PointImpl(x, y);
    }
}
