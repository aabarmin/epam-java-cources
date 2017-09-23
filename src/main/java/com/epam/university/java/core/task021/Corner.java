package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;

/**
 * Created by ilya on 23.09.17.
 */
public class Corner {

    private final Point point;
    private final double angle;

    /**
     * Constructor of corner.
     *
     * @param first Left or right point
     * @param second Left or right point
     * @param point target point
     */
    public Corner(Point first, Point second, Point point) {
        this.point = point;

        Vector firstVector = new Vector(point, first);
        Vector secondVector = new Vector(point, second);

        this.angle = Math.acos(
            firstVector.scalarMultiplication(secondVector)
                / (firstVector.getLength() * secondVector.getLength())
        ) * 180 / Math.PI;
    }

    public Point getPoint() {
        return point;
    }

    public double getAngle() {
        return angle;
    }

}
