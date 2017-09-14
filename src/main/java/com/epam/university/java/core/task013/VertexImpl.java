package com.epam.university.java.core.task013;

/**
 * Vertex of figure.
 */
public class VertexImpl implements Vertex {

    private double coordX;
    private double coordY;

    public VertexImpl(int x, int y) {
        coordX = x;
        coordY = y;
    }

    public VertexImpl(double x, double y) {
        coordX = x;
        coordY = y;
    }

    /**
     * Get x coordinate of vertex.
     *
     * @return coordinate value
     */
    @Override
    public int getX() {
        return (int) coordX;
    }

    public double getDoubleX() {
        return coordX;
    }

    /**
     * Set x coordinate of vertex.
     *
     * @param value coordinate value
     */
    @Override
    public void setX(int value) {
        coordX = value;
    }

    public void setX(double value) {
        coordX = value;
    }

    /**
     * Get y coordinate of vertex.
     *
     * @return coordinate value
     */
    @Override
    public int getY() {
        return (int) coordY;
    }

    public double getDoubleY() {
        return coordY;
    }

    /**
     * Set y coordinate of vertex.
     * @param value coordinate value
     */
    @Override
    public void setY(int value) {
        coordY = value;
    }

    public void setY(double value) {
        coordY = value;
    }

}
