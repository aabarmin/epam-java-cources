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

    /**
     * Find intersection point of line segments.
     *
     * @param line second line
     * @return intersection point, if not intersect - null
     */
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
        if (includes(point, this) && includes(point, line)) {
            return point;
        }

        return null;

    }

    public LineParam getLineParam() {
        return new LineParam(first, second);
    }

    /**
     * Check if point higher than line.
     *
     * @param point point to check
     * @return true - higher, false - lower or on line
     */
    public boolean isHighter(Point point) {
        LineParam param = getLineParam();

        if ((param.getA() * point.getX() + param.getB() * point.getY() + param.getC()) > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean includes(Point point, LineSegment lineSegment) {
        if (point.getX() >= Math.min(lineSegment.first.getX(), lineSegment.second.getX())
            && point.getX() <= Math.max(lineSegment.first.getX(), lineSegment.second.getX())
            && point.getY() >= Math.min(lineSegment.first.getY(), lineSegment.second.getY())
            && point.getY() <= Math.max(lineSegment.first.getY(), lineSegment.second.getY())) {
            LineParam params = lineSegment.getLineParam();
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
