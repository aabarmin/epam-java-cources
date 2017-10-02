package com.epam.university.java.core.task015;

/**
 * Class factory for <code>PointImpl</code> class.
 */
public class PointFactoryImpl implements PointFactory {
    @Override
    public Point newInstance(double x, double y) {
        return new PointImpl(x, y);
    }
}