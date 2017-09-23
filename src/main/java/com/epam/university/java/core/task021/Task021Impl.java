package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;
import com.epam.university.java.core.task015.Task015Impl;
import com.epam.university.java.core.util.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Fermat–Torricelli point.
 */
public class Task021Impl implements Task021 {

    /**
     * <p>
     *     There are three mines, position of each is in <code>minePositions</code> collection.
     *     You should determine coordinates of the city which will have a factory. It's better
     *     to have the shortest distance between mines and city.
     * </p>
     *
     * @param minePositions mines positions
     * @return city position
     */
    @Override
    public Point calculate(Collection<Point> minePositions) {

        if (minePositions == null || minePositions.size() != 3) {
            throw new IllegalArgumentException();
        }
        minePositions.forEach(Utils::assertNonNull);

        final ArrayList<Point> positions = new ArrayList<>(minePositions);
        Task015Impl.sortPoints(positions); // sort points clock-wise

        final Point a = positions.get(0);
        final Point b = positions.get(1);
        final Point c = positions.get(2);

        final double abDist = distance(a, b);
        final double acDist = distance(a, c);
        final double bcDist = distance(b, c);

        // if we have an angle >= 120 degrees, than Fermat point is
        // the vertex with such angle
        if (angle(bcDist, acDist, abDist) >= 2 * Math.PI / 3) {
            return a;
        }
        if (angle(acDist, abDist, bcDist) >= 2 * Math.PI / 3) {
            return b;
        }
        if (angle(abDist, bcDist, acDist) >= 2 * Math.PI / 3) {
            return c;
        }

        // arrays of two possible third vertices for equilateral triangle
        // built on the side of the initial triangle
        final Point[] abs = thirdVerticesOfEquilateralTriangle(a, b);
        final Point[] acs = thirdVerticesOfEquilateralTriangle(a, c);
        final Point[] bcs = thirdVerticesOfEquilateralTriangle(b, c);

        // array of intersection points for every line from third vertex defined
        // above to the opposite vertex of the initial triangle
        final ArrayList<Optional<Point>> intersectionPoints = new ArrayList<>();

        intersectionPoints.add(computeLinesIntersectionPoint(abs[0], c, bcs[0], a));
        intersectionPoints.add(computeLinesIntersectionPoint(abs[0], c, bcs[1], a));
        intersectionPoints.add(computeLinesIntersectionPoint(abs[1], c, bcs[0], a));
        intersectionPoints.add(computeLinesIntersectionPoint(abs[1], c, bcs[1], a));

        intersectionPoints.add(computeLinesIntersectionPoint(abs[0], c, acs[0], b));
        intersectionPoints.add(computeLinesIntersectionPoint(abs[0], c, acs[1], b));
        intersectionPoints.add(computeLinesIntersectionPoint(abs[1], c, acs[0], b));
        intersectionPoints.add(computeLinesIntersectionPoint(abs[1], c, acs[1], b));

        intersectionPoints.add(computeLinesIntersectionPoint(acs[0], b, bcs[0], a));
        intersectionPoints.add(computeLinesIntersectionPoint(acs[0], b, bcs[1], a));
        intersectionPoints.add(computeLinesIntersectionPoint(acs[1], b, bcs[0], a));
        intersectionPoints.add(computeLinesIntersectionPoint(acs[1], b, bcs[1], a));

        // each point occurrence count
        Map<Point, Long> ipOccurs = intersectionPoints.stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // since we search for intersection point of three lines, we don't want points
        // with occurrence count less than 3. sort remaining points by sum of distances
        // from it to every vertex of the initial triangle. return min if found
        return ipOccurs.entrySet().stream()
            .filter(e -> e.getValue() >= 3L)
            .map(Map.Entry::getKey)
            .sorted(
                Comparator.comparingDouble(p -> sumOfDistances(p, a, b, c))
            ).findFirst()
            .orElseThrow(RuntimeException::new);

    }

    /**
     * Compute coordinates of two possible vertices of equilateral triangle
     * built on the given side of the initial triangle.
     * @param first first point of the side
     * @param second second point of the side
     * @return both points
     */
    private Point[] thirdVerticesOfEquilateralTriangle(Point first, Point second) {
        double x1 = (first.getX() + second.getX()
            + Math.sqrt(3) * (first.getY() - second.getY())) / 2;
        double x2 = (first.getX() + second.getX()
            - Math.sqrt(3) * (first.getY() - second.getY())) / 2;
        double y1 = (first.getY() + second.getY()
            - Math.sqrt(3) * (first.getX() - second.getX())) / 2;
        double y2 = (first.getY() + second.getY()
            + Math.sqrt(3) * (first.getX() - second.getX())) / 2;
        return new Point[] {
            new PointImpl(x1, y1),
            new PointImpl(x2, y2)
        };
    }

    /**
     * Compute distance between given points.
     * @param p1 first point
     * @param p2 second point
     * @return distance between two points
     */
    private double distance(Point p1, Point p2) {
        return Math.sqrt(
            Math.pow(p2.getX() - p1.getX(), 2)
                + Math.pow(p2.getY() - p1.getY(), 2)
        );
    }

    /**
     * Return angle of the triangle by the side lengths.
     * @param a first side length
     * @param b second side length
     * @param c third side length
     * @return angle between sides b and c
     */
    private double angle(double a, double b, double c) {
        return Math.acos(
            (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c)
        );
    }

    /**
     * Compute sum of the distances from point p to a, b and c.
     * @param p point to check
     * @param a first point
     * @param b second point
     * @param c third point
     * @return sum of the distances
     */
    private double sumOfDistances(Point p, Point a, Point b, Point c) {
        return distance(p, a) + distance(p, b) + distance(p, c);
    }

    /**
     * Compute intersection point of the two lines.
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
        if (Double.isFinite(x) && Double.isFinite(y) && !Double.isNaN(x) && !Double.isNaN(y)) {
            return Optional.of(new PointImpl(x, y));
        }
        return Optional.empty();
    }

}
