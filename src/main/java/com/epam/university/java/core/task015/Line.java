package com.epam.university.java.core.task015;

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
        if (!Double.isNaN(abscissa) && !Double.isNaN(ordinate)
                && Double.isFinite(abscissa) && Double.isFinite(ordinate)
                && (abscissa % 1) == 0 && (ordinate % 1) == 0) {
            return Optional.of(new PointImpl(abscissa, ordinate));
        }
        return Optional.empty();
    }
}
