package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.LineSegment;
import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Created by ilya on 23.09.17.
 */
public class Task021Impl implements Task021 {

    @Override
    public Point calculate(Collection<Point> minePositions) {
        Map<Double, Point> corners = new HashMap<>();

        roundIterationThree(corners, minePositions,
            (p1, p2, p3) -> (new Corner(p1, p2, p3).getAngle()));

        List<Point> pointList = corners.entrySet().stream()
            .filter(e -> e.getKey() >= 120)
            .map(Entry::getValue)
            .collect(Collectors.toList());

        if (!pointList.isEmpty()) {
            return pointList.get(0);
        }

        Map<Point, Point> rightPoints = new HashMap<>();

        roundIterationThree(
            rightPoints,
            minePositions,
            (p1, p2, p3) -> {
                Point mid = new PointImpl((p2.getX() + p1.getX()) / 2, (p2.getY() + p1.getY()) / 2);
                Vector vector = new Vector(p1, p2);
                LineSegment seg = new LineSegment(p1, p2);
                Point threeLeft =
                    new PointImpl(
                        mid.getX() + vector.normPrepLeft().getCoordX() * vector.getLength()
                            * Math.tan(Math.PI / 3) / 2,
                        mid.getY() + vector.normPrepLeft().getCoordY() * vector.getLength()
                            * Math.tan(Math.PI / 3) / 2
                    );
                Point threeRight =
                    new PointImpl(
                        mid.getX() + vector.normPrepRight().getCoordX() * vector.getLength()
                            * Math.tan(Math.PI / 3) / 2,
                        mid.getY() + vector.normPrepRight().getCoordY() * vector.getLength()
                            * Math.tan(Math.PI / 3) / 2
                    );
                if (seg.isHighter(threeLeft) != seg.isHighter(p3)) {
                    return threeLeft;
                } else {
                    return threeRight;
                }
            });

        List<LineSegment> lineSegments = rightPoints.entrySet().stream()
            .map(e -> new LineSegment(e.getKey(), e.getValue()))
            .collect(Collectors.toList());

        Point point = lineSegments.get(0).lineIntersection(lineSegments.get(1));

        return point;
    }

    private <T, E> void roundIterationThree(Map<? super E, T> result,
        Collection<? extends T> collection, ThreeFunction<T, E> function) {
        Iterator<? extends T> iterator = collection.iterator();

        T previouse = null;
        while (iterator.hasNext()) {
            previouse = iterator.next();
        }

        iterator = collection.iterator();
        T last = iterator.next();
        T first = last;
        do {
            if (iterator.hasNext()) {
                T current = iterator.next();
                result.put(function.apply(last, current, previouse), previouse);
                previouse = last;
                last = current;
            } else {
                result.put(function.apply(last, first, previouse), previouse);
                break;
            }
        } while (true);
    }

}
