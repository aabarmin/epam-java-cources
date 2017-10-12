package com.epam.university.java.core.task016;

import com.epam.university.java.core.utils.geometricprimitives.Point2D;

/**
 * Class implements <code>Coordinate</code>.
 */
public class CoordinateImpl implements Coordinate {
    private Point2D point2D;

    /**
     * Initialisation of the class object.
     *
     * @param coordinateX coordinate X
     * @param coordinateY coordinate Y
     * @throws IllegalArgumentException if at least one of the arguments
     *                                  is infinite or not a number
     */
    public CoordinateImpl(int coordinateX, int coordinateY) {
        point2D = new Point2D(coordinateX, coordinateY);
    }

    @Override
    public int getX() {
        return (int) point2D.getCoordinateX();
    }

    @Override
    public void setX(int x) {
        point2D.setCoordinateX(x);
    }

    @Override
    public int getY() {
        return (int) point2D.getCoordinateY();
    }

    @Override
    public void setY(int y) {
        point2D.setCoordinateY(y);
    }

    @Override
    public String toString() {
        return "CoordinateImpl{x=" + point2D.getCoordinateX() + "y="
                + point2D.getCoordinateY() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CoordinateImpl that = (CoordinateImpl) o;
        return point2D.equals(that.point2D);
    }

    @Override
    public int hashCode() {
        return point2D.hashCode();
    }
}
