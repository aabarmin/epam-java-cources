package com.epam.university.java.core.task015;

import java.util.Optional;

/**
 * Created by Александр on 24.09.2017.
 * Fields first and second contains points of line segment
 * first the point with low x
 */
public class LineSegment {
    private Point first;
    private Point second;

    public LineSegment(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Get intersection Point of two line segments.
     *
     * @param first     line segment to intersection.
     * @param second    line segment to intersection.
     * @return point
     */
    public static Optional<Point> intersectionPoint(LineSegment first, LineSegment second) {
        double thisCoefficientA = first.getFirst().getY() - first.getSecond().getY();
        double thisCoefficientB = first.getSecond().getX() - first.getFirst().getX();
        double anotherCoefficientA = second.getFirst().getY() - second.getSecond().getY();
        double anotherCoefficientB = second.getSecond().getX() - second.getFirst().getX();

        double determinant = thisCoefficientA * anotherCoefficientB
                - anotherCoefficientA * thisCoefficientB;
        if (determinant != 0) {
            double thisCoefficientC = first.getSecond().getY() * first.getFirst().getX()
                    - first.getSecond().getX() * first.getFirst().getY();
            double anotherCoefficientC = second.getSecond().getY() * second.getFirst().getX()
                    - second.getSecond().getX() * second.getFirst().getY();

            double resultX = (thisCoefficientB * anotherCoefficientC
                    - anotherCoefficientB * thisCoefficientC)
                    / determinant;
            double resultY = (anotherCoefficientA * thisCoefficientC
                    - thisCoefficientA * anotherCoefficientC)
                    / determinant;

            Point thisA = first.getFirst();
            Point thisB = first.getSecond();
            Point anotherA = second.getFirst();
            Point anotherB = second.getSecond();
            if (resultX >= Math.min(thisA.getX(), thisB.getX())
                    && resultX <= Math.max(thisA.getX(), thisB.getX())
                    && resultY >= Math.min(thisA.getY(), thisB.getY())
                    && resultY <= Math.max(thisA.getY(), thisB.getY())
                    && resultX >= Math.min(anotherA.getX(), anotherB.getX())
                    && resultX <= Math.max(anotherA.getX(), anotherB.getX())
                    && resultY >= Math.min(anotherA.getY(), anotherB.getY())
                    && resultY <= Math.max(anotherA.getY(), anotherB.getY())) {
                return Optional.of(new PointImpl(resultX, resultY));
            } else {
                return Optional.empty();
            }


        } else {
            return Optional.empty();
        }
    }

    /**
     * Calculate length of the line.
     * @return line length
     */
    public  double length() {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2)
                + Math.pow(second.getY() - first.getY(), 2)
        );
    }

    /**
     * Angle between two lines.
     * @param first first line segment
     * @param second second line segment
     * @return angle
     */
    public static double angle(LineSegment first, LineSegment second) {
        Point startPoint = first.getFirst();
        Point endPoint = second.getFirst();
        if (first.getFirst() == second.getFirst() || first.getFirst() == second.getSecond()) {
            startPoint = first.getSecond();
        }
        if (second.getFirst() == first.getFirst() || second.getFirst() == first.getSecond()) {
            endPoint = second.getSecond();
        }
        LineSegment third = new LineSegment(startPoint, endPoint);
        double result;
        result = Math.acos(
                (Math.pow(first.length(), 2) + Math.pow(second.length(), 2)
                        - Math.pow(third.length(), 2)) / (2 * first.length() * second.length()));
        return  result;
    }

    /**
     * Get first point of LineSegment.
     * @return point
     */
    public Point getFirst() {
        return first;
    }

    /**
     * Get first point of LineSegment.
     * @return point
     */
    public Point getSecond() {
        return second;
    }
}
