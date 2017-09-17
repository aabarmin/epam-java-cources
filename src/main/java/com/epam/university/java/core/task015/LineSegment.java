package com.epam.university.java.core.task015;

/**
 * Created by ilya on 16.09.17.
 */
public class LineSegment {

    DoublePoint first;
    DoublePoint second;

    public LineSegment(DoublePoint first, DoublePoint second) {
        this.first = first;
        this.second = second;
    }

    public static void main(String[] args) {
        DoublePoint point1 = new DoublePoint(4, 4);
        DoublePoint point2 = new DoublePoint(2, 4);

        LineSegment seg1 = new LineSegment(point1, point2);

        DoublePoint point3 = new DoublePoint(5, 5);
        DoublePoint point4 = new DoublePoint(5, 3);

        LineSegment seg2 = new LineSegment(point3, point4);

        DoublePoint intersection = seg1.lineIntersection(seg2);
        System.out.println(intersection);
        System.out.println(seg1.includes(intersection));

    }

    public DoublePoint getFirst() {
        return first;
    }

    public void setFirst(DoublePoint first) {
        this.first = first;
    }

    public DoublePoint getSecond() {
        return second;
    }

    public void setSecond(DoublePoint second) {
        this.second = second;
    }

    public double getLength() {
        return Math.sqrt(Math.pow((first.getX() - second.getY()), 2) + Math
            .pow((first.getX() - second.getY()), 2));
    }

    public DoublePoint lineIntersection(LineSegment line) {
        LineParam thisParam = this.getLineParam();
        LineParam lineParam = line.getLineParam();

        double parA1 = thisParam.getA();
        double parB1 = thisParam.getB();
        double parC1 = thisParam.getC();
        double parA2 = lineParam.getA();
        double parB2 = lineParam.getB();
        double parC2 = lineParam.getC();

        double coordY = (parA2 * parC1 - parC2 * parA1) / (parB2 * parA1 - parB1 * parA2);
        double coordX = (parC2 * parB1 - parC1 * parB2) / (parB2 * parA1 - parB1 * parA2);

        return new DoublePoint(coordX, coordY);

    }

    public LineParam getLineParam() {
        return new LineParam(first, second);
    }

    public boolean includes(DoublePoint point) {
        if (point.getX() >= Math.min(first.getX(), second.getX())
            && point.getX() <= Math.max(first.getX(), second.getX())
            && point.getY() >= Math.min(first.getY(), second.getY())
            && point.getY() <= Math.max(first.getY(), second.getY())) {
            LineParam params = getLineParam();
            return params.getA() * point.getX() + params.getB() * point.getY() + params.getC()
                <= 0.0001;
        }
        return false;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LineSegment that = (LineSegment) o;

        if (first != null ? !first.equals(that.first) : that.first != null) {
            return false;
        }
        return second != null ? second.equals(that.second) : that.second == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    private static class LineParam {

        private double parA;
        private double parB;
        private double parC;

        public LineParam(DoublePoint first, DoublePoint second) {
            parA = first.getY() - second.getY();
            parB = second.getX() - first.getX();
            parC = first.getX() * second.getY() - first.getY() * second.getX();
        }

        public double getA() {
            return parA;
        }

        public double getB() {
            return parB;
        }

        public double getC() {
            return parC;
        }
    }

}
