package com.epam.university.java.core.task015;

import com.sun.javafx.geom.CubicCurve2D;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Александр on 22.09.2017.
 * So hurt.
 */
public class Task015Impl implements Task015 {
    /**
     * Get area of intersection of two squares. Squares are defined as two
     * opposite points in 2-dimensional area.
     *
     * <p>
     *     Example:
     *          square 1 = (2, 2) and (4, 4)
     *          square 2 = (3, 3) and (5, 5)
     *          area is 1 = square (3, 3) and (4, 4)
     * </p>
     * <p>
     *     Tip: paint it in the notebook.
     * </p>
     *
     * @param first first square definition
     * @param second second square definition
     * @return value of area
     */
    @Override
    public double getArea(Square first, Square second) {
        Polygon polygon = new Polygon(SquareImpl.getIntersectionPoints(first,second));
        return polygon.area();
    }

}
