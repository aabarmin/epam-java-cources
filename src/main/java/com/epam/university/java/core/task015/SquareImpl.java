package com.epam.university.java.core.task015;

public class SquareImpl implements Square {
    private Point first;
    private Point second;

    SquareImpl(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Point getFirst() {
        return first;
    }

    @Override
    public void setFirst(Point first) {
        this.first = first;
    }

    @Override
    public Point getSecond() {
        return second;
    }

    @Override
    public void setSecond(Point second) {
        this.second = second;
    }
}
