package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Task021Impl implements Task021 {
    @Override
    public Point calculate(Collection<Point> minePositions) {

        if (minePositions == null || minePositions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        ArrayList<PointImpl> listOfMinePositions = new ArrayList<>();

        for (Point minePosition : minePositions) {
            PointImpl vertex = (PointImpl) minePosition;
            listOfMinePositions.add(vertex);
        }

        Collections.sort(listOfMinePositions);

        Point vertexA = listOfMinePositions.get(0);
        Point vertexB = listOfMinePositions.get(1);
        Point vertexC = listOfMinePositions.get(2);

        //Get angles
        double angleA = findAngle(vertexC, vertexA, vertexB);
        if (angleA > 120) {
            return vertexA;
        }
        double angleB = findAngle(vertexA, vertexB, vertexC);
        if (angleB > 120) {
            return vertexB;
        }
        double angleC = findAngle(vertexA, vertexC, vertexB);
        if (angleC > 120) {
            return vertexC;
        }

        //three new vertexes;
        Point vertexAb = findAdditionalVertex(vertexA, vertexB);
        Point vertexBc = findAdditionalVertex(vertexB, vertexC);
        Point vertexAc = findAdditionalVertex(vertexC, vertexA);

        Point intersection = findIntersectionBetween(vertexAb, vertexC,
                                                     vertexBc, vertexA,
                                                     vertexAc, vertexB);


        return intersection;

    }

    private Point findIntersectionBetween(Point vertexAb, Point vertexC,
                                          Point vertexBc, Point vertexA,
                                          Point vertexAc, Point vertexB) {

        Point intersectionPoint = new PointImpl();

        Line fromABtoC = new Line(vertexAb.getX(), vertexAb.getY(), vertexC.getX(), vertexC.getY());
        Line fromBCtoA = new Line(vertexBc.getX(), vertexBc.getY(), vertexA.getX(), vertexA.getY());

        if (Double.isNaN(fromABtoC.getB())) {
            fromABtoC = new Line(vertexAc.getX(), vertexAc.getY(), vertexC.getX(), vertexC.getY());
        } else if (Double.isNaN(fromBCtoA.getB())) {
            fromBCtoA = new Line(vertexAc.getX(), vertexAc.getY(), vertexC.getX(), vertexC.getY());
        }

        //x = (b2-b1) / (m1-m2)
        double newX = (fromBCtoA.getB() - fromABtoC.getB()) / (fromABtoC.getK() - fromBCtoA.getK());
        //newY = Math.round(newY * 1000000000000000L) / 1000000000000000.0;
        intersectionPoint.setX(newX);

        //y = m1 * [(b2-b1) / (m1-m2)] + b1
        double newY = (fromABtoC.getK() * newX) + fromABtoC.getB();
        newY = Math.round(newY * 1000000000000000L) / 1000000000000000.0;
        intersectionPoint.setY(newY);


        return intersectionPoint;
    }

    private Point findAdditionalVertex(Point baseVertex, Point rotateVertex) {

        final Point newPoint = new PointImpl();
        double modifiedXOfB = rotateVertex.getX() - baseVertex.getX();
        double modifiedYOfB = rotateVertex.getY() - baseVertex.getY();

        double newX;
        double newY;

        newX = modifiedXOfB * 0.5 - modifiedYOfB * Math.sqrt(3) / 2.0;
        newY = modifiedXOfB * Math.sqrt(3) / 2.0 + modifiedYOfB * 0.5;

        newX += baseVertex.getX();
        newY += baseVertex.getY();

        newPoint.setX(newX);
        newPoint.setY(newY);

        return newPoint;
    }

    private double findAngle(Point vertexC, Point vertexA, Point vertexB) {

        double modifiedXOfB;
        double modifiedYOfB;
        modifiedXOfB = vertexB.getX() - vertexA.getX();
        modifiedYOfB = vertexB.getY() - vertexA.getY();

        double modifiedXOfC;
        double modifiedYOfC;
        modifiedXOfC = vertexC.getX() - vertexA.getX();
        modifiedYOfC = vertexC.getY() - vertexA.getY();

        double scMul = modifiedXOfB * modifiedXOfC
                + modifiedYOfB * modifiedYOfC;
        double moduloOfB = Math.sqrt(Math.pow(modifiedXOfB, 2)
                + Math.pow(modifiedYOfB, 2));
        double moduloOfC = Math.sqrt(Math.pow(modifiedXOfC, 2)
                + Math.pow(modifiedYOfC, 2));
        double cosOfAngle = scMul / (moduloOfB * moduloOfC);

        double angle;
        angle = Math.acos(cosOfAngle);
        angle = Math.toDegrees(angle);

        return angle;
    }


    public class Line {
        private double k;
        private double b;

        /**
         * Line constructor y= kx + b sets k and b.
         * @param x1 first point x
         * @param y1 first point y
         * @param x2 second point x
         * @param y2 second point y
         */
        public Line(double x1, double y1, double x2, double y2) {
            if (x1 + x2 == 0) {
                this.k = Double.NaN;
                this.b = Double.NaN;
            } else {
                this.k = (y1 - y2) / (x1 - x2);
                this.b = -(k * x1) + y1;
            }

        }

        public double getK() {
            return k;
        }

        public void setK(double k) {
            this.k = k;
        }

        public double getB() {
            return b;
        }

        public void setB(double b) {
            this.b = b;
        }
    }
}