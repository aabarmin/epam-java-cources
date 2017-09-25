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
     * @param xCoordinate the x-coordinate
     * @param yCoordinate the y-coordinate
     * @throws IllegalArgumentException if either {@code x} or {@code y}
     *                                  is {@code Double.NaN},
     *                                  {@code Double.POSITIVE_INFINITY} or
     *                                  {@code Double.NEGATIVE_INFINITY}
     */
    public Point2D(double xCoordinate, double yCoordinate) {
        if (Double.isInfinite(xCoordinate) || Double.isInfinite(yCoordinate)) {
            throw new IllegalArgumentException("Coordinates must be finite");
        }
        if (Double.isNaN(xCoordinate) || Double.isNaN(yCoordinate)) {
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        }
        if (xCoordinate == 0.0) {
            this.xCoordinate = 0.0;
        }  // convert -0.0 to +0.0
        else {
            this.xCoordinate = xCoordinate;
        }

        if (yCoordinate == 0.0) {
            this.yCoordinate = 0.0;
        } // convert -0.0 to +0.0
        else {
            this.yCoordinate = yCoordinate;
        }
    }

    private double xCoordinate;    // x coordinate
    private double yCoordinate;    // y coordinate

    /**
     * Returns the x-coordinate.
     *
     * @return the x-coordinate
     */
    public double x() {
        return xCoordinate;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return the y-coordinate
     */
    public double y() {
        return yCoordinate;
    }

    /**
     * Sets the x-coordinate.
     *
     * @return the x-coordinate
     */
    public void setCoordinateX(double coordinateX) {
        this.xCoordinate = coordinateX;
    }

    /**
     * Sets the y-coordinate.
     *
     * @return the y-coordinate
     */
    public void setCoordinateY(double coordinateY) {
        this.yCoordinate = coordinateY;
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
        double area2 = (b.xCoordinate - a.xCoordinate) * (c.yCoordinate
                - a.yCoordinate) - (b.yCoordinate - a.yCoordinate)
                * (c.xCoordinate - a.xCoordinate);
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
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(xCoordinate);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(yCoordinate);
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
        return (this.xCoordinate == that.xCoordinate) && (this.yCoordinate ==
                that.yCoordinate);
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
        if (this.yCoordinate < that.yCoordinate) {
            return -1;
        }
        if (this.yCoordinate > that.yCoordinate) {
            return +1;
        }
        if (this.xCoordinate < that.xCoordinate) {
            return -1;
        }
        if (this.xCoordinate > that.xCoordinate) {
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
            double dx1 = q1.xCoordinate - xCoordinate;
            double dy1 = q1.yCoordinate - yCoordinate;
            double dx2 = q2.xCoordinate - xCoordinate;
            double dy2 = q2.yCoordinate - yCoordinate;
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