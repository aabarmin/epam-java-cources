package com.epam.university.java.core.task015;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.LinkedList;
import java.util.Optional;
import java.util.List;
import java.util.Set;

public class Task015Impl implements Task015 {

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
        double centerX = (min.getX() + max.getX()) / 2;
        double centerY = (min.getY() + max.getY()) / 2;
        double halfDiagonalX = (min.getX() - max.getX()) / 2;
        double halfDiagonalY = (min.getY() - max.getY()) / 2;
        ArrayList<Point> vertices = new ArrayList<>(Arrays.asList(
                min,
                max,
                new PointImpl(centerX - halfDiagonalY, centerY + halfDiagonalX),
                new PointImpl(centerX + halfDiagonalY, centerY - halfDiagonalX)
        ));
        sortPoints(vertices);
        return vertices;
    }


    private List<Point> computeIntersectionPoints(Square first, Square second) {
        ArrayList<Point> firstVertices = (ArrayList<Point>) computeVertices(first);
        ArrayList<Point> secondVertices = (ArrayList<Point>) computeVertices(second);

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
        ArrayList<Point> verticesList = new ArrayList<>(vertices);
        sortPoints(verticesList);
        return verticesList;
    }

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
                && (x % 1) == 0 && (y % 1) == 0) {
            return Optional.of(new PointImpl(x, y));
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
    public static void sortPoints(List<Point> points) {
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

    private boolean containsPoint(Point p, Point a, Point b, Point d) {
        final Point apLen = vectorLength(a, p);
        final Point abLen = vectorLength(a, b);
        final Point adLen = vectorLength(a, d);
        final double abProd = scalarProduct(apLen, abLen);
        final double adProd = scalarProduct(apLen, adLen);
        return 0 <= abProd && abProd <= scalarProduct(abLen, abLen)
                && 0 <= adProd && adProd <= scalarProduct(adLen, adLen);
    }

    private Point vectorLength(Point a, Point b) {
        return new PointImpl(b.getX() - a.getX(), b.getY() - a.getY());
    }

    private double scalarProduct(Point a, Point b) {
        return a.getX() * b.getX() + a.getY() * b.getY();
    }

}