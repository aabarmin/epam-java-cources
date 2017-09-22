package com.epam.university.java.core.task015;

public class PointFactoryImpl implements PointFactory {
    @Override
    public Point newInstance(int x, int y) {
        return new PointImpl(x, y);
    }
}
