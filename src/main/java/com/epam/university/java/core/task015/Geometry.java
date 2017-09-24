package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.List;

public class Geometry {

    public static List<Point> getAllSquarePoints(Square square) {

        List<Point> squarePoints = new ArrayList<>();

        double leftX = Math.min(square.getFirst().getX(), square.getSecond().getX());
        double rightX = Math.max(square.getFirst().getX(), square.getSecond().getX());
        double topY = Math.max(square.getFirst().getY(), square.getSecond().getY());
        double bottomY = Math.min(square.getFirst().getY(), square.getSecond().getY());

        squarePoints.add(new PointImpl(leftX, bottomY));
        squarePoints.add(new PointImpl(leftX, topY));
        squarePoints.add(new PointImpl(rightX, topY));
        squarePoints.add(new PointImpl(rightX, bottomY));

        if (leftX == rightX) {

            double halfOfHeight = (topY - bottomY) * 0.5;
            double middleY = bottomY + halfOfHeight;
            double x = leftX;

            leftX  = x - halfOfHeight;
            rightX = x + halfOfHeight;

            squarePoints.set(0, new PointImpl(leftX, middleY));
            squarePoints.set(1, new PointImpl(x, topY));
            squarePoints.set(2, new PointImpl(rightX, middleY));
            squarePoints.set(3, new PointImpl(x, bottomY));


        } else if (topY == bottomY) {

            double halfOfLengt = (rightX - leftX) * 0.5;
            double middleX = leftX + halfOfLengt;
            double y = topY;

            topY  = y + halfOfLengt;
            bottomY = y - halfOfLengt;

            squarePoints.set(0, new PointImpl(leftX, y));
            squarePoints.set(1, new PointImpl(middleX, topY));
            squarePoints.set(2, new PointImpl(rightX, y));
            squarePoints.set(3, new PointImpl(middleX, bottomY));

        }

        return squarePoints;

    }

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

                if (z.getX() < Math.min(a.getX(), b.getX()) ||
                        z.getX() <  Math.min(c.getX(), d.getX()) ||
                        z.getX() >  Math.max(a.getX(), b.getX()) ||
                        z.getX() >  Math.max(c.getX(), d.getX()) ||
                        z.getY() <  Math.min(a.getY(), b.getY()) ||
                        z.getY() <  Math.min(c.getY(), d.getY()) ||
                        z.getY() >  Math.max(a.getY(), b.getY()) ||
                        z.getY() >  Math.max(c.getY(), d.getY()))     {

                    continue;

                }

                intersectionPoints.add(z);

            }

        }

        return intersectionPoints;

    }

    public static List<Point> getSquareInternalPoints(List<Point> squarePoints, List<Point> pointsToCheck) {

        List<Point> internalPoints = new ArrayList<>();

        for (Point point : pointsToCheck) {
            if (pointInsidePolygon(point, squarePoints)) {
                internalPoints.add(point);
            }
        }

        return internalPoints;

    }

    public static boolean pointInsidePolygon(Point pointToCheck, List<Point> polygonPoints) {
        
        boolean result = false;
        
        for (int i = 0, j = polygonPoints.size() - 1; i < polygonPoints.size(); j = i++) {
            if ((polygonPoints.get(i).getY() > pointToCheck.getY())
                    != (polygonPoints.get(j).getY() > pointToCheck.getY()) &&
                    (pointToCheck.getX() <
                            (polygonPoints.get(j).getX() - polygonPoints.get(i).getX()) *
                            (pointToCheck.getY() - polygonPoints.get(i).getY()) /
                            (polygonPoints.get(j).getY()-polygonPoints.get(i).getY()) +
                                    polygonPoints.get(i).getX()
                    )
                    ) {
                result = !result;
            }
        }

        return result;        

    }

    public static Point getLinesIntersectionPoint(Point a, Point b, Point c, Point d) {

        // Line AB represented as a1x + b1y = c1
        double a1 = b.getY() - a.getY();
        double b1 = a.getX() - b.getX();
        double c1 = a1*(a.getX()) + b1*(a.getY());

        // Line CD represented as a2x + b2y = c2
        double a2 = d.getY() - c.getY();
        double b2 = c.getX() - d.getX();
        double c2 = a2*(c.getX()) +  b2*(c.getY());

        double determinant = a1*b2 - a2*b1;

        // The lines are parallel.
        if (determinant == 0) {
            return null;
        }

        double x = (b2*c1 - b1*c2) / determinant;
        double y = (a1*c2 - a2*c1) / determinant;

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

        double aToCenter = Math.sqrt(Math.pow(center.getX() - a.getX(), 2) +
                Math.pow(center.getY() - a.getY(), 2));

        double bToCenter = Math.sqrt(Math.pow(center.getX() - b.getX(), 2) +
                Math.pow(center.getY() - b.getY(), 2));

        double aToB = Math.sqrt(Math.pow(b.getX() - a.getX(), 2)+
                Math.pow(b.getY() - a.getY(), 2));

        return Math.acos(
                (bToCenter * bToCenter + aToCenter * aToCenter - aToB * aToB) /
                        (2 * bToCenter * aToCenter)
        );

    }

    public static List<Point> getClockwiseOrderedPolygonPoints(List<Point> polygonPoints) {

        List<Point> clockwiseOrderedPolygonPoints = new ArrayList<>(polygonPoints.size());
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
