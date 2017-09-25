package com.epam.university.java.core.task015;

/**
 * Created by Александр on 22.09.2017.
 */
public class PointFactoryImpl implements PointFactory{
    /**
     * Creates new point instance.
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return point instance
     */
    @Override
    public Point newInstance(double x, double y) {
        return new PointImpl(x, y);
    }
}
