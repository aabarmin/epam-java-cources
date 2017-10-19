package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.LineSegment;
import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

/**
 * Created by Александр on 26.09.2017.
 * Fermat–Torricelli point.
 */
public class Task021Impl implements Task021 {
    /**
     * <p>
     * There are three mines, position of each is in <code>minePositions</code> collection.
     * You should determine coordinates of the city which will have a factory. It's better
     * to have the shortest distance between mines and city.
     * </p>
     * <p>
     * Example:
     * </p>
     *
     * @param minePositions mines positions
     * @return city city position
     */
    @Override
    public Point calculate(Collection<Point> minePositions) {
        ArrayList<Point> positions = new ArrayList<>(minePositions);

        PointImpl.orderPoints(positions);

        final Point a = positions.get(0);
        final Point b = positions.get(1);
        final Point c = positions.get(2);

        LineSegment ab = new LineSegment(a, b);
        LineSegment ac = new LineSegment(a, c);
        LineSegment bc = new LineSegment(b, c);

        if (LineSegment.angle(ab, ac) >= 2 * Math.PI / 3) {
            return a;
        }
        if (LineSegment.angle(ab, bc) >= 2 * Math.PI / 3) {
            return b;
        }
        if (LineSegment.angle(bc, ac) >= 2 * Math.PI / 3) {
            return c;
        }

        final List<LineSegment> sc = new ArrayList<>();
        sc.addAll(
                buildEquilateralTriangle(ab).stream()
                        .map((n) -> new LineSegment(n, c))
                        .collect(Collectors.toList()));

        final List<LineSegment> sa = new ArrayList<>();
        sa.addAll(
                buildEquilateralTriangle(bc).stream()
                        .map((n) -> new LineSegment(n, a))
                        .collect(Collectors.toList()));

        final List<LineSegment> sb = new ArrayList<>();
        sb.addAll(
                buildEquilateralTriangle(ac).stream()
                        .map((n) -> new LineSegment(n, b))
                        .collect(Collectors.toList()));

        final ArrayList<Optional<Point>> intersectionPoints = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < 2; i++) {
            intersectionPoints.add(getLinesIntersection(sc.get(i), sa.get(i)));
            intersectionPoints.add(getLinesIntersection(sc.get(i), sb.get(i)));
            intersectionPoints.add(getLinesIntersection(sb.get(i), sa.get(i)));
            intersectionPoints.add(getLinesIntersection(sc.get(i), sa.get(j)));
            intersectionPoints.add(getLinesIntersection(sc.get(i), sb.get(j)));
            intersectionPoints.add(getLinesIntersection(sb.get(i), sa.get(j)));
            j--;
        }

        ToDoubleFunction<Point> toDoubleFunction = (n) ->
                new LineSegment(n, a).length()
                        + new LineSegment(n, b).length()
                        + new LineSegment(n, c).length();

        return intersectionPoints.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() >= 3)
                .map(Map.Entry::getKey)
                .min(Comparator.comparingDouble(toDoubleFunction))
                .get();
    }

    /**
     * Build equilateral triangle, using given side
     * and return list of its two possible variants of vertex
     * not included in given side.
     *
     * @param base base of triangle
     * @return two possible vertices
     */
    public static List<Point> buildEquilateralTriangle(LineSegment base) {
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
     * Get point of in which two line intersect.
     * We use class Optional because lines may have no intersections.
     * @param first first point
     * @param second second point
     * @return point of intersections
     */
    public static Optional<Point> getLinesIntersection(LineSegment first, LineSegment second) {
        double firstX = first.getSecond().getX() - first.getFirst().getX();
        double secondX = second.getSecond().getX() - second.getFirst().getX();
        double firstY = first.getSecond().getY() - first.getFirst().getY();
        double secondY = second.getSecond().getY() - second.getFirst().getY();
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


}
