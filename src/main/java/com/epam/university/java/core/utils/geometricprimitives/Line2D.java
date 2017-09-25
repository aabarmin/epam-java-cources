package com.epam.university.java.core.utils.geometricprimitives;

public class Line2D {
    private Point2D pointFirst;
    private Point2D pointSecond;
    boolean isSegment;

    public Line2D(Point2D pointFirst, Point2D pointSecond) {
        this.pointFirst = pointFirst;
        this.pointSecond = pointSecond;
    }

    public Point2D getPointFirst() {
        return pointFirst;
    }

    public void setPointFirst(Point2D pointFirst) {
        this.pointFirst = pointFirst;
    }

    public Point2D getPointSecond() {
        return pointSecond;
    }

    public void setPointSecond(Point2D pointSecond) {
        this.pointSecond = pointSecond;
    }

    public Point2D intersectionPoint(Line2D lineSecond) {

        // first line represented as a1x + b1y = c1
        double firstA = this.pointSecond.y() - this.pointFirst.y();
        double firstB = this.pointFirst.x() - this.pointSecond.x();
        double firstC = firstA * (this.pointFirst.x())
                + firstB * (this.pointFirst.y());

        // Line CD represented as a2x + b2y = c2
        double secondA = lineSecond.pointSecond.y() - lineSecond.pointFirst.y();
        double secondB = lineSecond.pointFirst.x() - lineSecond.pointSecond.x();
        double secondC = secondA * (lineSecond.pointFirst.x())
                + secondB * (lineSecond.pointFirst.y());

        double determinant = firstA * secondB - secondA * firstB;

        if (determinant == 0) {
            // The lines are parallel. This is simplified by returning null
            return null;
        } else {
            double intersectionX = (secondB * firstC
                    - firstB * secondC) / determinant;
            double intersectionY = (firstA * secondC
                    - secondA * firstC) / determinant;
            //check that intersection point belongs to the segments
            if (((Math.min(this.pointFirst.x(), this.pointSecond.x())
                    <= intersectionX) && (intersectionX <= Math.max(
                    this.pointFirst.x(), this.pointSecond.x())))
                    && (((Math.min(lineSecond.pointFirst.x(), lineSecond
                    .pointSecond.x())
                    <= intersectionX) && (intersectionX <= Math.max(
                    lineSecond.pointFirst.x(), lineSecond.pointSecond.x()
            ))))
                    && ((Math.min(this.pointFirst.y(), this.pointSecond.y())
                    <= intersectionY) && (intersectionY <= Math.max(
                    this.pointFirst.y(), this.pointSecond.y())))
                    && (((Math.min(lineSecond.pointFirst.y(), lineSecond
                    .pointSecond.y())
                    <= intersectionY) && (intersectionY <= Math.max(
                    lineSecond.pointFirst.y(), lineSecond.pointSecond.y()
            ))))) {
                return new Point2D(intersectionX, intersectionY);
            }
            return null;
        }

    }

    /*public static void main(String[] args) {
        System.out.println(new Line2D(new Point2D(4, 4),
                new Point2D(4, 2))
                .intersectionPoint(new Line2D(new Point2D(0,
                        4), new Point2D(4, 4))));
    }*/
}