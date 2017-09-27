package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.List;

/**
 * Geometry static methods.
 */
public class Geometry {

    /**
     * Get all square points by given square defined as two opposite points in 2-dimensional area.
     * All points ordered clockwise;
     *
     * @param square square defined as two opposite points in 2-dimensional area
     *
     * @return list of 4 square points ordered clockwise
     */
    public static List<Point> getAllSquarePoints(Square square) {

        List<Point> squarePoints = new ArrayList<>();

        squarePoints.add(square.getFirst());
        squarePoints.add(square.getSecond());

        Point midPoint = new PointImpl(
                (square.getFirst().getX() + square.getSecond().getX()) / 2.0,
                (square.getFirst().getY() + square.getSecond().getY()) / 2.0
        );


        double x = (square.getFirst().getX() - square.getSecond().getX()) / 2.0;
        double y = - (square.getFirst().getY() - square.getSecond().getY()) / 2.0;

        squarePoints.add(new PointImpl(midPoint.getX() - y, midPoint.getY() - x));
        squarePoints.add(new PointImpl(midPoint.getX() + y, midPoint.getY() + x));

        squarePoints = getClockwiseOrderedPolygonPoints(squarePoints);

        return squarePoints;

    }

    /**
     * Get all squares intersection points.
     *
     * @param firstSquarePoints all points of first square
     * @param secondSquarePoints all points of second square
     *
     * @return list of all intersection points
     */
    public static List<Point> getSquaresIntersectionPoints(List<Point> firstSquarePoints,
                                                           List<Point> secondSquarePoints) {

        List<Point> intersectionPoints = new ArrayList<>();

        for (int i = 0; i < firstSquarePoints.size(); i++) {

            Point a = firstSquarePoints.get(i);
            Point b = firstSquarePoints.get(i == firstSquarePoints.size() - 1 ? 0 : i + 1);

            for (int j = 0; j < secondSquarePoints.size(); j++) {

                Point c = secondSquarePoints.get(j);
                Point d = secondSquarePoints.get(j == secondSquarePoints.size() - 1 ? 0 : j + 1);

                Point z = getLinesIntersectionPoint(a, b, c, d);

                if (z == null) {
                    continue;
                }

                if (z.getX() < Math.min(a.getX(), b.getX())
                        || z.getX() <  Math.min(c.getX(), d.getX())
                        || z.getX() >  Math.max(a.getX(), b.getX())
                        || z.getX() >  Math.max(c.getX(), d.getX())
                        || z.getY() <  Math.min(a.getY(), b.getY())
                        || z.getY() <  Math.min(c.getY(), d.getY())
                        || z.getY() >  Math.max(a.getY(), b.getY())
                        || z.getY() >  Math.max(c.getY(), d.getY())) {

                    continue;

                }

                intersectionPoints.add(z);

            }

        }

        return intersectionPoints;

    }

    /**
     * Get points that are inside of the square.
     *
     * @param squarePoints square
     * @param pointsToCheck all points of second square
     *
     * @return list of all points that are inside of the square
     */
    public static List<Point> getSquareInternalPoints(List<Point> squarePoints,
                                                      List<Point> pointsToCheck) {

        List<Point> internalPoints = new ArrayList<>();

        for (Point point : pointsToCheck) {
            if (pointInsidePolygon(point, squarePoints)) {
                internalPoints.add(point);
            }
        }

        return internalPoints;

    }

    /**
     * Check point is inside polygon or not.
     *
     * @param pointToCheck point to check
     * @param polygonPoints points of polygon
     *
     * @return true if point inside polygon and false if not
     */
    public static boolean pointInsidePolygon(Point pointToCheck, List<Point> polygonPoints) {

        boolean result = false;

        for (int i = 0, j = polygonPoints.size() - 1; i < polygonPoints.size(); j = i++) {
            if ((polygonPoints.get(i).getY() > pointToCheck.getY())
                    != (polygonPoints.get(j).getY() > pointToCheck.getY())
                    && (pointToCheck.getX()
                        < (polygonPoints.get(j).getX() - polygonPoints.get(i).getX())
                            * (pointToCheck.getY() - polygonPoints.get(i).getY())
                            /  (polygonPoints.get(j).getY() - polygonPoints.get(i).getY())
                            + polygonPoints.get(i).getX()
                        )
            ) {
                result = !result;
            }
        }

        return result;

    }

    /**
     * Get lines intersection point.
     *
     * @param a first point of first line
     * @param b second point of first line
     * @param c first point of second line
     * @param d second point of second line
     *
     * @return intersection point
     */
    public static Point getLinesIntersectionPoint(Point a, Point b, Point c, Point d) {

        // Line AB represented as a1x + b1y = c1
        double a1 = b.getY() - a.getY();
        double b1 = a.getX() - b.getX();
        double c1 = a1 * (a.getX()) + b1 * (a.getY());

        // Line CD represented as a2x + b2y = c2
        double a2 = d.getY() - c.getY();
        double b2 = c.getX() - d.getX();
        double c2 = a2 * (c.getX()) + b2 * (c.getY());

        double determinant = a1 * b2 - a2 * b1;

        // The lines are parallel.
        if (determinant == 0) {
            return null;
        }

        double x = (b2 * c1 - b1 * c2) / determinant;
        double y = (a1 * c2 - a2 * c1) / determinant;

        return new PointImpl(x, y);

    }

    /**
     * Calculates the angle (in radians) between two vectors pointing outward from one center.
     *
     * @param a first point
     * @param b second point
     * @param center center point
     */
    public static double getAngle(Point a, Point b, Point center) {

        double aToCenter = Math.sqrt(Math.pow(center.getX() - a.getX(), 2)
                + Math.pow(center.getY() - a.getY(), 2));

        double bToCenter = Math.sqrt(Math.pow(center.getX() - b.getX(), 2)
                + Math.pow(center.getY() - b.getY(), 2));

        double aToB = Math.sqrt(Math.pow(b.getX() - a.getX(), 2)
                + Math.pow(b.getY() - a.getY(), 2));

        return Math.acos(
                (bToCenter * bToCenter + aToCenter * aToCenter - aToB * aToB)
                        / (2 * bToCenter * aToCenter)
        );

    }

    /**
     * Get clockwise ordered polygon points.
     *
     * @param polygonPoints point of polygon in any order
     *
     * @return clockwise ordered polygon points
     */
    public static List<Point> getClockwiseOrderedPolygonPoints(List<Point> polygonPoints) {

        polygonPoints = new ArrayList<>(polygonPoints);

        // Find initial point with min x and y
        Point initialPoint = polygonPoints.get(0);

        for (int i = 1; i < polygonPoints.size(); i++) {
            if (polygonPoints.get(i).getX() < initialPoint.getX()) {
                initialPoint = polygonPoints.get(i);
            } else if (polygonPoints.get(i).getX() == initialPoint.getX()) {
                if (polygonPoints.get(i).getY() < initialPoint.getY()) {
                    initialPoint = polygonPoints.get(i);
                }
            }
        }

        polygonPoints.remove(initialPoint);

        List<Point> clockwiseOrderedPolygonPoints = new ArrayList<>(polygonPoints.size());
        clockwiseOrderedPolygonPoints.add(initialPoint);

        //  Find 2 polygonPoints with max angle to initial vertex
        Point center = polygonPoints.get(0);
        Point finish = polygonPoints.get(0);
        double maxAngle = 0;

        for (int i = 0; i < polygonPoints.size(); i++) {

            for (int k = 0; k < polygonPoints.size(); k++) {

                if (polygonPoints.get(i) == polygonPoints.get(k)) {
                    continue;
                }

                double angle = getAngle(polygonPoints.get(i), polygonPoints.get(k), initialPoint);

                if (angle > maxAngle) {
                    maxAngle = angle;
                    center = polygonPoints.get(i);
                    finish = polygonPoints.get(k);
                }

            }

        }

        // for clockwise order
        if (center.getY() < finish.getY()) {
            Point tempPoint = finish;
            finish = center;
            center = tempPoint;
        }

        polygonPoints.remove(center);
        clockwiseOrderedPolygonPoints.add(center);

        // let's go through the figure boundary
        Point a = initialPoint;
        Point b = initialPoint;

        while (center != finish) {

            maxAngle = 0;

            for (Point point : polygonPoints) {
                double angle = getAngle(a, point, center);
                if (angle > maxAngle) {
                    maxAngle = angle;
                    b = point;
                }
            }

            a = center;
            center = b;
            polygonPoints.remove(center);
            clockwiseOrderedPolygonPoints.add(center);

        }

        return clockwiseOrderedPolygonPoints;

    }

}
