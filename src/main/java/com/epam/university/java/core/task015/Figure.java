package com.epam.university.java.core.task015;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by ilya on 16.09.17.
 */
public class Figure {

    private List<DoublePoint> points;
    private List<LineSegment> lineSegments;

    /**
     * Figure constructor.
     * @param points figure points
     */
    public Figure(List<DoublePoint> points) {
        this.points = new LinkedList<>();
        for (DoublePoint point :
            points) {
            this.points.add(point);
        }
        this.lineSegments = new LinkedList<>();

        roundIteration(this.lineSegments, this.points,
            (p1, p2) -> (new LineSegment(p1, p2)));

    }

    /**
     * Getter for points.
     * @return list of points
     */
    public List<DoublePoint> getPoints() {
        return points;
    }

    private double getArea() {
        return Math.abs(lineSegments.stream().mapToDouble(
            l -> l.getFirst().getX() * l.getSecond().getY() - l.getFirst().getY() * l.getSecond()
                .getX()).sum() / 2);
    }

    /**
     * Check that point in figure.
     * @param point point for checking
     * @return true - include, false - not include
     */
    public boolean includes(DoublePoint point) {

        double area = lineSegments.stream().mapToDouble(l -> {
            List<DoublePoint> points = new LinkedList<>();
            Collections.addAll(points, point, l.getFirst(), l.getSecond());
            return new Figure(points).getArea();
        }).sum();

        return area == this.getArea();
    }

    private <T, E> void roundIteration(Collection<? super E> result,
        Collection<? extends T> collection, BiFunction<T, T, E> function) {
        Iterator<? extends T> iterator = collection.iterator();
        T last = iterator.next();
        T first = last;
        do {
            if (iterator.hasNext()) {
                T current = iterator.next();
                result.add(function.apply(last, current));
                last = current;
            } else {
                result.add(function.apply(last, first));
                break;
            }
        } while (true);
    }


}
