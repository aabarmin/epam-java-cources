package com.epam.university.java.core.task013;

/**
 * Vertex of figure.
 */
public class VertexImpl implements Vertex {

    private int coordX;
    private int coordY;

    VertexImpl(int x, int y) {
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

    /**
     * Get y coordinate of vertex.
     *
     * @return coordinate value
     */
    @Override
    public int getY() {
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

}
