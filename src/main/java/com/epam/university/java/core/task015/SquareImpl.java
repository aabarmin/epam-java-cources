package com.epam.university.java.core.task015;

/**
 * Created by ilya on 16.09.17.
 */
public class SquareImpl implements Square {

    private Point firstPoint;
    private Point secondPoint;

    public SquareImpl(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public Point getFirst() {
        return firstPoint;
    }

    @Override
    public void setFirst(Point first) {
        firstPoint = first;
    }

    @Override
    public Point getSecond() {
        return secondPoint;
    }

    @Override
    public void setSecond(Point second) {
        secondPoint = second;
    }
}
