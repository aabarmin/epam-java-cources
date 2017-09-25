package com.epam.university.java.core.task015;

import com.epam.university.java.core.utils.geometricprimitives.GrahamScan;
import com.epam.university.java.core.utils.geometricprimitives.Point2D;

import java.util.Stack;

public class SquareImpl implements Square {
    public SquareImpl(Point pointFirst, Point pointSecond) {
        this.pointFirst = pointFirst;
        this.pointSecond = pointSecond;
        reinitialize();
    }

    private Point pointFirst;
    private Point pointSecond;
    private Stack<Point2D> points;

    public Stack<Point2D> getPoints() {
        return points;
    }

    public Point2D[] getPoints2D() {
        Point2D[] points2D = new Point2D[points.size()];
        for (int i = 0; i < points2D.length; i++) {
            points2D[i] = points.get(i);
        }
        return points2D;
    }

    @Override
    public String toString() {
        String s="SquareImpl{";
        for (int i = 0; i <points.size() ; i++) {
            s+=points.get(i) +System.lineSeparator();
        }
        return s+ "}";
    }

    public void reinitialize() {
        if (pointFirst != null && pointSecond != null) {
            Point2D[] pointsTemp = new Point2D[4];
            pointsTemp[0] = ((PointImpl) pointFirst).getPoint2D();
            pointsTemp[1] = ((PointImpl) pointSecond).getPoint2D();
            pointsTemp[2] = new Point2D((pointsTemp[0].x()
                    + pointsTemp[1].x()) / 2 + (pointsTemp[0].y() -
                    pointsTemp[1].y()) / 2, (pointsTemp[0].y()
                    + pointsTemp[1].y()) / 2 + (pointsTemp[1].x() -
                    pointsTemp[0].x()) / 2);
            pointsTemp[3] = new Point2D((pointsTemp[0].x()
                    + pointsTemp[1].x()) / 2 + (pointsTemp[1].y() -
                    pointsTemp[0].y()) / 2, (pointsTemp[0].y()
                    + pointsTemp[1].y()) / 2 + (pointsTemp[0].x() -
                    pointsTemp[1].x()) / 2);
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