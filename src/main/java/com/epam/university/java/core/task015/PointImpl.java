package com.epam.university.java.core.task015;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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

    /**
     * Compute distance between given points.
     * @param first first point
     * @param second second point
     * @return distance between two points
     */
    public static double distance(Point first, Point second) {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2)
                        + Math.pow(second.getY() - first.getY(), 2)
        );
    }

    @Override
    public String toString() {
        return String.format("[%f, %f]",abscissa, ordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PointImpl other = (PointImpl) o;
        boolean result;
        result = Integer.compare((int) abscissa, (int)other.abscissa) == 0
                && Integer.compare((int) ordinate, (int) other.ordinate) == 0;
        return result;
    }

    @Override
    public int hashCode() {
        int result = 39 * Integer.hashCode((int)abscissa);
        result += Integer.hashCode((int)ordinate);
        return result;
    }
}
