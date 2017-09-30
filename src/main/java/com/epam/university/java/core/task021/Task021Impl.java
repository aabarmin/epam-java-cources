package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;

import java.util.Collection;

/**
 * Implementation class for Task021.
 *
 * @author Sergei Titov
 */
public class Task021Impl implements Task021 {

    /**
     * {@inheritDoc}
     */
    @Override
    public Point calculate(Collection<Point> minePositions) {

        Point<?>[] points = (Point<?>[]) minePositions.toArray();

        double x1 = ((Number)points[0].getX()).doubleValue();
        double y1 = ((Number)points[0].getY()).doubleValue();
        double x2 = ((Number)points[1].getX()).doubleValue();
        double y2 = ((Number)points[1].getY()).doubleValue();
        double x3 = ((Number)points[2].getX()).doubleValue();
        double y3 = ((Number)points[2].getY()).doubleValue();

        return FermatToricelliPoint.torricelli_point(x1, y1, x2, y2, x3, y3);
    }
}
