package com.epam.university.java.core.task015;


import com.epam.university.java.core.Validator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.Arrays;

public class Task015Impl implements Task015 {
    @Override
    public double getArea(Square first, Square second) {
        new Validator().vaildate(first, second);

        return intersection(first, second);
    }


    private double intersection(Square square1, Square square2) {
        double sumArea = 0;
        List<Point> sq1 = getFourPoints(square1);
        List<Point> sq2 = getFourPoints(square2);

        Set<Point> full = getCrossPoints(sq1, sq2);

        for (Point point : sq1) {
            if (isPointInSquare(point, sq2)) {
                full.add(point);
            }
        }
        for (Point point : sq2) {
            if (isPointInSquare(point, sq1)) {
                full.add(point);
            }
        }

        Point centroid = getCentroid2D(full);
        List<Point> full2 = new LinkedList<>(full);
        full2.sort((p1, p2) -> {
            double dx1 = p2.getX() - p1.getX();
            double dy1 = p2.getY() - p1.getY();
            double dx2 = centroid.getX() - p1.getX();
            double dy2 = centroid.getY() - p1.getY();
            return Double.compare(dx1 * dy2, dy1 * dx2);
        });

        while (full2.size() > 2) {
            Point p1 = full2.get(0);
            Point p2 = full2.get(1);
            Point p3 = full2.get(2);
            double s = getTriangleArea(p1, p2, p3);
            sumArea += s;
            full2.remove(1);
        }
        if (Double.isNaN(sumArea)) {
            sumArea = 0;
        }
        return sumArea;

    }

    private double getTriangleArea(Point p1, Point p2, Point p3) {
        double a = getSideLength(p1, p2);
        double b = getSideLength(p2, p3);
        double c = getSideLength(p1, p3);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private Set<Point> getCrossPoints(List<Point> sq1, List<Point> sq2) {
        Set<Point> full = new HashSet<>();
        for (int i = 0; i < sq1.size(); i++) {
            Point one = sq1.get((i));
            Point two = sq1.get((i + 1) % sq1.size());
            full.addAll(getCrossLines(one, two, sq2));
        }
        return full;
    }

    private static boolean isPointInSquare(Point point, List<Point> sq) {
        for (int i = 0; i < 2; i++) {
            Point p1 = sq.get(0);
            Point p2 = sq.get(i * 2 + 1);
            Point p3 = sq.get(2);
            double x = point.getX();
            double x1 = p1.getX();
            double x2 = p2.getX();
            double x3 = p3.getX();
            double y = point.getY();
            double y1 = p1.getY();
            double y2 = p2.getY();
            double y3 = p3.getY();
            double triangleAbc = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
            double triangleAbp = Math.abs(x1 * (y2 - y) + x2 * (y - y1) + x * (y1 - y2));
            double triangleApc = Math.abs(x1 * (y - y3) + x * (y3 - y1) + x3 * (y1 - y));
            double trianglePbc = Math.abs(x * (y2 - y3) + x2 * (y3 - y) + x3 * (y - y2));
            boolean isInTriangle = triangleAbp + triangleApc + trianglePbc == triangleAbc;
            if (isInTriangle) {
                return true;
            }
        }
        return false;
    }

    private static double getSideLength(Point p1, Point p2) {
        double a = Math.abs(p1.getX() - p2.getX());
        double b = Math.abs(p1.getY() - p2.getY());
        double alpha = Math.atan(b / a);
        double r;
        if (Math.sin(alpha) != 0) {
            r = b / Math.sin(alpha);
        } else {
            r = a / Math.cos(alpha);
        }
        return r;
    }

    private static Point getCentroid2D(Collection<Point> points) {
        double sumX = 0;
        double sumY = 0;
        for (Point v : points) {
            sumX += v.getX();
            sumY += v.getY();
        }
        double x = sumX / points.size();
        double y = sumY / points.size();
        return (new PointFactoryImpl()).newInstance(x, y);
    }


    private static List<Point> getFourPoints(Square square) {
        PointFactoryImpl factory = new PointFactoryImpl();
        Point p1 = square.getFirst();
        Point p2 = square.getSecond();

        Point square1p3 = factory.newInstance((p1.getX() + p2.getX()) / 2
                        + (p1.getY() - p2.getY()) / 2,
                (p2.getX() - p1.getX()) / 2 + (p1.getY() + p2.getY()) / 2);
        Point square1p4 = factory.newInstance((p1.getX() + p2.getX()) / 2
                        + (p2.getY() - p1.getY()) / 2,
                (p1.getX() - p2.getX()) / 2 + (p1.getY() + p2.getY()) / 2);
        return Arrays.asList(square.getFirst(), square1p3, square.getSecond(), square1p4);
    }

    private static List<Point> getCrossLines(Point one, Point two, List<Point> listSquare) {
        List<Point> list = new LinkedList<>();
        PointFactory pointFactory = new PointFactoryImpl();
        for (int i = 0; i < listSquare.size(); i++) {
            Point three = listSquare.get((i));
            Point four = listSquare.get((i + 1) % listSquare.size());
            double x = ((one.getX() * two.getY() - one.getY() * two.getX())
                    * (three.getX() - four.getX())
                    - (one.getX() - two.getX()) * (three.getX() * four.getY()
                    - three.getY() * four.getX()))
                    / ((one.getX() - two.getX()) * (three.getY() - four.getY())
                    - (one.getY() - two.getY()) * (three.getX() - four.getX()));
            double y = ((one.getX() * two.getY() - one.getY() * two.getX())
                    * (three.getY() - four.getY())
                    - (one.getY() - two.getY()) * (three.getX() * four.getY()
                    - three.getY() * four.getX()))
                    / ((one.getX() - two.getX()) * (three.getY() - four.getY())
                    - (one.getY() - two.getY()) * (three.getX() - four.getX()));
            if (x < Math.min(one.getX(), two.getX())
                    || x > Math.max(one.getX(), two.getX())) {
                continue;
            }
            if (y < Math.min(one.getY(), two.getY())
                    || y > Math.max(one.getY(), two.getY())) {
                continue;
            }
            if (x < Math.min(three.getX(), four.getX())
                    || x > Math.max(three.getX(), four.getX())) {
                continue;
            }
            if (y < Math.min(three.getY(), four.getY())
                    || y > Math.max(three.getY(), four.getY())) {
                continue;
            }
            if (Double.isNaN(x) || Double.isNaN(y)) {
                continue;
            }
            list.add(pointFactory.newInstance(x, y));
        }
        return list;
    }
}
