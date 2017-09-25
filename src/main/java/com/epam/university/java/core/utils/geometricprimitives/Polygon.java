package com.epam.university.java.core.utils.geometricprimitives;

import java.util.ArrayList;

public class Polygon {
    private int N;        // number of points in the polygon
    private Point2D[] a;    // the points, setting points[0] = points[N]

    // default buffer = 4
    public Polygon() {
        N = 0;
        a = new Point2D[4];
    }

    public Point2D[] getPoints2D() {
        ArrayList<Point2D> points = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                points.add(a[i]);
            }
        }
        return points.toArray(new Point2D[0]);
    }

    // double size of array
    private void resize() {
        Point2D[] temp = new Point2D[2 * N + 1];
        for (int i = 0; i <= N; i++) temp[i] = a[i];
        a = temp;
    }

    // return size
    public int size() {
        return N;
    }


    // add point p to end of polygon
    public void add(Point2D p) {
        if (N >= a.length - 1) resize();   // resize array if needed
        a[N++] = p;                        // add point
        a[N] = a[0];                       // close polygon
    }

    public void addAll(Point2D[] point2DS) {
        for (int i = 0; i < point2DS.length; i++) {
            add(point2DS[i]);
        }
    }

    // return signed area of polygon
    public double area() {
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            System.out.println(i);

            sum = sum + (a[i].x() * a[i + 1].y()) - (a[i].y() * a[i + 1].x());
        }
        return 0.5 * sum;
    }

    // does this Polygon contain the point p?
    // if p is on boundary then 0 or 1 is returned, and p is in exactly one
    // point of every partition of plane
    // Reference: http://exaflop.org/docs/cgafaq/cga2.html
    public boolean contains(Point2D p) {
        int crossings = 0;
        for (int i = 0; i < N; i++) {
            int j = i + 1;
            boolean cond1 = (a[i].y() <= p.y()) && (p.y() < a[j].y());
            boolean cond2 = (a[j].y() <= p.y()) && (p.y() < a[i].y());
            if (cond1 || cond2) {
                // need to cast to double
                if (p.x() < (a[j].x() - a[i].x()) * (p.y() - a[i].y())
                        / (a[j].y() - a[i]
                        .y()) + a[i].x())
                    crossings++;
            }
        }
        if (crossings % 2 == 1) return true;
        else return false;
    }

    // return string representation of this point
    public String toString() {
        if (N == 0) return "[ ]";
        String s = "";
        s = s + "[ ";
        for (int i = 0; i <= N; i++) {
            s = s + a[i] + " " + System.lineSeparator();
        }
        s = s + "]";
        return s;
    }
}