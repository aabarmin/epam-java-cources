package com.epam.university.java.core.task015;

import com.epam.university.java.core.task013.Line;

import java.util.ArrayList;
import java.util.List;

public class Task015Impl implements Task015 {

    @Override
    public double getArea(Square first, Square second) {

        final SquareImpl firstSquare = (SquareImpl) first;
        final SquareImpl secondSquare = (SquareImpl) second;

        final ArrayList<Edge> edgesOfFirst = new ArrayList<>(firstSquare.getEdges());
        final ArrayList<Edge> edgesOfSecond = new ArrayList<>(secondSquare.getEdges());


        final ArrayList<Point> pointsOfIntersections = new ArrayList<>();

        for (Edge firstEdge : edgesOfFirst) {
            for (Edge secondEdge : edgesOfSecond) {

                Point intersectionPoint = intersectionOf(firstEdge, secondEdge);
                if (intersectionPoint != null
                        && !pointsOfIntersections.contains(intersectionPoint)) {
                    pointsOfIntersections.add(intersectionPoint);
                }
            }
        }

        final ArrayList<Point> vertexesOfFirst = new ArrayList<>(firstSquare.getVertexes());
        final ArrayList<Point> vertexesOfSecond = new ArrayList<>(secondSquare.getVertexes());

        for (Point firstPoint : vertexesOfFirst) {
            if (isInsideTheQuad(firstPoint, secondSquare.getMiddle(), secondSquare)) {
                pointsOfIntersections.add(firstPoint);

            }
        }
        for (Point secondPoint : vertexesOfSecond) {
            if (isInsideTheQuad(secondPoint, firstSquare.getMiddle(), firstSquare)) {
                pointsOfIntersections.add(secondPoint);

            }
        }


        if (pointsOfIntersections.size() == 0) {
            return 0;
        } else if (pointsOfIntersections.size() == 3) {
            return squareOfTriangle(pointsOfIntersections);
        }


        return 0;
    }


    private Point intersectionOf(Edge first, Edge second) {
        Point intersectionPoint = new PointImpl();

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

        for (Edge edge : square.getEdges()) {
            Point pointA = squareCenter;
            Point pointB = edge.getFrom();
            Point pointC = edge.getTo();
            if (isInsideTheTriangle(supposedPoint, pointA, pointB, pointC)) {
                return true;
            }
        }


        return false;
    }

    private boolean isInsideTheTriangle(Point supposedPoint, Point pointA, Point pointB, Point pointC) {

        double x = supposedPoint.getX();
        double y = supposedPoint.getY();

        double x1 = pointA.getX();
        double y1 = pointA.getY();
        double x2 = pointB.getX();
        double y2 = pointB.getY();
        double x3 = pointC.getX();
        double y3 = pointC.getY();


        double squareWithSupposedPoint = (Math.abs((x1 - x) * (y2 - y) * (y1 - y)))
                + (Math.abs((x1 - x3) * (y - y3) - (x - x3) * (y1 - y3)))
                + Math.abs((x - x3) * (y2 - y3) - (x2 - x3) * (y - y3));

        double simpleSquare = Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3));

        return squareWithSupposedPoint == simpleSquare;
    }

    private double squareOfTriangle(List<Point> points){
        double x1 = points.get(0).getX();
        double y1 = points.get(0).getY();
        double x2 = points.get(1).getX();
        double y2 = points.get(1).getY();
        double x3 = points.get(2).getX();
        double y3 = points.get(2).getY();

        double simpleSquare = Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3));

        return simpleSquare;
    }

    private double squareOfSquare(List<Point> points){
        double x1 = points.get(0).getX();
        double y1 = points.get(0).getY();
        double x2 = points.get(1).getX();
        double y2 = points.get(1).getY();
        double x3 = points.get(2).getX();
        double y3 = points.get(2).getY();

        double simpleSquare = Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3));

        return simpleSquare;
    }
}
