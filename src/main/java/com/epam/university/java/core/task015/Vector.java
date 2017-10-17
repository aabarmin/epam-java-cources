package com.epam.university.java.core.task015;

/**
 * Created by Александр on 17.10.2017.
 * Vector in 2-dimensional area.
 */
public class Vector {
    private Point point;

    /**
     * Constructor from Point.
     * @param point vector from zero to point
     */
    public Vector(Point point) {
        this.point = point;
    }

    /**
     * Constructor from 2 points.
     * @param first vector from
     * @param second vecrot to
     */
    public Vector(Point first, Point second) {
        this.point = new PointImpl(second.getX() - first.getX(), second.getY() - first.getY());
    }

    public Point getPoint() {
        return point;
    }

    /**
     * Calculate scalar product of two vectors.
     * @param vector vector
     * @return value
     */
    public double scalarProduct(Vector vector) {
        return this.point.getX() * vector.getPoint().getX()
                + this.point.getY() * vector.getPoint().getY();

    }

}
