package com.epam.university.java.core.task015;

public class PointFactoryImpl implements PointFactory {
    @Override
    public Point newInstance(double x, double y) {
        Point point = new PointImpl();
        point.setX(x);
        point.setY(y);
        return point;
    }
}
