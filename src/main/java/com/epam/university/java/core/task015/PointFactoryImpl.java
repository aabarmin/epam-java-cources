package com.epam.university.java.core.task015;

public class PointFactoryImpl implements PointFactory {
    @Override
    public Point newInstance(double x, double y) {
        return new PointImpl(x, y);
    }
}
