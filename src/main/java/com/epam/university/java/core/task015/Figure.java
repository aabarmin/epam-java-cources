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


    public Figure(List<DoublePoint> points) {
        this.points = new LinkedList<>();
        for (DoublePoint point :
            points) {
            this.points.add(new Vertex(point));
        }
        this.lineSegments = new LinkedList<>();

        roundIteration(this.lineSegments, this.points,
            (p1, p2) -> (new LineSegment(p1.getElement(), p2.getElement())));

    }

    public Figure() {
        this.points = new LinkedList<>();
    }

    public static void main(String[] args) {

    }

    public List<DoublePoint> getPoints() {
        List<DoublePoint> doublePoints = points.stream().map(p -> p.getElement())
            .collect(Collectors.toList());
        return doublePoints;
    }

    public List<Vertex> getVertex(){
        return points;
    }

    public void addPoint(int i, DoublePoint point) {
        points.add(i, new Vertex(point));
    }

    public void addPoint(DoublePoint point) {
        points.add(new Vertex(point));
    }

    public List<LineSegment> getLineSegments() {
        return lineSegments;
    }

    public double getArea() {
        return Math.abs(lineSegments.stream().mapToDouble(
            l -> l.getFirst().getX() * l.getSecond().getY() - l.getFirst().getY() * l.getSecond()
                .getX()).sum() / 2);
    }

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
