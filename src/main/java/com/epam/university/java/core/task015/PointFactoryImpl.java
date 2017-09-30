package com.epam.university.java.core.task015;

/**
 * Implementation class for PointFactory.
 *
 * @author Sergei Titov
 */
public class PointFactoryImpl implements PointFactory {
    /**
     * Creates new point instance.
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return point instance
     */
    @Override
    public Point newInstance(Number x, Number y) {
        return new PointImpl(x, y);
    }
}
