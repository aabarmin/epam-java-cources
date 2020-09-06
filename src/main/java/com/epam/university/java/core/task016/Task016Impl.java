package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author Dmitry Novikov 05-Sep-20.
 */
public class Task016Impl implements Task016 {
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius < 1) {
            throw new IllegalArgumentException();
        }
        return makeRound(findCoordinates(radius));
    }

    /**
     * Some text.
     */

    public static List<Coordinate> makeRound(List<Coordinate> list) {
        List<Coordinate> result = new ArrayList<>();
        for (Coordinate p : list
        ) {
            result.add(new CoodrinateImpl(p.getX(), p.getY()));
            result.add(new CoodrinateImpl(-p.getX(), p.getY()));
            result.add(new CoodrinateImpl(p.getX(), -p.getY()));
            result.add(new CoodrinateImpl(-p.getX(), -p.getY()));
        }

        return result;
    }

    /**
     * Some text.
     */
    public static List<Coordinate> findCoordinates(int radius) {
        List<Coordinate> myPoint = new ArrayList<>();
        int maxValue = radius * 2 - 1;
        for (int i = 1; i <= radius; i++) {
            for (int j = 1; j <= maxValue; j++) {
                myPoint.add(new CoodrinateImpl(i, j));
            }
        }


        for (int i = 1; i <= maxValue; i++) {
            for (int j = 1; j <= radius; j++) {
                CoodrinateImpl temp = new CoodrinateImpl(i, j);
                if (!myPoint.contains(temp)) {
                    myPoint.add(temp);
                }
            }
        }

        if (maxValue - radius > 1) {
            myPoint.add(new CoodrinateImpl(maxValue - 1, maxValue - 1));
        }

        return myPoint;
    }
}
