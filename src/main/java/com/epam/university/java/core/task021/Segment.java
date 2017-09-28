package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;

public class Segment {
    private Point first;
    private Point second;

    public Segment(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    public double deltaX() {
        return second.getX() - first.getX();
    }

    public double deltaY() {
        return second.getY() - first.getY();
    }

    public strictfp double cosAngleBetween(Segment segment) {
        return this.vectorMultiply(segment)
                / this.multiplyOfLengths(segment);
    }

    public strictfp double sinAngleBetween(Segment segment) {
        return this.scalarMultiply(segment)
                / this.multiplyOfLengths(segment);
    }

    public strictfp double length() {
        return Math.sqrt(deltaX() * deltaX() + deltaY() * deltaY());
    }

    public strictfp double scalarMultiply(Segment arg) {
        return this.deltaX() * arg.deltaX() + this.deltaY() * arg.deltaY();
    }

    public strictfp double multiplyOfLengths(Segment arg) {
        return this.length() * arg.length();
    }

    public strictfp double vectorMultiply(Segment arg) {
        return this.deltaX() * arg.deltaY() - this.deltaY() * arg.deltaX();
    }

    public Point getFirst() {
        return first;
    }

    public Point getSecond() {
        return second;
    }
}
