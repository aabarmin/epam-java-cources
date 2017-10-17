package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointFactoryImpl;

import java.util.Collection;

public class Task021Impl implements Task021 {
    @Override
    public Point calculate(Collection<Point> minePositions) {
        if (minePositions.size() != 3) {
            throw new IllegalArgumentException("To solve the task need 3 points.");
        }
        Point[] points = minePositions.toArray(new Point[0]);
        Point point = checkTorricelliPoint(points);
        if (point != null) {
            return point;
        }

        double ax = points[0].getX();
        double ay = points[0].getY();
        double bx = points[1].getX();
        double by = points[1].getY();
        double cx = points[2].getX();
        double cy = points[2].getY();
        //additional first point
        double addFirstX = (cx + bx + (cy - by) * Math.sqrt(3)) / 2;
        double addFirstY = (cy + by + (bx - cx) * Math.sqrt(3)) / 2;
        //additional second point
        double addSecondX = (ax + bx + (ay - by) * Math.sqrt(3)) / 2;
        double addSecondY = (ay + by + (bx - ax) * Math.sqrt(3)) / 2;

        double a1 = cy - addSecondY;
        double b1 = addSecondX - cx;
        double a2 = ay - addFirstY;
        double b2 = addFirstX - ax;

        double d = a1 * b2 - a2 * b1;
        double c1 = addSecondY * cx - addSecondX * cy;
        double c2 = addFirstY * ax - addFirstX * ay;

        double finalX = (b1 * c2 - b2 * c1) / d;
        double finalY = (a2 * c1 - a1 * c2) / d;
        return new PointFactoryImpl().newInstance(finalX, finalY);
    }

    private Point checkTorricelliPoint(Point[] points) {
        double ax = points[0].getX();
        double ay = points[0].getY();
        double bx = points[1].getX();
        double by = points[1].getY();
        double cx = points[2].getX();
        double cy = points[2].getY();

        double abLen = Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
        double acLen = Math.sqrt(Math.pow(cx - ax, 2) + Math.pow(cy - ay, 2));
        double bcLen = Math.sqrt(Math.pow(cx - bx, 2) + Math.pow(cy - by, 2));

        //cosine formula
        double angleA = Math.acos((Math.pow(abLen, 2) + Math.pow(acLen, 2) - Math.pow(bcLen, 2))
                / (2 * abLen * acLen));
        double angleB = Math.acos((Math.pow(abLen, 2) + Math.pow(bcLen, 2) - Math.pow(acLen, 2))
                / (2 * abLen * bcLen));
        double angleC = Math.acos((Math.pow(acLen, 2) + Math.pow(bcLen, 2) - Math.pow(abLen, 2))
                / (2 * acLen * bcLen));
        //120 degree in radians
        double rad = 2 * Math.PI / 3;
        if (angleA >= rad) {
            return points[0];
        } else if (angleB >= rad) {
            return points[1];
        } else if (angleC >= rad) {
            return points[2];
        }
        return null;
    }
}