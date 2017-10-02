package com.epam.university.java.core.task015;

import com.epam.university.java.core.utils.geometricprimitives.Point2D;

/**
 * Class implements <code>Point</code>class.
 */
public class PointImpl implements Point {

    private Point2D point2D;

    /**
     * Initialisation of two-dimensional point.
     *
     * @param coordinateX coordinate x
     * @param coordinateY coordinate y
     * @throws IllegalAccessException if at least one of parameters violates
     *                                permitted range
     */
    public PointImpl(double coordinateX, double coordinateY) {
        point2D = new Point2D(coordinateX, coordinateY);
    }

    /**
     * Get the point.
     *
     * @return <code>Point2D</code>
     */
    public Point2D getPoint2D() {
        return point2D;
    }

    @Override

    public double getX() {
        return (int) point2D.getCoordinateX();
    }

    @Override
    public double getY() {
        return (int) point2D.getCoordinateY();
    }

    @Override
    public void setX(double x) {
        point2D.setCoordinateX(x);
    }

    @Override
    public void setY(double y) {
        point2D.setCoordinateY(y);
    }

    @Override
    public String toString() {
        return "PointImpl{" +
                "point2D=" + point2D +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointImpl)) return false;

        PointImpl point = (PointImpl) o;

        return point2D.equals(point.point2D);
    }

    @Override
    public int hashCode() {
        return point2D.hashCode();
    }
}