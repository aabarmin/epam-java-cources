package com.epam.university.java.core.task015;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class SquareImpl implements Square {
    private Point first;
    private Point second;
    private Point third;
    private Point forth;
    private ArrayList<Line2D.Double> lines = new ArrayList<>();
    private ArrayList<PointImpl> points = new ArrayList<>();
    private Point center;

    /**
     * Square figure with two points.
     * @param first Point object.
     * @param second Point object.
     */
    public SquareImpl(Point first, Point second) {
        this.first = first;
        this.second = second;
        getTwoPointsAndCenter();
        fillLines();
        fillPoints();
    }

    private void fillPoints() {
        points.add((PointImpl) first);
        points.add((PointImpl) second);
        points.add((PointImpl) third);
        points.add((PointImpl) forth);
    }

    private void getTwoPointsAndCenter() {
        double x0 = (first.getX() + second.getX()) / 2;
        double y0 = (first.getY() + second.getY()) / 2;
        double xv = first.getX() - x0;
        double yv = first.getY() - y0;

        double xThird = x0 - yv;
        double yThird = y0 + xv;

        double xForth = x0 + yv;
        double yForth = y0 - xv;

        this.third = new PointImpl(xThird, yThird);
        this.forth = new PointImpl(xForth, yForth);

        double centerX = (first.getX() + second.getX()) / 2;
        double centerY = (second.getY() + first.getY()) / 2;

        center = new PointImpl(centerX, centerY);
    }

    private void fillLines() {
        Line2D.Double line13 = new Line2D.Double(first.getX(), first.getY(),
                third.getX(), third.getY());
        Line2D.Double line32 = new Line2D.Double(third.getX(), third.getY(),
                second.getX(), second.getY());
        Line2D.Double line24 = new Line2D.Double(second.getX(), second.getY(),
                forth.getX(), forth.getY());
        Line2D.Double line41 = new Line2D.Double(forth.getX(), forth.getY(),
                first.getX(), first.getY());

        lines.add(line13);
        lines.add(line32);
        lines.add(line24);
        lines.add(line41);
    }

    @Override
    public Point getFirst() {
        return first;
    }

    @Override
    public Point getSecond() {
        return second;
    }

    @Override
    public void setFirst(Point first) {
        this.first = first;
    }

    @Override
    public void setSecond(Point second) {
        this.second = second;
    }

    public Point getThird() {
        return third;
    }

    public Point getForth() {
        return forth;
    }

    public ArrayList<Line2D.Double> getLines() {
        return lines;
    }

    public ArrayList<PointImpl> getPoints() {
        return points;
    }

    /**
     * Returns Point Object that is crossing of two lines.
     * @param line1 line object.
     * @param line2 line object.
     * @return Point object.
     */
    public static PointImpl getCrossingPoint(Line2D.Double line1, Line2D.Double line2) {
        double a1 = line1.getY1() - line1.getY2();
        double b1 = line1.getX2() - line1.getX1();
        double a2 = line2.getY1() - line2.getY2();
        double b2 = line2.getX2() - line2.getX1();

        double d = (a1 * b2) - (a2 * b1);
        PointImpl point = null;
        if (d != 0) {
            double c1 = line1.getY2() * line1.getX1() - line1.getX2() * line1.getY1();
            double c2 = line2.getY2() * line2.getX1() - line2.getX2() * line2.getY1();

            double xi = (b1 * c2 - b2 * c1) / d;
            double yi = (a2 * c1 - a1 * c2) / d;

            point = new PointImpl(xi, yi);
        }

        return point;
    }

    /**
     * Checks of Polygon contains Point.
     * @param point Point object.
     * @return true or false.
     */
    public boolean contains(Point point) {
        if (point.equals(first)
                || point.equals(second)
                || point.equals(third)
                || point.equals(forth)) {
            return true;
        }

        double maxX = Math.max(
                Math.max(first.getX(), second.getX()), Math.max(third.getX(), forth.getX()));

        Line2D.Double line = new Line2D.Double(
                point.getX(), point.getY() - 0.5d,
                maxX + 1, point.getY() - 0.5d);

        List<PointImpl> crossingPoints = new ArrayList<>();
        for (Line2D.Double border : lines) {
            if (border.intersectsLine(line)) {
                crossingPoints.add(getCrossingPoint(border, line));
            }
        }

        if (crossingPoints.size() % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
