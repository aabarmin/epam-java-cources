package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

import java.util.Collection;
import java.util.LinkedList;

public class Task021Impl implements Task021 {
    @Override
    public strictfp Point calculate(Collection<Point> minePositions) {
        LinkedList<Point> points = new LinkedList<>();
        points.addAll(minePositions);
        for (int i = 0; i < points.size(); i++) {
            Point pointToCheck = points.removeFirst();
            if (isAngleOver120(pointToCheck, points.getFirst(),
                                            points.getLast())) {
                return pointToCheck;
            }
            points.addLast(pointToCheck);
        }
        Segment segment = new Segment(points.removeFirst(),
                                    points.removeFirst());
        Point pointForRegularTriangle =
                pointForRegularTriangle(segment, points.getFirst());
        LinkedList<Point> regularTriangle = new LinkedList<>();
        regularTriangle.addFirst(pointForRegularTriangle);
        regularTriangle.addFirst(segment.getSecond());
        regularTriangle.addFirst(segment.getFirst());

        Point circleCenter = findCenter(regularTriangle);
        double radius = segment.length() / Math.sqrt(3);

        segment = new Segment(pointForRegularTriangle, points.getFirst());

        return intersection(segment, circleCenter, radius);
    }

    private strictfp Point intersection(Segment segment,
                                        Point circleCenter,
                                        double radius) {
        Point point = new PointImpl();
        double incrementX = segment.deltaX() / segment.length() * 2 * radius
                * segment.sinAngleBetween(
                        new Segment(segment.getFirst(), circleCenter)
                    );
        double incrementY = segment.deltaY() / segment.length() * 2 * radius
                * segment.sinAngleBetween(
                        new Segment(segment.getFirst(), circleCenter)
                    );
        point.setX(segment.getFirst().getX() + incrementX);
        point.setY(segment.getFirst().getY() + incrementY);
        return point;
    }

    private strictfp Point findCenter(Collection<Point> points) {
        Point center = new PointImpl();
        double x = 0;
        double y = 0;
        for (Point point : points) {
            x += point.getX();
            y += point.getY();
        }
        center.setX(x / points.size());
        center.setY(y / points.size());
        return center;
    }

    private strictfp Point turnAround(Segment segment, double angle) {
        PointImpl output = new PointImpl();
        output.setX(
                segment.getFirst().getX()
                        + segment.deltaX() * Math.cos(angle)
                        - segment.deltaY() * Math.sin(angle)
        );
        output.setY(
                segment.getFirst().getY()
                        + segment.deltaX() * Math.sin(angle)
                        + segment.deltaY() * Math.cos(angle)
        );

        return output;
    }

    private strictfp Point pointForRegularTriangle(Segment segment,
                                          Point pointForNavigation) {
        double angle = 5 * Math.PI / 3;
        Segment navigator = new Segment(segment.getFirst(), pointForNavigation);
        if (segment.vectorMultiply(navigator) < 0) {
            angle = Math.PI / 3;
        }
        return turnAround(segment, angle);
    }

    private boolean isAngleOver120(Point toCheck, Point first,
                                   Point second) {
        Segment firstSeg = new Segment(toCheck, first);
        Segment secondSeg = new Segment(toCheck, second);

        return (firstSeg.multiplyOfLengths(secondSeg) / (-2)
                > firstSeg.scalarMultiply(secondSeg));
    }
}
