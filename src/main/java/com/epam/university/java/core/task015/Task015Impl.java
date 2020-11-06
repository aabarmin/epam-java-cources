package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task015Impl implements Task015 {

    @Override
    public double getArea(Square first, Square second) {

        final SquareImpl firstSquare = (SquareImpl) first;
        final SquareImpl secondSquare = (SquareImpl) second;

        final ArrayList<Edge> edgesOfFirst = new ArrayList<>(firstSquare.getEdges());
        final ArrayList<Edge> edgesOfSecond = new ArrayList<>(secondSquare.getEdges());

        final ArrayList<PointImpl> pointsOfIntersections = new ArrayList<>();

        for (Edge firstEdge : edgesOfFirst) {
            for (Edge secondEdge : edgesOfSecond) {
                PointImpl intersectionPoint = intersectionOf(firstEdge, secondEdge);
                if (intersectionPoint != null
                        && !pointsOfIntersections.contains(intersectionPoint)) {
                    pointsOfIntersections.add(intersectionPoint);
                }
            }
        }


        final ArrayList<Point> vertexesOfFirst = new ArrayList<>(firstSquare.getVertexes());
        final ArrayList<Point> vertexesOfSecond = new ArrayList<>(secondSquare.getVertexes());

        for (Point point : vertexesOfFirst) {
            PointImpl firstPoint = (PointImpl) point;
            if (isInsideTheQuad(point, secondSquare.getMiddle(), secondSquare)
                    && !pointsOfIntersections.contains(firstPoint)) {
                pointsOfIntersections.add(firstPoint);
            }
        }

        for (Point point : vertexesOfSecond) {
            PointImpl secondPoint = (PointImpl) point;
            if (isInsideTheQuad(point, firstSquare.getMiddle(), firstSquare)
                    && !pointsOfIntersections.contains(secondPoint)) {
                pointsOfIntersections.add(secondPoint);
            }
        }

        for (Point point : vertexesOfFirst) {
            PointImpl firstPoint = (PointImpl) point;
            if (isInsideTheQuad(firstPoint, secondSquare.getMiddle(), secondSquare)
                    && !pointsOfIntersections.contains(firstPoint)) {
                pointsOfIntersections.add(firstPoint);
            }
        }
        for (Point point : vertexesOfSecond) {
            PointImpl secondPoint = (PointImpl) point;
            if (isInsideTheQuad(secondPoint, firstSquare.getMiddle(), firstSquare)
                    && !pointsOfIntersections.contains(secondPoint)) {
                pointsOfIntersections.add(secondPoint);
            }
        }

        if (pointsOfIntersections.size() == 0) {
            return 0;
        } else if (pointsOfIntersections.size() == 3) {
            return squareOfTriangle(pointsOfIntersections);
        } else if (pointsOfIntersections.size() == 4) {
            return squareOfSquare(pointsOfIntersections);
        } else if (pointsOfIntersections.size() == 8) {
            return squareOfOctagon(pointsOfIntersections, secondSquare.getMiddle());
        }

        return 0;
    }

    private double squareOfOctagon(ArrayList<PointImpl> pointsOfIntersections, Point middle) {

        Collections.sort(pointsOfIntersections);
        Point first = pointsOfIntersections.get(0);
        Point second = pointsOfIntersections.get(1);
        Point fourth = pointsOfIntersections.get(3);

        double squareOfOctagon = 0;

        squareOfOctagon += squareOfTriangle(first, middle, second);
        squareOfOctagon += squareOfTriangle(second, middle, fourth);
        squareOfOctagon *= 4;

        return squareOfOctagon;
    }


    private PointImpl intersectionOf(Edge first, Edge second) {
        final PointImpl intersectionPoint = new PointImpl();

        if (first.isVertical()) {
            Edge tmp = first;
            first = second;
            second = tmp;
        }

        Point p1 = first.getFrom();
        Point p2 = first.getTo();
        if (p1.getX() > p2.getX()) {
            Point tmp = p1;
            p1 = p2;
            p2 = tmp;
        } else if (p1.getX() == p2.getX() && p1.getY() > p2.getY()) {
            Point tmp = p1;
            p1 = p2;
            p2 = tmp;
        }
        Point p3 = second.getFrom();
        Point p4 = second.getTo();
        if (p3.getX() > p4.getX()) {
            Point tmp = p3;
            p3 = p4;
            p4 = tmp;
        } else if (p3.getX() == p4.getX() && p3.getY() > p4.getY()) {
            Point tmp = p3;
            p3 = p4;
            p4 = tmp;
        }

        double x1 = p1.getX();
        double y1 = p1.getY();

        double x2 = p2.getX();
        double y2 = p2.getY();

        double x3 = p3.getX();
        double y3 = p3.getY();

        double x4 = p4.getX();
        double y4 = p4.getY();


        double denominator = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
        // if den == 0 -> a || b
        if (denominator == 0) {
            return null;
        }
        double uA = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3))
                / denominator;
        double uB = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3))
                / denominator;

        if (uA > 1.0 || uA < 0.0 || uB > 1.0 || uB < 0.0) {
            return null;
        }

        double n;
        if (y2 - y1 != 0) {  // a(y)
            double q = (x2 - x1) / (y1 - y2);
            double sn = (x3 - x4) + (y3 - y4) * q;
            double fn = (x3 - x1) + (y3 - y1) * q;   // b(x) + b(y)*q
            n = fn / sn;
        } else {
            n = (y3 - y1) / (y3 - y4);   // c(y)/b(y)
        }
        double x = x3 + (x4 - x3) * n;  // x3 + (-b(x))*n
        double y = y3 + (y4 - y3) * n;  // y3 +(-b(y))*n

        intersectionPoint.setX(x);
        intersectionPoint.setY(y);

        return intersectionPoint;
    }

    private boolean isInsideTheQuad(Point supposedPoint, Point squareCenter, SquareImpl square) {
        Collections.sort(square.getEdges());
        if (supposedPoint.equals(squareCenter)) {
            return true;
        }
        for (Edge edge : square.getEdges()) {
            Point pointA = squareCenter;
            Point pointB = edge.getFrom();
            Point pointC = edge.getTo();

            if (isInsideTheTriangle(supposedPoint, pointA, pointB, pointC)) {
                return true;
            }
            if (squareOfTriangle(pointA, pointB, pointC)
                    == squareOfTriangle(supposedPoint, pointB, pointC)
                    + squareOfTriangle(supposedPoint, pointC, pointA)
                    + squareOfTriangle(supposedPoint, pointA, pointB)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInsideTheTriangle(Point supposedPoint, Point pointA,
                                        Point pointB, Point pointC) {

        if (pointB.getY() == supposedPoint.getY()) {
            Point tmp = pointB;
            pointB = pointC;
            pointC = tmp;
        }
        if (pointC.getY() == supposedPoint.getY()) {
            Point tmp = pointB;
            pointB = pointC;
            pointC = tmp;
        }

        double firstPart = squareOfTriangle(pointB, supposedPoint, pointA);
        double secondPart = squareOfTriangle(pointB, pointA, pointC);
        if (firstPart == 0 || secondPart == 0) {
            return false;
        }

        double squareWithSupposedPoint = firstPart + secondPart;
        double simpleSquare = squareOfTriangle(pointA, pointB, pointC);

        return squareWithSupposedPoint == simpleSquare;
    }

    private double squareOfTriangle(List<PointImpl> points) {
        double x1 = points.get(0).getX();
        double y1 = points.get(0).getY();
        double x2 = points.get(1).getX();
        double y2 = points.get(1).getY();
        double x3 = points.get(2).getX();
        double y3 = points.get(2).getY();

        return Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
    }

    private double squareOfTriangle(Point a, Point b, Point c) {
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        double x3 = c.getX();
        double y3 = c.getY();

        return Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
    }

    private double squareOfSquare(List<PointImpl> points) {
        Collections.sort(points);
        PointImpl pointA = points.get(1);
        PointImpl pointC = points.get(3);

        double firstSquare = squareOfTriangle(pointA, pointC, points.get(0));
        double secondSquare = squareOfTriangle(pointA, pointC, points.get(2));

        return firstSquare + secondSquare;
    }
}