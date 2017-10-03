package com.epam.university.java.core.task015;

import com.epam.university.java.core.utils.common.Validator;
import com.epam.university.java.core.utils.geometricprimitives.GrahamScan;
import com.epam.university.java.core.utils.geometricprimitives.Point2D;

import java.util.Stack;

/**
 * Implementation of square.
 */
public class SquareImpl implements Square {
    private Point pointFirst;
    private Point pointSecond;
    private Stack<Point2D> points;

    /**
     * Initialisation of <code>SquareImpl</code>.
     *
     * @param pointFirst  one of square vertices
     * @param pointSecond one of square vertices
     * @throws IllegalArgumentException if at least one of arguments is null
     */
    public SquareImpl(Point pointFirst, Point pointSecond) {
        Validator.validateNotNull(pointFirst, pointSecond,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        this.pointFirst = pointFirst;
        this.pointSecond = pointSecond;
        reinitialize();
    }

    /**
     * Get all vertices of square.
     *
     * @return <code>Stack<Point2D><code> - collection of vertices
     */
    public Stack<Point2D> getPoints() {
        return points;
    }

    /**
     * Get the vertices in array.
     *
     * @return <code>Point2D</code>
     */
    public Point2D[] getPoints2D() {
        Point2D[] points2D = new Point2D[points.size()];
        for (int i = 0; i < points2D.length; i++) {
            points2D[i] = points.get(i);
        }
        return points2D;
    }

    @Override
    public String toString() {
        String s = "SquareImpl{";
        for (int i = 0; i < points.size(); i++) {
            s += points.get(i) + System.lineSeparator();
        }
        return s + "}";
    }

    /**
     * Reinitialisation of square - creating another 2 vertices and
     * counter-clockwise sorting of vertices.
     */
    public void reinitialize() {
        if (pointFirst != null && pointSecond != null) {
            Point2D[] pointsTemp = new Point2D[4];
            pointsTemp[0] = ((PointImpl) pointFirst).getPoint2D();
            pointsTemp[1] = ((PointImpl) pointSecond).getPoint2D();
            pointsTemp[2] = new Point2D((pointsTemp[0]
                    .getCoordinateX() + pointsTemp[1].getCoordinateX()) / 2
                    + (pointsTemp[0].getCoordinateY() - pointsTemp[1]
                    .getCoordinateY()) / 2, (pointsTemp[0]
                    .getCoordinateY() + pointsTemp[1].getCoordinateY()) / 2
                    + (pointsTemp[1].getCoordinateX() - pointsTemp[0]
                    .getCoordinateX()) / 2);
            pointsTemp[3] = new Point2D((pointsTemp[0]
                    .getCoordinateX() + pointsTemp[1].getCoordinateX()) / 2
                    + (pointsTemp[1].getCoordinateY() - pointsTemp[0]
                    .getCoordinateY()) / 2, (pointsTemp[0]
                    .getCoordinateY() + pointsTemp[1].getCoordinateY()) / 2
                    + (pointsTemp[0].getCoordinateX() - pointsTemp[1]
                    .getCoordinateX()) / 2);
            points = new GrahamScan(pointsTemp).getHull();
        }
    }

    @Override
    public Point getFirst() {
        return pointFirst;
    }

    @Override
    public Point getSecond() {
        return pointSecond;
    }

    @Override
    public void setFirst(Point first) {
        this.pointFirst = first;
    }

    @Override
    public void setSecond(Point second) {
        this.pointSecond = second;
    }
}