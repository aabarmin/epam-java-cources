package com.epam.university.java.core.utils.geometricprimitives;

import java.util.Comparator;

/**
 * The class is an immutable data type to encapsulate a
 * two-dimensional point with real-value coordinates.
 */
public final class Point2D implements Comparable<Point2D> {

    /**
     * Initializes a new point (x, y).
     *
     * @param CoordinateX the x-coordinate
     * @param CoordinateY the y-coordinate
     * @throws IllegalArgumentException if either {@code x} or {@code y}
     *                                  is {@code Double.NaN},
     *                                  {@code Double.POSITIVE_INFINITY} or
     *                                  {@code Double.NEGATIVE_INFINITY}
     */
    public Point2D(double CoordinateX, double CoordinateY) {
        if (Double.isInfinite(CoordinateX) || Double.isInfinite(CoordinateY)) {
            throw new IllegalArgumentException("Coordinates must be finite");
        }
        if (Double.isNaN(CoordinateX) || Double.isNaN(CoordinateY)) {
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        }
        if (CoordinateX == 0.0) {
            this.CoordinateX = 0.0;
        }  // convert -0.0 to +0.0
        else {
            this.CoordinateX = CoordinateX;
        }

        if (CoordinateY == 0.0) {
            this.CoordinateY = 0.0;
        } // convert -0.0 to +0.0
        else {
            this.CoordinateY = CoordinateY;
        }
    }

    private double CoordinateX;    // x coordinate
    private double CoordinateY;    // y coordinate

    /**
     * Returns the x-coordinate.
     *
     * @return the x-coordinate
     */
    public double getCoordinateX() {
        return CoordinateX;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return the y-coordinate
     */
    public double getCoordinateY() {
        return CoordinateY;
    }

    /**
     * Sets the x-coordinate.
     *
     * @return the x-coordinate
     */
    public void setCoordinateX(double coordinateX) {
        this.CoordinateX = coordinateX;
    }

    /**
     * Sets the y-coordinate.
     *
     * @return the y-coordinate
     */
    public void setCoordinateY(double coordinateY) {
        this.CoordinateY = coordinateY;
    }


    /**
     * Returns true if a→b→c is a counterclockwise turn.
     *
     * @param a first point
     * @param b second point
     * @param c third point
     * @return { -1, 0, +1 } if a→b→c is a { clockwise, collinear;
     * counterclocwise } turn.
     */
    public static int ccw(Point2D a, Point2D b, Point2D c) {
        double area2 = (b.CoordinateX - a.CoordinateX) * (c.CoordinateY
                - a.CoordinateY) - (b.CoordinateY - a.CoordinateY)
                * (c.CoordinateX - a.CoordinateX);
        if (area2 < 0) {
            return -1;
        } else if (area2 > 0) {
            return +1;
        } else {
            return 0;
        }
    }


    @Override
    public String toString() {
        return "Point2D{" +
                "CoordinateX=" + CoordinateX +
                ", CoordinateY=" + CoordinateY +
                '}';
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(CoordinateX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(CoordinateY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Compares this point to the specified point.
     *
     * @param other the other point
     * @return {@code true} if this point equals {@code other};
     * {@code false} otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        Point2D that = (Point2D) other;
        return (this.CoordinateX == that.CoordinateX) && (this.CoordinateY ==
                that.CoordinateY);
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument
     * point (x1, y1)
     * if and only if either {@code y0 < y1} or if {@code y0 == y1} and
     * {@code x0 < x1}.
     *
     * @param that the other point
     * @return the value {@code 0} if this string is equal to the argument
     * string (precisely when {@code equals()} returns {@code true});
     * a negative integer if this point is less than the argument
     * point; and a positive integer if this point is greater than the
     * argument point
     */
    public int compareTo(Point2D that) {
        if (this.CoordinateY < that.CoordinateY) {
            return -1;
        }
        if (this.CoordinateY > that.CoordinateY) {
            return +1;
        }
        if (this.CoordinateX < that.CoordinateX) {
            return -1;
        }
        if (this.CoordinateX > that.CoordinateX) {
            return +1;
        }
        return 0;
    }

    /**
     * Compares two points by polar angle (between 0 and 2&pi;)
     * with respect to this point.
     *
     * @return the comparator
     */
    public Comparator<Point2D> polarOrder() {
        return new PolarOrder();
    }

    /**
     * Compare points relative to polar angle (between 0 and 2pi)
     * they make with this Point.
     *
     * @return the comparator
     */
    private class PolarOrder implements Comparator<Point2D> {
        public int compare(Point2D q1, Point2D q2) {
            double dx1 = q1.CoordinateX - CoordinateX;
            double dy1 = q1.CoordinateY - CoordinateY;
            double dx2 = q2.CoordinateX - CoordinateX;
            double dy2 = q2.CoordinateY - CoordinateY;
            if (dy1 >= 0 && dy2 < 0) {
                return -1;
            }    // q1 above; q2 below
            else if (dy2 >= 0 && dy1 < 0) {
                return +1;
            }   // q1 below; q2 above
            else if (dy1 == 0 && dy2 == 0) { // 3-collinear and horizontal
                if (dx1 >= 0 && dx2 < 0) {
                    return -1;
                } else if (dx2 >= 0 && dx1 < 0) {
                    return +1;
                } else {
                    return 0;
                }
            } else
                return -ccw(Point2D.this, q1, q2);     // both above or below
            // Note: ccw() recomputes dx1, dy1, dx2, and dy2
        }
    }
}