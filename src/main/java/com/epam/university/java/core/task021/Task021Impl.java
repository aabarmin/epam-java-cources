package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Александр on 26.09.2017.
 * Fermat–Torricelli point.
 */
public class Task021Impl implements Task021 {
    /**
     * <p>
     *     There are three mines, position of each is in <code>minePositions</code> collection.
     *     You should determine coordinates of the city which will have a factory. It's better
     *     to have the shortest distance between mines and city.
     * </p>
     * <p>
     *     Example:
     * </p>
     *
     * @param minePositions mines positions
     * @return city city position
     */
    @Override
    public Point calculate(Collection<Point> minePositions) {
        ArrayList<Point> minePoints = new ArrayList<>(minePositions);
        Point pointA = minePoints.get(0);
        Point pointB = minePoints.get(1);
        Point pointC = minePoints.get(2);
        Point oppositeB;
        Point oppositeC;


        Vector vectorAtoB = new Vector(pointA, pointB);
        Vector vectorAtoC = new Vector(pointA, pointC);

        if (vectorAtoC.isRightTurn(vectorAtoB)) {
            oppositeC = getPoint(pointA, pointB, Math.PI * 2 / 3);
            oppositeB = getPoint(pointA, pointC, -Math.PI * 2 / 3);
        } else {
            oppositeC = getPoint(pointA, pointB, -Math.PI * 2 / 3);
            oppositeB = getPoint(pointA, pointC, Math.PI * 2 / 3);
        }

        return null;
    }

    /**
     * Rotste point around axis for angle.
     *
     * @param axis point
     * @param currPoint point to rotate
     * @param angle num from -PI to PI
     * @return new point after rotating
     */
    public Point getPoint(Point axis, Point currPoint, double angle) {

        //shift the origin of coordinates to axis
        double tempX = currPoint.getX() - axis.getX();
        double tempY = currPoint.getY() - axis.getY();

        //rotate
        double resultX;
        double resultY;
        if (angle > 0) {
            resultX = tempX * Math.cos(angle) - tempY * Math.sin(angle);
            resultY = tempX * Math.sin(angle) + tempY * Math.cos(angle);
        } else {
            resultX = tempX * Math.cos(angle) + tempY * Math.sin(angle);
            resultY = -tempX * Math.sin(angle) + tempY * Math.cos(angle);
        }

        //shift the origin of coordinates to 0, 0
        resultX += axis.getX();
        resultY += axis.getY();

        return new PointImpl(resultX, resultY);
    }


}
