package com.epam.university.java.core.task013;

/**
 * Vertex of figure.
 */
public final class VertexImpl implements Vertex {

    /**
     * X coordinate of vertex.
     */
    private int coordX;

    /**
     * Y coordinate of vertex.
     */
    private int coordY;

    /**
     * Get coordX coordinate of vertex.
     *
     * @return coordinate value
     */
    @Override
    public int getX() {
        return this.coordX;
    }

    /**
     * Set coordX coordinate of vertex.
     *
     * @param value coordinate value
     */
    @Override
    public void setX(final int value) {
        this.coordX = value;

    }

    /**
     * Get coordY coordinate of vertex.
     *
     * @return coordinate value
     */
    @Override
    public int getY() {
        return this.coordY;
    }

    /**
     * Set coordY coordinate of vertex.
     *
     * @param value coordinate value
     */
    @Override
    public void setY(final int value) {
        this.coordY = value;
    }
}
