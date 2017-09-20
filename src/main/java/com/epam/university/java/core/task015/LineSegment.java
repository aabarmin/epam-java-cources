package com.epam.university.java.core.task015;

/**
 * Created by ilya on 16.09.17.
 */
public class LineSegment {

    private Point first;
    private Point second;

    public LineSegment(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    public static void main(String[] args) {
        Point point1 = new PointImpl(4, 4);
        Point point2 = new PointImpl(2, 4);

        LineSegment seg1 = new LineSegment(point1, point2);

        Point point3 = new PointImpl(4, 5);
        Point point4 = new PointImpl(3, 3);

        LineSegment seg2 = new LineSegment(point3, point4);

        Point intersection = seg1.lineIntersection(seg2);
        System.out.println(intersection);
        System.out.println(seg1.includes(intersection));

    }

    public Point getFirst() {
        return first;
    }

    public void setFirst(Point first) {
        this.first = first;
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public double getLength() {
        return Math.sqrt(Math.pow((first.getX() - second.getY()), 2) + Math
            .pow((first.getX() - second.getY()), 2));
    }

    public Point lineIntersection(LineSegment line) {
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

        Point point = new PointImpl(coordX, coordY);
        if(includes(point)){
            return point;
        }

        return null;

    }

    public LineParam getLineParam() {
        return new LineParam(first, second);
    }

    private boolean includes(Point point) {
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

        public LineParam(Point first, Point second) {
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
