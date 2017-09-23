package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class Task021Impl implements Task021 {
    /**
     * <p>
     * There are three mines, position of each is in <code>minePositions</code> collection.
     * You should determine coordinates of the city which will have a factory. It's better
     * to have the shortest distance between mines and city.
     * </p>
     * <p>
     * Example:
     * </p>
     *
     * @param minePositions mines positions
     * @return city city position
     */
    @Override
    public Point calculate(Collection<Point> minePositions) {

        if (minePositions == null || minePositions.size() != 3) {
            throw new IllegalArgumentException();
        }

        List<Point> minePositionsList = new ArrayList<>(minePositions);

        double x = 0;
        double y = 0;

        for (Point minePosition : minePositions) {
            x = x + minePosition.getX();
            y = y + minePosition.getY();
        }

        x = x / 3;
        y = y / 3;

        return new PointImpl(x, y);

    }
}
