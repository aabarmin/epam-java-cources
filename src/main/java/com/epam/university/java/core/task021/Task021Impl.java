package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Вера on 29.09.2017.
 */
public class Task021Impl implements Task021 {
    @Override
    public Point calculate(Collection<Point> minePositions) {
        //double[] pointX = new double[3];
        //double[] pointY = new double[3];
        Point[] points = new Point[3];
        int i = 0;

        System.out.println(minePositions.toString());

        for (Point p : minePositions ) {
            System.out.println(p.toString());
            //pointX[i] = p.getX();
            //pointY[i] = p.getY();
            //points[i].setX(p.getX());
            //points[i].setY(p.getY());
            points[i] = p;
            i++;
        }

        double cos120 = 120;

        System.out.println(points[0].toString());
        System.out.println(points[1].toString());
        System.out.println(points[2].toString());

        int indicator = -1;

        if (angle(points[0], points[1], points[2]) >= cos120) {
            indicator = 1;
        }
        if (angle(points[1], points[2], points[0]) >= cos120) {
            indicator = 2;
        }
        if (angle(points[2], points[0], points[1]) >= cos120) {
            indicator = 0;
        }

        if (indicator > -1) {
            for (Point p : minePositions) {
                System.out.println(p.toString());
                if (points[indicator].getX() == p.getX()
                        && points[indicator].getY() == p.getY()) {
                    return p;
                }
            }
        }



        return null;
    }

    //private double angle(double Ax, double Ay, double Bx, double By, double Cx, double Cy) {
    private double angle(Point a, Point b, Point c) {
        double abX = a.getX() - b.getX();
        double abY = a.getY() - b.getY();
        double cbX = c.getX() - b.getX();
        double cbY = c.getY() - b.getY();

        double ba = Math.sqrt(abX * abX + abY * abY);
        double bc = Math.sqrt(cbX * cbX + cbY * cbY);

        double result = Math.acos((abX * cbX + abY * cbY) / (ba * bc));
        double resulttoDegree = Math.toDegrees(result);

        return resulttoDegree;
    }
}
