package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;

import java.util.Collection;

/**
 * Fermat–Torricelli point.
 */
public interface Task021 {
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
    Point calculate(Collection<Point> minePositions);
}
