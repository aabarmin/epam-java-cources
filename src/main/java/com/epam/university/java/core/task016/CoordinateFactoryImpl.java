package com.epam.university.java.core.task016;

/**
 * Author Dmitry Novikov 05-Sep-20.
 */
public class CoordinateFactoryImpl implements CoordinateFactory {
    @Override
    public Coordinate newInstance(int x, int y) {
        return new CoodrinateImpl(x, y);
    }
}
