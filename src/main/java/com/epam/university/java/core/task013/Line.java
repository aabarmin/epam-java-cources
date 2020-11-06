package com.epam.university.java.core.task013;

public class Line {
    private double k;
    private double b;

    /**
     * Default line constructor.
     */
    public Line() {
    }

    /**
     * Line constructor y= kx + b sets k and b.
     * @param x1 first point x
     * @param y1 first point y
     * @param x2 second point x
     * @param y2 second point y
     */
    public Line(double x1, double y1, double x2, double y2) {
        if (x1 + x2 == 0) {
            this.k = Double.NaN;
            this.b = Double.NaN;
        } else {
            this.k = (y1 - y2) / (x1 - x2);
            this.b = -(k * x1) + y1;
        }

    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}