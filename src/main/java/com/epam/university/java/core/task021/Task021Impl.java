package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointFactoryImpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * {@inheritDoc}
 */
public class Task021Impl implements Task021 {
    /**
     * {@inheritDoc}
     */
    @Override
    public Point calculate(Collection<Point> minePositions) {
        List<Point> list = new ArrayList<>(minePositions);
        Point bigAngle = checkAngles(list);
        if (bigAngle != null) {
            return bigAngle;
        }
        Point pointA = list.get(0);
        Point pointB = list.get(1);
        Point pointC = list.get(2);

        Point veretexA = getTriangelVertex(pointA, pointB, pointC);
        Point veretexB = getTriangelVertex(pointB, pointC, pointA);

        Point result = getIntersection(veretexA, pointC, veretexB, pointA);

        return result;
    }

    /**
     * This method finds two vertex of equilateral triangle by designed to points.
     * <code>first</code> and <code>second</code> from opposite sides and returns
     * that which is farther from <code>toCompare</code> point.
     *
     * @param first     first point of triangle
     * @param second    second point of triangle
     * @param toCompare point to compare distance
     * @return third vertex of equilateral triangle
     */
    private Point getTriangelVertex(Point first, Point second, Point toCompare) {
        Point result = null;
        double xOfVertA = (first.getX() + second.getX() +
                (first.getY() - second.getY()) * Math.sqrt(3)) / 2;
        double yOfVertA = (first.getY() + second.getY() +
                (second.getX() - first.getX()) * Math.sqrt(3)) / 2;

        double xOfOppA = (first.getX() + second.getX() -
                (first.getY() - second.getY()) * Math.sqrt(3)) / 2;
        double yOfOppA = (first.getY() + second.getY() -
                (second.getX() - first.getX()) * Math.sqrt(3)) / 2;

        double distanceA = Math.sqrt(Math.pow(xOfVertA - toCompare.getX(), 2) +
                Math.pow(yOfVertA - toCompare.getY(), 2));
        double distanceB = Math.sqrt(Math.pow(xOfOppA - toCompare.getX(), 2) +
                Math.pow(xOfOppA - toCompare.getY(), 2));
        if (distanceA > distanceB) {
            result = new PointFactoryImpl().newInstance(xOfVertA, yOfVertA);
        } else {
            result = new PointFactoryImpl().newInstance(xOfOppA, yOfOppA);
        }
        return result;
    }

    /**
     * This method finds result point of intersection of to line segments.
     *
     * @param aPoint first point of first line segment
     * @param bPoint second point of first line segment
     * @param cPoint first point of second line segment
     * @param dPoint second point of second line segment
     * @return point of intersection of given line segments
     */
    private Point getIntersection(Point aPoint, Point bPoint, Point cPoint, Point dPoint) {

        double devider = (aPoint.getX() - bPoint.getX()) * (dPoint.getY() - cPoint.getY()) -
                (aPoint.getY() - bPoint.getY()) * (dPoint.getX() - cPoint.getX());

        double dividendA = (aPoint.getX() - cPoint.getX()) * (dPoint.getY() - cPoint.getY()) -
                (aPoint.getY() - cPoint.getY()) * (dPoint.getX() - cPoint.getX());

        double dividendB = (aPoint.getX() - bPoint.getX()) * (aPoint.getY() - cPoint.getY()) -
                (aPoint.getY() - bPoint.getY()) * (aPoint.getX() - cPoint.getX());

        double resultA = dividendA / devider;
        double resultB = dividendB / devider;
        Point result = null;
        if (resultA >= 0 && resultA <= 1 && resultB >= 0 && resultB <= 1) {
            double interX = aPoint.getX() + resultA * (bPoint.getX() - aPoint.getX());
            double interY = aPoint.getY() + resultA * (bPoint.getY() - aPoint.getY());
            result = new PointFactoryImpl().newInstance(interX, interY);
        }
        return result;
    }

    /**
     * Check if triangle has angle which is bigger than 120.
     *
     * @param points point of triangle
     * @return return vertex with angle more than 120 if exists or null if doesn't
     */
    private Point checkAngles(List<Point> points) {
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        Point pointC = points.get(2);

        double ribA = Math.sqrt(Math.pow(pointB.getX() - pointC.getX(), 2) +
                Math.pow(pointB.getY() - pointC.getY(), 2));

        double ribB = Math.sqrt(Math.pow(pointA.getX() - pointC.getX(), 2) +
                Math.pow(pointA.getY() - pointC.getY(), 2));

        double ribC = Math.sqrt(Math.pow(pointA.getX() - pointB.getX(), 2) +
                Math.pow(pointA.getY() - pointB.getY(), 2));

        double angleA = Math.acos((Math.pow(ribB, 2) + Math.pow(ribC, 2) - Math.pow(ribA, 2)) /
                (2 * ribB * ribC));

        double angleB = Math.acos((Math.pow(ribA, 2) + Math.pow(ribC, 2) - Math.pow(ribB, 2)) /
                (2 * ribA * ribC));

        double angleC = 1.8 - (angleB + angleA);

        if (angleA > 1.2) {
            return pointA;
        } else if (angleB > 1.2) {
            return pointB;
        } else if (angleC > 1.2) {
            return pointC;
        }
        return null;
    }
}
