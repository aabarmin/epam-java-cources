package com.epam.university.java.core.task015;

/**
 * Vector in 2-dimensional area.
 */
public class Vector {

    private final Point coordinates;
    private final Point first;
    private final Point second;

    /**
     * Constructor.
     */
    public Vector(Point first, Point second) {
        this.first = first;
        this.second = second;
        coordinates = new PointImpl(second.getX() - first.getX(),
                second.getY() - first.getY());
    }

    /** Get start point of vector.
     * @return point
     */
    public Point getFirst() {
        return first;
    }

    /** Get end point of vector.
     * @return point
     */
    public Point getSecond() {
        return second;
    }

    /** Get coordinates of vector.
     * @return point
     */
    public Point getCoordinates() {
        return coordinates;
    }

    /**
     * Calculate scalar product of two vectors.
     * @param vector vector
     * @return value
     */
    public double scalarProduct(Vector vector) {
        return this.coordinates.getX() * vector.getCoordinates().getX()
                + this.coordinates.getY() * vector.getCoordinates().getY();

    }

}
