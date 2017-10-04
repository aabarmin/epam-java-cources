package com.epam.university.java.core.task021;

import static com.epam.university.java.core.task015.Line.angle;
import static com.epam.university.java.core.task015.Line.buildEquilateralTriangle;
import static com.epam.university.java.core.task015.Line.getLinesIntersection;
import static com.epam.university.java.core.task015.PointImpl.orderPoints;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import com.epam.university.java.core.task015.Line;
import com.epam.university.java.core.task015.Point;

public class Task021Impl implements Task021 {

    @Override
    public Point calculate(Collection<Point> minePositions) {

        if (minePositions == null || minePositions.size() != 3) {
            throw new IllegalArgumentException();
        }
        for (Point current : minePositions) {
            if (current == null) {
                throw new IllegalArgumentException();
            }
        }

        final ArrayList<Point> positions = new ArrayList<>(minePositions);

        orderPoints(positions);

        Line ab = new Line(positions.get(0), positions.get(1));
        Line ac = new Line(positions.get(0), positions.get(2));
        Line bc = new Line(positions.get(1), positions.get(2));

        final Point a = positions.get(0);
        final Point b = positions.get(1);
        final Point c = positions.get(2);


        if (angle(ab, ac) >= 2 * Math.PI / 3) {
            return a;
        }
        if (angle(ab, bc) >= 2 * Math.PI / 3) {
            return b;
        }
        if (angle(bc, ac) >= 2 * Math.PI / 3) {
            return c;
        }

        final List<Line> sc = new ArrayList<>();
        sc.addAll(
                buildEquilateralTriangle(ab).stream()
                        .map((n) -> new Line(n, c))
                        .collect(Collectors.toList()));

        final List<Line> sa = new ArrayList<>();
        sa.addAll(
                buildEquilateralTriangle(bc).stream()
                        .map((n) -> new Line(n, a))
                        .collect(Collectors.toList()));

        final List<Line> sb = new ArrayList<>();
        sb.addAll(
                buildEquilateralTriangle(ac).stream()
                        .map((n) -> new Line(n, b))
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
             new Line(n, a).length() + new Line(n, b).length() + new Line(n, c).length();

        Point result = intersectionPoints.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() >= 3)
                .map(Map.Entry::getKey)
                .min(Comparator.comparingDouble(toDoubleFunction))
                .get();
        return result;

    }
}
