package com.epam.university.java.core.task015;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by ilya on 16.09.17.
 */
public class Figure {

    private List<Vertex> points;
    private List<LineSegment> lineSegments;

    /**
     * Figure constructor.
     *
     * @param points points of convex polygon
     */
    public Figure(List<Point> points) {
        this.points = new LinkedList<>();
        for (Point point :
            points) {
            this.points.add(new Vertex(point));
        }
        this.lineSegments = new LinkedList<>();

        roundIteration(this.lineSegments, this.points,
            (p1, p2) -> (new LineSegment(p1.getElement(), p2.getElement())));
    }

    /**
     * Get figure's points.
     *
     * @return List of figure's points
     */
    public List<Point> getPoints() {
        List<Point> vertPoints = points.stream().map(p -> p.getElement())
            .collect(Collectors.toList());
        return vertPoints;
    }

    public List<Vertex> getVertex() {
        return points;
    }

    public void addPoint(int i, Point point) {
        points.add(i, new Vertex(point));
    }

    public void addPoint(Point point) {
        points.add(new Vertex(point));
    }

    public List<LineSegment> getLineSegments() {
        return lineSegments;
    }

    /**
     * Calculate figure area.
     *
     * @return figure area
     */
    public double getArea() {
        return Math.abs(lineSegments.stream().mapToDouble(
            l -> l.getFirst().getX() * l.getSecond().getY() - l.getFirst().getY() * l.getSecond()
                .getX()).sum() / 2);
    }

    /**
     * Check if point in figure.
     *
     * @param point point to check
     * @return true - point in figure, false - point not in figure
     */
    public boolean includes(Point point) {

        double area = lineSegments.stream().mapToDouble(l -> {
            List<Point> points = new LinkedList<>();
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
