package com.epam.university.java.core.task016;

/**
 * Created by Вера on 24.09.2017.
 */
public class CoordinateFactoryImpl implements CoordinateFactory {
    @Override
    public Coordinate newInstance(int x, int y) {
        CoordinateImpl coordinate = new CoordinateImpl();
        coordinate.setX(x);
        coordinate.setY(y);
        return coordinate;
    }
}
