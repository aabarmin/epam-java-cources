package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Squares and areas.
 */
public class Task015Impl implements Task015 {

    /**
     * Returns area of intersection of two squares. Squares are defined as two
     * opposite points in 2-dimensional area.
     * <p>
     *     Example:
     *          square 1 = (2, 2) and (4, 4)
     *          square 2 = (3, 3) and (5, 5)
     *          area is 1 = square (3, 3) and (4, 4)
     * </p>
     * <p>
     *     Area of any polygon with sorted vertices:
     *          ((x1 * y2 - x2 * y1) + ... + (xn * y1 - x1 * yn)) / 2
     * </p>
     * @param first first square definition
     * @param second second square definition
     * @return value of area
     */
    @Override
    public double getArea(Square first, Square second) {
        ArrayList<Point> intersectionPoints =
            (ArrayList<Point>) computeIntersectionPoints(first, second);
        double doubleArea = 0.0D;
        for (int i = 0; i < intersectionPoints.size(); ++i) {
            doubleArea += intersectionPoints.get(i).getX()
                * intersectionPoints.get((i + 1) % intersectionPoints.size()).getY()
                - intersectionPoints.get(i).getY()
                * intersectionPoints.get((i + 1) % intersectionPoints.size()).getX();
        }
        return doubleArea / 2;
    }

    /**
     * Takes two opposite points of the square and computes two other points.
     * @param square Square instance
     * @return list of 4 points sorted clock-wise
     */
    private List<Point> computeVertices(Square square) {
        Point min;
        Point max;
        if (square.getFirst().getX() >= square.getSecond().getX()
            && square.getFirst().getY() >= square.getSecond().getY()) {
            min = square.getSecond();
            max = square.getFirst();
        } else {
            min = square.getFirst();
            max = square.getSecond();
        }
        double centerX = (double) (min.getX() + max.getX()) / 2;
        double centerY = (double) (min.getY() + max.getY()) / 2;
        double halfDiagonalX = (double) (min.getX() - max.getX()) / 2;
        double halfDiagonalY = (double) (min.getY() - max.getY()) / 2;
        ArrayList<Point> vertices = new ArrayList<>(Arrays.asList(
            min,
            max,
            new PointImpl((int) (centerX - halfDiagonalY), (int) (centerY + halfDiagonalX)),
            new PointImpl((int) (centerX + halfDiagonalY), (int) (centerY - halfDiagonalX))
        ));
        sortPoints(vertices);
        return vertices;
    }

    /**
     * Computes vertices of the squares intersection and sorts it clock-wise.
     * @param first first square
     * @param second second square
     * @return list of vertices
     */
    private List<Point> computeIntersectionPoints(Square first, Square second) {
        ArrayList<Point> firstVertices = (ArrayList<Point>) computeVertices(first);
        ArrayList<Point> secondVertices = (ArrayList<Point>) computeVertices(second);

        // list of intersection points for every line of the first square and every
        // line of the second square
        List<Optional<Point>> ops = new LinkedList<>();
        for (int i = 0; i < firstVertices.size(); ++i) {
            for (int j = 0; j < secondVertices.size(); ++j) {
                ops.add(
                    computeLinesIntersectionPoint(
                        firstVertices.get(i),
                        firstVertices.get((i + 1) % firstVertices.size()),
                        secondVertices.get(j),
                        secondVertices.get((j + 1) % secondVertices.size())
                    )
                );
            }
        }
        // set of squares intersection vertices (avoids duplicates)
        Set<Point> vertices = ops.stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .filter(
                p -> containsPoint(
                    p,
                    firstVertices.get(0),  // point A
                    firstVertices.get(1),  // point B
                    firstVertices.get(3))) // point D
            .filter(
                p -> containsPoint(
                    p,
                    secondVertices.get(0),
                    secondVertices.get(1),
                    secondVertices.get(3)))
            .collect(Collectors.toSet());
        // add all vertices of the first square that are inside of the second square
        vertices.addAll(
            firstVertices.stream()
                .filter(
                    p -> containsPoint(
                        p,
                        secondVertices.get(0),
                        secondVertices.get(1),
                        secondVertices.get(3)))
                .collect(Collectors.toList())
        );
        // add all vertices of the second square that are inside of the first square
        vertices.addAll(
            secondVertices.stream()
                .filter(
                    p -> containsPoint(
                        p,
                        firstVertices.get(0),
                        firstVertices.get(1),
                        firstVertices.get(3)))
                .collect(Collectors.toList())
        );
        // collect and sort vertices clock-wise
        ArrayList<Point> verticesList = new ArrayList<>(vertices);
        sortPoints(verticesList);
        return verticesList;
    }

    /**
     * Computes intersection point of the two lines.
     * <p>
     *     line equations: a*y = k*x + b
     * </p>
     * @param firstStart start point of the first line
     * @param firstEnd end point of the first line
     * @param secondStart start point of the second line
     * @param secondEnd end point of the second line
     * @return intersection point if exists in integral coordinates
     */
    private Optional<Point> computeLinesIntersectionPoint(Point firstStart, Point firstEnd,
                                                          Point secondStart, Point secondEnd) {
        final double firstA = firstEnd.getX() - firstStart.getX();
        final double secondA = secondEnd.getX() - secondStart.getX();
        final double firstK = firstEnd.getY() - firstStart.getY();
        final double secondK = secondEnd.getY() - secondStart.getY();
        if (firstA == 0 && secondA == 0 || firstK == 0 && secondK == 0) {
            return Optional.empty();
        }
        final double firstB = firstEnd.getX() * firstStart.getY()
            - firstStart.getX() * firstEnd.getY();
        final double secondB = secondEnd.getX() * secondStart.getY()
            - secondStart.getX() * secondEnd.getY();
        double x;
        double y;
        if (firstA == 0) {
            x = -firstB / firstK;
            y = (secondK * x + secondB) / secondA;
        } else if (secondA == 0) {
            x = -secondB / secondK;
            y = (firstK * x + firstB) / firstA;
        } else {
            final double ratio = firstA / secondA;
            x = (firstB - ratio * secondB) / (ratio * secondK - firstK);
            y = firstK == 0
                ? (secondK * x + secondB) / secondA
                : (firstK * x + firstB) / firstA;
        }
        if (Double.isFinite(x) && Double.isFinite(y) && !Double.isNaN(x) && !Double.isNaN(y)
            && (x % 1) == 0 && (y % 1) == 0) { // not NaN, not Infinity and integral
            return Optional.of(new PointImpl((int) x, (int) y));
        }
        return Optional.empty();
    }

    /**
     * Sorts points clock-wise.
     * <p>
     *     Calculates centroid point and uses angle between point and centroid
     * </p>
     * @param points list of points to sort
     */
    private void sortPoints(List<Point> points) {
        double centroidX = 0.0D;
        double centroidY = 0.0D;
        for (Point p : points) {
            centroidX += p.getX();
            centroidY += p.getY();
        }
        final int size = points.size();
        centroidX /= size;
        centroidY /= size;

        final double finalCentroidY = centroidY;
        final double finalCentroidX = centroidX;
        points.sort(Comparator.comparingDouble(
            p -> Math.atan2(p.getY() - finalCentroidY, p.getX() - finalCentroidX)
        ));
    }

    /**
     * Checks if square contains given point.
     *
     * <p>Let's say a square looks like this:
     *     A-----B
     *     |     |
     *     |   P |
     *     D-----C
     *     (positions of the points may be different but
     *     the ordering must be kept)
     *     <p>
     *         if 0 <= AP * AB <= AB * AB
     *         and 0 <= AP * AD <= AD * AD
     *         where AP - vector, AP * AD -
     *         scalar product of vectors
     *         then square contains a point
     *     </p>
     * </p>
     * @param p point to check
     * @param a point A of the square
     * @param b point B of the square
     * @param d point D of the square
     * @return if square contains a point
     */
    private boolean containsPoint(Point p, Point a, Point b, Point d) {
        final Point apLen = vectorLength(a, p);
        final Point abLen = vectorLength(a, b);
        final Point adLen = vectorLength(a, d);
        final int abProd = scalarProduct(apLen, abLen);
        final int adProd = scalarProduct(apLen, adLen);
        return 0 <= abProd && abProd <= scalarProduct(abLen, abLen)
            && 0 <= adProd && adProd <= scalarProduct(adLen, adLen);
    }

    /**
     * Computes length of given vector.
     * @param a start point of the vector
     * @param b end point of the vector
     * @return length
     */
    private Point vectorLength(Point a, Point b) {
        return new PointImpl(b.getX() - a.getX(), b.getY() - a.getY());
    }

    /**
     * Computes scalar product of two vectors.
     * @param a first vector length
     * @param b second vector length
     * @return scalar product
     */
    private int scalarProduct(Point a, Point b) {
        return a.getX() * b.getX() + a.getY() * b.getY();
    }

}
