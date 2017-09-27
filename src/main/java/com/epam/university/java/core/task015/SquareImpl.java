package com.epam.university.java.core.task015;

public class SquareImpl implements Square {
    Point firstPoint;
    Point secondPoint;

    public SquareImpl(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public Point getFirst() {
        return firstPoint;
    }

    @Override
    public Point getSecond() {
        return secondPoint;
    }

    @Override
    public void setFirst(Point first) {
        firstPoint = first;

    }

    @Override
    public void setSecond(Point second) {
        secondPoint = second;
    }
}
