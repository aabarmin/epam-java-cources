package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Line, determined by two points.
 */
public class Line {
    private Point first;
    private Point second;

    public Line(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Get first point.
     * @return coordinates of first point
     */
    public Point getFirst() {
        return first;
    }

    /**
     * Get second point.
     * @return coordinates of first point
     */
    public Point getSecond() {
        return second;
    }

    /**
     * Get point of in which two line intersect.
     * We use class Optional because lines may have no intersections.
     * @param first first point
     * @param second second point
     * @return point of intersections
     */
    public static Optional<Point> getLinesIntersection(Line first, Line second) {
        double firstX = first.getSecond().getX() - first.getFirst().getX();
        double secondX = second.getSecond().getX() - second.getFirst().getX();
        double firstY = first.getSecond().getY() - first.getFirst().getY();
        double secondY = second.getSecond().getY() - second.getFirst().getY();;
        if (firstX == 0 && secondX == 0 || firstY == 0 && secondY == 0) {
            return Optional.empty();
        }
        final double firstZ = first.getSecond().getX() * first.getFirst().getY()
                - first.getFirst().getX() * first.getSecond().getY();
        final double secondZ = second.getSecond().getX() * second.getFirst().getY()
                - second.getFirst().getX() * second.getSecond().getY();
        double abscissa;
        double ordinate;
        if (firstX == 0) {
            abscissa = -firstZ / firstY;
            ordinate = (secondY * abscissa + secondZ) / secondX;
        } else if (secondX == 0) {
            abscissa = -secondZ / secondY;
            ordinate = (firstY * abscissa + firstZ) / firstX;
        } else {
            final double ratio = firstX / secondX;
            abscissa = (firstZ - ratio * secondZ) / (ratio * secondY - firstY);
            ordinate = firstY == 0
                    ? (secondY * abscissa + secondZ) / secondX
                    : (firstY * abscissa + firstZ) / firstX;
        }
        if (Double.isFinite(abscissa) && Double.isFinite(ordinate)
                && !Double.isNaN(abscissa) && !Double.isNaN(ordinate)) {
            return Optional.of(new PointImpl(abscissa, ordinate));
        }
        return Optional.empty();
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
     * Build equilateral triangle, using given side
     * and return list of its two possible variants of vertex
     * not included in given side.
     * @param base base of triangle
     * @return two possible vertices
     */
    public static List<Point> buildEquilateralTriangle(Line base) {
        double x1 = (base.getFirst().getX() + base.getSecond().getX()
                + Math.sqrt(3) * (base.getFirst().getY() - base.getFirst().getY())) / 2;
        double x2 = (base.getFirst().getX() + base.getSecond().getX()
                - Math.sqrt(3) * (base.getFirst().getY() - base.getSecond().getY())) / 2;
        double y1 = (base.getFirst().getY() + base.getSecond().getY()
                - Math.sqrt(3) * (base.getFirst().getX() - base.getSecond().getX())) / 2;
        double y2 = (base.getFirst().getY() + base.getSecond().getY()
                + Math.sqrt(3) * (base.getFirst().getX() - base.getSecond().getX())) / 2;
        List<Point> result = new ArrayList<>(2);
        result.add(new PointImpl(x1, y1));
        result.add(new PointImpl(x2, y2));
        return result;
    }

    /**
     * Compute angle between two lines.
     * @param first first line
     * @param second second line
     * @return angle
     */
    public static double angle(Line first, Line second) {
        Point startPoint = first.getFirst();
        Point endPoint = second.getFirst();
        if (first.getFirst() == second.getFirst() || first.getFirst() == second.getSecond()) {
            startPoint = first.getSecond();
        }
        if (second.getFirst() == first.getFirst() || second.getFirst() == first.getSecond()) {
            endPoint = second.getSecond();
        }
        Line third = new Line(startPoint, endPoint);
        double result;
        result = Math.acos(
                (Math.pow(first.length(), 2) + Math.pow(second.length(), 2)
                        - Math.pow(third.length(), 2)) / (2 * first.length() * second.length()));
        return  result;
    }
}
