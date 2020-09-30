package com.epam.university.java.core.task015;

/**
 * Author Dmitry Novikov 28-Sep-20.
 */
public class PointFactoryImpl implements PointFactory{
    @Override
    public Point newInstance(double x, double y) {
        return new PointImpl(x,y);
    }
}
