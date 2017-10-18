package com.epam.university.java.core.task015;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by Александр on 22.09.2017.
 * Point
 */
public class PointImpl implements Point {
    private double x;
    private double y;

    public PointImpl(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get x value of point.
     *
     * @return value
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Get y value of point.
     *
     * @return value
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * Set x value of point.
     *
     * @param x value
     */
    @Override
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Set y value of point.
     *
     * @param y value
     */
    @Override
    public void setY(double y) {
        this.y = y;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PointImpl point = (PointImpl) o;

        if (Double.compare(point.x, x) != 0) {
            return false;
        }
        return Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
