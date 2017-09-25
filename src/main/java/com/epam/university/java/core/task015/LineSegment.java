package com.epam.university.java.core.task015;

/**
 * Created by Александр on 24.09.2017.
 *
 * Fields firast and second contains sorted points of line segment
 * first the point with low x
 */
public class LineSegment {
    private Point first;
    private Point second;

    LineSegment(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    public Point intersectionPoint(LineSegment another) {
        double thisCoefficientA = this.getFirst().getY() - this.getSecond().getY();
        double thisCoefficientB = this.getSecond().getX() - this.getFirst().getX();
        double anotherCoefficientA = another.getFirst().getY() - another.getSecond().getY();
        double anotherCoefficientB = another.getSecond().getX() - another.getFirst().getX();

        double determinant = thisCoefficientA * anotherCoefficientB - anotherCoefficientA * thisCoefficientB;
        if (determinant != 0 ) {
            double thisCoefficientC = this.getSecond().getY() * this.getFirst().getX()
                    - this.getSecond().getX() * this.getFirst().getY();
            double anotherCoefficientC = another.getSecond().getY() * another.getFirst().getX()
                    - another.getSecond().getX() * another.getFirst().getY();

            double resultX = (thisCoefficientB * anotherCoefficientC - anotherCoefficientB * thisCoefficientC)
                    / determinant;
            double resultY = (anotherCoefficientA * thisCoefficientC - thisCoefficientA * anotherCoefficientC)
                    / determinant;

            if (resultX >= Math.min(this.getFirst().getX(), this.getSecond().getX())
                    && resultX <= Math.max(this.getFirst().getX(), this.getSecond().getX())
                    && resultY >= Math.min(this.getFirst().getY(), this.getSecond().getY())
                    && resultY <= Math.max(this.getFirst().getY(), this.getSecond().getY())
                    && resultX >= Math.min(another.getFirst().getX(), another.getSecond().getX())
                    && resultX <= Math.max(another.getFirst().getX(), another.getSecond().getX())
                    && resultY >= Math.min(another.getFirst().getY(), another.getSecond().getY())
                    && resultY <= Math.max(another.getFirst().getY(), another.getSecond().getY())) {
                return new PointImpl(resultX, resultY);
            } else {
                return null;
            }


        } else {
            return null;
        }
    }


    public Point getFirst() {
        return first;
    }


    public Point getSecond() {
        return second;
    }
}
