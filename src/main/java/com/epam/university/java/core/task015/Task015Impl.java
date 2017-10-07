package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Task015Impl implements Task015 {
    /**
     * Determines if lines (line1Point1, line1Point2) and (line2Point2, line2Point2)
     * cross each other.
     *
     * @param line1Point1 first point of line 1
     * @param line1Point2 second point of line 1
     * @param line2Point1 first point of line 2
     * @param line2Point2 second point of line 2
     * @return true if line1 cross line2
     */
    private boolean isCrossing(Point line1Point1, Point line1Point2,
                               Point line2Point1, Point line2Point2) {
        double measure = (line1Point1.getX() - line1Point2.getX())
                * (line2Point1.getY() - line2Point2.getY())
                - (line1Point1.getY() - line1Point2.getY())
                * (line2Point1.getX() - line2Point2.getX());
        return !(measure == 0);


    }

    /**
     * Finds the intersection coordinate x of lines (line1Point1, line1Point2)
     * and (line2Point1, line2Point2).
     *
     * @param line1Point1 first point of line 1
     * @param line1Point2 second point of line 1
     * @param line2Point1 first point of line 2
     * @param line2Point2 second point of line 2
     * @return x coordinate of intersection
     */
    private double intersectionX(Point line1Point1, Point line1Point2,
                                 Point line2Point1, Point line2Point2) {

        return ((line1Point1.getX() * line1Point2.getY()
                - line1Point1.getY() * line1Point2.getX())
                * (line2Point1.getX() - line2Point2.getX())
                - (line1Point1.getX() - line1Point2.getX())
                * (line2Point1.getX() * line2Point2.getY()
                - line2Point1.getY() * line2Point2.getX()))
                / ((line1Point1.getX() - line1Point2.getX())
                * (line2Point1.getY() - line2Point2.getY())
                - (line1Point1.getY() - line1Point2.getY())
                * (line2Point1.getX() - line2Point2.getX()));
    }

    /**
     * Finds the intersection coordinate y of lines (line1Point1, line1Point2)
     * and (line2Point1, line2Point2).
     *
     * @param line1Point1 first point of line 1
     * @param line1Point2 second point of line 1
     * @param line2Point1 first point of line 2
     * @param line2Point2 second point of line 2
     * @return y coordinate of intersection
     */
    private double intersectionY(Point line1Point1, Point line1Point2,
                                 Point line2Point1, Point line2Point2) {

        return ((line1Point1.getX() * line1Point2.getY()
                - line1Point1.getY() * line1Point2.getX())
                * (line2Point1.getY() - line2Point2.getY())
                - (line1Point1.getY() - line1Point2.getY())
                * (line2Point1.getX() * line2Point2.getY()
                - line2Point1.getY() * line2Point2.getX()))
                / ((line1Point1.getX() - line1Point2.getX())
                * (line2Point1.getY() - line2Point2.getY())
                - (line1Point1.getY() - line1Point2.getY())
                * (line2Point1.getX() - line2Point2.getX()));
    }


    /**
     * Determines the relative position of a point
     * <code>b</code> andvector [<code>a1</code>,<code>a2</code>.
     * if metric < 0 point is to the left side of vector
     * if metric > 0 point is to the right side of vector
     * if metric =0  point lies on the vector of it's forming line
     *
     * @param a1 vector's starting point
     * @param a2 vector's ending point
     * @param b  point b
     * @return value of metric
     */
    private static double metric(Point a1, Point a2, Point b) {
        return (b.getX() - a1.getX()) * (a2.getY() - a1.getY())
                - (b.getY() - a1.getY()) * (a2.getX() - a1.getX());
    }

    /**
     * Sort vertexes in the order, where one "is left" from another.
     * It's a part of Graham scan algorithm.
     *
     * @param vertices source set of points
     * @return sorted list of vertices
     */
    public static ArrayList<Point> sortVertices(ArrayList<Point> vertices) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(0).getX() > vertices.get(i).getX()) {
                Point tmp = vertices.get(0);
                vertices.set(0, vertices.get(i));
                vertices.set(i, tmp);
            }
        }
        for (int i = 1; i < vertices.size(); i++) {
            int j = i;
            while (j > 1 && (metric(vertices.get(0), vertices.get(j - 1), vertices.get(j)) < 0)) {
                Point tmp = vertices.get(j);
                vertices.set(j, vertices.get(j - 1));
                vertices.set(j - 1, tmp);
                j--;
            }
        }

        return vertices;

    }

    private double vectorLength(Point first, Point second) {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2)
                + Math.pow(second.getY() - first.getY(), 2));

    }

    public double delta(Point a, Point b) {
        return (a.getX() * b.getY() - a.getY() * b.getX());
    }

    /**
     * Determines if the point targetPoint is inside the triangle (pointA, pointB, pointC).
     *
     * @param pointA      first point of Triangle
     * @param pointB      second point of triangle
     * @param pointC      third point of triangle
     * @param targetPoint target point
     * @return true if targetPoint is inside the triangle
     */
    private boolean isInTriangle(Point pointA, Point pointB,
                                 Point pointC, Point targetPoint) {

        double s1 = ((targetPoint.getX() - pointA.getX()) * (pointB.getY() - pointA.getY())
                - (targetPoint.getY() - pointA.getY()) * (pointB.getX() - pointA.getX()))
                * ((pointC.getX() - pointA.getX()) * (pointB.getY() - pointA.getY())
                - (pointC.getY() - pointA.getY()) * (pointB.getX() - pointA.getX()));

        double s2 = ((targetPoint.getX() - pointB.getX()) * (pointC.getY() - pointB.getY())
                - (targetPoint.getY() - pointB.getY()) * (pointC.getX() - pointB.getX()))
                * ((pointA.getX() - pointB.getX()) * (pointC.getY() - pointB.getY())
                - (pointA.getY() - pointB.getY()) * (pointC.getX() - pointB.getX()));

        double s3 = ((targetPoint.getX() - pointC.getX()) * (pointA.getY() - pointC.getY())
                - (targetPoint.getY() - pointC.getY()) * (pointA.getX() - pointC.getX()))
                * ((pointB.getX() - pointC.getX()) * (pointA.getY() - pointC.getY())
                - (pointB.getY() - pointC.getY()) * (pointA.getX() - pointC.getX()));


        return s1 >= 0 && s2 >= 0 && s3 >= 0;

    }

    private double calculateArea(HashSet<Point> points) {
        ArrayList<Point> pointsArr = new ArrayList<>(points);
        if (points.size() == 0) {
            return 0;
        }
        pointsArr = sortVertices(pointsArr);
        pointsArr.add(pointsArr.get(0));
        double area = 0;
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < pointsArr.size() - 1; i++) {
            sum1 += pointsArr.get(i).getX() * pointsArr.get(i + 1).getY();
            sum2 += pointsArr.get(i + 1).getX() * pointsArr.get(i).getY();
        }
        area = Math.abs((sum1 - sum2) / 2);
        return area;
    }

    @Override
    public double getArea(Square first, Square second) {
        Point firstPoint1 = first.getFirst().getX() <= first.getSecond().getX()
                ? first.getFirst() : first.getSecond();
        Point firstPoint3 = first.getFirst().getX() > first.getSecond().getX()
                ? first.getFirst() : first.getSecond();
        PointFactoryImpl factory = new PointFactoryImpl();
        //найдем координаты остальных вершин квадрата
        //координаты центра
        Point centerPoint1 = factory.newInstance((firstPoint1.getX() + firstPoint3.getX()) / 2,
                (firstPoint1.getY() + firstPoint3.getY()) / 2);
        // вектры из центра к вершинам
        Point vectorCenterA1 = factory.newInstance(firstPoint1.getX() - centerPoint1.getX(),
                firstPoint1.getY() - centerPoint1.getY());
        Point vectorCenterB1 = factory.newInstance(vectorCenterA1.getY(), -vectorCenterA1.getX());
        Point vectorCenterD1 = factory.newInstance(-vectorCenterA1.getY(), vectorCenterA1.getX());
        // подсчет точек
        Point firstPoint2 = factory.newInstance(centerPoint1.getX() + vectorCenterB1.getX(),
                centerPoint1.getY() + vectorCenterB1.getY());
        Point firstPoint4 = factory.newInstance(centerPoint1.getX() + vectorCenterD1.getX(),
                centerPoint1.getY() + vectorCenterD1.getY());


        Point secondPoint1 = second.getFirst().getX() <= second.getSecond().getX()
                ? second.getFirst() : second.getSecond();
        Point secondPoint3 = second.getFirst().getX() > second.getSecond().getX()
                ? second.getFirst() : second.getSecond();

        ArrayList<Point> points1 = new ArrayList<>();  // массив точек для обхода
        points1.add(firstPoint1);
        points1.add(firstPoint2);
        points1.add(firstPoint3);
        points1.add(firstPoint4);
        points1.add(firstPoint1);
        //найдем координаты остальных вершин квадрата
        //координаты центра
        Point centerPoint2 = factory.newInstance((secondPoint1.getX() + secondPoint3.getX()) / 2,
                (secondPoint1.getY() + secondPoint3.getY()) / 2);
        // вектры из центра к вершинам
        Point vectorCenterA2 = factory.newInstance(secondPoint1.getX() - centerPoint2.getX(),
                secondPoint1.getY() - centerPoint2.getY());
        Point vectorCenterB2 = factory.newInstance(vectorCenterA2.getY(), -vectorCenterA2.getX());
        Point vectorCenterD2 = factory.newInstance(-vectorCenterA2.getY(), vectorCenterA2.getX());
        // подсчет точек
        Point secondPoint2 = factory.newInstance(centerPoint2.getX() + vectorCenterB2.getX(),
                centerPoint2.getY() + vectorCenterB2.getY());
        Point secondPoint4 = factory.newInstance(centerPoint2.getX() + vectorCenterD2.getX(),
                centerPoint2.getY() + vectorCenterD2.getY());
        ArrayList<Point> points2 = new ArrayList<>();
        points2.add(secondPoint1);
        points2.add(secondPoint2);
        points2.add(secondPoint3);
        points2.add(secondPoint4);
        points2.add(secondPoint1);

        HashSet<Point> resultPoints = new HashSet<>();
        double x = 0;
        double y = 0;

        for (int i = 0; i < points1.size() - 1; i++) {
            for (int j = 0; j < points2.size() - 1; j++) {
                Point p1 = points1.get(i);
                Point p2 = points1.get(i + 1);
                Point p3 = points2.get(j);
                Point p4 = points2.get(j + 1);
                if (metric(p1, p2, p3) < 0 && metric(p1, p2, p4) > 0
                        || metric(p1, p2, p3) > 0 && metric(p1, p2, p4) < 0) {
                    if (isCrossing(p1, p2, p3, p4)) {
                        x = intersectionX(p1, p2, p3, p4);
                        y = intersectionY(p1, p2, p3, p4);
                        Point resPoint = factory.newInstance(x, y);
                        if (vectorLength(p1, p2) > vectorLength(p1, resPoint)
                                && vectorLength(p2, p1) > vectorLength(p2, resPoint)
                                && vectorLength(p3, p4) > vectorLength(p3, resPoint)
                                && vectorLength(p4, p3) > vectorLength(p4, resPoint)) {
                            resultPoints.add(resPoint);
                        }
                    }
                }
            }
        }
        for (Point point : points2) {
            if (isInTriangle(firstPoint1, firstPoint2, firstPoint3, point)
                    || isInTriangle(firstPoint1, firstPoint3, firstPoint4, point)) {
                resultPoints.add(point);
            }
        }
        for (Point point : points1) {
            if (isInTriangle(secondPoint1, secondPoint2, secondPoint3, point)
                    || isInTriangle(secondPoint1, secondPoint3, secondPoint4, point)) {
                resultPoints.add(point);
            }
        }
        return calculateArea(resultPoints);
    }
}
