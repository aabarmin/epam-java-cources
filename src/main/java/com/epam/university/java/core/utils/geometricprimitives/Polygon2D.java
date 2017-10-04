package com.epam.university.java.core.utils.geometricprimitives;

import com.epam.university.java.core.utils.common.Validator;

import java.util.ArrayList;

/**
 * Class implements polygon.
 */
public class Polygon2D {
    private int dynamicVerticesNumber;
    private Point2D[] dynamicVerticesPolygon;

    /**
     * Initialisation of polygon, default buffer = 4.
     */
    public Polygon2D() {
        dynamicVerticesNumber = 0;
        dynamicVerticesPolygon = new Point2D[4];
    }

    /**
     * Get existing points of array in another one.
     *
     * @return <code>Point2D</code> array of existing points
     */
    public Point2D[] getPoints2D() {
        ArrayList<Point2D> points = new ArrayList<>();
        for (int i = 0; i < dynamicVerticesPolygon.length; i++) {
            if (dynamicVerticesPolygon[i] != null) {
                points.add(dynamicVerticesPolygon[i]);
            }
        }
        return points.toArray(new Point2D[0]);
    }

    /**
     * Double size of points array.
     */
    private void resize() {
        Point2D[] temp = new Point2D[2 * dynamicVerticesNumber + 1];
        for (int i = 0; i <= dynamicVerticesNumber; i++) {
            temp[i] = dynamicVerticesPolygon[i];
        }
        dynamicVerticesPolygon = temp;
    }

    /**
     * Get size of polygon.
     */
    public int size() {
        return dynamicVerticesNumber;
    }

    /**
     * Add point p to end of polygon.
     *
     * @param point point to add
     * @throws IllegalArgumentException if point is null
     */
    public void add(Point2D point) {
        Validator.validateNotNull(point, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        if (dynamicVerticesNumber >= dynamicVerticesPolygon.length - 1) {
            resize();   // resize array if needed
        }
        dynamicVerticesPolygon[dynamicVerticesNumber++] = point;
        // add point
        dynamicVerticesPolygon[dynamicVerticesNumber] =
                dynamicVerticesPolygon[0];
        // close polygon
    }

    /**
     * Add points from array to polygon.
     *
     * @param points array to add
     * @throws IllegalArgumentException if array is null
     */
    public void addAll(Point2D[] points) {
        Validator.validateNotNull(points, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        for (int i = 0; i < points.length; i++) {
            add(points[i]);
        }
    }

    /**
     * Return signed area of polygon.
     *
     * @return <code>double</code> signed area of polygon
     */
    public double area() {
        double sum = 0.0;
        for (int i = 0; i < dynamicVerticesNumber; i++) {
            sum = sum + (dynamicVerticesPolygon[i].getCoordinateX()
                    * dynamicVerticesPolygon[i + 1].getCoordinateY())
                    - (dynamicVerticesPolygon[i].getCoordinateY()
                    * dynamicVerticesPolygon[i + 1].getCoordinateX());
        }
        return 0.5 * sum;
    }

    /**
     * Check if this polygon contains the point <code>p</code>.
     *
     * @param point if point is on boundary then <code>crossings</code>
     *              is 0 or 1, and point is exactly one
     * @return <code>boolean</code> true if polygon contains point
     * @throws IllegalArgumentException if point is null
     */
    public boolean contains(Point2D point) {
        Validator.validateNotNull(point, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        int crossings = 0;
        for (int i = 0; i < dynamicVerticesNumber; i++) {
            int j = i + 1;
            boolean cond1 = (dynamicVerticesPolygon[i].getCoordinateY()
                    <= point.getCoordinateY()) && (point.getCoordinateY()
                    < dynamicVerticesPolygon[j].getCoordinateY());
            boolean cond2 = (dynamicVerticesPolygon[j].getCoordinateY()
                    <= point.getCoordinateY()) && (point.getCoordinateY()
                    < dynamicVerticesPolygon[i].getCoordinateY());
            if (cond1 || cond2) { // need to cast to double
                if (point.getCoordinateX() < (dynamicVerticesPolygon[j]
                        .getCoordinateX() - dynamicVerticesPolygon[i]
                        .getCoordinateX()) * (point.getCoordinateY()
                        - dynamicVerticesPolygon[i].getCoordinateY())
                        / (dynamicVerticesPolygon[j].getCoordinateY()
                        - dynamicVerticesPolygon[i].getCoordinateY())
                        + dynamicVerticesPolygon[i].getCoordinateX()) {
                    crossings++;
                }
            }
        }
        if (crossings % 2 == 1) {
            System.out.println(crossings);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (dynamicVerticesNumber == 0) {
            return "[ ]";
        }
        String s = "";
        s = s + "[ ";
        for (int i = 0; i <= dynamicVerticesNumber; i++) {
            s = s + dynamicVerticesPolygon[i] + " " + System.lineSeparator();
        }
        s = s + "]";
        return s;
    }
}