package com.epam.university.java.core.task015;

/**
 * Created by ilya on 16.09.17.
 */
public class PointFactoryImpl implements PointFactory {

    @Override
    public Point newInstance(double x, double y) {
        return new PointImpl(x, y);
    }
}
