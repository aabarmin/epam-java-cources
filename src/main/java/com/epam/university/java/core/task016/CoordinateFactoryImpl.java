package com.epam.university.java.core.task016;

public class CoordinateFactoryImpl implements CoordinateFactory {
    @Override
    public Coordinate newInstance(int x, int y) {
        return new CoordinateImpl(x, y);
    }
}
