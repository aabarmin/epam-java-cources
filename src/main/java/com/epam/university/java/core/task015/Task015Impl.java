package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Romin Nuro on 31.08.2020 23:17.
 */
public class Task015Impl implements Task015 {
    public static final PointFactory pointFactory = new PointFactoryImpl();
    public static final SquareFactory squareFactory = new SquareFactoryImpl();

    /**
     * Get area of intersection of two squares. Squares are defined as two
     * opposite points in 2-dimensional area.
     *
     * <p>
     * Example:
     * square 1 = (2, 2) and (4, 4)
     * square 2 = (3, 3) and (5, 5)
     * area is 1 = square (3, 3) and (4, 4)
     * </p>
     * <p>
     * Tip: paint it in the notebook.
     * </p>
     *
     * @param first  first square definition
     * @param second second square definition
     * @return value of area
     */
    @Override
    public double getArea(Square first, Square second) {
        List<Point> intersectionVertexes = new ArrayList<>();
        List<Point> firstSquare = getAllVertexes(first);
        List<Point> secondSquare = getAllVertexes(second);
        for (Point point : firstSquare) {
            if (isInsidePolygon(point, secondSquare)) {
                intersectionVertexes.add(point);
            }
        }
        for (Point point : secondSquare) {
            if (isInsidePolygon(point, firstSquare)) {
                intersectionVertexes.add(point);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Point startFirst = firstSquare.get(i);
                Point endFirst = firstSquare.get((i + 1) % 4);
                Point startSecond = secondSquare.get(j);
                Point endSecond = secondSquare.get((j + 1) % 4);
                Point intersection = getIntersection(startFirst, endFirst, startSecond, endSecond);
                if (intersection != null) {
                    intersectionVertexes.add(intersection);
                }
            }
        }

        intersectionVertexes.sort(new PointsComparatorClockwise(intersectionVertexes));
        double result = 0;
        for (int i = 1; i < intersectionVertexes.size() - 1; i++) {
            result += getTriangleArea(intersectionVertexes.get(0),
                    intersectionVertexes.get(i),
                    intersectionVertexes.get(i + 1));
        }
        return result;
    }

    /**
     * Method for getting all four vertexes of square as list.
     * @param square the given square with two opposite points
     * @return list of points
     */
    public static List<Point> getAllVertexes(Square square) {
        List<Point> points = new ArrayList<>();
        // a, b, c, d are vertexes of the square
        Point a = square.getFirst();
        Point c = square.getSecond();
        double ax = a.getX();
        double ay = a.getY();
        double cx = c.getX();
        double cy = c.getY();
        // finding vector from first point to the center
        double vectorX = (cx - ax) / 2;
        double vectorY = (cy - ay) / 2;
        // finding center coordinates
        double centerX = (ax + cx) / 2;
        double centerY = (ay + cy) / 2;
        // adding rotated vectors to the central point to find other points
        Point d = pointFactory.newInstance((centerX + vectorY), (centerY - vectorX));
        Point b = pointFactory.newInstance((centerX - vectorY), (centerY + vectorX));
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
        // sorting points clockwise
        points.sort(new PointsComparatorClockwise(points));
        return points;
    }

    /**
     * Method checks if the given point is inside the polygon.
     * @param point point to check
     * @param points list of polygon vertexes
     * @return is the point inside the polygon
     */
    public static boolean isInsidePolygon(Point point, List<Point> points) {
        double firstProduct = 0;
        // checking if the product of vectors from given point to first point
        // and from first point to second point is always positive or always negative
        // it means that the given point is inside the square
        for (int i = 0; i < points.size(); i++) {
            Point first = points.get(i);
            Point second = points.get((i + 1) % points.size());
            Point firstVector = pointFactory
                    .newInstance(first.getX() - point.getX(), first.getY() - point.getY());
            Point secondVector = pointFactory
                    .newInstance(second.getX() - first.getX(), second.getY() - first.getY());
            if (i == 0) {
                firstProduct = multiplyVectors(firstVector, secondVector);
            } else {
                double product = multiplyVectors(firstVector, secondVector);
                if (firstProduct * product < 0) {
                    return false;
                }
            }
        }
        // getting bounds for intersection point
        double minX = points.stream()
                .min(Comparator.comparing(Point::getX)).orElse(points.get(0)).getX();
        double minY = points.stream()
                .min(Comparator.comparing(Point::getY)).orElse(points.get(0)).getY();
        double maxX = points.stream()
                .max(Comparator.comparing(Point::getX)).orElse(points.get(2)).getX();
        double maxY = points.stream()
                .max(Comparator.comparing(Point::getY)).orElse(points.get(2)).getY();
        if (point.getX() >= minX && point.getY() >= minY
                && point.getX() <= maxX && point.getY() <= maxY) {
            return true;
        }
        return false;
    }

    public static double multiplyVectors(Point first, Point second) {
        return first.getX() * second.getY() - second.getX() * first.getY();
    }

    /**
     * Get the point of intersection of two line segments.
     * @param startFirst first point of first segment
     * @param endFirst second point of first segment
     * @param startSecond first point of second segment
     * @param endSecond second point of second segment
     * @return point of intersection
     */
    public static Point getIntersection(Point startFirst,
                                        Point endFirst,
                                        Point startSecond,
                                        Point endSecond) {
        //checking if lines are parallel
        Point firstVector = pointFactory
                .newInstance(endFirst.getX() - startFirst.getX(),
                        endFirst.getY() - startFirst.getY());
        Point secondVector = pointFactory
                .newInstance(endSecond.getX() - startSecond.getX(),
                        endSecond.getY() - startSecond.getY());
        if (multiplyVectors(firstVector, secondVector) == 0) {
            return null;
        }
        double resultX;
        double resultY;
        double x1 = startFirst.getX();
        double y1 = startFirst.getY();
        double x2 = endFirst.getX();
        double y2 = endFirst.getY();
        double x3 = startSecond.getX();
        double y3 = startSecond.getY();
        double x4 = endSecond.getX();
        double y4 = endSecond.getY();
        double k1 = (y2 - y1) / (x2 - x1);
        double b1 = y1 - k1 * x1;
        double k2 = (y4 - y3) / (x4 - x3);
        double b2 = y3 - k2 * x3;
        if (firstVector.getX() == 0) {
            resultX = x1;
            resultY = k2 * x1 + b2;
        } else if (secondVector.getX() == 0) {
            resultX = x3;
            resultY = k1 * x3 + b1;
        } else {
            resultX = (b2 - b1) / (k1 - k2);
            resultY = resultX * k2 + b2;
        }
        Point intersection = pointFactory.newInstance(resultX, resultY);

        if (resultX >= Math.min(x1,x2) && resultX <= Math.max(x1,x2)
                && resultX >= Math.min(x3,x4) && resultX <= Math.max(x3,x4)
                && resultY >= Math.min(y1,y2) && resultY <= Math.max(y1,y2)
                && resultY >= Math.min(y3,y4) && resultY <= Math.max(y3,y4)) {
            return intersection;
        }
        return null;
    }

    /**
     * Get the distance between two points.
     * @param first first point
     * @param second second point
     * @return distance
     */
    public static double getSegmentLength(Point first, Point second) {
        double deltaX = first.getX() - second.getX();
        double deltaY = first.getY() - second.getY();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    /**
     * Calculate the area of the triangle.
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     * @return area
     */
    public static double getTriangleArea(Point p1, Point p2, Point p3) {
        double a = getSegmentLength(p1, p2);
        double b = getSegmentLength(p2, p3);
        double c = getSegmentLength(p3, p1);
        //half perimeter
        double hp = (a + b + c) / 2;
        double area = Math.sqrt(hp * (hp - a) * (hp - b) * (hp - c));
        return area;
    }
}
