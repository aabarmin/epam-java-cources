package com.epam.university.java.core.task015;

/**
 * Created by Александр on 24.09.2017.
 * Fields first and second contains points of line segment
 * first the point with low x
 */
public class LineSegment {
    private Point first;
    private Point second;

    LineSegment(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Get intersection Point of two line segments.
     * @param another line segment to intersection.
     * @return point
     */
    public Point intersectionPoint(LineSegment another) {
        double thisCoefficientA = this.getFirst().getY() - this.getSecond().getY();
        double thisCoefficientB = this.getSecond().getX() - this.getFirst().getX();
        double anotherCoefficientA = another.getFirst().getY() - another.getSecond().getY();
        double anotherCoefficientB = another.getSecond().getX() - another.getFirst().getX();

        double determinant = thisCoefficientA * anotherCoefficientB
                - anotherCoefficientA * thisCoefficientB;
        if (determinant != 0) {
            double thisCoefficientC = this.getSecond().getY() * this.getFirst().getX()
                    - this.getSecond().getX() * this.getFirst().getY();
            double anotherCoefficientC = another.getSecond().getY() * another.getFirst().getX()
                    - another.getSecond().getX() * another.getFirst().getY();

            double resultX = (thisCoefficientB * anotherCoefficientC
                    - anotherCoefficientB * thisCoefficientC)
                    / determinant;
            double resultY = (anotherCoefficientA * thisCoefficientC
                    - thisCoefficientA * anotherCoefficientC)
                    / determinant;

            Point thisA = this.getFirst();
            Point thisB = this.getSecond();
            Point anotherA = another.getFirst();
            Point anotherB = another.getSecond();
            if (resultX >= Math.min(thisA.getX(), thisB.getX())
                    && resultX <= Math.max(thisA.getX(), thisB.getX())
                    && resultY >= Math.min(thisA.getY(), thisB.getY())
                    && resultY <= Math.max(thisA.getY(), thisB.getY())
                    && resultX >= Math.min(anotherA.getX(), anotherB.getX())
                    && resultX <= Math.max(anotherA.getX(), anotherB.getX())
                    && resultY >= Math.min(anotherA.getY(), anotherB.getY())
                    && resultY <= Math.max(anotherA.getY(), anotherB.getY())) {
                return new PointImpl(resultX, resultY);
            } else {
                return null;
            }


        } else {
            return null;
        }
    }

    /**
     * Get first point of LineSegment.
     * @return point
     */
    public Point getFirst() {
        return first;
    }

    /**
     * Get first point of LineSegment.
     * @return point
     */
    public Point getSecond() {
        return second;
    }
}
