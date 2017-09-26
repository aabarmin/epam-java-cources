package com.epam.university.java.core;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointFactoryImpl;

import java.util.Collection;

/**
 * Service class for frequently used functions.
 */
public class Points {


    /**
     * Calculate centriond of figure.
     *
     * @param points Collection of Point
     * @return point of centroind Point
     */
    public static Point getCentroid2D(Collection<Point> points) {
        double sumX = 0;
        double sumY = 0;
        for (Point v : points) {
            sumX += v.getX();
            sumY += v.getY();
        }
        double x = sumX / points.size();
        double y = sumY / points.size();
        return (new PointFactoryImpl()).newInstance(x, y);
    }

    /**
     * Calculate angle of three points.
     *
     * @param p1          first point
     * @param p2          second point
     * @param centerPoint center point of angle
     * @return double in degrees
     */
    public static double getAngle(Point p1, Point centerPoint, Point p2) {
        double p0c = Math.sqrt(Math.pow(centerPoint.getX() - p1.getX(), 2)
                + Math.pow(centerPoint.getY() - p1.getY(), 2));
        double p1c = Math.sqrt(Math.pow(centerPoint.getX() - p2.getX(), 2)
                + Math.pow(centerPoint.getY() - p2.getY(), 2));
        double p0p1 = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2)
                + Math.pow(p2.getY() - p1.getY(), 2));
        return Math.acos((p1c * p1c + p0c * p0c - p0p1 * p0p1) / (2 * p1c * p0c)) * 180 / Math.PI;
    }

    /**
     * Calculate distance between points.
     *
     * @param p1 first point
     * @param p2 second point
     * @return distance
     */
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(
                Math.pow(p2.getX() - p1.getX(), 2)
                        + Math.pow(p2.getY() - p1.getY(), 2)
        );
    }
}
