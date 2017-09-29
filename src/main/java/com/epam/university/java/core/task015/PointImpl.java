package com.epam.university.java.core.task015;

import java.util.Comparator;
import java.util.List;

public class PointImpl implements Point {

    private final double abscissa;
    private final double ordinate;

    public PointImpl(double x, double y) {
        abscissa = x;
        ordinate = y;
    }

    @Override
    public double getX() {
        return abscissa;
    }

    @Override
    public double getY() {
        return ordinate;
    }

    @Override
    public void setX(double x) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setY(double y) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Puts points in appropriate order - clockwise about (0,0) coordinate.
     * @param points collection of points
     */
    public static void orderPoints(List<Point> points) {
        double averageX = points.stream().mapToDouble(Point::getX).sum() / points.size();
        double averageY = points.stream().mapToDouble(Point::getY).sum() / points.size();
        points.sort(Comparator.comparingDouble(
            p -> Math.atan2(p.getY() - averageY, p.getX() - averageX)
        ));
    }
}
