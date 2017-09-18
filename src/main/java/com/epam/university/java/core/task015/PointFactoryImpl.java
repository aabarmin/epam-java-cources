package com.epam.university.java.core.task015;

/**
 * Point factory.
 */
public class PointFactoryImpl implements PointFactory {

    /**
     * Creates new point instance.
     * @param x x coordinate
     * @param y y coordinate
     * @return point instance
     */
    @Override
    public Point newInstance(int x, int y) {
        return new PointImpl(x, y);
    }

}
